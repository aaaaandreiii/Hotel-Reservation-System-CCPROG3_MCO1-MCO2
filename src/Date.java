
public class Date {
	private int nDay, nMonth, nYear;
	private String rawDate;
	private String convertedMonth, convertedDate;
	private int convertedDay, convertedYear;
	private String[] dateParts;
	
	//constructor for new empty object
	public Date(String rawDate) {
		dateParts = rawDate.split("-");
		
		this.nDay = Integer.parseInt(dateParts[0]);
        this.nMonth = Integer.parseInt(dateParts[1]);
        this.nYear = Integer.parseInt(dateParts[2]);
	}
	
	//setter for DD, MM, YYYY	
	public String convertedMMDDYY() {
		
		if (this.nMonth == 01)
			convertedMonth = "Jan";
		else if (this.nMonth == 02)
			convertedMonth = "Feb";
		else if (this.nMonth == 03)
			convertedMonth = "Mar";
		else if (this.nMonth == 04)
			convertedMonth = "Apr";
		else if (this.nMonth == 05)
			convertedMonth = "May";
		else if (this.nMonth == 06)
			convertedMonth = "Jun";
		else if (this.nMonth == 07)
			convertedMonth = "Jul";
		else if (this.nMonth == 8)
			convertedMonth = "Aug";
		else if (this.nMonth == 9)
			convertedMonth = "Sep";
		else if (this.nMonth == 10)
			convertedMonth = "Oct";
		else if (this.nMonth == 11)
			convertedMonth = "Nov";
		else if (this.nMonth == 12)
			convertedMonth = "Dec";
		
		convertedDay = nDay;
		
		if (nYear < 100)
			convertedYear = nYear + 2000;
		else 
			convertedYear = nYear;

		convertedDate = convertedMonth + " " + convertedDay + ", " + convertedYear;
		return convertedDate;
	}
}

/*
Creating 2 dates...
        date1 -> MyDate(2022, 9, 29)
        date2 -> MyDate(2022, 9, 28)

Testing initialize values...
        date1 values: 2022 9 29 -- PASSED CASE
        date2 values: 2022 9 28 -- PASSED CASE

Testing isBefore() method...
        Is date1 before date2? false -- PASSED CASE
        Is date2 before date1? true -- PASSED CASE

Creating more 2 dates...
        date3 -> MyDate()
        date4 -> MyDate()

Testing initialize values...
        date3 values: 1950 1 1 -- PASSED CASE
        date4 values: 1950 1 1 -- PASSED CASE

Testing isBefore() method...
        Is date3 before date4? false -- PASSED CASE

Testing setMonth(String) method by setting date3 to 'febRuarY' and date4 to 'March'

New values...
        date3 values: 1950 2 1 -- PASSED CASE
        date4 values: 1950 3 1 -- PASSED CASE

Testing isBefore() method...
        Is date3 before date4? true -- PASSED CASE
        Is date3 before date1? true -- PASSED CASE

Changing date1 to 1949...
        Is date3 before date1? false -- PASSED CASE
        Is date1 before date3? true -- PASSED CASE

End of test cases...
 */ 
