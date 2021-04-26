package logic;

public class Auth {
	

	
	public User login(String email,String password) {
		DBReader db = new DBReader();
		User user = db.getUser(email, password);
		 
		if(user != null ) {
			System.out.println(user);
			return db.getUser(email, password);
		}
		
		return null;
	}
	
	public static boolean Register(String firstname, String lastname, String email, String password) {
		DBReader db = new DBReader();
		String usertype="C";
		
		if(db.addRecord(firstname, lastname, email, password, usertype)) {
			return true;
		}
		
		return false;
	}
	
	
}
