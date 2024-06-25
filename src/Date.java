/**
 * CCPROG3 MCO1: Hotel Reservation System
 * Filename: Date.java
 * @author Andrei Balingit	| 12203297
 * @version 24/06/2024
 * 
 */

/**
 * This Date class is used as formatted structure for a specified period/moment in time.
 * It is identified by just an integer for each of its main attributes Year, Month, and Day.
 */
public class Date {
	/**
	 * Three integer variables are declared for its three main attributes: Day, Month, and Year
	 * Another integer variable is allocated for counting each of the twelve month's different number of days.
	 * 		If the month is February, there are 29 days (2024). If the month is August, there are 31 days.
	 * A string array is declared to store the parsed version of the user-inputted date string.
	 */
	private int nDay;
	private int nMonth;
	private int nYear;
	private int nDaysOfMonth;
	private String[] dateParts;
	
	/**
	 * This constructor is declared empty without any parameters in order to just instantiate a Date object.
	 * This is used in the program when creating Date objects before filling it in with Check-In and Check-Out dates.
	 */
	public Date() {
	}
	
	/**
	 * This constructor includes a user-inputted String to be processed before passing them onto the main attributes of this class.
	 * Once a correctly inputed string is received, the constructor splits the string by each dash line, stores them into a String array, then is parsed into 3 parts: DAY, MONTH, YEAR, and lastly stored into its appropriate attribute.
	 * @param rawDate - This parameter requires the user to input a date in the format DD-MM-YYYY where each segment of the DAY, MONTH, and YEAR must be divided by dash lines.
	 */
	public Date(String rawDate) {
		dateParts = rawDate.split("-");
		
		this.nDay = Integer.parseInt(dateParts[0]);
        this.nMonth = Integer.parseInt(dateParts[1]);
        this.nYear = Integer.parseInt(dateParts[2]);
        this.setnDaysOfMonth();
	}
	
	/**
	 * This method computes for the number of days the inputed date is in the year. 
	 * In simpler terms, it converts the date to the nth day in the year.
	 * 		If the passed date is January 1, then it is Day 1. If the passed date is June 25, it is Day 177.
	 * This method does so by finding the summation of number of days per month until the specified month minus one, then adds the number of specifed days.
	 * This method could have been a public static method or a method in the class it was used in because it does not require a specific instance's attributes to be computed, but I decided to put it here for better convenience.
	 * @param date - Inputed/passed date object to be computed for
	 * @return the nth date in the year
	 */
	public int dayInYear(Date date) {
		int[] numOfDaysPerMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int totalNumOfDays = 0;
		for (int i = 0; i < date.getnMonth() - 2; i++) {
			totalNumOfDays += numOfDaysPerMonth[i];
		}
		totalNumOfDays += date.getnDay();
		
		return totalNumOfDays;
	}
	
	/**
	 * This method prints the entire date in the format: Day Month, Year.
	 * @return date - String in the format: Day Month, Year
	 */
	public String printStringDate() {
		String date = null;
		date = this.monthWord() + " " + this.nDay + ", " + this.nYear;
		return (date);
	}
	
	/**
	 * This method finds the equivalent word of the month integer.
	 * @return month - where month is the English word equivalent to the MM integer (in the DD-MM-YYYY format)
	 */
	public String monthWord() {
		String month = null;
		switch (this.nMonth) {
			case 1:			// January
				month = "January";
				break;
			case 2:			// February
				month = "February";
				break;
			case 3:			// March
				month = "March";
				break;
			case 4:			// April
				month = "April";
				break;
			case 5:			// May
				month = "May";
				break;
			case 6:			// June
				month = "June";
				break;
			case 7:			// July
				month = "July";
				break;
			case 8:			// August
				month = "August";
				break;
			case 9:			// September
				month = "September";
				break;
			case 10:		// October
				month = "October";
				break;
			case 11:		// November
				month = "November";
				break;
			case 12:		// December
				month = "December";
				break;
		}
		return month;
	}

