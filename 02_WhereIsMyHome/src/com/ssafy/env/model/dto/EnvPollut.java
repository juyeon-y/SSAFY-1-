package com.ssafy.env.model.dto;

public class EnvPollut {
	
	/**점검 내역을 식별할 번호*/
	private int no;
	/**업체(시설)명*/
	private String  companyName;
	/**인허가번호*/
	private String licenseNo;
	/**업종코드*/
	private String bizCode;
	/**업종명*/
	private String bizName;
	/**지도점검 연도*/
	private String inspDate;
	/**점검기관 번호*/
	private String inspAgencyNo;
	/**점검기관명*/
	private String inspAgencyName;
	/**지도점검구분*/
	private String inspCategory;
	/**처분대상여부*/
	private String forDisposal;
	/**점검사항*/
	private String inspDesc;
	/**점검결과*/
	private String inspRes;
	/**소재지도로명주소*/
	private String roadNameAdd; 
	/**소재지주소*/
	private String address;
	
	public EnvPollut() {}
	public EnvPollut(int no) {
		super();
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	
	public String getInspDate() {
		return inspDate;
	}
	public void setInspDate(String inspDate) {
		this.inspDate = inspDate;
	}
	public String getInspAgencyNo() {
		return inspAgencyNo;
	}
	public void setInspAgencyNo(String inspAgencyNo) {
		this.inspAgencyNo = inspAgencyNo;
	}
	public String getInspAgencyName() {
		return inspAgencyName;
	}
	public void setInspAgencyName(String inspAgencyName) {
		this.inspAgencyName = inspAgencyName;
	}
	public String getInspCategory() {
		return inspCategory;
	}
	public void setInspCategory(String inspCategory) {
		this.inspCategory = inspCategory;
	}
	public String getForDisposal() {
		return forDisposal;
	}
	public void setForDisposal(String forDisposal) {
		this.forDisposal = forDisposal;
	}
	public String getInspDesc() {
		return inspDesc;
	}
	public void setInspDesc(String inspDesc) {
		this.inspDesc = inspDesc;
	}
	public String getInspRes() {
		return inspRes;
	}
	public void setInspRes(String inspRes) {
		this.inspRes = inspRes;
	}
	public String getRoadNameAdd() {
		return roadNameAdd;
	}
	public void setRoadNameAdd(String roadNameAdd) {
		this.roadNameAdd = roadNameAdd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EnvPollut [no=" + no + ", companyName=" + companyName + ", licenseNo=" + licenseNo + ", bizCode="
				+ bizCode + ", bizName=" + bizName + ", inspDate=" + inspDate + ", inspAgencyNo=" + inspAgencyNo
				+ ", inspAgencyName=" + inspAgencyName + ", inspCategory=" + inspCategory + ", forDisposal="
				+ forDisposal + ", inspDesc=" + inspDesc + ", inspRes=" + inspRes + ", roadNameAdd=" + roadNameAdd
				+ ", address=" + address + "]";
	}
	
}