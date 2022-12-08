package dto;

public class InterestCity {
	String userEmail;
	String sidoName;
	String gugunName;
	String dongName;
	
	
	public String getDongName() {
		return dongName;
	}


	public void setDongName(String dongName) {
		if (dongName != null) {
			if (dongName.equals("None")) this.dongName = null;
			else this.dongName = dongName;
		}
	}

	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		if (userEmail != null) this.userEmail = userEmail;
	}


	public String getSidoName() {
		return sidoName;
	}


	public void setSidoName(String sidoName) {
		if (sidoName != null) this.sidoName = sidoName;
	}


	public String getGugunName() {
		return gugunName;
	}


	public void setGugunName(String gugunName) {
		if (gugunName != null) this.gugunName = gugunName;
	}


	public InterestCity(String userEmail, String sidoName, String gugunName, String dongName) {
		super();
		setUserEmail(userEmail);
		setSidoName(sidoName);
		setGugunName(gugunName);
		setDongName(dongName);
	}
}
