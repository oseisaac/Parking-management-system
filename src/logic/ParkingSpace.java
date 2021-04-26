package logic;

public class ParkingSpace {

	int id;
	boolean isOccupied;
	
	ParkingSpace(int id){
			this.id=id;
			this.isOccupied=false;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getId() {
		return id;
	}
	
	
}
