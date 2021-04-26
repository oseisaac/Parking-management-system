package logic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ParkingSpaces {

	private int id;
	private boolean isPayed;
	private LocalTime time;
	private boolean isOccupied; 
	private Customer customer;
	private static ArrayList<ParkingSpace> spaces = new ArrayList<ParkingSpace>(Arrays.asList(new ParkingSpace(1),
			new ParkingSpace(2), new ParkingSpace(3), new ParkingSpace(4), new ParkingSpace(5), new ParkingSpace(6),
			new ParkingSpace(7), new ParkingSpace(8), new ParkingSpace(9), new ParkingSpace(10), new ParkingSpace(11),
			new ParkingSpace(12), new ParkingSpace(13), new ParkingSpace(14), new ParkingSpace(15)));

	public static boolean addSpace(int id) {
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i).id == id) {
				return false;
			} else if (i == spaces.size() - 1) {
				return spaces.add(new ParkingSpace(id));
			}
		}
		return false;
	}

	public static boolean removeSpace(int id) {
		for (ParkingSpace e : spaces) {
			if (e.getId() == id && !e.isOccupied) {
				return spaces.remove(e);
			}
		}
		return false;
	}

	public static ArrayList getSpaces() {
		return ParkingSpaces.spaces;
	}
	
	public static ParkingSpace getParkingSpace(int id) {
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i).id == id) {
				return spaces.get(i);
			} 
		}
		return null;
	}

	public static boolean contains(int parkingSpace) {
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i).id == parkingSpace) {
				return true;
			} 
		}
		return false;
	}
}
