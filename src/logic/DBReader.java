package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DBReader {

	private ArrayList<String> firstnames;
	private ArrayList<String> lastnames;
	private ArrayList<String> emails;
	private ArrayList<String> passwords;
	private ArrayList<String> usertypes;

	public DBReader() {

		fetchDb();
	}

	private void fetchDb() {
		emails = new ArrayList<String>();
		passwords = new ArrayList<String>();
		firstnames = new ArrayList<String>();
		lastnames = new ArrayList<String>();
		usertypes= new ArrayList<String>();
		try {
			File myObj = new File("users.txt");
			BufferedReader br = new BufferedReader(new FileReader(myObj));
			String str;
			int count = 1;
			while ((str = br.readLine()) != null) {
//					    System.out.println(str);
				if (count != 0) {

					String[] tokens = str.split(",");
					for (int i = 0; i < tokens.length; i++) {
//						System.out.print(tokens[i]+" ");
						if (i == 0) {
							firstnames.add(tokens[i]);
						} else if (i == 1) {
							lastnames.add(tokens[i]);

						} else if (i == 2) {
							emails.add(tokens[i]);
						} else if (i == 3) {
							passwords.add(tokens[i]);
						}
						else if (i == 4) {
							usertypes.add(tokens[i]);
						}
					}
//					System.out.println();
				}
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void setDb() {

		try {

			File myObj = new File("users.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(myObj));
			if (emails.size() > 0) {
				for (int i = 0; i < emails.size(); i++) {
					bw.write(firstnames.get(i) + "," + lastnames.get(i) + "," + emails.get(i) + "," + passwords.get(i)+"," + usertypes.get(i));
					bw.newLine();
				}
			}

//			bw.write("peter,null,peter@my.yorku.ca,null");
//			bw.newLine();
			bw.close();
			fetchDb();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @return boolean true if added and false otherwise
	 */

	public boolean addRecord(String firstname, String lastname, String email, String password, String usertype) {
		if (firstname != null && lastname != null && email != null && password != null) {

//			System.out.println(firstname+" "+lastname);
			// check if record already exist before adding
			if (!this.emails.contains(email)) {
				this.emails.add(email);
				this.firstnames.add(firstname);
				this.lastnames.add(lastname);
				this.passwords.add(password);
				this.usertypes.add(usertype);
				this.setDb();
				return true;
			}
		} else {
			throw new Error("Missing field while adding a new record");
		}
		return false;
	}

	public boolean removeRecord(String email) {
		
		for(int i=0; i< emails.size();i++) {
			if(emails.get(i).equals(email)) {
				this.emails.remove(email);
				this.firstnames.remove(i);
				this.lastnames.remove(i);
				this.passwords.remove(i);
				this.usertypes.remove(i);
				this.setDb();
				return true;
			}
		}
		
		return false;
	}
	
	
	public User getUser(String email, String password) {
//		System.out.println("index of email "+ this.emails.indexOf(email));
//		System.out.println("index of password "+ this.passwords.indexOf(password));
//		System.out.println("contains email "+ this.emails.contains(email));
//		System.out.println(this.emails.contains(email) && this.passwords.contains(password) && (this.emails.indexOf(email) == this.passwords.indexOf(password)));
		if (this.emails.contains(email) && this.passwords.contains(password) && (this.passwords.get(emails.indexOf(email)).equals(password))) {
			int index =   this.emails.indexOf(email);
			if(usertypes.get(index).equals("SA")) {
				User user = new SystemAdministrator(firstnames.get(index), lastnames.get(index), emails.get(index), passwords.get(index),usertypes.get(index),true);
				return user;
			}
			else if(usertypes.get(index).equals("TPA")) {
				User user = new ParkingAurthority(firstnames.get(index), lastnames.get(index), emails.get(index), passwords.get(index),usertypes.get(index),true);
				return user;
			}
			else {
				User user = new Customer(firstnames.get(index), lastnames.get(index), emails.get(index), passwords.get(index),usertypes.get(index),true);
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param email - get a user by unique email
	 * @return User
	 */
	public User getUser(String email) {
		if (this.emails.contains(email)) {
			int index = this.emails.indexOf(email);
			User user = new Customer(firstnames.get(index), lastnames.get(index), emails.get(index), passwords.get(index),usertypes.get(index),false);
			return user;
		}		
		return null;
	}
	private ArrayList<String> getEmails() {
		return emails;
	}

	private ArrayList<String> getPasswords() {
		return passwords;
	}

	private ArrayList<String> getFirstnames() {
		return firstnames;
	}

	private ArrayList<String> getLastnames() {
		return lastnames;
	}

	public static void main(String[] args) {
		DBReader db = new DBReader();
		System.out.println(db.emails.toString());
//		System.out.println(db.passwords.toString());
		System.out.println(db.addRecord("dsf", "ds", "davsidsfson@my.yorku.ca", "1896523421","TPA"));
//		System.out.println(db.getUser("davsison@my.yorku.ca", "1896523421"));
		System.out.println(db.emails.toString());
	}


}
