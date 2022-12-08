package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;
import util.DBUtil;

public class MemberDao {
	private static MemberDao instance;
	Connection con;
	
	private MemberDao() {
		try {
			DBUtil dbUtil = DBUtil.getInstance();
			con = dbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if (instance == null) instance = new MemberDao();
		return instance;
	}

	public boolean checkId (String id) {
		String sql = "select count(*) as count from member where user_id = ? ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getLong("count") == 0) return true;
				return false;
			}
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int regist(Member member) {
		String sql = "insert into member(user_id, password, email) values (?, ?, ?) ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, member.getUserId());
			stmt.setString(2, member.getPwd());
			stmt.setString(3, member.getEmail());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Member login(String id, String pw) {
		String sql = "select * from member where user_id = ? and password = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new Member(id, pw, rs.getString("email"));
			else return null;
		} catch (Exception e) {
			return null;
		}
	}

	public int update(Member member) {
		String sql = "update member set password = ?, email = ? where user_id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, member.getPwd());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getUserId());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void delete(String id) {
		String sql = "delete from member where user_id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			return;
		}
	}

	public Member get(String id) {
		String sql = "select * from member where user_id = ? ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new Member(id, rs.getString("password"), rs.getString("email"));
			else return null;
		} catch (Exception e) {
			return null;
		}
	}

}
