/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: Reservation.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/**
 * The following libraries were imported to be used in certain sections of the program:
 * 		HashSet - imported in order to make double sure that no Reservation Numbers are duplicated during runtime. Checked once during initialization, checked another time by the nature of HashSets.
 * 		Set - imported in order to allow HashSets to work.
 * 		Random - imported in order to randomize the Reservation Numbers generated.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

/**
 * This class was made in order for the HotelReservationClass to have an object that holds the customers' different unique reservations.
 */
public class Reservation {
	/**
	 * The following variables are declared to be used by the Reservation class:
	 * 		a public static final HashSet of all existing Reservation Numbers - public static to serve as a placeholder and checker for all already existing numbers.
	 * 		an integer variable for the reservation's reservation number to help identify each reservation per customer
	 * 		an integer variable for the reservation's corresponding RoomID in order to identify the Hotel AND Room number of the customer's booking
	 * 		a string variable for the guest's name
	 * 		two Date instances for the guest's Check-In date and Check-Out date
	 * 		an integer variable to compute for the number of days the customer will be booking a reservation to the hotel
	 * 		a double floating point variable to store the total cost of the customer's booking
	 * 		and a double floating point variable to store the cost of each night's stay at the hotel
	 */
	public static final Set<Integer> existingReservationNumbers = new HashSet<>();		//refers to unique idenfication number given by system to every booking customer
	
	private int reservationNumber;
	private int roomID;
	private String sGuestName;
	private Date CheckInDate;
	private Date CheckOutDate;
	private int nNumDaysOfStay;
	private double dTotalPriceOfBooking;
	private double basePrice;
	private double[] datePriceModifierMultiplier;
	private double roomTypeMultiplier;
	private boolean[] dateRoomReserved = new boolean[366];					//Stores this reservation's reserved dates for each day of the 2024 leap year
	
	/**
	 * This constructor assigns all this class's attributes by passing them directly, computing for their values, or generating them when every object is instantiated.
	 * This constructor passes the guest name, check in/out date, and chosen room directly as attributes for this class.
	 * This constructor generates a reservation number randomly from 0 to 1000 uniquely.
	 * This constructor calculates the total number of days between the inputed check-in date and check-out date.
	 * This constructor takes the cost per night by referencing an attribute from the Room class.
	 * This constructor calculates the total price of the customer's booking by multiplying the total number of days of stay with the cost per night.
	 * @param sGuestName - refers to the user's name
	 * @param CheckInDate - refers to the user's inputed check in date
	 * @param CheckOutDate - refers to the user's inputed check out date
	 * @param room - refers to the room object that this reservation is assigned to upon instantiation
	 */
	public Reservation (String sGuestName, Date CheckInDate, Date CheckOutDate, Room room, double basePrice, double[] datePriceModifierMultiplier, double roomTypeMultiplier) {
		this.reservationNumber = setReservationNumber();
		existingReservationNumbers.add(this.reservationNumber);
		
		this.roomID = room.getRoomID();
		this.sGuestName = sGuestName;
		this.CheckInDate = CheckInDate;
		this.CheckOutDate = CheckOutDate;
		this.nNumDaysOfStay = getnNumDaysOfStay(CheckInDate, CheckOutDate);
		this.basePrice = basePrice;
		this.datePriceModifierMultiplier = datePriceModifierMultiplier;
		this.roomTypeMultiplier = roomTypeMultiplier;
		this.dTotalPriceOfBooking = this.computeDTotalPriceOfBooking(basePrice, datePriceModifierMultiplier, roomTypeMultiplier);

		//initialize dateRoomReserved
		for (int i = 0; i < 365; i++) {
			this.dateRoomReserved[i] = false;
		}

		setDateRoomReserved(CheckInDate, CheckOutDate);
	}

	public Reservation (String sGuestName, Date CheckInDate, Date CheckOutDate, Room room, double basePrice, double[] datePriceModifierMultiplier, double roomTypeMultiplier, double totalCost) {
		this.reservationNumber = setReservationNumber();
		existingReservationNumbers.add(this.reservationNumber);
		
		this.roomID = room.getRoomID();
		this.sGuestName = sGuestName;
		this.CheckInDate = CheckInDate;
		this.CheckOutDate = CheckOutDate;
		this.nNumDaysOfStay = getnNumDaysOfStay(CheckInDate, CheckOutDate);
		this.basePrice = basePrice;
		this.datePriceModifierMultiplier = datePriceModifierMultiplier;
		this.roomTypeMultiplier = roomTypeMultiplier;
		// this.dTotalPriceOfBooking = this.computeDTotalPriceOfBooking(basePrice, datePriceModifierMultiplier, roomTypeMultiplier);

		this.dTotalPriceOfBooking = totalCost;

		//initialize dateRoomReserved
		for (int i = 0; i < 365; i++) {
			this.dateRoomReserved[i] = false;
		}

		setDateRoomReserved(CheckInDate, CheckOutDate);
	}

