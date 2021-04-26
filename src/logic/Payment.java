package logic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Payment {

	private final static double pricePerMinutes = 0.5;
	private int id;
	private LocalTime orderTime;
	public static ArrayList<String> payedUsers =  new ArrayList<String>(Arrays.asList("jame@gmail.com","peter@my.yorku.ca","davison@my.yorku.ca"));
	
	
	public Payment() {
		
	}
	
	
	public static double getTotalPrice(ArrayList<Booking> toCheckout) {
		
		double total=0;
		for(Booking e: toCheckout) {
			total+=e.getDuration()*pricePerMinutes;
		}
		
		return total;
	}
	
	public static String pay(ArrayList<Booking> toCheckout, Customer user) {
	
		for(int i =0; i< toCheckout.size(); i++) {
			if(!toCheckout.get(i).getIsGranted()) {
				return "An Item in you selection has not be approved";
			}
			else if(i == toCheckout.size()-1){
				return "true";
			}
		}
		
		
		return "Somthing went wrong";
	}
	
}
