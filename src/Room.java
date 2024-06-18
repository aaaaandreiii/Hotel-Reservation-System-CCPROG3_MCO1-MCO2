import java.util.HashSet;
import java.util.Set;

public class Room {
	private String sRoomName;
	private int RoomStatus;
	public static double dBasePricePerNight;
	private final Set<String> existingRoomNumbers = new HashSet<>();
	private Reservation reservation; 
	public boolean[] dateRoomReserved = new boolean[365];

	public Room(int floor, int roomNum) {
		this.setsRoomName(floor, roomNum);
		
		if (existingRoomNumbers.contains(this.sRoomName)) {
			throw new IllegalArgumentException("This room already exists");
		}
		existingRoomNumbers.add(this.sRoomName);
		
		this.RoomStatus = 0;
		this.dBasePricePerNight = 1299.00;
		
		//initialize dateRoomReserved
		for (int i = 0; i < 365; i++) {
			this.dateRoomReserved[i] = false;
		}
		
	}
	
	public int DayOfTheYear(Date date) {
		int conversion = 0;
		int month = date.getnMonth();
		int[] numOfDaysPerMonth = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
		
		for (int i = 0; i < month - 1; i++) {
			conversion += numOfDaysPerMonth[i];
		}
		
		conversion += date.getnDay();
		
		return conversion;
	}

	public void setDateRoomReserved(boolean[] dateRoomReserved, Date CheckIn, Date CheckOut) {
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
	
	public boolean checkIfRoomIsBooked(int date1, int date2) {	
		for (date1 = date1; date1 < date2; date1++) {
			if (this.dateRoomReserved[date1] == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean[] getDateRoomReserved() {
		return dateRoomReserved;
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
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	//room status = 0 means unoccupied/unbooked
	//room status = 1 means occupied/booked
	public int getRoomStatus() {
		//if 
		return RoomStatus;
	}
}
