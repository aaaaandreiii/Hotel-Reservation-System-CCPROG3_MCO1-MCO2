import java.util.HashSet;
import java.util.Set;

public class Room {
	private String sRoomName;
	private int RoomStatus;
	public static double dBasePricePerNight;
	private final Set<String> existingRoomNumbers = new HashSet<>();
	private Reservation reservation; 

	public Room(int floor, int roomNum) {
		this.setsRoomName(floor, roomNum);
		
		if (existingRoomNumbers.contains(this.sRoomName)) {
			throw new IllegalArgumentException("This room already exists");
		}
		existingRoomNumbers.add(this.sRoomName);
		
		this.RoomStatus = 0;
		this.dBasePricePerNight = 1299.00;
	}
	
	public String getsRoomName() {
		return sRoomName;
	}
	
	//room status = 0 means unoccupied/unbooked
	//room status = 1 means occupied/booked
//	public String getRoomStatus() {
//		//if 
//		return RoomStatus;
//	}

	public void setsRoomName(int floor, int roomNum) {
		RoomName name = new RoomName(floor, roomNum);
		this.sRoomName = name.completeRoomName;
	}

	public double getdBasePricePerNight() {
		return dBasePricePerNight;
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
