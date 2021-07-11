// also check strategy pattern which we applied there in notification
class Customer {

	ShoppingCart cart;
	Search searchObj;
	int customerId;

	public ShoppingCart getShoppingCart(customerId);
	public void addItemsToShoppingCart(Item item);
	public void updateItemFromShoppingCart(Item item);
	public void removeItemFromShoppingCart(Item item);
}

class Guest extends Customer {

	public Account createNewAccount();

}

class User extends Customer {

	Account account;

}

class Seller extends User {

	public void addProduct(Product product);
}

class Buyer extends User {

	Order orderObj;

	public void addReview(ProductReview review);
	public OrderStatus placeOrder(ShoppingCart cart);

}

class Account {

	String name;
	String email;
	String phoneNumber;
	String userName;
	String password;

	List<Address> shippingAdresses;

	AccountStatus accountStatus;
}

class Address {

	int pinCode; //ZipCode
	String street;
	String city;
	String state;
	String country;
}

public enum AccountStatus {

	ACTVE,BLOCKED,INACTIVE;
}

class ShoppingCart {

	List<Item> items;
	double cartValue;

	public void addItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
	public void checkoutItems();
	public List<Item> getItems();
	public double getCartValue();
}

class Item {

	Product product;
	int qty;

}

class Product {

	int productId;
	String productDescription;
	String name;
	ProductCategory productCategory;
	Seller seller;
	double cost;

	List<ProductReview> productReviews;

}

public enum ProductCategory {

	ELECTRONICS,FURNITURE,GROCERY,MOBILE;
}

class ProductReview {

	String details;
	Buyer reviewer;
	int rating;

}

class search {

	public List<Product> searchByName(String name);
	public List<Product> searchByCategory(ProductCategory productCategory);
}

class Order {

	int orderId;
	List<Item> orderItem;
	double orderValue;
	Buyer buyer;
	Date orderDate;
	NotificationService notificationService;

	List<OrderLog> orderLog;

	public OrderStatus placeOrder();
	public OrderStatus trackOrder();
	public void addOrderLogs();
	public PaymentStatus makePayment(PaymentType paymentType);

}

public enum OrderStatus {

	PACKED, SHIPPED, ENROUTE, OUT_FOR_DELIVERY, DELIVERED, CANCELLED;
}

public enum PaymentStatus {

	SUCCESS, ERROR, CANCELLED, REFUND_INITIATED, REFUNDED;

}

public enum PaymentType {

	CREDIT_CARD, DEBIT_CARD, NET_BANKING, UPI;
}

class OrderLog {

	String orderDetail;
	Date createdDate;
	OrderStatus status;
}

class NotificationDomain {

	String notificationID;
	NotificationType notificationType;
	User user;

}

// Stratagy pattern and run time polimorphism
class NotificationService {

	public boolean sendNotification(NotificationDomain notificationDomain) {

		Notification notificationObject;
		MessageAttribute messageAttribute;

		switch(notificationDomain.getNotificationType()) {


			case NotificationType.EMAIL:
				notificationObject = new EmailNotification();
				messageAttribute = new MessageAttribute("abc@abc.com", notificationDomain.getUser().getAccount().getEmail(),"Order Detail ...");
				break;
			case NotificationType.WHATSAPP:
				notificationObject = new WhatsappNotification();
				messageAttribute = new MessageAttribute("9888888888", notificationDomain.getUser().getAccount().getPhoneNumber(),"Order Detail ...");
				break;
			default:
				notificationObject = new SMSNotification();
				messageAttribute = new MessageAttribute("988888888", notificationDomain.getUser().getAccount().getPhoneNumber(),"Order Detail ...");
				break;
		}

		return notificationObject.sendNotification(messageAttribute);
	}

}

class MessageAttributes {

	String to;
	String from;
	String message;

}

interface Notification {

	boolean sendNotification(MessageAttribute meesageAttribute);

}

class EmailNotification implements Notification {

	boolean sendNotification(MessageAttribute meesageAttribute);
}

class WhatsappNotification implements Notification {

	boolean sendNotification(MessageAttribute meesageAttribute);
}

class SMSNotification implements Notification {

	boolean sendNotification(MessageAttribute meesageAttribute);

}