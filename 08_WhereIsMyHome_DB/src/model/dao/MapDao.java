package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.House;
import util.DBUtil;

public class MapDao {
	
	DBUtil dbUtil;
	
	private static MapDao instance;
	
	private MapDao() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MapDao getInstance() {
		if(instance == null) instance = new MapDao();
		return instance;
	}

	public List<String> getSido() throws SQLException {
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct(sidoName) from dongcode order by sidoName");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sidoName = rs.getString("sidoName");
				list.add(sidoName);
			}
			return list;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public List<String> getGugun(String sidoName) throws SQLException {
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct(gugunName) from dongcode where sidoName = ? order by gugunName");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sidoName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String gugunName = rs.getString("gugunName");
				if(gugunName!=null) list.add(gugunName);
			}
			return list;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public List<String> getDong(String gugunName) throws SQLException {
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct(dongName) from dongcode where gugunName = ? order by dongName");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, gugunName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String dongName = rs.getString("dongName");
				if(dongName!=null)list.add(dongName);
			}
			return list;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public String getDongCode(String sidoName, String gugunName, String dongName) throws SQLException {
		String dongCode = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select dongCode from dongcode where sidoName = ? and gugunName = ? and dongName = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sidoName);
			pstmt.setString(2, gugunName);
			pstmt.setString(3, dongName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dongCode = rs.getString("dongCode");
			}
			return dongCode;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public List<House> getHouse(String dongCode, String year, String month) throws SQLException {
		List<House> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT i.apartmentName, d.floor, d.area, i.dong, d.dealAmount, i.roadName, i.roadNameBonBun \n");
			sql.append("from houseinfo as i \n");
			sql.append("inner join housedeal as d \n");
			sql.append("on i.aptCode = d.aptCode \n");
			sql.append("where i.dongCode=? and d.dealYear=? and d.dealMonth=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dongCode);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String apartmentName = rs.getString("apartmentName");
				String floor = rs.getString("floor");
				String area = rs.getString("area");
				String dong = rs.getString("dong");
				String dealAmount = rs.getString("dealAmount");
				String roadName = rs.getString("roadName");
				String roadNameBonBun = rs.getString("roadNameBonBun");
				list.add(new House(apartmentName, floor, area, dong, dealAmount, roadName, roadNameBonBun));
			}
			return list;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
	


}
