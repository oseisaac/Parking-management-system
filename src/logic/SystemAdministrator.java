package logic;

import java.util.UUID;

public class SystemAdministrator extends User {

	public SystemAdministrator(String firstname, String lastname, String email, String password, String usertype,
			boolean isLoggedIn) {
		// TODO Auto-generated constructor stub

		super(firstname, lastname, email, password, usertype, isLoggedIn);
	}

	public boolean addParkingOfficer(String firstname, String lastname, String email, String password) {
		DBReader db = new DBReader();

		return db.addRecord(firstname, lastname, email, password, "TPA");
	}

	public boolean removeParkingOfficer(String email) {
		DBReader db = new DBReader();
		return db.removeRecord(email);
	}

	public boolean changePaymentStatus(String firstname, String lastname, String email, int parkingSpace) {


		Booking e = Bookings.getBooking(firstname, lastname, email, parkingSpace);
		if (e != null) {
			e.setPaid(true);
			return true;
		}

		return false;
	}

	public void test() {
		System.out.println("This is a System Administrator");
	}

}
