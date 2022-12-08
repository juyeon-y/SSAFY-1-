package member.service;

import java.util.UUID;

import common.utils.OpenCrypt;
import member.dao.MemberDao;
import member.dto.Member;
import member.dto.SecVO;

public class MemberService {
	MemberDao memberDao;
	private static MemberService instance;
	private MemberService() {
		memberDao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		if(instance== null) instance = new MemberService();
		return instance;
	}
	public Member login(String id, String pw) {
		SecVO sec = memberDao.selectSecurity(id);
		if(sec != null) {
			pw = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(pw, sec.getSalt()));
			Member m = memberDao.login(id, pw);
			if (m != null) {
				try {
					m.setName(OpenCrypt.aesDecrypt(m.getName(), OpenCrypt.hexToByteArray(sec.getSecKey())));
					return m;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public int memberInsert(Member member) {
		if ( memberDao.memberSelect(member.getId()) != null ) {
			return -1; //중복인 아이디 존재
		} else {
			try {
			   byte[] key=OpenCrypt.generateKey("AES",128);
			   System.out.println("key length:"+key.length);
			   SecVO sec=new SecVO(member.getId(),UUID.randomUUID().toString(),OpenCrypt.byteArrayToHex(key));
			   int cnt = memberDao.securityInsert(sec);
			   if(cnt<=0) return -1; //security 테이블 insert 실패
			   member.setName(OpenCrypt.aesEncrypt(member.getName(), key));
			   member.setPw(OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(member.getPw(), sec.getSalt())));
			   return memberDao.memberInsert(member); //회원가입 성공
			} catch(Exception e ){
			  e.printStackTrace();
				   return -1; //sql 에러났을 때
			}
		}
	}
	
	public int idCheck(String id) {
		return memberDao.idCheck(id);
	}
}

