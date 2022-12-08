package dto;

import java.util.Date;

public class Environment {

	private int idx;
	private String wrkpNm, upchCobCode, upchCobNm, orgAndTeamCode, sfTeamNm, drtInspSeNm, dispoTgtYn, drtInspItem,
			drtInspRtDtl, dongcode, address;
	private Date drtInspYmd;

	public Environment(String wrkpNm, String upchCobCode, String upchCobNm, Date drtInspYmd, String orgAndTeamCode,
			String sfTeamNm, String drtInspSeNm, String dispoTgtYn, String drtInspItem, String drtInspRtDtl,
			String dongcode, String address) {
		setWrkpNm(wrkpNm);
		setUpchCobCode(upchCobCode);
		setUpchCobNm(upchCobNm);
		setOrgAndTeamCode(orgAndTeamCode);
		setSfTeamNm(sfTeamNm);
		setDrtInspSeNm(drtInspSeNm);
		setDispoTgtYn(dispoTgtYn);
		setDrtInspItem(drtInspItem);
		setDrtInspRtDtl(drtInspRtDtl);
		setDongcode(dongcode);
		setDrtInspYmd(drtInspYmd);
		setAddress(address);
	}

	public int getIdx() {
		return idx;
	}

	public String getWrkpNm() {
		return wrkpNm;
	}

	public void setWrkpNm(String wrkpNm) {
		if(wrkpNm != null) this.wrkpNm = wrkpNm;
	}

	public String getUpchCobCode() {
		return upchCobCode;
	}

	public void setUpchCobCode(String upchCobCode) {
		if(upchCobCode != null) this.upchCobCode = upchCobCode;
	}

	public String getUpchCobNm() {
		return upchCobNm;
	}

	public void setUpchCobNm(String upchCobNm) {
		if(upchCobNm != null) this.upchCobNm = upchCobNm;
	}

	public String getOrgAndTeamCode() {
		return orgAndTeamCode;
	}

	public void setOrgAndTeamCode(String orgAndTeamCode) {
		if(orgAndTeamCode != null) this.orgAndTeamCode = orgAndTeamCode;
	}

	public String getSfTeamNm() {
		return sfTeamNm;
	}

	public void setSfTeamNm(String sfTeamNm) {
		if(sfTeamNm != null) this.sfTeamNm = sfTeamNm;
	}

	public String getDrtInspSeNm() {
		return drtInspSeNm;
	}

	public void setDrtInspSeNm(String drtInspSeNm) {
		if(drtInspSeNm != null) this.drtInspSeNm = drtInspSeNm;
	}

	public String getDispoTgtYn() {
		return dispoTgtYn;
	}

	public void setDispoTgtYn(String dispoTgtYn) {
		if(dispoTgtYn != null) this.dispoTgtYn = dispoTgtYn;
	}

	public String getDrtInspItem() {
		return drtInspItem;
	}

	public void setDrtInspItem(String drtInspItem) {
		if(drtInspItem != null) this.drtInspItem = drtInspItem;
	}

	public String getDrtInspRtDtl() {
		return drtInspRtDtl;
	}

	public void setDrtInspRtDtl(String drtInspRtDtl) {
		if(drtInspRtDtl != null) this.drtInspRtDtl = drtInspRtDtl;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		if(dongcode != null) this.dongcode = dongcode;
	}

	public Date getDrtInspYmd() {
		return drtInspYmd;
	}

	public void setDrtInspYmd(Date drtInspYmd) {
		if(drtInspYmd != null) this.drtInspYmd = drtInspYmd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address != null) this.address = address;
	}

}
