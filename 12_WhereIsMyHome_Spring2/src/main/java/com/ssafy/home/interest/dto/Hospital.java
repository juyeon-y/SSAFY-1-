package com.ssafy.home.interest.dto;

public class Hospital {
	String hospitalname, sidoname, sigugunname, address, applicationtype, phone;

	public Hospital(String hospitalname, String sidoname, String sigugunname, String address, String applicationtype,
			String phone) {
		super();
		setHospitalname(hospitalname);
		setSidoname(sidoname);
		setSigugunname(sigugunname);
		setAddress(address);
		setApplicationtype(applicationtype);
		setPhone(phone);
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		if (hospitalname != null)
			this.hospitalname = hospitalname;
	}

	public String getSidoname() {
		return sidoname;
	}

	public void setSidoname(String sidoname) {
		if (sidoname != null)
			this.sidoname = sidoname;
	}

	public String getSigugunname() {
		return sigugunname;
	}

	public void setSigugunname(String sigugunname) {
		if (sigugunname != null)
			this.sigugunname = sigugunname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null)
			this.address = address;
	}

	public String getApplicationtype() {
		return applicationtype;
	}

	public void setApplicationtype(String applicationtype) {
		if (applicationtype != null)
			this.applicationtype = applicationtype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null)
			this.phone = phone;
	}

}
