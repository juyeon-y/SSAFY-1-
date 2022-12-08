package com.ssafy.home.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.map.dto.House;
import com.ssafy.home.map.mapper.MapMapper;


@Service
public class MapService {

	@Autowired
	MapMapper mapMapper;

	public List<String> selectSido() {
		return mapMapper.selectSido();
	}

	public List<String> selectGugun(String sidoName) {
		return mapMapper.selectGugun(sidoName);
	}

	public List<String> selectDong(String gugunName) {
		return mapMapper.selectDong(gugunName);
	}

	public String selectDongCode(String sidoName, String gugunName, String dongName) {
		return mapMapper.selectDongCode(sidoName, gugunName, dongName);
	}

	public List<House> selectHouse(String dongCode, String year, String month) {
		return mapMapper.selectHouse(dongCode, year, month);
	}

	
	
	
	
}
