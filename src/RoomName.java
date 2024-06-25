/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: RoomName.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/*
 * An object class that creates a formatted "room name" for every instance of the Room object
 */
public class RoomName {
	/**
	 * The only attribute that this class really needs is a String to store the room's complete name. 
	 * 		This string/complete name is consisted of a room's floor number and room number.
	 * 		This implies that the user will be asked to specify and supply these two conditions before the name of a room is created.
	 */
	public String completeRoomName;

	/**
	 * This constructor is used as a template to create a RoomName for each Room instance. 
	 * It requires the following parameters ands appends each in a formatted manner:
	 * @param floorNumber - a user-inputted integer that dictates the floor number assignment of a room
	 * @param roomNumber - a user-inputted integer that dictates the numbering of the room for every floor
	 */
	public RoomName(Integer floorNumber, Integer roomNumber) {
		if (roomNumber > 9) 
			this.completeRoomName = floorNumber.toString() + roomNumber.toString();
		
		else 
			this.completeRoomName = floorNumber.toString() + "0" + roomNumber.toString();
	}
}
