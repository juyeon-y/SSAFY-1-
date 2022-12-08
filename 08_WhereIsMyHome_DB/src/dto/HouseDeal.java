package dto;

public class HouseDeal {

	private long no, aptCode;
	private String dealAmount, area, floor, cancelDealType;
	private int dealYear, dealMonth, dealDay;

	public HouseDeal(long no, long aptCode, String dealAmount, String area, String floor, String cancelDealType,
			int dealYear, int dealMonth, int dealDay) {
		setNo(no);
		setAptCode(aptCode);
		setDealAmount(dealAmount);
		setArea(area);
		setFloor(floor);
		setCancelDealType(cancelDealType);
		setDealYear(dealYear);
		setDealMonth(dealMonth);
		setDealDay(dealDay);
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		if(no>=0) this.no = no;
	}

	public long getAptCode() {
		return aptCode;
	}

	public void setAptCode(long aptCode) {
		if(aptCode>=0) this.aptCode = aptCode;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		if(dealAmount != null) this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		if(area != null) this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		if(floor != null) this.floor = floor;
	}

	public String getCancelDealType() {
		return cancelDealType;
	}

	public void setCancelDealType(String cancelDealType) {
		if(cancelDealType != null) this.cancelDealType = cancelDealType;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		if(dealYear>=0) this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		if(dealMonth>=0) this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		if(dealDay>=0) this.dealDay = dealDay;
	}

}
