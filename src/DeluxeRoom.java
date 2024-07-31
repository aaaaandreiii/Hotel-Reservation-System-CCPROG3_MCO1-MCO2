public class DeluxeRoom extends Room {
	public DeluxeRoom(int floor, int roomNum, String hotelName) {
		super(floor, roomNum, hotelName);

		this.roomType = "Deluxe Room";
		
		//set price as 120% of base rate
		this.roomTypeMultiplier = 1.2;
	}
}
