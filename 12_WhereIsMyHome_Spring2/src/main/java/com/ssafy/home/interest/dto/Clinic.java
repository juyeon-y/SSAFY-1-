package com.ssafy.home.interest.dto;

public class Clinic {

	private String sidoname, sigugunname, clinicname, address, daytime, saturdaytime, sundaytime, redtime, phone;

	public Clinic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clinic(String sidoname, String sigugunname, String clinicname, String address, String daytime,
			String saturdaytime, String sundaytime, String redtime, String phone) {
		super();
		setSidoname(sidoname);
		setSigugunname(sigugunname);
		setClinicname(clinicname);
		setAddress(address);
		setDaytime(daytime);
		setSaturdaytime(saturdaytime);
		setSundaytime(sundaytime);
		setRedtime(redtime);
		setPhone(phone);
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

	public String getClinicname() {
		return clinicname;
	}

	public void setClinicname(String clinicname) {
		if (clinicname != null)
			this.clinicname = clinicname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null)
			this.address = address;
	}

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		if (daytime != null)
			this.daytime = daytime;
	}

	public String getSaturdaytime() {
		return saturdaytime;
	}

	public void setSaturdaytime(String saturdaytime) {
		if (saturdaytime != null)
			this.saturdaytime = saturdaytime;
	}

	public String getSundaytime() {
		return sundaytime;
	}

	public void setSundaytime(String sundaytime) {
		if (sundaytime != null)
			this.sundaytime = sundaytime;
	}

	public String getRedtime() {
		return redtime;
	}

	public void setRedtime(String redtime) {
		if (redtime != null)
			this.redtime = redtime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null)
			this.phone = phone;
	}

}
