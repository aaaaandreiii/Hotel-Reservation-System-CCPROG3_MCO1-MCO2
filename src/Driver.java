import java.io.IOException;
import java.util.Scanner;

public class Driver {
	/**
	 * Main method that runs all other classes and methods.
	 * @param args - string array
	 */
    public static void main(String[] args) {
		//initialize objects
		Model model;
		View view;
		Controller controller;
        HotelReservationSystem HRS = new HotelReservationSystem();

		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String choice = null;
		String end = null;
		
		do {
			System.out.println("Do you want to open the GUI? (yes/no)");
			choice = "yes";// choice = sc.next(); //choice = "no";// 
			
			if (choice.toLowerCase().equals("yes") || choice.toLowerCase().equals("y")) {
				//instantiate attributes needed by attributes of MVC


				//model
				//view - GUI classes
				//controller 

				model = new Model();
				view = new View();
				controller = new Controller(model, view);

				System.out.println("Do you want to quit the program? (yes/no)");
				end = sc.next();
				
				if (end.toLowerCase().equals("yes") || choice.equals("yes")) {
					view.exitApplication();
					System.out.println("Thank you for using this program.");
				}

			} else if (choice.toLowerCase().equals("no") || choice.toLowerCase().equals("n")) {
				MainMenu(HRS);
			} else {
				System.out.println("Please choose between yes or no only.\n");
				cls();
			}
			
			System.out.println("Do you want to quit the program? (yes/no)");
			System.out.println("Select no to open the GUI.");
			end = sc.next();
			
			if (end.toLowerCase().equals("yes") || choice.equals("yes")) {
				System.out.println("Thank you for using this program.");
			}

		} while (!(choice.equals("yes") || choice.equals("y")) && !(end.equals("yes") || end.equals("y")));
		
		sc.close();
	}
    
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
	
	public static void MainMenu(HotelReservationSystem HRS) {
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		String choice = "";
		
		do {
            cls();
            
			System.out.println("HOTEL RESERVATION SYSTEM\n");
			System.out.println("What do you want to do?");
			System.out.println("\t1. Create Hotel");
			System.out.println("\t2. View Hotel");
			System.out.println("\t3. Manage Hotel");
			System.out.println("\t4. Simulate Booking");
			System.out.println("\t5. Quit Program");
			
			choice = sc.nextLine();
			
			if (HRS.isHotelsInHRSEmpty() && choice.equals("1")) {
				HRS.CreateHotel();
			} else if (HRS.isHotelsInHRSEmpty() && (choice.equals("2") || choice.equals("3") || choice.equals("4"))) {
				System.out.println("Apologies. There are no existing hotels yet. Please create a hotel first.");
				sc.nextLine();
			} else if (HRS.isHotelsInHRSEmpty() && choice.equals("5")) {
				cls();
				System.out.println("Thank you for using this HOTEL RESERVATION SYSTEM!");
			} else {
				if (choice.equals("1")) {
					HRS.CreateHotel();
				} else if (choice.equals("2")) {
					HRS.ViewHotel();
				} else if (choice.equals("3")) {
					HRS.ManageHotel();
				} else if (choice.equals("4")) {
					HRS.SimulateBooking();
				} else if (choice.equals("5")) {
					cls();
					System.out.println("Thank you for using this HOTEL RESERVATION SYSTEM!");
				} else {
					System.out.println("uh oh! Please reinput your selection :((\n");
				}
			}
		} while (!choice.equals("5"));
		// sc.close();
	}
}