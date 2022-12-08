package house.dto;

import com.google.gson.JsonObject;

public class House {
	private long no;
	private String dong, roadName, apartmentName, lat, lng, floor, area, dealAmount;
	
	@Override
	public String toString() {
		JsonObject json = new JsonObject();
		json.addProperty("no", no);
		json.addProperty("dong", dong);
		json.addProperty("roadName", roadName);
		json.addProperty("apartmentName", apartmentName);
		json.addProperty("lat", lat);
		json.addProperty("lng", lng);
		json.addProperty("floor", floor);
		json.addProperty("area", area);
		json.addProperty("dealAmount", dealAmount);
		return json.toString();
	}

	public House(long no, String dong, String roadName, String apartmentName, String lat, String lng, String floor,
			String area, String dealAmount) {
		setNo(no);
		setDong(dong);
		setRoadName(roadName);
		setApartmentName(apartmentName);
		setLat(lat);
		setLng(lng);
		setFloor(floor);
		setArea(area);
		setDealAmount(dealAmount);
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		if (no==0) {
			this.no = no;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		if (dong != null) {
			this.dong = dong;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
		
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		if (roadName != null) {
			this.roadName = roadName;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
		
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		if (apartmentName != null) {
			this.apartmentName = apartmentName;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
		
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		if (lat != null) {
			this.lat = lat;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		if (lng != null) {
			this.lng = lng;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		if (floor != null) {
			this.floor = floor;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		if (area != null) {
			this.area = area;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		if (dealAmount != null) {
			this.dealAmount = dealAmount;
        } else {
            System.out.println("유효하지 않은 값입니다.");
        }
	}

}
