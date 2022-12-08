package com.ssafy.rent.model.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ssafy.rent.model.dto.ComDeal;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.util.CSVReader;

public class ComDaoImpl implements ComDao {

	private List<List<String>> csvList;
	private int size;
	private List<ComDeal> search;

	public ComDaoImpl() {
		loadData();
	}

	public ComDaoImpl(String dong) {
		loadData(dong);
	}

	public void loadData(String dong) {
		CSVReader csvReader = new CSVReader();
		csvList = csvReader.readCSV();
		search = new ArrayList<ComDeal>();
		int j=1;
		for (int i = 1; i < csvList.size(); i++) {
			if (csvList.get(i).get(18).replace("\"", "").equals(dong)) {
				ComDeal tmp = new ComDeal();
				tmp.setAddr(csvList.get(i).get(26));
				tmp.setComName(csvList.get(i).get(1));
				tmp.setDong(csvList.get(i).get(18));
				tmp.setFloor(csvList.get(i).get(35));
				tmp.setGu(csvList.get(i).get(14));
				tmp.setMidKind(csvList.get(i).get(6));
				tmp.setSmallKind(csvList.get(i).get(8));
				tmp.setNo(j++);
				search.add(tmp);
			}
		}
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		CSVReader csvReader = new CSVReader();
		csvList = csvReader.readCSV();
		search = new ArrayList<ComDeal>();
		for (int i = 1; i < csvList.size(); i++) {
			ComDeal tmp = new ComDeal();
			tmp.setAddr(csvList.get(i).get(26));
			tmp.setComName(csvList.get(i).get(1));
			tmp.setDong(csvList.get(i).get(16));
			tmp.setFloor(csvList.get(i).get(35));
			tmp.setGu(csvList.get(i).get(14));
			tmp.setMidKind(csvList.get(i).get(6));
			tmp.setSmallKind(csvList.get(i).get(8));
			tmp.setNo(i - 1);
			search.add(tmp);
		}
	}

	@Override
	public List<ComDeal> searchAll() {

		return search;
	}

	@Override
	public ComDeal search(int no) {
		// TODO Auto-generated method stub
		for (ComDeal a : search) {
			if (a.getNo() == no) {
				return a;
			}
		}
		return null;
	}

}
