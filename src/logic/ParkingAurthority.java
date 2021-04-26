package logic;

public class ParkingAurthority extends User {

	public ParkingAurthority(String firstname, String lastname, String email, String password, String usertype,
			boolean isLoggedIn) {
		// TODO Auto-generated constructor stub
		super(firstname, lastname, email, password, usertype, isLoggedIn);
	}

	public boolean addSpace(int id) {
		return ParkingSpaces.addSpace(id);
	}

	public boolean removeSpace(int id) {
		return ParkingSpaces.removeSpace(id);
	}

	public boolean grantRequest(int bookingId) {

		for(Booking e: Bookings.getBookings()) {
			if(e.getBookingId() == bookingId) {
				return Bookings.remove(bookingId); 
			}
			
		}
		return false;
	}

	public boolean cancelRequest(int bookingId) {
		return Bookings.remove(bookingId);
	}

	public void test() {
		System.out.println("This is a TPA");
	}
}