	/**
	 * This method is a getter for this reservations Room ID
	 * @return roomID - which refers to the unique identification of rooms in the entire system even if each hotel has a similar naming convention for every room.
	 */
	public int getRoomID() {
		return this.roomID;
	}

	/**
	 * This method is a getter for the reservation number attribute.
	 * @return reservationNumber - which refers to the unique identification for each reservation code.
	 */
	public int getReservationNumber() {
		return this.reservationNumber;
	}

	/**
	 * This method is a setter for the reservation number attribute.
	 * It does so by generating a unique random 5-digit number that no other reservation is already assigned to.
	 * @return random - which is the generated reservation number.
	 */
	public int setReservationNumber() {
		Random randomNumber = new Random();
		int random;
		
		do {
			random = randomNumber.nextInt(99999);
		} while (existingReservationNumbers.contains(random));
		
		existingReservationNumbers.add(random);
		return random;
	}
	
	/**
	 * This is a setter for the total price of booking price of the customer's reservation.
	 * It does so by getting the summation of the base price, multiplied by the room type multiplier, multiplied by the user indicated date price modifier, from 1 to numOfDays
	 * As no other variable was specified in the specifications to be accounted for (such as additional hotel fees, snack bar fees, breakfast fees, etc), no such variables will be accounted for in the total.
	 * @return product of the cost per night and the total number of days of stay
	 */
	public double computeDTotalPriceOfBooking(double basePrice, double[] datePriceModifierMultiplier, double roomTypeMultiplier) {
		this.dTotalPriceOfBooking = 0;

		for (int i = this.CheckInDate.dayInYear(CheckInDate); i < this.CheckOutDate.dayInYear(CheckOutDate); i++) {
			this.dTotalPriceOfBooking = this.dTotalPriceOfBooking + (basePrice * roomTypeMultiplier * datePriceModifierMultiplier[i]);
		}

		return this.dTotalPriceOfBooking;
	}


	public double getdTotalPriceOfBooking() {
		return this.dTotalPriceOfBooking;
	}

	public void setdTotalPriceOfBooking(double price) {
		this.dTotalPriceOfBooking = price;
	}

	public double costOnCertainDay(int dayInYear) {
		return this.basePrice * this.roomTypeMultiplier * this.datePriceModifierMultiplier[dayInYear]; // * 1 day
	}

	/**
	 * This method is a getter for the String variable guest name.
	 * @return sGuestName - which refers to the String variable of the guest's name.
	 */
	public String getsGuestName() {
		return sGuestName;
	}

	/**
	 * This method is a getter for the Check-In date.
	 * @return CheckInDate - which refers to the guest's check in date with a Date datatype.
	 */
	public Date getCheckInDate() {
		return CheckInDate;
	}

	/**
	 * This method is a getter for the Check-Out date.
	 * @return CheckOutnDate - which refers to the guest's check out date with a Date datatype.
	 */
	public Date getCheckOutDate() {
		return CheckOutDate;
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
	 * This method is a getter for the number of days of the guest's stay.
	 * This method computes for such by first converting the date to the day of the year and finding the difference.
	 * @param date1 - this must be the check-in date of the reservation
	 * @param date2 - this must be the check-out date of the reservation
	 * @return nNumDaysOfStay - which refers to the number of days of stay of the guest's reservation
	 */
	public int getnNumDaysOfStay(Date date1, Date date2) {
		if (date1.getnMonth() == date2.getnMonth())
			nNumDaysOfStay = (date2.getnDay() - date1.getnDay());
		else if (date1.getnMonth() < date2.getnMonth()) {
			nNumDaysOfStay = 0;
			for (int i = date1.dayInYear(date1); i < date2.dayInYear(date2) - 1; i++) {
				nNumDaysOfStay++;
			}
		}
		return nNumDaysOfStay;
	}
}