package logic;

import java.util.ArrayList;

public class User {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String usertype ;
	private boolean isLoggedIn ;

	

	public User(String email, String password) {
		this.email = email;
		this.password = password;
		this.isLoggedIn = false;
	}
	
	public User(String firstname, String lastname, String email, String password,String usertype,boolean isLoggedIn) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
		this.usertype = usertype;
		
	}
	




	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}



	public String getEmail() {
		return email;
	}
	public String getUsertype() {
		return usertype;
	}

	protected void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	protected String getPassword() {
		return password;
	}



	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ ", usertype=" + usertype + ", isLoggedIn=" + isLoggedIn + "]";
	}

	
	

}
