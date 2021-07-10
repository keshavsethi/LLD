public class BMSService  {

	List<CinemaHall> cinemas;

	public List<Movie> getMovies(Date date, String city);
	public List<CinemaHall> getCinemalHalls(String city);

}

public class CinemaHall {

	int cinemaHallId;
	String cinemaHallName;

	Address address;

	List<Audi>audiList;

	public Map<Date, Movies> getMovies(List<Date> dateList);
	public Map<Date, Show> getShows(List<Date> dateList);

}

public class Address {

	int pinCode; //ZipCode
	String street;
	String city;
	String state;
	String country;

}

public class Audi {

	int audiId;
	String audiName;
	int totalSeats;
	
	List<Show> shows;

}

public class Show {

	int showId;
	Movie movie;
	Date startTime;
	Date endTime;
	CinemaHall cinemaPlayedAt;
	List<Seat> seats;

}

public class Seat {

	int seatId;
	SeatType seatType;
	SeatStatus seatStatus;
	Double price;

}


public enum SeatType {

	DELUX, VIP, ECONOMY, OTHER;

}

public enum SeatStatus {

	BOOKED, AVAILABLE, RESERVED, NOT_AVAILABLE;

}

public class Movie {

	String movieName;
	int movieId;
	int durationInMins;
	String language;
	Genre genre;
	Date releaseDate;
	Map<String, List<Show>> cityShowMap;

}

public enum Genre {

	SCI_FI, DRAMA, ROM_COM, FANTASY;
}

public class User {

	int userId;
	Search searchObj;

}

public class SystemMember extends User {

	Account account;
	String name;
	String email;
	Address address;

}



public class Member extends SystemMember {

	public Booking makeBooking(Booking booking);
	public List<Booking> getBooking();

}

public class Admin extends SystemMember {

	public boolean addMovie(Movie moivie);
	public boolean addShow(Show show);

}

public class Account {

	String userName;
	String password;

}

public class Search {

	public List<Movie> searchMoviesByNames(String name);
	public List<Movie> searchMoviesByGenre(Genre genre);
	public List<Movie> searchMoviesByLanguage(String language);
	public List<Movie> searchMoviesByDate(Date releaseDate);
}

public class Booking {

	String bookingId;
	Date bookingDate;
	Member member;
	Audi audi;
	Show show;
	BookingStatus bookingStatus;
	double totalAmount;
	List<Seat> seats;
	Payment paymentObj;

	public boolean makePayment(Payment payment);

}

public class Payment {

	double amount;
	Date paymentDate;
	int transactionId;
	PaymentStatus paymentStatus;

}

public enum BookingStatus {

	REQUESTED, PENDING, CONFIRMED, CANCELLED;
}

public enum PaymentStatus {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}
