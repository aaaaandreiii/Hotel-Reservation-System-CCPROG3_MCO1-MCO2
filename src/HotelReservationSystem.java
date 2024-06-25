/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: HotelReservationSystem.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/**
 * Represents the hotel reservation system which includes methods for managing hotels, rooms, and reservations.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//public static variables are for var that the system needs to access, regardless of class/object/instantiation

/**
 * HotelReservationSystem class provides functionalities to manage hotels, rooms, and reservations.
 */
public class HotelReservationSystem {
	
	/**
	 * The following libraries were imported to be used in certain sections of the program:
	 * 		ArrayList of hotels in the reservation system.
	 * 		ArrayList of reservations in the reservation system.
	 */
	private static ArrayList<Hotel> hotelsInHRS = new ArrayList<>();
	private static ArrayList<Reservation> reservationsInHRS = new ArrayList<>();
		
	/**
	 * Clears the console screen.
	 * System("cls") method
	 * credit to Amit Rawat from https://intellipaat.com/community/294/java-clear-the-console
	 */
	@SuppressWarnings("deprecation")
	public static void cls(){
		try {									
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {}
	}
	
	/**
	 * Creates a new hotel and adds it to the list of hotels.
	 */
	public static void CreateHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nYou have chosen Option 1: Create Hotel!\n");
		System.out.println("Enter name of hotel:");
		String name = sc.nextLine();
		
		Hotel newHotel= new Hotel(name);
		hotelsInHRS.add(newHotel);
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Prompts the user to select a hotel from the list and returns the selected hotel.
	 * @return the selected hotel.
	 */
	public static Hotel WhichHotelToViewManage() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose which hotel to view/manage:");
		
		int j = 1;
		//for each loop										vv cool lol
		for (Hotel i : hotelsInHRS) {
			String name = i.getsHotelName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		int choice = sc.nextInt();
		return hotelsInHRS.get(choice - 1);
	}
	
	/**
	 * Displays high-level information of the selected hotel.
	 * @param hotel - the hotel to view information of.
	 */
	public static void ViewHighLevelHotelInformation(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view Hotel Information");
		
		System.out.println("\nName of Hotel: " + hotel.getsHotelName());
		System.out.println("Total Number of Rooms: " + hotel.getHotelRooms().size());
		System.out.printf("Estimated Earnings of the Month: PHP%.2f", hotel.EstimatedEarningsPerMonth());
		System.out.println("\n\nReturning to Main Menu. Press Enter to Continue...\n");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Displays the available and booked rooms of the selected hotel.
	 * @param hotel - The hotel to view room availability.
	 */
	public static void ViewAvailableAndBookedRooms(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen to view all available and booked rooms.");
				
		System.out.println("\nTo view all available and booked rooms," + "\n\tpleease input your selected date in DD-MM-YYYY format");
		String dateString = sc.nextLine();
		Date date = new Date(dateString);
		
		int j = 1;
		Boolean isBooked = null;
		
		System.out.println("\n\tNo.Room No.\tStatus");
		for (Room i : hotel.getHotelRooms()) {
			String name = i.getsRoomName();
			isBooked = i.checkIfRoomIsBooked(date);
			if (isBooked == true)
				System.out.println("\t" + j + ". Room " + name + "\tBooked");
			else 
				System.out.println("\t" + j + ". Room " + name + "\tAvailable");
			j++;
		}
			
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Displays detailed information of the selected room in the given hotel.
	 * @param hotel - The hotel to view room information.
	 */
	public static void ViewInfoOfSelectedRoom(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen to view all information for a selected room.");
		System.out.println("\nPlease select what room to view: ");
		
		int j = 1;
		System.out.println("\tNo.Room No.");
		for (Room i : hotel.getHotelRooms()) {
			String name = i.getsRoomName();
			System.out.println("\t" + j + ". Room " + name);
			j++;
		}
		
		int choice = sc.nextInt();
		System.out.println("\nYou have selected to view Room " + hotel.getHotelRooms().get(choice - 1).getsRoomName() + "'s information.");
		System.out.println("Room Name: " + hotel.getHotelRooms().get(choice - 1).getsRoomName());
		System.out.printf("Price per night: PHP%.2f", hotel.getHotelRooms().get(choice - 1).getdBasePricePerNight());
		System.out.println();
		hotel.getHotelRooms().get(choice - 1).printDateRoomReserved();
//		System.out.println("\nAside from those above, the room is available to be booked for the rest of the year.");
		System.out.println("\n\nReturning to Menu. Press Enter to Continue...");
		sc.nextLine();
		sc.nextLine();
		cls();
	}
	
	/**
	 * Displays detailed information of the selected reservation in the given hotel.
	 * @param hotel - The hotel to view reservation information.
	 */
	public static void ViewInfoOfSelectedReservation(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen to view all information for a selected reservation.");
		
		
		if (hotel.getHotelReservations().isEmpty()) {
			System.out.println("There are no reservations in this hotel yet.");
		} else {
			System.out.println("\nPlease select what reservation to view: ");
			int j = 1;
			System.out.println("\tNo.Reservation No.\tRoom No.");
			for (Reservation i : hotel.getHotelReservations()) {
				int reservationNum = i.getReservationNumber();
				String roomNum = hotel.findRoomWithRoomID(i.getRoomID()).getsRoomName();
				System.out.println("\t" + j + ". No.  " + reservationNum + "\t\t" + roomNum);
				j++;
			}
			
			int choice = sc.nextInt();
			System.out.println("\nYou have selected to view Reservation Number " + hotel.getHotelReservations().get(choice - 1).getReservationNumber() + "'s information.");
			System.out.println("Reservation booked at: \t" + hotel.getsHotelName());
			System.out.println("Booked by: \t\tGuest " + hotel.getHotelReservations().get(choice - 1).getsGuestName());
			System.out.println("Room Number: \t\t" + hotel.findRoomWithRoomID(hotel.getHotelReservations().get(choice - 1).getRoomID()).getsRoomName());
			System.out.println("Check-In Date: \t\t" + hotel.getHotelReservations().get(choice - 1).getCheckInDate().printStringDate());
			System.out.println("Check-In Date: \t\t" + hotel.getHotelReservations().get(choice - 1).getCheckOutDate().printStringDate());
			System.out.printf("Price per night: \tPHP%.2f", hotel.getHotelReservations().get(choice - 1).getdCostPerNight());
			System.out.println("\nTotal cost of stay: \tPHP" + hotel.getHotelReservations().get(choice - 1).getdTotalPriceOfBooking());
			
		}
		System.out.println("\nReturning to Menu. Press Enter to Continue...");
		sc.nextLine();
		sc.nextLine();
		cls();
	}
	
	/**
	 * Prompts the user to select a hotel to view and manage its details.
	 */
	public static void ViewHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
			System.out.println("\nYou have chosen Option 2: View Hotel!\n");
			
			Hotel hotel = WhichHotelToViewManage();
			
			System.out.println("\nPlease select what to do with " + hotel.getsHotelName());
			System.out.println("\t1. View High Level Hotel Information");
			System.out.println("\t2. View Hotel's Available and Booked Rooms");
			System.out.println("\t3. View Info of Selected Room");
			System.out.println("\t4. View Info of Selected Reservation");
			System.out.println("\t5. Return to Main Menu");
			choice = sc.nextLine();
			
			if (choice.equals("1")) {
				ViewHighLevelHotelInformation(hotel);
			} else if (choice.equals("2")) {
				ViewAvailableAndBookedRooms(hotel);
			} else if (choice.equals("3")) {
				ViewInfoOfSelectedRoom(hotel);
			} else if (choice.equals("4")) {
				ViewInfoOfSelectedReservation(hotel);
			} else if (choice.equals("5")) {
				System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
				sc.nextLine();
				cls();
			} else {
				System.out.println("uh oh! Please reinput your selection :((\n");
			}
			
		} while (!(choice.equals("5")));
	}
	
	/**
	 * Changes the name of the hotel according to the inputted new string. 
	 * Goes through validation before change.
	 * @param chosenHotel - the hotel which name is to be changed
	 */
	public static void ChangeNameOfHotel(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen to change the name of: " + chosenHotel.getsHotelName() + ".");
		System.out.println("Please input below the new name of the previous " + chosenHotel.getsHotelName() + ":");
		String newName = sc.nextLine();
		chosenHotel.setsHotelName(newName);
		System.out.println("Hotel name changed to: " + chosenHotel.getsHotelName() + "\n");
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Adds rooms to the specified hotel.
	 * @param chosenHotel - hotel to be added rooms to.
	 */
	public static void AddRooms(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have chosen to add rooms to: " + chosenHotel.getsHotelName() + "!");
		chosenHotel.createRoom();
		
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Removes rooms from the specified hotel.
	 * @param chosenHotel - hotel to have rooms removed from.
	 */
	public static void RemoveRooms(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		//TODO multiple rooms?
		System.out.println("\nYou have chosen to remove rooms from the " + chosenHotel.getsHotelName() + " hotel.");
		System.out.println("\nPlease select what room to remove: ");
		int j = 1;
		System.out.println("\tNo.Room No.\t Status");
		for (Room i : chosenHotel.getHotelRooms()) {
			String name = i.getsRoomName();
			boolean status = i.checkIfRoomIsBooked(0, 364);
			
			if (status == true) {
				System.out.println("\t" + j + ". Room " + name + "\t This room cannot be removed.");
			} else {
				System.out.println("\t" + j + ". Room " +  name + "\t This room may be removed.");
			}
			j++;
		}
//		j++;
		System.out.println("\t" + j + ". <Cancel: Do not remove any room.>");
		
		int choice = sc.nextInt();	
		
		if (!(choice == j)) {
			System.out.println("\nAre you sure you want to REMOVE this Room " + chosenHotel.getHotelRooms().get(choice - 1).getsRoomName() + " from the system?");
			System.out.println("You cannot undo this action. (Type Yes to Proceed)");
			
			sc.nextLine();
			String YesOrNo = sc.nextLine();
			if (YesOrNo.toLowerCase().equals("yes"))
				chosenHotel.getHotelRooms().remove(choice - 1);
			else
				System.out.println("You have chosen to keep: Room " + chosenHotel.getHotelRooms().get(choice - 1).getsRoomName());
		} else {
			System.out.println("\nYou have chosen not to remove any rooms.");
		}
		
		System.out.println("\nThe current rooms left in " + chosenHotel.getsHotelName() + " are: ");
		j = 1;
		for (Room i : chosenHotel.getHotelRooms()) {
			String name = i.getsRoomName();
			System.out.println("\t" + j + ". Room " + name);
			j++;
		}
		
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		sc.nextLine();
		cls();
	}
	
	/**
	 * Updates the base prices of rooms.
	 * @param chosenHotel - hotel to have room base prices updated.
	 */
	public static void UpdateRoomBasePrices(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYou have selected to update the base price of rooms in " + chosenHotel.getsHotelName());
		
		System.out.println("\nPlease input the date today in DD-MM-YYYY format"
				+ "\n\tas updating the base prices of all rooms must be done "
				+ "\n\ton a date where there are no reservations in the hotel.");
		
		String dateString = sc.nextLine();
		
		Date date = new Date(dateString);
		
		Boolean isBooked = chosenHotel.checkIfHotelIsBooked(date);
		if (isBooked == true) {
			System.out.println("\nApologies. You cannot change the base price of rooms today.");
			System.out.printf("\nThe base price of %s's rooms is still: PHP%.2f!\n", chosenHotel.getsHotelName(), Room.dBasePricePerNight);
		} else {
			System.out.println("\nSuccess! There are no hotel reservations today! You may change the base price of rooms.");
			System.out.println("Please input a new base price: ");
			double newPrice = sc.nextDouble();
			
			chosenHotel.UpdateBasePriceOfRooms(newPrice);
			System.out.printf("\nSuccess! The new base price of %s's rooms is now: PHP%.2f!\n", chosenHotel.getsHotelName(), Room.dBasePricePerNight);
		}
			
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		sc.nextLine();
		cls();
	}
	
	/**
	 * Remove reservations from the hotel reservation system.
	 * @param chosenHotel - removes reservations from the hotel as well.
	 */
	public static void RemoveReservation(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		//TODO multiple reservations to remove?
		System.out.println("\nYou have chosen to remove reservations from the " + chosenHotel.getsHotelName() + " hotel.");
		System.out.println("Please select whose reservation or what room's reservation to remove: ");
		
		int j = 1;
		for (Reservation i : chosenHotel.getHotelReservations()) {
			int num = i.getReservationNumber();
			String name = i.getsGuestName();
			String room = chosenHotel.findRoomWithRoomID(i.getRoomID()).getsRoomName();
			System.out.println("\t" + j + ". Reservation No. " + num + "\tCustomer " + name + " in Room " + room);
			j++;
		}
		
		int choice = sc.nextInt();		
		System.out.println("Are you sure you want to REMOVE this Reservation No. "
							+ chosenHotel.getHotelReservations().get(choice - 1).getReservationNumber()
							+ " by Guest " 
							+ chosenHotel.getHotelReservations().get(choice - 1).getsGuestName()
							+ " in Room "
							+ chosenHotel.findRoomWithRoomID(chosenHotel.getHotelReservations().get(choice - 1).getRoomID()).getsRoomName() 
							+ " from the system?");
		
		System.out.println("\nYou cannot undo this action. (Type Yes to Proceed)");
		
		sc.nextLine();
		String YesOrNo = sc.nextLine();
		if (YesOrNo.toLowerCase().equals("yes"))
			chosenHotel.getHotelReservations().remove(choice - 1);
		else
			System.out.println("You have chosen to keep: Room " + chosenHotel.getHotelRooms().get(choice - 1).getsRoomName());
		
		System.out.println("The current rooms left in " + chosenHotel.getsHotelName() + " are: ");
		j = 1;
		for (Room i : chosenHotel.getHotelRooms()) {
			String name = i.getsRoomName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Removes hotels from the hotel reservation system.
	 * @param chosenHotel - hotel to be removed.
	 */
	public static void RemoveHotel(Hotel chosenHotel) {
		//TODO remove multiple hotels?
		Scanner sc = new Scanner(System.in);
		System.out.println("\nYou have chosen to remove the " + chosenHotel.getsHotelName() + " hotel.");
		System.out.println("Are you sure you want to REMOVE " + chosenHotel.getsHotelName() + " from the system?");
		System.out.println("You cannot undo this action. (Type Yes to Proceed)");
		String YesOrNo = sc.nextLine();
		
		if (YesOrNo.toLowerCase().equals("yes"))
			hotelsInHRS.remove(chosenHotel);
		else
			System.out.println("You have chosen to keep the hotel: " + chosenHotel.getsHotelName());
		System.out.println("The current hotels left in the Hotel Reservation System are: ");
		
		int j = 1;
		for (Hotel i : hotelsInHRS) {
			String name = i.getsHotelName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	/**
	 * Prompts the user for options to manage the hotels in the system.
	 */
	public static void ManageHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
			System.out.println("\nYou have chosen Option 3: Manage Hotel!\n");
			
			Hotel hotel = WhichHotelToViewManage();
			System.out.println("\nPlease select what to do with " + hotel.getsHotelName());
			System.out.println("\t1. Change Name of Hotel");
			System.out.println("\t2. Add Rooms");
			System.out.println("\t3. Remove Rooms");
			System.out.println("\t4. Update Base Price of Rooms");
			System.out.println("\t5. Remove Reservation");
			System.out.println("\t6. Remove Hotel");
			System.out.println("\t7. Return to Main Menu");
			choice = sc.nextLine();
			
			if (choice.equals("1")) {
				ChangeNameOfHotel(hotel);
			} else if (choice.equals("2")) {
				AddRooms(hotel);
			} else if (choice.equals("3")) {
				RemoveRooms(hotel);
			} else if (choice.equals("4")) {
				UpdateRoomBasePrices(hotel);
			} else if (choice.equals("5")) {
				RemoveReservation(hotel);
			} else if (choice.equals("6")) {
				RemoveHotel(hotel);
			} else if (choice.equals("7")) {
				System.out.println("\nReturning to Main Menu. Press Enter to Continue...");
				sc.nextLine();
				cls();
			} else {
				System.out.println("uh oh! Please reinput your selection :((\n");
			}
			
		} while (!(choice.equals("7")));
	}
	
	/**
	 * Prompts the user with a series of instructions and questions to simulate the booking process.
	 */
	public static void SimulateBooking() {
		Scanner sc = new Scanner(System.in);
		
		String guestName = null;
		String date = null;
		String YesOrNo = null;
		
		Date CheckInDate = new Date ();
		Date CheckOutDate = new Date ();
		
		int hotelChoice = 0;
		
		
		do {
			cls();
			System.out.println("Good day, user! Welcome to the hotel reservation system!\n");
			System.out.println("My name is HRS! May I know yours?");
			guestName = sc.nextLine();
			
			System.out.printf("\nHello, %s!\n", guestName);
			System.out.println("Which hotel would you like to book for your stay?");
			System.out.println("    Please select among the following: ");
			
			int j = 1;
			for (Hotel i : hotelsInHRS) {
				String name = i.getsHotelName();
				System.out.println("\t" + j + ". " + name);
				j++;
			}
			hotelChoice = sc.nextInt();
			sc.nextLine();
			
			System.out.println("\nYou have selected to book your stay at " + hotelsInHRS.get(hotelChoice - 1).getsHotelName() + "!");
			
			System.out.println("\nNow, please enter the start and end dates of your stay.");
			
			boolean isBefore = false;
			do {
				System.out.println("Please input your Check-In date in dd-mm-yy format: ");
				date = sc.nextLine();
				
				
				String[] dateParts = date.split("-");
				int nDay = Integer.parseInt(dateParts[0]);
				CheckInDate.setnDay(nDay);

			    int nMonth = Integer.parseInt(dateParts[1]);
			    CheckInDate.setnMonth(nMonth);
			    
			    int nYear = Integer.parseInt(dateParts[2]);
				CheckInDate.setnYear(nYear);
				
				
				System.out.println("Please input your Check-Out date in dd-mm-yy format: ");
				date = sc.nextLine();
				
				dateParts = date.split("-");
				nDay = Integer.parseInt(dateParts[0]);
				CheckOutDate.setnDay(nDay);

			    nMonth = Integer.parseInt(dateParts[1]);
			    CheckOutDate.setnMonth(nMonth);
			    
			    nYear = Integer.parseInt(dateParts[2]);
			    CheckOutDate.setnYear(nYear);
			    
				
				if (CheckInDate.getnDay() == 31 || CheckOutDate.getnDay() == 1) {	//sir i do not get what this means but bc the specs indicate it, then it SHALL BE DONEEEE
					System.out.println("Apologies. Please re-check your Check-In and Check-Out dates as they violate some constraints.\n");
				} else if (CheckInDate.isBefore(CheckOutDate) == false) {
					System.out.println("Please re-input your Check-In and Check-Out dates.");
				} else {
					isBefore = true;
				}
			} while (!(isBefore == true));
			
			System.out.println("\nJust to confirm, you wish to stay at \n" + hotelsInHRS.get(hotelChoice - 1).getsHotelName()
					+ " from " + CheckInDate.printStringDate() + " to " + CheckOutDate.printStringDate() + ". Is that right?");
			System.out.println("If there are any mistakes in the details above, \n\tplease type 'no'. Otherwise, please type 'yes'!");
			YesOrNo = sc.nextLine();
			
			if (YesOrNo.toLowerCase().equals("no")) {
				System.out.println("If so, please re-input your choices. Thank you!");
			}
			
		} while (!(YesOrNo.toLowerCase().equals("yes")));
		
		System.out.println("\nPlease select a room to stay at: ");
		
		int j = 1;
		int counter = 0;
		System.out.println("\tNo.Room No.\tPrice Per Night");
		for (Room i : hotelsInHRS.get(hotelChoice - 1).getHotelRooms()) {
			String name = i.getsRoomName();
			boolean status = i.checkIfRoomIsBooked(CheckInDate, CheckOutDate);
			
			if (status == false) {
				System.out.printf("\t%d. Room %s\t%.2f", j, name, Room.dBasePricePerNight);
//				System.out.println("\t" + j + ". Room " + name + "\t" + Room.dBasePricePerNight);
				counter++;
			}
			j++;
		}
		if (counter == 0) {				//if there are no more rooms available for the specified dates
			System.out.println("\nApologies. There are no more rooms available to be booked...");
			System.out.println("Please give the hotel a call regarding this concern or pick another check-in to check-out date. Thank you.");
			sc.nextLine();
		} else {
			int roomChoice = sc.nextInt();
		
			System.out.println("\nYou have chosen to book: \tRoom " + hotelsInHRS.get(hotelChoice - 1).getHotelRooms().get(roomChoice - 1).getsRoomName() 
					+ " in " + hotelsInHRS.get(hotelChoice - 1).getsHotelName());
			
			Reservation guestReservation = new Reservation(guestName, CheckInDate, CheckOutDate, hotelsInHRS.get(hotelChoice - 1).getHotelRooms().get(roomChoice - 1));
			
			reservationsInHRS.add(guestReservation);
			hotelsInHRS.get(hotelChoice - 1).getHotelReservations().add(guestReservation);
			
			hotelsInHRS.get(hotelChoice - 1).getHotelRooms().get(roomChoice - 1).setDateRoomReserved(CheckInDate, CheckOutDate);
			
			System.out.println ("\n----------------------------------------------------------------------");
			System.out.println("This booking was made by: \t" + guestReservation.getsGuestName());
			System.out.println("You plan to stay from: \t\t" + guestReservation.getCheckInDate().printStringDate() 
					+ " to " + guestReservation.getCheckOutDate().printStringDate());
			System.out.println("Your total days of stay is: \t" + guestReservation.getnNumDaysOfStay(CheckInDate, CheckOutDate));
			System.out.printf("\nAnd with a cost per night of: \tPHP%.2f", guestReservation.getdCostPerNight());
			System.out.printf("\nYour total bill will be: \tPHP%.2f", guestReservation.getdTotalPriceOfBooking());
			System.out.println ("\n----------------------------------------------------------------------");
			
			System.out.println("\nBy typing 'confirm' you are confirming the details of your reservation \n\tand will be redirected to the payments page.");
			sc.nextLine();
			sc.nextLine();
			
			System.out.println ("\n----------------------------------------------------------------------");
			System.out.println("Your reservation number is: \t" + guestReservation.getReservationNumber());
			
			Room guestRoom = hotelsInHRS.get(hotelChoice - 1).findRoomWithRoomID(guestReservation.getRoomID());
			
			System.out.println("Your room will be at: \t\tRoom " + guestRoom.getsRoomName() + " at " + hotelsInHRS.get(hotelChoice - 1).getsHotelName());
			System.out.println ("----------------------------------------------------------------------");
			
			System.out.println("\n\nRedirecting to payments page...");
			sc.nextLine();
			System.out.println("\nReturning to Main Menu...");
			sc.nextLine();
			cls();
		}
	}

	/**
	 * Main method that runs all other classes and methods.
	 * @param args - string array
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String choice = "";
		
		do {
//			sc.nextLine();
			cls();
			System.out.println("HOTEL RESERVATION SYSTEM\n");
			System.out.println("What do you want to do?");
			System.out.println("\t1. Create Hotel");
			System.out.println("\t2. View Hotel");
			System.out.println("\t3. Manage Hotel");
			System.out.println("\t4. Simulate Booking");
			System.out.println("\t5. Quit Program");
			

			choice = sc.nextLine();
			if (choice.equals("1")) {
				CreateHotel();
			} else if (choice.equals("2")) {
				ViewHotel();
			} else if (choice.equals("3")) {
				ManageHotel();
			} else if (choice.equals("4")) {
				SimulateBooking();
			} else if (choice.equals("5")) {
				cls();
				System.out.println("Thank you for using this HOTEL RESERVATION SYSTEM!");
			} else {
				System.out.println("uh oh! Please reinput your selection :((\n");
			}
		} while (!(choice.equals("5")));
	}
}
