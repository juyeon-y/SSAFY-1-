package com.ssafy.home.interest.dto;

public class Business {

	private int idx;
	private String dongcode, bizname, maincategory, middleclass, subcategory, category, address;
	private double lng, lat;

	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Business(int idx, String dongcode, String bizname, String maincategory, String middleclass,
			String subcategory, String category, String address, double lng, double lat) {
		super();
		setIdx(idx);
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

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		if (idx > -1)
			this.idx = idx;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		if (dongcode != null)
			this.dongcode = dongcode;
	}

	public String getBizname() {
		return bizname;
	}

	public void setBizname(String bizname) {
		if (bizname != null)
			this.bizname = bizname;
	}

	public String getMaincategory() {
		return maincategory;
	}

	public void setMaincategory(String maincategory) {
		if (maincategory != null)
			this.maincategory = maincategory;
	}

	public String getMiddleclass() {
		return middleclass;
	}

	public void setMiddleclass(String middleclass) {
		if (middleclass != null)
			this.middleclass = middleclass;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		if (subcategory != null)
			this.subcategory = subcategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if (category != null)
			this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null)
			this.address = address;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		if (lng > -1)
			this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		if (lat > -1)
			this.lat = lat;
	}

}
