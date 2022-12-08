package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.dto.Member;
import member.dto.SecVO;

public class MemberDao {
	Connection con;
	private static MemberDao instance;
	private MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy", "ssafy");
		} catch(Exception e) {
			
		}
	}
	public static MemberDao getInstance() {
		if(instance == null) instance = new MemberDao();
		return instance;
	}
	
	public Member login(String id, String pw) {
		String sql = "select * from member where id=? and pw=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {					
				return new Member(id, pw, rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int memberInsert(Member member) {
		String sql = "insert into member(id, pw, name) values(?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.setString(3, member.getName());
			
			return stmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Member memberSelect(String id) {
		String sql = "select * from member where id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(id, rs.getString("pw"), rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int securityInsert(SecVO sec) {
		String sql = "insert into security( id, salt, seckey) values(?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sec.getUserId());
			stmt.setString(2, sec.getSalt());
			stmt.setString(3, sec.getSecKey());
			return stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public SecVO selectSecurity(String id) {
		String sql = "select salt, seckey from security where id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new SecVO(id, rs.getString("salt"), rs.getString("seckey"));
			}
			return null;
 		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int idCheck(String id) {
		int cnt = 1;
		String sql = "select count(id) from member where id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		return cnt;
	}
}
