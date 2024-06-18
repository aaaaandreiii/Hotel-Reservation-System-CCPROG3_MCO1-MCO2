import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Reservation {
	private final Set<Integer> existingReservationNumbers = new HashSet<>();
	private int reservationNumber;
	private String sGuestName;
	private Date CheckInDate;
	private Date CheckOutDate;
	private Room room;
	private int nNumDaysOfStay;
	private double dTotalPriceOfBooking;
	private double dCostPerNight;
	
	public Reservation (String sGuestName, Date CheckInDate, Date CheckOutDate, int nNumDaysOfStay, Room room) {
		
		this.reservationNumber = setReservationNumber();
		existingReservationNumbers.add(this.reservationNumber);
		
		this.sGuestName = sGuestName;
		this.CheckInDate = CheckInDate;
		this.CheckOutDate = CheckOutDate;
		this.nNumDaysOfStay = getnNumDaysOfStay(CheckInDate, CheckOutDate);
		this.dCostPerNight = this.getdCostPerNight();
		this.dTotalPriceOfBooking = this.getdTotalPriceOfBooking();
		this.room = room;
		System.out.println("Reservation created!");
	}

	public int getReservationNumber() {
		return this.reservationNumber;
	}

	public int setReservationNumber() {
		Random randomNumber = new Random();
		int random;
		
		do {
			random = randomNumber.nextInt(10000);
		} while (existingReservationNumbers.contains(random));
		
		existingReservationNumbers.add(random);
		return random;
	}
	
	public double getdTotalPriceOfBooking() {
		return this.dCostPerNight * this.nNumDaysOfStay;
	}

	public double getdCostPerNight() {
		return Room.dBasePricePerNight;
	}

	public String getsGuestName() {
		return sGuestName;
	}

	public Date getCheckInDate() {
		return CheckInDate;
	}

	public Date getCheckOutDate() {
		return CheckOutDate;
	}
	
	public Room getRoom() {
		return room;
	}
	
	//date1 MUST be checkIn, date2 MUST be checkOut
	public int getnNumDaysOfStay(Date date1, Date date2) {
		if (date1.getnMonth() == date2.getnMonth())
			nNumDaysOfStay = (date2.getnDay() - date1.getnDay());
		else
			nNumDaysOfStay = (date2.getnDaysOfMonth() - date2.getnDay() + date1.getnDay());
		return nNumDaysOfStay;
	}
}
