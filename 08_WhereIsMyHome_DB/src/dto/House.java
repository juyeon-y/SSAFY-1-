package dto;

public class House {

	private String apartmentName, floor, area, dong, dealAmount, roadName, roadNameBonBun;
	
	public House(String apartmentName, String floor, String area, String dong, String dealAmount, String roadName, String roadNameBonBun) {
		super();
		setApartmentName(apartmentName);
		setFloor(floor);
		setArea(area);
		setDong(dong);
		setDealAmount(dealAmount);
		setRoadName(roadName);
		setRoadNameBonBun(roadNameBonBun);
	}
	
	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		if(apartmentName!=null) this.apartmentName = apartmentName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		if(floor!=null) this.floor = floor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		if(area!=null) this.area = area;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		if(dong!=null) this.dong = dong;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		if(dealAmount!=null) this.dealAmount = dealAmount;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		if(roadName!=null) this.roadName = roadName;
	}

	public String getRoadNameBonBun() {
		return roadNameBonBun;
	}

	public void setRoadNameBonBun(String roadNameBonBun) {
		if(roadNameBonBun!=null) this.roadNameBonBun = roadNameBonBun;
	}
	
	
}
