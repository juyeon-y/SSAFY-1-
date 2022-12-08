package com.ssafy.home.map.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ssafy.home.map.dto.House;
import com.ssafy.home.map.service.MapService;

@Controller
@RequestMapping("/map")
public class MapController {

	@Autowired MapService mapService;

	@GetMapping("/sido")
	@ResponseBody
	public String selectSido(HttpServletRequest request) {
		List<String> sidos=null;
		sidos = mapService.selectSido();
		JsonArray sidoArray = new JsonArray();
		for(String sido : sidos) {
			JsonObject sidoInfo = new JsonObject();
			sidoInfo.addProperty("sidoName", sido);
			sidoArray.add(sidoInfo);
		}
		return sidoArray.toString();
	}
	
	@PostMapping("/gugun")
	@ResponseBody
	public String selectGugun(@RequestParam Map<String, String> map) {
		List<String> guguns=null;
		String sidoName = map.get("sido");
		guguns = mapService.selectGugun(sidoName);
		JsonArray gugunArray = new JsonArray();
		for(String gugun : guguns) {
			JsonObject gugunInfo = new JsonObject();
			gugunInfo.addProperty("gugunName", gugun);
			gugunArray.add(gugunInfo);
		}
		return gugunArray.toString();
	}
	
	@PostMapping("/dong")
	@ResponseBody
	public String selectDong(@RequestParam Map<String, String> map) {
		List<String> dongs=null;
		String gugunName = map.get("gugun");
		dongs = mapService.selectDong(gugunName);
		JsonArray dongArray = new JsonArray();
		for(String dong : dongs) {
			JsonObject dongInfo = new JsonObject();
			dongInfo.addProperty("dongName", dong);
			dongArray.add(dongInfo);
		}
		return dongArray.toString();
	}
	
	@GetMapping("/apt")
	@ResponseBody
	public String selectHouse(HttpServletRequest request) {
		String dongCode=null;
		List<House> houses = null;
		String sidoName = request.getParameter("sido");
		String gugunName = request.getParameter("gugun");
		String dongName = request.getParameter("dong");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		dongCode = mapService.selectDongCode(sidoName, gugunName, dongName);
		System.out.println(dongCode);
		houses = mapService.selectHouse(dongCode, year, month);
		JsonArray houseArray = new JsonArray();
		for(House house : houses) {
			JsonObject houseInfo = new JsonObject();
			houseInfo.addProperty("apartmentName", house.getApartmentName());
			houseInfo.addProperty("floor", house.getFloor());
			houseInfo.addProperty("area", house.getArea());
			houseInfo.addProperty("dong", house.getDong());
			houseInfo.addProperty("dealAmount", house.getDealAmount());
			houseInfo.addProperty("roadName", house.getRoadName());
			houseInfo.addProperty("roadNameBonBun", house.getRoadNameBonBun());
			houseArray.add(houseInfo);
			System.out.println(houseInfo);
		}
		return houseArray.toString();
	}
	
}
