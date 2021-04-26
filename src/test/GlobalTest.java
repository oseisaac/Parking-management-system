package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import logic.Auth;
import logic.Booking;
import logic.Bookings;
import logic.Customer;
import logic.DBReader;
import logic.ParkingAurthority;
import logic.ParkingSpaces;
import logic.SystemAdministrator;
import logic.User;



public class GlobalTest {

	User customer; 
	ParkingAurthority parkingOfficer;
	User systemAdmin;
	Auth auth ;
	
    @Before
    public void setUp() throws Exception {
    	auth = new Auth();
    	DBReader db = new DBReader();
    	db.removeRecord("globaltester@gmail.com");
    	
    	parkingOfficer = (ParkingAurthority) auth.login("one@gmail.com", "king");
		
    }

    
    @Test
    public void test_RegisterUser_and_Login() {
    	
    	boolean isRegistered = auth.Register("global", "tester", "globaltester@gmail.com", "123456");
    	
//    	User user_2 = auth.login("one@gmail.com", "king");
//    	System.out.println(isRegistered);
    	
    	Assert.assertEquals(isRegistered, true);
    	
    	//try to register same user again
    	boolean isRegistered_2 = auth.Register("global", "tester", "globaltester@gmail.com", "123456");
    	
//    	System.out.println(isRegistered_2);
    	
    	Assert.assertEquals(isRegistered_2, false);
    		
    }
    
    
    /**
     * Login with users in the be to see if right instance of the user is returned
     */
    
    @Test
    public void test_Customer_login() {
    	
    	
    	/**
    	 * Test a Customer Login
    	 */
		User user_3 = auth.login("davison@my.yorku.ca", "1896521");
		
    	Assert.assertEquals(user_3 instanceof Customer, true); 	

 }
    @Test
    public void test_SystemAdministrator_Login() {
    	
    	/**
    	 * Test a System Administrator  Login 
    	 */
    	User user = auth.login("osei@gmail.com", "123456");
    	
    	Assert.assertEquals(user instanceof SystemAdministrator, true);

    	 
    }
    @Test
    public void test_ParkingAuth_login() {
    	
    	
    	/**
    	 * Test a Toronto Parking Authority  Login
    	 */
    	User user_2 = auth.login("one@gmail.com", "king");
    	
    	Assert.assertEquals(user_2 instanceof ParkingAurthority, true);
    		
    }
    
    @Test
    public void test_Invalid_login() {
    	
    	
    	/**
    	 * Test a Customer Login
    	 */
    	User user_3 = auth.login("davisofdn@my.yorku.ca", "1896521");
    	
    	Assert.assertEquals(user_3 == null, true); 	

    }
    
    /**
     * test userFunctionality 
     */
    
    @Test
    public void test_Customer_Functionalities() {
    	
    	//register a new user customer
    	boolean isRegistered = auth.Register("global", "tester", "globaltester@gmail.com", "123456");
    	Assert.assertEquals(isRegistered, true);

    	//login the user
    	User user = auth.login("globaltester@gmail.com", "123456");
    	Assert.assertEquals(user instanceof Customer, true); 	
    	 
    	//test some basic functionss
    	Assert.assertEquals(user.getFirstname().equals("global"), true);
    	Assert.assertEquals(user.getLastname().equals("tester"), true);
    	Assert.assertEquals(user.getEmail().equals("globaltester@gmail.com"), true);
    	Assert.assertEquals(user.getUsertype().equals("C"), true);
    
    }

    /**
     * test userFunctionality 
     */
    
//    @Test
//    public void test_Customer_Advance_Functionalities() {
//    	
//    	//register a new user customer
//    	boolean isRegistered = auth.Register("global", "tester", "globaltester@gmail.com", "123456");
//    	Assert.assertEquals(isRegistered, true);
//
//    	//login the user
//    	Auth auth_2 = new Auth();
//    	Customer user =(Customer) auth_2.login("globaltester@gmail.com", "123456");
//    	Assert.assertEquals(user instanceof Customer, true); 	
//
////    	Customer user = new Customer("global", "tester", "globaltester@gmail.com", "123456", "C", true);
//    	
////    	System.out.println(Bookings.getBooking(user));
////    	System.out.println(user instanceof Customer);
////		System.out.println(user instanceof SystemAdministrator);
////		System.out.println(user instanceof ParkingAurthority);
//    	parkingOfficer.removeSpace(100);
//    	parkingOfficer.removeSpace(101);
//    	parkingOfficer.removeSpace(102);
//    	parkingOfficer.removeSpace(103);
//    	for(Booking e :Bookings.getBookings()) {
//    		if(e.getParkingSpace() == 100  ) {
//    			Bookings.removeBySpace(100);
//    		}else if( e.getParkingSpace() == 101) {
//    			Bookings.removeBySpace(101);
//    		}else if( e.getParkingSpace() == 102) {
//    			Bookings.removeBySpace(102);
//    		}else if(e.getParkingSpace() == 103) {
//    			Bookings.removeBySpace(103);
//    		}	
//    	}
//    	
//    	// add a new booking space for testing
//    	parkingOfficer.addSpace(100);
//    	parkingOfficer.addSpace(101);
//    	parkingOfficer.addSpace(102);
//    	parkingOfficer.addSpace(103);
//    	
//    	System.out.println(ParkingSpaces.getSpaces().size()+" "+user.getEmail());
//    	// add booking 
//
//    	
//    	Assert.assertEquals(user.addBooking(100, 60, "123xyz").equals("true"), true); 
//    	Assert.assertEquals(user.addBooking(100, 30, "123xyz").equals("Parking space is not available"), true); 
//    	Assert.assertEquals(user.addBooking(101, 60, "123xyz").equals("true"), true); 
//    	Assert.assertEquals(user.addBooking(102, 60, "123xyz").equals("true"), true); 
//    	Assert.assertEquals(user.addBooking(103, 60, "123xyz").equals("Max number of booking reached"), true); 
//    	
//    	
//    }

   
	
}


