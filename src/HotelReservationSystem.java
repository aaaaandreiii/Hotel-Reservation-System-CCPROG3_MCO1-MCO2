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
		
//		System.out.println(newHotel1.hotelRooms.get(0).sRoomName);
//		System.out.println(newHotel1.hotelRooms.get(1).sRoomName);
	}
	
	public static Hotel WhichHotelToViewManage() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose which hotel to view/manage:");
		
		int j = 1;
		//for each loop vv cool lol
		for (Hotel i : hotelsInHRS) {
			String name = i.getsHotelName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		int choice = sc.nextInt();
		return hotelsInHRS.get(choice - 1);
	}
	
	public static void ViewHighLevelHotelInformation() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have chosen to view Hotel Information");
		System.out.println("Please choose which hotel to view:");
		
		int j = 1;
		for (Hotel i : hotelsInHRS) {
			String name = i.getsHotelName();
			System.out.println("\t" + j + ". " + name);
			j++;
		}
		int choice = sc.nextInt();
		
		System.out.println("\nName of Hotel: " + hotelsInHRS.get(choice - 1).getsHotelName());
		System.out.println("Total Number of Rooms: " + hotelsInHRS.get(choice - 1).getnCountOfRooms());
		System.out.println("Estimated Earnings of the Month: " + hotelsInHRS.get(choice - 1).EstimatedEarningsPerMonth());
		System.out.println("\nReturning to Main Menu. Press Enter to Continue...\n");
		sc.nextLine();
		cls();
	}
	
	public static void ViewAvailableAndBookedRooms() {
		
	}
	
	public static void ViewInfoOfSelectedRoom() {
		
	}
	
	public static void ViewInfoOfSelectedReservation() {
		
	}
	
	public static void ViewHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
//			sc.nextLine();
//			cls();
			System.out.println("\nYou have chosen Option 2: View Hotel!\n");
			System.out.println("\t1. View High Level Hotel Information");
			System.out.println("\t2. View Hotel's Available and Booked Rooms");
			System.out.println("\t3. View Info of Selected Room");
			System.out.println("\t4. View Info of Selected Reservation");
			System.out.println("\t5. Return to Main Menu");
			choice = sc.nextLine();
			
			if (choice.equals("1")) {
				ViewHighLevelHotelInformation();
			} else if (choice.equals("2")) {
				ViewAvailableAndBookedRooms();
			} else if (choice.equals("3")) {
				ViewInfoOfSelectedRoom();
			} else if (choice.equals("4")) {
				ViewInfoOfSelectedReservation();
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
		
	}
	
	public static void UpdateRoomBasePrices(Hotel chosenHotel) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You have selected to update the base price of rooms in " + chosenHotel.getsHotelName());
		System.out.println("Please input a new base price: ");
		double newPrice = sc.nextDouble();
		
		chosenHotel.UpdateBasePriceOfRooms(newPrice);
		System.out.printf("\nSuccess! The new base price of %s's rooms is now: %fPHP.", chosenHotel.getsHotelName(), Room.dBasePricePerNight);
	}
	
	public static void RemoveReservation(Hotel chosenHotel) {
		
	}
	
	public static void RemoveHotel(Hotel chosenHotel) {
		
	}
	
	public static void ManageHotel() {
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		do {
//			sc.nextLine();
//			cls();
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
