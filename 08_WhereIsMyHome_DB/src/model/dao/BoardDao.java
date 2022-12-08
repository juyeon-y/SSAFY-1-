package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Notice;
import util.DBUtil;

public class BoardDao {

	Connection con;
	private static BoardDao instance;
	
	private BoardDao() {
		try {
			DBUtil dbUtil = DBUtil.getInstance();
			con = dbUtil.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		if(instance==null)
			instance = new BoardDao();
		return instance;
	}
	public int registNotice(Notice board) {
		try(PreparedStatement stmt = con.prepareStatement("INSERT INTO `happyhouse`.`notice` ( `title`, `contents`, `hits`, `writer`, `date`) VALUES (?, ?, '0', ?, curdate())");){
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setString(3, board.getWriter());
			
			return stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public int updateNotice(Notice board) {
		try(PreparedStatement stmt = con.prepareStatement("update notice set title=?, contents=?, writer=? where idx=?");){
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setString(3, board.getWriter());
			stmt.setInt(4, board.getIdx());
			
			return stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int deleteNotice(int no) {
		try(PreparedStatement stmt = con.prepareStatement("delete from notice where idx = ?");){
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public Notice selectNoticeByIdx(int idx) {
		try(PreparedStatement stmt = con.prepareStatement("select * from notice where idx=?");){
			stmt.setInt(1, idx);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Notice(rs.getInt("idx"), rs.getString("title"),rs.getString("contents"),rs.getInt("hits"),rs.getString("writer"),rs.getDate("date"));
			}else
				return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Notice> selectNoticeByTitle(String str) {
		try(PreparedStatement stmt = con.prepareStatement("select * from notice where title like ?");){
			stmt.setString(1, "%"+str+"%");
			
			List<Notice> result = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				result.add(new Notice(rs.getInt("idx"), rs.getString("title"),rs.getString("contents"),rs.getInt("hits"),rs.getString("writer"),rs.getDate("date")));
			}
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Notice> selectNoticeAll(){
		try(PreparedStatement stmt = con.prepareStatement("select * from notice order by idx desc");){
			List<Notice> result = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				result.add(new Notice(rs.getInt("idx"), rs.getString("title"),rs.getString("contents"),rs.getInt("hits"),rs.getString("writer"),rs.getDate("date")));
			}
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int updateHits(Notice board) {
		try(PreparedStatement stmt = con.prepareStatement("update notice set hits = ? where idx=?");){
			stmt.setInt(1, board.getHits());
			stmt.setInt(2, board.getIdx());
			
			return stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
