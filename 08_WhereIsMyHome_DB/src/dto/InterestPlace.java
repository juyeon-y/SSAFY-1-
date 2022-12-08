package dto;

public class InterestPlace {
	
	private String email, dongCode;	

	public InterestPlace(String email, String dongCode) {
		setEmail(email);
		setDongCode(dongCode);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null) this.email = email;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		if(dongCode != null) this.dongCode = dongCode;
	}

	
}
