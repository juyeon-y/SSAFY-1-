package dto;

public class Houseinfo {
	long aptCode;
	int buildYear;
	String roadName, roadNameBonbun, roadNameBubun, roadNameSeq, roadNameBasementCode, roadNameCode, dong, bonbun, bubun, sigunguCode, eubmyundongCode, dongCode, landCode, apartmentName,jibun, lng, lat;
	public Houseinfo(long aptCode, int buildYear, String roadName, String roadNameBonbun, String roadNameBubun,
			String roadNameSeq, String roadnameBasementCode, String roadNameCode, String dong, String bonbun,
			String bubun, String sigunguCode, String eubmyundongCode, String dongCode, String landCode,
			String apartmentName, String jibun, String lng, String lat) {
		super();
		setAptCode(aptCode);
		setBuildYear(buildYear);
		setRoadName(roadName);
		setRoadNameBonbun(roadNameBonbun);
		setRoadNameSeq(roadNameSeq);
		setRoadNameBasementCode(roadNameBasementCode);
		setRoadNameCode(roadNameCode);
		setDong(dong);
		setBonbun(bonbun);
		setBubun(bubun);
		setSigunguCode(sigunguCode);
		setEubmyundongCode(eubmyundongCode);
		setDongCode(dongCode);
		setLandCode(landCode);
		setApartmentName(apartmentName);
		setJibun(jibun);
		setLng(lng);
		setLat(lat);
	}
	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		if(aptCode>0)
			this.aptCode = aptCode;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		if(aptCode>0)
			this.buildYear = buildYear;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		if(roadName!=null)
			this.roadName = roadName;
	}
	public String getRoadNameBonbun() {
		return roadNameBonbun;
	}
	public void setRoadNameBonbun(String roadNameBonbun) {
		if(roadNameBonbun!=null)
			this.roadNameBonbun = roadNameBonbun;
	}
	public String getRoadNameBubun() {
		return roadNameBubun;
	}
	public void setRoadNameBubun(String roadNameBubun) {
		if(roadNameBubun!=null)
			this.roadNameBubun = roadNameBubun;
	}
	public String getRoadNameSeq() {
		return roadNameSeq;
	}
	public void setRoadNameSeq(String roadNameSeq) {
		if(roadNameSeq!=null)
			this.roadNameSeq = roadNameSeq;
	}
	public String getRoadNameBasementCode() {
		return roadNameBasementCode;
	}
	public void setRoadNameBasementCode(String roadNameBasementCode) {
		if(roadNameBasementCode!=null)
			this.roadNameBasementCode = roadNameBasementCode;
	}
	public String getRoadNameCode() {
		return roadNameCode;
	}
	public void setRoadNameCode(String roadNameCode) {
		if(roadNameCode!=null)
			this.roadNameCode = roadNameCode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		if(dong!=null)
			this.dong = dong;
	}
	public String getBonbun() {
		return bonbun;
	}
	public void setBonbun(String bonbun) {
		if(bonbun!=null)
			this.bonbun = bonbun;
	}
	public String getBubun() {
		return bubun;
	}
	public void setBubun(String bubun) {
		if(bubun!=null)
			this.bubun = bubun;
	}
	public String getSigunguCode() {
		return sigunguCode;
	}
	public void setSigunguCode(String sigunguCode) {
		if(sigunguCode!=null)
			this.sigunguCode = sigunguCode;
	}
	public String getEubmyundongCode() {
		return eubmyundongCode;
	}
	public void setEubmyundongCode(String eubmyundongCode) {
		if(eubmyundongCode!=null)
			this.eubmyundongCode = eubmyundongCode;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		if(dongCode!=null)
			this.dongCode = dongCode;
	}
	public String getLandCode() {
		return landCode;
	}
	public void setLandCode(String landCode) {
		if(landCode!=null)
			this.landCode = landCode;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		if(apartmentName!=null)
			this.apartmentName = apartmentName;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		if(jibun!=null)
			this.jibun = jibun;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		if(lng!=null)
			this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		if(lat!=null)
			this.lat = lat;
	}
	
	
}
