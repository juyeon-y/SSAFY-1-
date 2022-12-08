package com.ssafy.home.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.map.dto.House;

@Mapper
public interface MapMapper {

	List<String> selectSido();

	List<String> selectGugun(String sidoName);

	List<String> selectDong(String gugunName);

	String selectDongCode(String sidoName, String gugunName, String dongName);

	List<House> selectHouse(String dongCode, String year, String month);

}
