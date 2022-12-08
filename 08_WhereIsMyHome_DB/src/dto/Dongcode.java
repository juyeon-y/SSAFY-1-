package dto;

public class Dongcode {
	String dongCode, sidoName, gugunName, dongName;

	public Dongcode(String dongCode, String sidoName, String gugunName, String dongName) {
		super();
		setDongCode(dongCode);
		setSidoName(sidoName);
		setGugunName(gugunName);
		setDongName(dongName);
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		if(dongCode!=null)
			this.dongCode = dongCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		if(sidoName!=null)
			this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		if(gugunName!=null)
			this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		if(dongName!=null)
			this.dongName = dongName;
	}
	
	
}
