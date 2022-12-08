package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.InterestCity;
import dto.User;
import util.DBUtil;

public class UserDao {
	private static UserDao instance;
	Connection con;
	
	private UserDao() {
		try {
			DBUtil dbUtil = DBUtil.getInstance();
			con = dbUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDao getInstance() {
		if (instance == null) instance = new UserDao();
		return instance;
	}

	public boolean checkEmail (String email) {
		String sql = "select count(*) as count from user where email = ? ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, email);
			
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
	
	public int regist(User user) {
		String sql = "insert into user(email, password, name, nickname) values (?, ?, ?, ?) ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getNickname());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int registInterestCity(InterestCity interest) {
		String citySql = "select dongCode from dongcode where sidoName = ? and gugunName = ? and dongName = ? ";
		
		try (PreparedStatement stmt = con.prepareStatement(citySql)){
			stmt.setString(1, interest.getSidoName());
			stmt.setString(2, interest.getGugunName());
			stmt.setString(3, interest.getDongName());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String dongCode = rs.getString("dongCode");
			
				String ifSql = "select * from interestplace where email = ? and dongcode = ? ";
				try (PreparedStatement stmt2 = con.prepareStatement(ifSql)){
					
					stmt2.setString(1, interest.getUserEmail());
					stmt2.setString(2, dongCode);
					
					ResultSet rs2 = stmt.executeQuery();
					if (rs2.next()) {
						if (rs2.getRow() > 0) {
							String sql = "update interestplace set dongCode = ? where email = ? ";
								
							try (PreparedStatement stmt3 = con.prepareStatement(sql)){
									
								stmt3.setString(1, dongCode);
								stmt3.setString(2, interest.getUserEmail());
								return stmt3.executeUpdate();
							} catch (Exception e) {
								e.printStackTrace();
								return 0;
							}

						} else {
							String sql = "insert into interestplace(email, dongCode) values (?, ?) ";
							
							try (PreparedStatement stmt3 = con.prepareStatement(sql)){
							
								stmt3.setString(1, interest.getUserEmail());
								stmt3.setString(2, dongCode);
								return stmt3.executeUpdate();
							} catch (Exception e) {
								e.printStackTrace();
								return 0;
							}
						}
					}
					else return 0;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			} else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public User login(String email, String pw) {
		String sql = "select * from user where email = ? and password = ?";
		
		System.out.println(email);
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, email);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new User(email, rs.getString("name"), pw, rs.getString("nickname"));
			else return null;
		} catch (Exception e) {
			return null;
		}
	}

	public int update(User user) {
		String sql = "update user set password = ?, name = ?, nickname = ? where email = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getNickname());
			stmt.setString(4, user.getEmail());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void delete(String email) {
		String sql = "delete from user where email = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.executeUpdate();
		} catch (Exception e) {
			return;
		}
	}

	public User get(String email) {
		String sql = "select * from user where email = ? ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new User(email, rs.getString("name"), rs.getString("password"), rs.getString("nickname"));
			else return null;
		} catch (Exception e) {
			return null;
		}
	}

	public String getInterestCity(String email) {
		String sql = "select * from dongCode where dongcode = (select dongcode from interestplace where email = ? )";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return rs.getString("sidoName") + " " + rs.getString("gugunName") + " " + rs.getString("dongName");
			else return null;
		} catch (Exception e) {
			return null;
		}
	}

}
