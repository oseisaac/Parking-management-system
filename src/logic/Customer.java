package logic;

import java.time.LocalTime;
import java.util.ArrayList;

public class Customer extends User {

	private ArrayList<Booking> bookings;

	public Customer(String firstname, String lastname, String email, String password, String usertype,
			boolean isLoggedIn) {

		super(firstname, lastname, email, password, usertype, isLoggedIn);

	}

	public String addBooking(int parkingSpace, int duration,String plateNumber) {
		Booking nb = new Booking(parkingSpace,duration,plateNumber,this);
//		System.out.println(nb);
		return Bookings.addBooking(nb);
	}


	public String cancelBooking(int bookingId) {
		for(Booking e : this.getBookings()) {
			if(e.getBookingId() == bookingId) {
				if(!e.hasExpired()) {					
				this.getBookings().remove(e);
				Bookings.remove(e.getBookingId());
					return "true";
				}else {
					return "Booking Expired Already";
				}
			}
		}
		return "Faild";
	}
	public void removeByIndex(int index) {
		System.out.println("index "+index);
		for(int i=0; i < this.getBookings().size(); i++) {
			System.out.println("here "+ this.getBookings().get(i).getBookingId()+" "+(index==i));
			if(index == i) {
				this.cancelBooking(this.getBookings().get(i).getBookingId());
			}
		}
	}

	public ArrayList<Booking> getBookings() {
//		ArrayList<Booking> res =Bookings.getBooking(this);
		if(Bookings.getBooking(this) != null) {
			return Bookings.getBooking(this);
		}
		return bookings ;
	}

	public Booking getBooking(int parkingSpace) {
		ArrayList<Booking> bookings =getBookings();
		for(Booking e: bookings) {
			if(e.getParkingSpace() == parkingSpace) {
				return e;
			}
		}
		
		return null;
	}

	public void test() {
		System.out.println("This is a Customer");
	}
}
