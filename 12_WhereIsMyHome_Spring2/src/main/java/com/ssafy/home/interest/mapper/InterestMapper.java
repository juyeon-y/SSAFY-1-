package com.ssafy.home.interest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.interest.dto.Business;
import com.ssafy.home.interest.dto.Environment;

@Mapper
public interface InterestMapper {

	public List<Environment> selectEnvInspInfo(String loginEmail);

	public List<Business> selectBizInfo(String loginEmail);

	public List<Business> selectHospitalInfo(String loginEmail);

	public String selectGugunName(String loginEmail);
	
	public List<Business> selectClinicInfo(String gugunName);

}
