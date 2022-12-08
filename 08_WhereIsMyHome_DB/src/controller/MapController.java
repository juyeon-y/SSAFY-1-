package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.House;
import model.service.MapService;

@WebServlet("/map")
public class MapController extends HttpServlet {
	
	MapService mapService;

	public void init(ServletConfig config) throws ServletException {
		mapService = MapService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sign = request.getParameter("sign");
		RequestDispatcher disp = null;
		if(sign!=null) {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JsonObject reJson = new JsonObject();
			if("sido".equals(sign)) {
				List<String> sidos=null;
				try {
					sidos = mapService.getSido();
					JsonArray sidoArray = new JsonArray();
					for(String sido : sidos) {
						JsonObject sidoInfo = new JsonObject();
						sidoInfo.addProperty("sidoName", sido);
						sidoArray.add(sidoInfo);
					}
					reJson.add("sidoList", sidoArray);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if("gugun".equals(sign)) {
				List<String> guguns=null;
				String sidoName = request.getParameter("sido");
				try {
					guguns = mapService.getGugun(sidoName);
					JsonArray gugunArray = new JsonArray();
					for(String gugun : guguns) {
						JsonObject gugunInfo = new JsonObject();
						gugunInfo.addProperty("gugunName", gugun);
						gugunArray.add(gugunInfo);
					}
					reJson.add("gugunList", gugunArray);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if("dong".equals(sign)) {
				List<String> dongs=null;
				String gugunName = request.getParameter("gugun");
				try {
					dongs = mapService.getDong(gugunName);
					JsonArray dongArray = new JsonArray();
					for(String dong : dongs) {
						JsonObject dongInfo = new JsonObject();
						dongInfo.addProperty("dongName", dong);
						dongArray.add(dongInfo);
					}
					reJson.add("dongList", dongArray);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if("apt".equals(sign)) {
				String dongCode=null;
				List<House> houses = null;
				String sidoName = request.getParameter("sido");
				String gugunName = request.getParameter("gugun");
				String dongName = request.getParameter("dong");
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				try {
					dongCode = mapService.getDongCode(sidoName, gugunName, dongName);
					houses = mapService.getHouse(dongCode, year, month);
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
					}
					reJson.add("houseList", houseArray);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				reJson.addProperty("msg", "error");
			}
			out.append(reJson.toString());
			
		}else { //action이 null일 때
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
