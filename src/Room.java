/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: Room.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/**
 * The following libraries were imported to be used in certain sections of the program:
 * 		HashMap - imported in order to store a key/value variable in the system for roomID/hotel name
 * 		HashSet - imported in order to make double sure that no room IDs are duplicated during runtime. Checked once during initialization, checked another time by the nature of HashSets.
 * 		Set - imported in order to allow HashSets to work.
 * 		Random - imported in order to randomize the Reservation Numbers generated.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class represents a Room in a hotel, with attributes and methods to manage room reservations.
 */
public class Room {
	/**
	 * The following variables are declared to be used by the Room class:
	 * 		a public static final HashSet of all existing Room IDs - to ensure no duplicate room IDs across the system.
	 * 		a public static double variable for the base price per night for a room - for easier access and updating to each room's base price, as it was indicated in the specs that there is only one constant price for all rooms in the hotel
	 * 		a private HashMap variable to store a key and value of the room ID and the corresponding hotel name - for easier finding and processing with just the reservation number
	 * 		a private String for the room's name (not to be confused by the room's identification number)
	 * 		a private HashSet to store unique existing room numbers within just the hotel
	 * 		a private boolean array for every room instance to store the 365 days in one year.
	 */
	public static final Set<Integer> existingRoomIDs = new HashSet<>();		//refers to room names INSIDE hotel reservation system
	public static double dBasePricePerNight = 1299;							//room ID is assigned to reservation

	private HashMap<Integer, String> roomIDWithHotelNameMap = new HashMap<>();
	private String sRoomName;
	private final Set<String> existingRoomNumbers = new HashSet<>();		//refers to room names inside hotel
	private boolean[] dateRoomReserved = new boolean[366];					//Tracks room reservations for each day of the 2024 leap year
	
	/**
	 * This constructor initializes a Room object with a floor number, room number, and hotel name.
	 * It generates a unique room ID, sets the room name, and initializes the reservation status for the year.
	 * @param floor - the floor number of the room.
	 * @param roomNum - the room number of the room.
	 * @param hotelName - the name of the hotel.
	 */
	public Room(int floor, int roomNum, String hotelName) {
		int roomID = this.generateRoomID();
		String hotel = hotelName; 
		this.roomIDWithHotelNameMap.put(roomID, hotel);
		
		this.setsRoomName(floor, roomNum);
		
		if (existingRoomNumbers.contains(this.sRoomName)) {
			throw new IllegalArgumentException("This room already exists");
		}
		existingRoomNumbers.add(this.sRoomName);
		
		//initialize dateRoomReserved
		for (int i = 0; i < 365; i++) {
			this.dateRoomReserved[i] = false;
		}	
	}
	
	/**
	 * This method returns the map of room IDs with their associated hotel names.
	 * @return roomIDWithHotelNameMap - a map of room IDs and hotel names.
	 */
	public HashMap<Integer, String> getRoomIDWithHotelNameMap() {
		return this.roomIDWithHotelNameMap;
	}

	/**
	 * This method returns the room ID of the current room.
	 * @return roomID - the unique room ID.
	 */
	public int getRoomID() {
		return (int) this.roomIDWithHotelNameMap.keySet().toArray()[0];
	}
	
	/**
	 * This method generates a unique room ID for the room.
	 * It ensures that the generated ID is not already in use.
	 * @return randomRoomIDNumber - the generated unique room ID.
	 */
	public int generateRoomID() {
		Random randomNumber = new Random();
		int randomRoomIDNumber;
		
		do {
			randomRoomIDNumber = randomNumber.nextInt(99999);
		} while (existingRoomIDs.contains(randomRoomIDNumber));
		
		existingRoomIDs.add(randomRoomIDNumber);
		
		return randomRoomIDNumber;
	}
	
	/**
	 * This method converts a Date object into the corresponding day of the year.
	 * @param date - the date to be converted.
	 * @return conversion - the day of the year corresponding to the date.
	 */
	public int DayOfTheYear(Date date) {
		int conversion = 0;
		int month = date.getnMonth();
		int[] numOfDaysPerMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 0; i < month - 1; i++) {
			conversion += numOfDaysPerMonth[i];
		}
		
		conversion += date.getnDay();
		