	/**
	 * This method is a setter for nDay.
	 * @param nDay - this is the integer variable of DD in the DD-MM-YYYY format.
	 */
	public void setnDay(int nDay) {
		this.nDay = nDay;
	}

	/**
	 * This method is a setter for nMonth.
	 * @param nMonth - this is the integer variable of MM in the DD-MM-YYYY format
	 */
	public void setnMonth(int nMonth) {
		this.nMonth = nMonth;
	}

	/**
	 * This method is a setter for nYear.
	 * @param nYear - this is the integer variable of YYYY in the DD-MM-YYYY format
	 */
	public void setnYear(int nYear) {
		this.nYear = nYear;
	}

	/**
	 * This method is a getter for nDay.
	 * @return nDay - this is the integer variable of DD in the DD-MM-YYYY format.
	 */
	public int getnDay() {
		return nDay;
	}

	/**
	 * This method is a getter for nMonth.
	 * @return nMonth - this is the integer variable of MM in the DD-MM-YYYY format
	 */
	public int getnMonth() {
		return nMonth;
	}

	/**
	 * This method is a getter for nYear.
	 * @return nYear - this is the integer variable of YYYY in the DD-MM-YYYY format
	 */
	public int getnYear() {
		return nYear;
	}
	
	/**
	 * This method is a getter for nDaysOfMonth.
	 * @return nDaysOfMonth - this is the variable that store how many days there are in the specified month.
	 */
	public int getnDaysOfMonth() {
		return nDaysOfMonth;
	}
	
	/**
	 * This method is a setter for nDaysOfMonth.
	 * It sets the number of days there are in the specified month.
	 * If the specified month is January (or MM = 01), there are 31 days. If the specified month is February (or MM = 02), then there are 29 days.
	 */
	public void setnDaysOfMonth() {
		switch (this.nMonth) {
			case 1:			// January
				this.nDaysOfMonth = 31;
				break;
			case 2:			// February
				this.nDaysOfMonth = 29;
				break;
			case 3:			// March
				this.nDaysOfMonth = 31;
				break;
			case 4:			// April
				this.nDaysOfMonth = 30;
				break;
			case 5:			// May
				this.nDaysOfMonth = 31;
				break;
			case 6:			// June
				this.nDaysOfMonth = 30;
				break;
			case 7:			// July
				this.nDaysOfMonth = 31;
				break;
			case 8:			// August
				this.nDaysOfMonth = 31;
				break;
			case 9:			// September
				this.nDaysOfMonth = 30;
				break;
			case 10:		// October
				this.nDaysOfMonth = 31;
				break;
			case 11:		// November
				this.nDaysOfMonth = 30;
				break;
			case 12:		// December
				this.nDaysOfMonth = 31;
				break;
		}
	}
	
	/**
	 * This method checks whether the instance's date is before another given date.
	 * This method is used in checking the validity of the Check-In and Check-Out dates.
	 * @param date - This Date instance that is passed as a parameter is different and a separate date time from the current object instance that is in effect. 
	 * @return TRUE or FALSE whether the current date instance is before the passed date object.
	 */
	public boolean isBefore(Date date) {					//is 2022 9 28 before 2022 9 29
		if (this.getnYear() == date.getnYear()) {				//if 2022 == 2022
			if (this.getnMonth() == date.getnMonth()) {		//if 9 == 9
				if (this.getnDay() == date.getnDay())			//if 29 == 29
					return false;								//then no, not before
				else if (this.getnDay() > date.getnDay())		//else if 29 > 28
					return false;
				else 
					return true;
			}
			else if (this.getnMonth() > date.getnMonth())
				return false;
			else 
				return true;
		}
		else if (this.getnYear() > date.getnYear())			//if 2023 > 2022
			return false;
		else												//if 2022 > 2023
			return true;
	}
}