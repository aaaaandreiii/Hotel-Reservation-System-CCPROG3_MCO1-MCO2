import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Hotel {
	private static final Set<String> existingNames = new HashSet<>();	//hashSet to create unique hotel names
	private String sHotelName;
	private ArrayList<Room> hotelRooms = new ArrayList<>();
	private ArrayList<Reservation> hotelReservations = new ArrayList<>();
	private int nCountOfRooms = 0;


	public Hotel(String sHotelName) {
		setsHotelName(sHotelName);
		System.out.println("New Hotel Established: " + this.sHotelName + "\n");
		//Create new room
		Room newRoom1 = new Room(1,1);
		
		this.hotelRooms.add(newRoom1);
		this.nCountOfRooms++;
	}
	
	public void createRoom() {
		Scanner sc = new Scanner(System.in);
		if (!(this.nCountOfRooms < 50))
			throw new IllegalArgumentException("Hotel name already exists");
		else {
			System.out.println("\nCreating Room...");
			System.out.println("What floor is the room located in?");
				int floor = sc.nextInt();
			System.out.println("What room number will you be assigning the room?");
				int roomNum = sc.nextInt();
				
			Room newRoom = new Room(floor, roomNum);
			
			this.hotelRooms.add(newRoom);
			System.out.println("Room " + newRoom.getsRoomName() + " created!");
			this.nCountOfRooms++;
//			System.out.println(this.hotelRooms);
				
		}
	}
	
	public String getsHotelName() {
		return sHotelName;
	}

	public String checkIfValidName(String sHotelName) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		do {
			//TODO huhu why no work
//			if (sHotelName.equals(null) || sHotelName.equals("\n")) {
//				System.out.println("That is an invalid name. Please choose another name for the hotel.");
//				name = sc.nextLine();
//				checkIfValidName(name);
//			} else 
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
	public void setsHotelName(String sHotelName) {
		String newName = checkIfValidName(sHotelName);
		this.sHotelName = newName;
		existingNames.add(newName);
	}

	public int getnCountOfRooms() {
		return nCountOfRooms;
	}

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
		
		Room.dBasePricePerNight = newPrice;
	}
	
	//this needs more editing for more accurate estimation
	//this could be interpreted kasi as max estimate as in all rooms booked all days of the month
	//or summation of all reservations in all rooms on all 31 days
	public double EstimatedEarningsPerMonth() {
		float estimatedEarningsThisMonth = 0.0f;
		for (Room room : hotelRooms) {
			estimatedEarningsThisMonth += room.getReservation().getdTotalPriceOfBooking();
		}
		return estimatedEarningsThisMonth;
	}

	public ArrayList<Room> getHotelRooms() {
		return hotelRooms;
	}

	public ArrayList<Reservation> getHotelReservations() {
		return hotelReservations;
	}
}