		return conversion;
	}

	/**
	 * This method sets the room as reserved for the specified date range.
	 * @param CheckIn - the check-in date.
	 * @param CheckOut - the check-out date.
	 */
	public void setDateRoomReserved(Date CheckIn, Date CheckOut) {
		int date1 = DayOfTheYear(CheckIn);
		int date2 = DayOfTheYear(CheckOut);
		
		for (date1 = DayOfTheYear(CheckIn); date1 < date2; date1++) {
			this.dateRoomReserved[date1] = true;
		}
	}
	
	/**
	 * This method checks if the room is booked for the specified date range.
	 * @param CheckIn - the check-in date.
	 * @param CheckOut - the check-out date.
	 * @return true if the room is booked for any date in the range, false otherwise.
	 */
	public boolean checkIfRoomIsBooked(Date CheckIn, Date CheckOut) {
		int date1 = DayOfTheYear(CheckIn);
		int date2 = DayOfTheYear(CheckOut);
		
		for (date1 = DayOfTheYear(CheckIn); date1 < date2; date1++) {
			if (this.dateRoomReserved[date1] == true) {
				return true;
			} else if (this.dateRoomReserved[date1] == false && this.dateRoomReserved[date1++] == true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks if the room is booked on a specific date with a Date dataype parameter.
	 * @param date - the date to check.
	 * @return true if the room is booked on the date, false otherwise.
	 */
	//used in check availability of rooms
	public boolean checkIfRoomIsBooked(Date date) {
		int date1 = DayOfTheYear(date);
		
		if (this.dateRoomReserved[date1] == true)
			return true;
		else
			return false;
	}
	
	/**
	 * This method checks if the room is booked between two specific dates.
	 * @param date1 - the start date as an integer (check-in).
	 * @param date2 - the end date as an integer (check-out).
	 * @return true if the room is booked for any date in the range, false otherwise.
	 */
	//used in remove room
	public boolean checkIfRoomIsBooked(int date1, int date2) {	
		for (date1 = date1; date1 < date2; date1++) {
			if (this.dateRoomReserved[date1] == true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks if the room is booked on a specific date with an int dataype parameter.
	 * @param date - the date to check as an integer from the nth day of the year method converter.
	 * @return true if the room is booked on the date, false otherwise.
	 */
	//used in update booking price
	public boolean checkIfRoomIsBooked(int date) {
		if (this.dateRoomReserved[date] == true)
			return true;
		else
			return false;
	}
	
	/**
	 * This method returns the array tracking room reservations for each day of the year.
	 * @return dateRoomReserved - an array indicating reservation status for each day.
	 */
	public boolean[] getDateRoomReserved() {
		return dateRoomReserved;
	}
	
	/**
	 * This method prints the dates on which the room is reserved.
	 * It outputs the dates in DD-MM-YYYY format.
	 */
	public void printDateRoomReserved() {
		int[] numOfDaysPerMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int counter = 0;
		
		for (int i = 0; i < 365; i++) {
			if (this.getDateRoomReserved()[i] == true) {
				System.out.println("\nThe following dates are in DD-MM-YYYY format.");
				counter++;
				int dayInYear = i;
				int monthToday, dayToday;
				
				int daysPerMonth = 0;
				int j = 0;
				
				do {
					daysPerMonth += numOfDaysPerMonth[j];
					j++;
				} while (daysPerMonth < dayInYear);
				
				monthToday = j;
				
				daysPerMonth = daysPerMonth - numOfDaysPerMonth[j--] + 1;
				
				dayToday = dayInYear - daysPerMonth;
				
				System.out.printf("\nThis room is reserved on %d/%d/%d", dayToday, monthToday, 2024);
				//TODO
//				System.out.printf("\nThis room is reserved on %d/%d/%d by Guest %s", 
//						monthToday, dayToday, 2024, this.reservation.get(i).getsGuestName());			
			} 
		}
		if (counter == 0)
			System.out.println("This room has neither active nor incoming bookings as of today.");
	}

	/**
	 * This method is a getter for the Room Name variable.
	 * @return sRoomName - room name (floor num + room num)
	 */
	public String getsRoomName() {
		return sRoomName;
	}

	/**
	 * This method is a setter for the Room Name variable.
	 * This invokes an instance of the Room Name object and passes the two parameters to it for a unique formatted room name to be generated.
	 * @param floor - floor number of the room
	 * @param roomNum - room number of the room on the floor
	 */
	public void setsRoomName(int floor, int roomNum) {
		RoomName name = new RoomName(floor, roomNum);
		this.sRoomName = name.completeRoomName;
	}

	/**
	 * This method is a getter for the base price per night of the room.
	 * @return dBasePricePerNight - the base price per night of the room.
	 */
	public double getdBasePricePerNight() {
		return dBasePricePerNight;
	}
	
	/**
	 * This method is a setter for the base price per night of the room.
	 * @param price - base price per night of the room.
	 */
	public void setdBasePricePerNight(double price) {
		Room.dBasePricePerNight = price;
	}
}