//When ever we start any Low Level Design Problem we start with the class of the base system and then we start
// defining the complex object and try to decouple as much as possible and then start defining all actors and their use case based upon relationship with different actors
public class Library{
    String name;
    Address location;
    List<BookItem> books;
}

class Address {
    int pincode;
    String street;
    String city;
    String state;
    String country;
}

class Book {
    String uniqueIdNumber;
    String title;
    List<Author> authors;
    BookType bookType; // enum
}

class BookItem extends Book{
    String barcode; // different for each book
    Date publicationDate;
    Rack rackLocation; // other complex class
    BookShelf bookShelf;
    BookFormat bookFormat; //enum {Hardcover, journal etx}
    Date issueDate;
}
// Always try to make complex to class to decouple responsibilities

public enum BookType {

	SCI_FI, ROMANTIC, FANTASY, DRAMA;
}

public enum BookFormat {

	HARDCOVER, PAPERBACK, NEWSPAPER, JOURNAL;
}

public enum BookStatus {

	ISSUED, AVAILABLE, RESERVED, LOST;
}

class Tack{
    int number;
    String locationId;
}

class Person {
    String firstName;
    String lastName;
}

class Author extends Person{
    List<Book> bookPublished; // all the books that author has publushed adn help to search books as per author name
}

class SystemUser extends Person{
    String Email;
    String PhoneNumber;
    Account account;
}

class Member extends SystemUser{
    int totalBookCheckOuts;
    Search searchObj; // as this method is shared by other entities
    BookIssueService issueService;
}

class Librarian extends SystemUser {
    Search searchObj;
    BookIssueService issueService;
	public void addBookItem(BookItem bookItem);
	public BookItem deleteBookItem(String barcode); 
	public BookItem editBookItem(BookItem bookItem);
}

class Account {

	String userName;
	String password;
	int accountId;
}

class Search {

	public List<BookItem> geBookByTitle(String title);
	public List<BookItem> geBookByAuthor(Author author);
	public List<BookItem> geBookByType(BookType bookType);
	public List<BookItem> geBookByPublicationDate(Date publicationDate);

}

class BookIssueService {

	Fine fine;

	public BookReservationDetail getReservationDetail(BookItem book);

	public void updateReservationDetail(BookReservationDetail bookReservationDetail);

	public BookReservationDetail reserveBook(BookItem book, SystemUser user);

	public BookIssueDetail issueBook(BookItem book, SystemUser user);

	// it will internaly call the issueBook function after basic validations
	public BookIssueDetail renewBook(BookItem book, SystemUser user); 

	public void returnBook(BookItem book, SystemUser user);

}

class BookLending {

	BookItem book;
	Date startDate;
	SystemUser user;
}

class BookReservationDetail extends BookLending {

	ReservationStatus reservationStatus;

}

class BookIssueDetail extends BookLending {

	Date dueDate;

}

class Fine {

	Date fineDate;
	BookItem book;
	SystemUser user;

	public double calculateFine(int days);
}

