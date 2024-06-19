import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class HotelReservationSystem {
	private static ArrayList<Hotel> hotelsInHRS = new ArrayList<>();
		
	
	// credit to Amit Rawat from https://intellipaat.com/community/294/java-clear-the-console
	// for this system("cls") method
	@SuppressWarnings("deprecation")
	public static void cls(){
		try {									
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {}
	}
		
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
	
	public static void ViewHighLevelHotelInformation(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view Hotel Information");
		
		System.out.println("\nName of Hotel: " + hotel.getsHotelName());
		System.out.println("Total Number of Rooms: " + hotel.getHotelRooms().size());
		System.out.println("Estimated Earnings of the Month: " + hotel.EstimatedEarningsPerMonth());
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...\n");
		sc.nextLine();
		cls();
	}
	
	public static void ViewAvailableAndBookedRooms(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view all available and booked rooms.");
		System.out.println();
	}
	
	public static void ViewInfoOfSelectedRoom(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view all information for a selected room.");
		System.out.println("\nPlease select what room to view: ");
		
		int j = 0;
		System.out.println("\tNo.Room No.");
		for (Room i : hotel.getHotelRooms()) {
			String name = i.getsRoomName();
			System.out.println("\t" + j + ". Room " + name);
			j++;
		}
		
		int choice = sc.nextInt();
		System.out.println("You have selected to view room " + hotel.getHotelRooms().get(choice - 1).getsRoomName() + "'s information.");
		System.out.println("Room Name: " + hotel.getHotelRooms().get(choice - 1).getsRoomName());
		System.out.println("Price per night: " + hotel.getHotelRooms().get(choice - 1).getdBasePricePerNight());
		hotel.getHotelRooms().get(choice - 1).printDateRoomReserved();
		System.out.println("Aside from those above, the room is available to be booked for the rest of the year.");
		
	}
	
	public static void ViewInfoOfSelectedReservation(Hotel hotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view all information for a selected reservation.");
		System.out.println();
	}
	
	public static void ViewHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
			System.out.println("\nYou have chosen Option 2: View Hotel!\n");
			
			Hotel hotel = WhichHotelToViewManage();
			
			System.out.println("Please select what to do with " + hotel.getsHotelName());
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
				System.out.println("Returning to Main Menu. Press Enter to Continue...");
				sc.nextLine();
				cls();
			} else {
				System.out.println("uh oh! Please reinput your selection :((\n");
			}
			
		} while (!(choice.equals("5")));
	}
	
	public static void ChangeNameOfHotel(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to change the name of: " + chosenHotel.getsHotelName() + ".");
		System.out.println("Please input below the new name of the previous " + chosenHotel.getsHotelName() + ":");
		String newName = sc.nextLine();
		chosenHotel.setsHotelName(newName);
		System.out.println("Hotel name changed to: " + chosenHotel.getsHotelName() + "\n");
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	public static void AddRooms(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to add rooms to: " + chosenHotel.getsHotelName() + "!");
		chosenHotel.createRoom();
		
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	public static void RemoveRooms(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		//TODO multiple rooms?
		System.out.println("You have chosen to remove rooms from the " + chosenHotel.getsHotelName() + " hotel.");
		System.out.println("\nPlease select what room to remove: ");
		int j = 1;
		System.out.println("\tNo.Room No.\t Status");
		for (Room i : chosenHotel.getHotelRooms()) {
			String name = i.getsRoomName();
			boolean status = i.checkIfRoomIsBooked(0, 364);
			
			if (status == true) {
				System.out.println("\t" + j + ". Room " + name + "\t This room cannot be removed.");
			} else {
				System.out.println("\t" + j + ". Room " + name + "\t This room may be removed.");
			}
			
			j++;
		}
		
		int choice = sc.nextInt();		
		System.out.println("Are you sure you want to REMOVE this Room " + chosenHotel.getHotelRooms().get(choice - 1).getsRoomName() + " from the system?");
		System.out.println("You cannot undo this action. (Type Yes to Proceed)");
		
		sc.nextLine();
		String YesOrNo = sc.nextLine();
		if (YesOrNo.toLowerCase().equals("yes"))
			chosenHotel.getHotelRooms().remove(choice - 1);
		else
			System.out.println("You have chosen to keep: Room " + chosenHotel.getHotelRooms().get(choice - 1).getsRoomName());
		
		System.out.println("The current rooms left in " + chosenHotel.getsHotelName() + " are: ");
		j = 1;
		for (Room i : chosenHotel.getHotelRooms()) {
			String name = i.getsRoomName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	public static void UpdateRoomBasePrices(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have selected to update the base price of rooms in " + chosenHotel.getsHotelName());
		
		System.out.println("Please input the date today as updating the base prices of all rooms must be done on a date where there are no reservations in the hotel.");
		String dateString = sc.nextLine();
		Date date = new Date(dateString);
		
		Boolean isBooked = chosenHotel.checkIfHotelIsBooked(date);
		if (isBooked == true) {
			System.out.println("Apologies. You cannot change the base price of rooms today.");
			System.out.printf("\nThe base price of %s's rooms is still: %.2fPHP!\n", chosenHotel.getsHotelName(), Room.dBasePricePerNight);
		} else {
			System.out.println("Success! There are no hotel reservations today! You may change the base price of rooms.");
			System.out.println("Please input a new base price: ");
			double newPrice = sc.nextDouble();
			
			chosenHotel.UpdateBasePriceOfRooms(newPrice);
			System.out.printf("\nSuccess! The new base price of %s's rooms is now: %.2fPHP!\n", chosenHotel.getsHotelName(), Room.dBasePricePerNight);
		}
			
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		sc.nextLine();
		cls();
	}
	
	public static void RemoveReservation(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		//TODO multiple reservations to remove?
		System.out.println("You have chosen to remove reservations from the " + chosenHotel.getsHotelName() + " hotel.");
		System.out.println("Please select whose reservation or what room's reservation to remove: ");
		
		int j = 1;
		for (Reservation i : chosenHotel.getHotelReservations()) {
			int num = i.getReservationNumber();
			String name = i.getsGuestName();
			String room = i.getRoom().getsRoomName();
			System.out.println("\t" + j + ". Reservation No. " + num + "\tCustomer " + name + "\tin Room " + room);
			j++;
		}
		
		int choice = sc.nextInt();		
		System.out.println("Are you sure you want to REMOVE this Reservation No. "
							+ chosenHotel.getHotelReservations().get(choice - 1).getReservationNumber()
							+ " by Guest " 
							+ chosenHotel.getHotelReservations().get(choice - 1).getsGuestName()
							+ " in Room "
							+ chosenHotel.getHotelRooms().get(choice - 1).getsRoomName() 
							+ " from the system?");
		System.out.println("You cannot undo this action. (Type Yes to Proceed)");
		
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
		
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	public static void RemoveHotel(Hotel chosenHotel) {
		//TODO remove multiple hotels?
		Scanner sc = new Scanner(System.in);
		System.out.println("You have chosen to remove the " + chosenHotel.getsHotelName() + " hotel.");
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
		
		System.out.println("Returning to Main Menu. Press Enter to Continue...");
		sc.nextLine();
		cls();
	}
	
	public static void ManageHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
			System.out.println("\nYou have chosen Option 3: Manage Hotel!\n");
			
			Hotel hotel = WhichHotelToViewManage();
			System.out.println("Please select what to do with " + hotel.getsHotelName());
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
				System.out.println("Returning to Main Menu. Press Enter to Continue...");
				sc.nextLine();
				cls();
			} else {
				System.out.println("uh oh! Please reinput your selection :((\n");
			}
			
		} while (!(choice.equals("7")));
	}
	
	
	public static void SimulateBooking() {
		Scanner sc = new Scanner(System.in);
		
		String guestName = null;
		String date = null;
		String YesOrNo = null;
		
		Date CheckInDate = new Date ();
		Date CheckOutDate = new Date ();
		
		int choice = null;
		
		
		do {
			System.out.println("Good day, user! Welcome to the hotel reservation system!\n");
			System.out.println("My name is HRS! May I know yours?");
			guestName = sc.nextLine();
			
			System.out.printf("\nHello, %s!", guestName);
			System.out.println("Which hotel would you like to book for your stay? Please select among the following: ");
			
			int j = 1;
			for (Hotel i : hotelsInHRS) {
				String name = i.getsHotelName();
				System.out.println("\t" + j + ". " + name);
				j++;
			}
			choice = sc.nextInt();
			
			System.out.println("You have selected to book your stay at " + hotelsInHRS.get(choice - 1).getsHotelName() + "!");
			
			System.out.println("Now, please enter the start and end dates of your stay.");
			
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
			    
				
				if (CheckInDate.isBefore(CheckOutDate) == false) {
					System.out.println("Please re-input your Check-In and Check-Out dates.");
				} else {
					isBefore = true;
				}
			} while (!(isBefore == true));
			
			System.out.println("Just to confirm, you wish to stay at " + hotelsInHRS.get(choice - 1).getsHotelName()
					+ "from " + CheckInDate.printStringDate() + " to " + CheckOutDate.printStringDate());
			System.out.println("Is that correct? If there are any mistakes in the details above, please type 'no'. Otherwise, please type 'yes'!");
			YesOrNo = sc.nextLine();
			
			if (YesOrNo.toLowerCase().equals("no")) {
				System.out.println("If so, please re-input your choices. Thank you!");
			}
			
		} while (!(YesOrNo.toLowerCase().equals("yes")));
		
		System.out.println("Please select a room to stay at: ");
		
		int j = 0;
		System.out.println("\tNo.Room No.\tPrice Per Night");
		for (Room i : hotelsInHRS.get(choice - 1).getHotelRooms()) {
			String name = i.getsRoomName();
			boolean status = i.checkIfRoomIsBooked(CheckInDate, CheckOutDate);
			
			if (status == false)
				System.out.println("\t" + j + ". Room " + name + "\t" + Room.dBasePricePerNight);
			
			j++;
		}
		
		
		
		
//		CheckInDate.
	}

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
