public class Date {
	private int nDay;
	private int nMonth;
	private int nYear;
	private int nDaysOfMonth;
	private String[] dateParts;
	
	//empty constructor just to instantiate object
	public Date() {
	}
	
	public Date(String rawDate) {
		dateParts = rawDate.split("-");
		
		this.nDay = Integer.parseInt(dateParts[0]);
        this.nMonth = Integer.parseInt(dateParts[1]);
        this.nYear = Integer.parseInt(dateParts[2]);
        this.setnDaysOfMonth();
	}
	
	//converts date to nth date in year
	public int dayInYear(Date date) {
		int[] numOfDaysPerMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int totalNumOfDays = 0;
		for (int i = 0; i < date.getnMonth() - 2; i++) {
			totalNumOfDays += numOfDaysPerMonth[i];
		}
		totalNumOfDays += date.getnDay();
		
		return totalNumOfDays;
	}
	
	public String printStringDate() {
		String date = null;
		date = this.monthWord() + " " + this.nDay + ", " + this.nYear;
		return (date);
	}
	
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

	public void setnDay(int nDay) {
		this.nDay = nDay;
	}

	public void setnMonth(int nMonth) {
		this.nMonth = nMonth;
	}

	public void setnYear(int nYear) {
		this.nYear = nYear;
	}

	public int getnDay() {
		return nDay;
	}

	public int getnMonth() {
		return nMonth;
	}

	public int getnYear() {
		return nYear;
	}
	
	public int getnDaysOfMonth() {
		return nDaysOfMonth;
	}
	
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