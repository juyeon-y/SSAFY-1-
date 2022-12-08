package dto;

public class Business {
	String dongcode, bizname, maincategory,  middleclass, subcategory, category, address; 
	Double lng, lat;
	public Business(String dongcode, String bizname, String maincategory, String middleclass, String subcategory,
			String category, String address, Double lng, Double lat) {
		super();
		setDongcode(dongcode);
		setBizname(bizname);
		setMaincategory(maincategory);
		setMiddleclass(middleclass);
		setSubcategory(subcategory);
		setCategory(category);
		setAddress(address);
		setLng(lng);
		setLat(lat);
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		if (dongcode != null) this.dongcode = dongcode;
	}
	public String getBizname() {
		return bizname;
	}
	public void setBizname(String bizname) {
		if (bizname != null) this.bizname = bizname;
	}
	public String getMaincategory() {
		return maincategory;
	}
	public void setMaincategory(String maincategory) {
		if (maincategory != null) this.maincategory = maincategory;
	}
	public String getMiddleclass() {
		return middleclass;
	}
	public void setMiddleclass(String middleclass) {
		if (middleclass != null) this.middleclass = middleclass;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		if (subcategory != null) this.subcategory = subcategory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		if (category != null) this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if (address != null) this.address = address;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		if (lng > 0) this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		if (lat > 0) this.lat = lat;
	}

}
