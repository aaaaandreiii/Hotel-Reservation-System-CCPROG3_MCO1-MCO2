import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Room {
	public static final Set<Integer> existingRoomIDs = new HashSet<>();		//refers to room names INSIDE hotel reservation system
	public static double dBasePricePerNight = 1299;										//room ID is assigned to reservation

	private HashMap<Integer, String> roomIDWithHotelNameMap = new HashMap<>();
	private String sRoomName;
	private final Set<String> existingRoomNumbers = new HashSet<>();				//refers to room names inside hotel
	private boolean[] dateRoomReserved = new boolean[365];
	
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
	
	public HashMap<Integer, String> getRoomIDWithHotelNameMap() {
		return this.roomIDWithHotelNameMap;
	}

	//idk if will work
	public int getRoomID() {
		return (int) this.roomIDWithHotelNameMap.keySet().toArray()[0];
	}
	
	public int generateRoomID() {
		Random randomNumber = new Random();
		int randomRoomIDNumber;
		
		do {
			randomRoomIDNumber = randomNumber.nextInt(10000);
		} while (existingRoomIDs.contains(randomRoomIDNumber));
		
		existingRoomIDs.add(randomRoomIDNumber);
		
		return randomRoomIDNumber;
	}
	
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

	public void setDateRoomReserved(Date CheckIn, Date CheckOut) {
		int date1 = DayOfTheYear(CheckIn);
		int date2 = DayOfTheYear(CheckOut);
		
		for (date1 = DayOfTheYear(CheckIn); date1 < date2; date1++) {
			this.dateRoomReserved[date1] = true;
		}
	}
	
	public boolean checkIfRoomIsBooked(Date CheckIn, Date CheckOut) {
		int date1 = DayOfTheYear(CheckIn);
		int date2 = DayOfTheYear(CheckOut);
		
		for (date1 = DayOfTheYear(CheckIn); date1 < date2; date1++) {
			if (this.dateRoomReserved[date1] == true) {
				return true;
			}
		}
		return false;
	}
	
	//used in remove room
	public boolean checkIfRoomIsBooked(int date1, int date2) {	
		for (date1 = date1; date1 < date2; date1++) {
			if (this.dateRoomReserved[date1] == true) {
				return true;
			}
		}
		return false;
	}
	
	//used in update booking price
	public boolean checkIfRoomIsBooked(int date) {
		if (this.dateRoomReserved[date] == true)
			return true;
		else
			return false;
	}
	
	public boolean[] getDateRoomReserved() {
		return dateRoomReserved;
	}
	
	public void printDateRoomReserved() {
		int[] numOfDaysPerMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int counter = 0;
		
		System.out.println("\nThe following dates are in DD-MM-YYYY format.");
		for (int i = 0; i < 365; i++) {
			if (this.getDateRoomReserved()[i] == true) {
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
			
			if (counter == 0)
				System.out.println("This room has neither active nor incoming bookings as of today.");
		}		
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
	
	public void setdBasePricePerNight(double price) {
		Room.dBasePricePerNight = price;
	}
}