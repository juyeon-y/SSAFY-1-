package model.service;

import dto.Member;
import model.dao.MemberDao;

public class MemberService {

	private static MemberService instance;
	MemberDao memberDao;
	
	private MemberService() {
		memberDao = MemberDao.getInstance();
	}
	
	public static MemberService getInstance() {
		if (instance == null) instance = new MemberService();
		return instance;
	}

	public int regist(Member member) {
		return memberDao.regist(member);
	}
	
	public Member login(String id, String pw) {
		return memberDao.login(id, pw);
	}
	
	public int update(Member member) {
		return memberDao.update(member);
	}
	
	public void delete(String id) {
		memberDao.delete(id);
	}

	public Member get(String id) {
		return memberDao.get(id);
	}

	public boolean checkId(String id) {
		return memberDao.checkId(id);
	}
}
