package com.ssafy.home.member.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.member.dto.InterestCity;
import com.ssafy.home.member.dto.Member;

@Mapper
public interface MemberMapper {
	Member login(Member member);
	int checkEmail(String email);
	int joinMember(Member member);

	String selectDongCode(InterestCity interestCity);
	int insertInterestCity(Map map);

	int updateInterestCity(HashMap<String, String> map);

	int updateMember(Member member);

	Member selectOne(String email);

	InterestCity selectInterestCity(String email);
}