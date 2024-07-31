public class ExecutiveRoom extends Room {
	public ExecutiveRoom(int floor, int roomNum, String hotelName) {
		super(floor, roomNum, hotelName);

		this.roomType = "Executive Room";
		
		//set price as 135% of base rate
		this.roomTypeMultiplier = 1.35;
	}
}
