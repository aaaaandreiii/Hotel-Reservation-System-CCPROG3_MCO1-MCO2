public class StandardRoom extends Room {
	public StandardRoom(int floor, int roomNum, String hotelName) {
		super(floor, roomNum, hotelName);

		this.roomType = "Standard Room";

		//set price as 100% of base rate
		this.roomTypeMultiplier = 1.0;
	}
}
