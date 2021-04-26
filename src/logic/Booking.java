package logic;

import java.time.LocalTime;
import java.util.UUID;

/**
 * @author oseis
 *
 */
public class Booking {

	private int bookingId;
	private int parkingSpace;
	private boolean isPaid;
	private boolean isGranted;
	private LocalTime time;
	private LocalTime expiry;
	private int duration;
	private String plateNumber;
	private Customer user;
	
	
	public Booking(int parkingSpace, int duration,String plateNumber,Customer user) {
		this.bookingId = (Bookings.getBookings().size()+1) * 10;
		this.parkingSpace = parkingSpace;
		this.time = null;
		this.duration = duration;
		this.plateNumber =plateNumber;
		this.isPaid = false;
		this.user=user;
		this.isGranted=false;
	}
	
	public Booking( int bookingId, int parkingSpace, boolean isPaid,LocalTime time, int duration,String plateNumber,Customer user) {
		this.bookingId = bookingId;
		this.parkingSpace = parkingSpace;
		this.isPaid = isPaid;
		this.time = time;
		this.duration = duration;
		this.plateNumber =plateNumber;
		this.user=user;
	}

	public int getBookingId() {
		return bookingId;
	}

	public int getParkingSpace() {
		return parkingSpace;
	}
	public boolean getIsGranted() {
		return this.isGranted;
	}
	public void setIsGranted( boolean isGranted) {
		 this.isGranted = isGranted;
		 
	}


	public LocalTime getExpiry() {
		if(time != null) {
			return this.time.plusMinutes(this.duration);
		}
		return null;
	}

	public Customer getUser() {
		return user;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}


	public boolean isPaid() {
		return isPaid;
	}


	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}


	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingId < 1) {
			if (other.bookingId < 1)
				return false;
		} else if (bookingId != other.bookingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", parkingSpace=" + parkingSpace + ", isPaid=" + isPaid + ", time="
				+ time + ", expiry=" + expiry + ", duration=" + duration + ", plateNumber=" + plateNumber + ", user="
				+ user + "]";
	}

	public boolean hasExpired() {
		if(this.getExpiry() != null) {			
			if( this.getExpiry().compareTo(LocalTime.now()) <= 0 ) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
		
		System.out.println(LocalTime.now());
		System.out.println(LocalTime.parse("05:09"));
		System.out.println(LocalTime.parse("10:09").compareTo(LocalTime.now()));
	}



}
