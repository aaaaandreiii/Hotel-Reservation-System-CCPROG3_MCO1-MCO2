/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: Hotel.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/**
 * The following libraries were imported to be used in certain sections of the program:
 * 		HashSet - imported in order to make double sure that no hotel names are duplicated during runtime. Checked once during initialization, checked another time by the nature of HashSets.
 * 		Set - imported in order to allow HashSets to work.
 * 		ArrayList - imported in order to store dynamic arrays for the different data types in this program.
 * 		Scanner - imported to use system.in inputs.
 */
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This class represents a Hotel in the Hotel Reservation System.
 */
public class Hotel {
	/**
	 * The following variables are declared to be used by the Hotel class:
	 * 		a public static final HashSet to store all unique hotel names during runtime
	 * 		a private String to store the hotel's name
	 * 		a private array to store all hotel rooms
	 * 		a private array to store all hotel reservations
	 */
	public static final Set<String> existingNames = new HashSet<>();	//hashSet to create unique hotel names
	
	private String sHotelName;
	private ArrayList<Room> hotelRooms = new ArrayList<>();
	private ArrayList<Reservation> hotelReservations = new ArrayList<>();

	/**
	 * Constructor to create a new hotel with the specified name.
	 * Initializes the hotel with a default room.
	 * @param sHotelName - the hotel name
	 */
	public Hotel(String sHotelName) {
		setsHotelName(sHotelName);
		System.out.println("New Hotel Established: " + this.sHotelName + "\n");
		//Create new room
		Room room = new Room(1, 1, this.getsHotelName());
		
		this.hotelRooms.add(room);
	}
	
	/**
	 * Finds a room in the hotel by its ID.
	 * @param ID - the ID of the room to be found.
	 * @return the room with the specified ID, or null if not found
	 */
	public Room findRoomWithRoomID(int ID) {
		Room found = null;
		int i = 0;
		
		if (Room.existingRoomIDs.contains(ID)) {
			for (Room room : this.hotelRooms) {
				if ((int) this.hotelRooms.get(i).getRoomIDWithHotelNameMap().keySet().toArray()[0] == ID)
					found = hotelRooms.get(i);
				i++;
			}
			
		}
		return found;
	}
	
	/**
	 * Creates a new room in the hotel.
	 * Prompts the user for room details and adds the new room to the hotel.
	 */
	public void createRoom() {
		Scanner sc = new Scanner(System.in);
		if (!(this.hotelRooms.size() < 50))
//			throw new IllegalArgumentException("Apologies. You cannot create more than 50 rooms.");
			System.out.println("Apologies. You cannot create more than 50 rooms.");
		else {
			System.out.println("\nCreating Room...");
			System.out.println("What floor is the room located in?");
				int floor = sc.nextInt();
			System.out.println("What room number will you be assigning the room?");
				int roomNum = sc.nextInt();
				
			Room newRoom = new Room(floor, roomNum, this.getsHotelName());
			
			this.hotelRooms.add(newRoom);
			System.out.println("Room " + newRoom.getsRoomName() + " created!");				
		}
	}
	
	/**
	 * Gets the name of the hotel.
	 * @return the name of the hotel.
	 */
	public String getsHotelName() {
		return sHotelName;
	}

	/**
	 * Checks if the provided hotel name is valid and unique.
	 * @param sHotelName - the possible unvalidated hotel name.
	 * @return the validated hotel name.
	 */
	public String checkIfValidName(String sHotelName) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		do {
			
			if (existingNames.contains(sHotelName)) {
				System.out.println("Please choose another name. There already exists a hotel with this name.");
//				throw new IllegalArgumentException("Hotel name already exists");
				name = sc.nextLine();
				checkIfValidName(name);
			}
			else
				return sHotelName;
		} while (!(existingNames.contains(sHotelName)));
		
		return name;
	}
	
	/**
	 * Sets the name of the hotel.
	 * Ensures the name is unique and adds it to the set of existing names.
	 * @param sHotelName - the name to set for the hotel.
	 */
	public void setsHotelName(String sHotelName) {
		String newName = checkIfValidName(sHotelName);
		this.sHotelName = newName;
		existingNames.add(newName);
	}

	/**
	 * Updates the base price of all rooms in the hotel.
	 * @param newPrice - the new base price to set.
	 */
	public void UpdateBasePriceOfRooms(double newPrice) {
		Scanner sc = new Scanner(System.in);
		double num = newPrice;
				
		do {
			if (!(num >= 100)) {
				System.out.println("Please increase the new base price of rooms to at least 100PHP");
				num = sc.nextDouble();
				UpdateBasePriceOfRooms(num);
			}
		} while (!(num >= 100));	//do all this while 1000 ! >= 100
		
		hotelRooms.get(0).setdBasePricePerNight(newPrice);			//dynamic (??)
//		Room.dBasePricePerNight = newPrice;							//static
	}
	
	/**
	 * Estimates the hotel's earnings for the current month based on reservations.
	 * @return the estimated earnings for the month.
	 */
	public double EstimatedEarningsPerMonth() {
		float estimatedEarningsThisMonth = 0.0f;
		for (Reservation reservation : hotelReservations) {
			estimatedEarningsThisMonth += reservation.getdTotalPriceOfBooking();
		}
		return estimatedEarningsThisMonth;
	}

	/**
	 * Gets the list of rooms in the hotel.
	 * @return the list of rooms in the hotel.
	 */
	public ArrayList<Room> getHotelRooms() {
		return hotelRooms;
	}

	/**
	 * Gets the list of reservations in the hotel.
	 * @return the list of reservations in the hotel.
	 */
	public ArrayList<Reservation> getHotelReservations() {
		return hotelReservations;
	}
	
	/**
	 * Checks if the hotel is fully booked on a given date.
	 * @param date - the date to check.
	 * @return true if the hotel is fully booked, false otherwise.
	 */
	public boolean checkIfHotelIsBooked(Date date) {
		boolean isBooked = false;
		for (Room room : hotelRooms) {
			if (room.checkIfRoomIsBooked(room.DayOfTheYear(date)))
				isBooked = true;
			else
				isBooked = false;
		}
		return isBooked;
	}
}
