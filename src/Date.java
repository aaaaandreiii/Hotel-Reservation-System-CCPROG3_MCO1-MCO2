
public class Date {
	private int nDay;
	private int nMonth;
	private int nYear;
	private int nDaysOfMonth;
	private String[] dateParts;
	
	public Date(String rawDate) {
		dateParts = rawDate.split("-");
		
		this.nDay = Integer.parseInt(dateParts[0]);
        this.nMonth = Integer.parseInt(dateParts[1]);
        this.nYear = Integer.parseInt(dateParts[2]);
        this.setnDaysOfMonth();
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
}