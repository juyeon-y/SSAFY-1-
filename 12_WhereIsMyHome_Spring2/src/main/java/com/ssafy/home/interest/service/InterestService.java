package com.ssafy.home.interest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.interest.dto.Business;
import com.ssafy.home.interest.dto.Environment;
import com.ssafy.home.interest.mapper.InterestMapper;

@Service
public class InterestService {
	
	@Autowired
	InterestMapper interestMapper;

	public List<Environment> selectEnvInspInfo(String loginEmail) {
		return interestMapper.selectEnvInspInfo(loginEmail);
	}

	public List<Business> selectBizInfo(String loginEmail) {
		return interestMapper.selectBizInfo(loginEmail);
	}

	public List<Business> selectHospitalInfo(String email) {
		return interestMapper.selectHospitalInfo(email);
	}

	public List<Business> selectClinicInfo(String email) {
		String gugunName = interestMapper.selectGugunName(email);
		return interestMapper.selectClinicInfo(gugunName);
	}
	
	

}
