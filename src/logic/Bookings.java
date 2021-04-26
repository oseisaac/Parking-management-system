package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

public class Bookings {
	
	private static ArrayList<Booking> bookings ;
	
	
/**
 * 
 * @param booking
 * return true if added and false otherwise
 */
	
	
	public static String addBooking(Booking booking) {
		fetchDb();
		int userOccurrence=0;

		if(ParkingSpaces.contains(booking.getParkingSpace())){ 
		for(int i = 0; i < Bookings.bookings.size(); i++) {
			if(Bookings.bookings.get(i).getParkingSpace() == booking.getParkingSpace()) {
				return "Parking space is not available";
			}
			if(Bookings.bookings.get(i).getUser().getEmail().equals(booking.getUser().getEmail())) {
				userOccurrence++;
			}
			if(userOccurrence >= 3) {
				return "Max number of booking reached";
			}
			else if(i==Bookings.bookings.size()-1) {
//				System.out.println("here");
				Bookings.bookings.add(booking);
				Bookings.setDb();
				return "true";
			}
		}
		}
		
		return "Invaild parking space";
	}

	public static ArrayList<Booking> getBookings() {
		fetchDb();
		
		return bookings;
	}


	public static boolean remove(int bookingId) {
		fetchDb();
		System.out.println(bookingId);
		for(Booking e : bookings) {
//			System.out.println(e);
			System.out.println(e.getBookingId() == (bookingId));
			if(e.getBookingId() == (bookingId)) {
				 boolean update = bookings.remove(e);
				 Bookings.setDb();
				return update;
			}
		}
		return false;
	}
	public static boolean removeBySpace(int parkingSpace) {
		fetchDb();
		for(Booking e : bookings) {
//			System.out.println(e);
			if(e.getParkingSpace() == (parkingSpace)) {
				 boolean update = bookings.remove(e);
				 Bookings.setDb();
				return update;
			}
		}
		return false;
	}
	
	public static ArrayList getBooking(Customer user) {
		fetchDb();
		ArrayList<Booking> userBookings =  new ArrayList<Booking>();
		for(Booking e : bookings) {
//			System.out.println(e);
			if(e.getUser().getEmail().equals(user.getEmail())) {
				userBookings.add(e);
			}
		}
		if(userBookings.size() > 0) {
			return userBookings;
		}
		return null;
	}
	public static Booking getBooking(String firstname, String lastname, String email, int parkingSpace) {
		fetchDb();
		for(Booking e : bookings) {
//			System.out.println(e);
			if(e.getUser().getEmail().equals(email) && e.getUser().getLastname().equals(lastname) && e.getParkingSpace() == parkingSpace ) {
				return e;
			}
		}
		return null;
	} 
	
	private static void fetchDb() {
		try {
			File myObj = new File("bookingsDB.txt");
			BufferedReader br = new BufferedReader(new FileReader(myObj));
			String str;
			int count = 0;
			Bookings.bookings = new ArrayList<Booking>();
			while ((str = br.readLine()) != null) {
//					    System.out.println(str);
				if (count != 0) {
					String[] tokens = str.split(",");
					
					// access user db to get user object
					DBReader db = new DBReader();
					Customer user = (Customer) db.getUser(tokens[6]);
//					System.out.println(user);
					
										
					Booking newB = new Booking(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]) ,Boolean.parseBoolean(tokens[2]),tokens[3].equals("null") ? null :LocalTime.parse(tokens[3]), Integer.parseInt(tokens[4]), tokens[5],user);
//					System.out.println(newB.toString());
					Bookings.bookings.add(newB);
				}
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private static void setDb() {

		try {

			File myObj = new File("bookingsDB.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(myObj));
			bw.write("bookingId,parkingSpace,isPaid,time,duration,plateNumnber,userEmail");
			bw.newLine();
				for (int i = 0; i < Bookings.bookings.size(); i++) {
					bw.write(Bookings.bookings.get(i).getBookingId() + "," + Bookings.bookings.get(i).getParkingSpace() + "," + Bookings.bookings.get(i).isPaid() + "," + Bookings.bookings.get(i).getTime() +"," + Bookings.bookings.get(i).getDuration()+","+Bookings.bookings.get(i).getPlateNumber()+","+Bookings.bookings.get(i).getUser().getEmail());
					bw.newLine();
				}

//			bw.newLine();
			bw.close();
			fetchDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	public static void main(String[] args) {

		DBReader db = new DBReader();
		Customer user = (Customer) db.getUser("sdfs","sdfsdf");
		System.out.println(Bookings.getBookings());
		Booking newB = new Booking(12,15 ,false,LocalTime.parse("02:01"),60, "abc123",user );
		System.out.println(Bookings.addBooking(newB));
//		Booking g = Bookings.getBooking(UUID.fromString("61e31128-b0fc-4dae-ae69-7d5c4d1f25ea"));
//		System.out.println(g);
		
//		System.out.println(Bookings.remove(UUID.fromString("68656c02-550d-4093-8c9f-77f45c696335")));
		
	}

	
	
	
	

}
