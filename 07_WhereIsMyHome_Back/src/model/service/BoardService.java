package model.service;

import java.util.List;

import dto.Notice;
import model.dao.BoardDao;

public class BoardService {

	private static BoardService instance;
	BoardDao boardDao;
	
	private BoardService() {
		boardDao = BoardDao.getInstance();
	}
	public static BoardService getInstance() {
		if(instance==null)
			instance = new BoardService();
		return instance;
	}
	
	public boolean registNotice(Notice board) {
		if(boardDao.registNotice(board)==1)
			return true;
		else
			return false;
	}
	
	public boolean updateNotice(Notice board) {
		if(boardDao.updateNotice(board)==1)
			return true;
		else
			return false;
	}
	
	public Notice selectNoticeByIdx(int idx){
		return boardDao.selectNoticeByIdx(idx);
	}
	
	public List<Notice> selectNoticeByTitle(String search){
		return boardDao.selectNoticeByTitle(search);
	}
	
	public List<Notice> selectNoticeAll(){
		return boardDao.selectNoticeAll();
	}
	
	public boolean updateHits(Notice board) {
		if(boardDao.updateHits(board)==1)
			return true;
		else
			return false;
	}
	public boolean deleteNotice(int index) {
		if(boardDao.deleteNotice(index)==1) {
			return true;
		}else
			return false;
	}
}
