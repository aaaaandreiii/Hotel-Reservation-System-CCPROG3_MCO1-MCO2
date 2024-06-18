
public class Reservation {
	private String sGuestName;
	private Date dtCheckInDate;
	private Date dtCheckOutDate;
	private Room room;
	private int nNumDaysOfStay;
	private double dTotalPriceOfBooking;
	private double dCostPerNight;
	
	public Reservation (String sGuestName, Date dtCheckInDate, Date dtCheckOutDate, int nNumDaysOfStay, Room room) {
		this.sGuestName = sGuestName;
		this.dtCheckInDate = dtCheckInDate;
		this.dtCheckOutDate = dtCheckOutDate;
		this.nNumDaysOfStay = nNumDaysOfStay;
		this.dCostPerNight = this.getdCostPerNight();
		this.dTotalPriceOfBooking = this.getdTotalPriceOfBooking();
		this.room = room;
		System.out.println("Reservation created!");
	}

	public double getdTotalPriceOfBooking() {
		return this.dCostPerNight * this.nNumDaysOfStay;
	}

	public double getdCostPerNight() {
		return dCostPerNight;
	}

	public void setdCostPerNight(double dCostPerNight) {
		this.dCostPerNight = dCostPerNight;
	}

	public String getsGuestName() {
		return sGuestName;
	}

	public Date getDtCheckInDate() {
		return dtCheckInDate;
	}

	public Date getDtCheckOutDate() {
		return dtCheckOutDate;
	}

	public int getnNumDaysOfStay() {
		return nNumDaysOfStay;
	}
}
