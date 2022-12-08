package com.ssafy.home.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.member.dto.InterestCity;
import com.ssafy.home.member.dto.Member;
import com.ssafy.home.member.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;

	public Member login(Member m) throws Exception {
		return memberMapper.login(m);
	}

	public int checkEmail(String email) {
		return memberMapper.checkEmail(email);
	}

	public boolean regist(InterestCity interestCity, Member member) {
		String dongCode = memberMapper.selectDongCode(interestCity);
		Map<String,String> map = new HashMap<>();
		map.put("email", member.getEmail());
		map.put("dongCode", dongCode);
		return memberMapper.joinMember(member) > 0 && memberMapper.insertInterestCity(map) > 0;
	}

	public void update(InterestCity interestCity, Member member) {
		HashMap<String, String> map = new HashMap<>();
		String dongCode = memberMapper.selectDongCode(interestCity);
		System.out.println("dongCode = " + dongCode);
		System.out.println("interestCity = " + interestCity);
		System.out.println("member = " + member);
		map.put("email", member.getEmail());
		map.put("dongCode", dongCode);
		memberMapper.updateMember(member);
		memberMapper.updateInterestCity(map);

	}

	public Member selectOne(String email) {
		return memberMapper.selectOne(email);
	}

	public InterestCity selectInterestCity(String email) {
		return memberMapper.selectInterestCity(email);
	}
}