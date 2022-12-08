package model.service;

import java.sql.SQLException;
import java.util.List;

import dto.House;
import model.dao.MapDao;


public class MapService {
	
MapDao mapDao = MapDao.getInstance();
	
	private static MapService instance;
	
	private MapService() {}
	
	public static MapService getInstance() {
		if(instance == null) instance = new MapService();
		return instance;
	}

	public List<String> getSido() throws SQLException {
		return mapDao.getSido();
	}

	public List<String> getGugun(String sidoName) throws SQLException {
		return mapDao.getGugun(sidoName);
	}

	public List<String> getDong(String gugunName) throws SQLException {
		return mapDao.getDong(gugunName);
	}

	public String getDongCode(String sidoName, String gugunName, String dongName) throws SQLException {
		return mapDao.getDongCode(sidoName, gugunName, dongName);
	}

	public List<House> getHouse(String dongCode, String year, String month) throws SQLException {
		return mapDao.getHouse(dongCode, year, month);
	}

}
