
public class RoomName {
	public String completeRoomName;

	public RoomName(Integer floorNumber, Integer roomNumber) {
		this.completeRoomName = floorNumber.toString() + roomNumber.toString();
		
		if (roomNumber > 9) 
			this.completeRoomName = floorNumber.toString() + roomNumber.toString();
		
		else 
			this.completeRoomName = floorNumber.toString() + "0" + roomNumber.toString();
	}
}
