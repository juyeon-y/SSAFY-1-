package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Business;
import dto.Clinic;
import dto.Environment;
import dto.Hospital;
import util.DBUtil;

public class InterestDao {
	private static InterestDao instance;
	Connection con;
	
	private InterestDao() {
		try {
			DBUtil dbUtil = DBUtil.getInstance();
			con = dbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static InterestDao getInstance() {
		if (instance == null) instance = new InterestDao();
		return instance;
	}

	public List<Environment> getEnvInspInfo(String email) {
		String sql = "select * from environment where dongcode = (select dongcode from interestplace where email = ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Environment> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(new Environment(rs.getString("WRKP_NM"),rs.getString("UPCH_COB_CODE"),rs.getString("UPCH_COB_NM"),rs.getDate("DRT_INSP_YMD"),rs.getString("ORG_AND_TEAM_CODE"),rs.getString("SF_TEAM_NM"),rs.getString("DRT_INSP_SE_NM"),rs.getString("DISPO_TGT_YN"),rs.getString("DRT_INSP_ITEM"),rs.getString("DRT_INSP_RT_DTL"),rs.getString("dongcode"),rs.getString("address")));
			}
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Business> getBizInfo(String email) {
		String sql = "select * from business where dongcode = (select dongcode from interestplace where email = ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Business> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(new Business(rs.getString("dongcode"),rs.getString("bizname"),rs.getString("maincategory"),rs.getString("middleclass"),rs.getString("subcategory"),rs.getString("category"),rs.getString("address"),rs.getDouble("lng"), rs.getDouble("lat")));
			}
					
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Hospital> getHospitalInfo(String email) {
		String sql = "select * from hospital where sigugunname = (select gugunName from dongcode where dongcode = (select dongcode from interestplace where email = ?))";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Hospital> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(new Hospital(rs.getString("hospitalname"),rs.getString("sidoname"),rs.getString("sigugunname"),rs.getString("address"),rs.getString("applicationtype"),rs.getString("phone")));
			}
					
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Clinic> getClinicInfo(String email) {
		String gugunName ="";
		String sql = "select gugunName from dongcode where dongcode = (select dongcode from interestplace where email = ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				gugunName = rs.getString("gugunName");
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		sql = "select * from clinic where instr(address, ?);";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, gugunName);
			ResultSet rs = stmt.executeQuery();
			
			List<Clinic> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(new Clinic(rs.getString("sidoname"),rs.getString("sigugunname"),rs.getString("clinicname"),rs.getString("address"),rs.getString("daytime"),rs.getString("saturdaytime"),rs.getString("sundaytime"),rs.getString("redtime"), rs.getString("phone")));
			}
					
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
