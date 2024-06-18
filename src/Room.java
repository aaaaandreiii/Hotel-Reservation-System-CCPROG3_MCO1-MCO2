import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Room {
	private String sRoomName;
	public static double dBasePricePerNight;
	private final Set<String> existingRoomNumbers = new HashSet<>();
	
	public Room(int floor, int roomNum) {
		this.setsRoomName(floor, roomNum);
		
		if (existingRoomNumbers.contains(this.sRoomName)) {
			throw new IllegalArgumentException("This room already exists");
		}
		existingRoomNumbers.add(this.sRoomName);

		this.dBasePricePerNight = 1299.00;
	}
	
	public String getsRoomName() {
		return sRoomName;
	}

	public void setsRoomName(int floor, int roomNum) {
		RoomName name = new RoomName(floor, roomNum);
		this.sRoomName = name.completeRoomName;
	}

	public double getdBasePricePerNight() {
		return dBasePricePerNight;
	}

	public void setdBasePricePerNight(double dBasePricePerNight) {
		this.dBasePricePerNight = dBasePricePerNight;
	}
}
