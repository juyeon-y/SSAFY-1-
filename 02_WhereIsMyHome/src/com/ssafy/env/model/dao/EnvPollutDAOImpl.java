package com.ssafy.env.model.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ssafy.env.model.dto.EnvPollut;
import com.ssafy.env.util.CSVReader;
import com.ssafy.rent.model.dto.ComDeal;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomeInfo;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.util.HomeSaxParser;

public class EnvPollutDAOImpl implements EnvPollutDAO{

	private List<List<String>> csvList;
	private int size;
	private List<EnvPollut> search;
	
	public EnvPollutDAOImpl() {
		loadData();
	}
	
	/**
	 * 아파트 정보와 아파트 거래 정보를  xml 파일에서 읽어온다.
	 */
	public void loadData() {
		CSVReader csvReader = new CSVReader();
		csvList = csvReader.readCSV();
		search = new ArrayList<EnvPollut>();
		for (int i = 1; i < csvList.size(); i++) {
			EnvPollut tmp = new EnvPollut();
			tmp.setNo(i-1);
			//System.out.println(csvList.get(i));
			tmp.setCompanyName(csvList.get(i).get(0));
			tmp.setLicenseNo(csvList.get(i).get(1));
			tmp.setBizCode(csvList.get(i).get(2));
			tmp.setBizName(csvList.get(i).get(3));
			tmp.setInspDate(csvList.get(i).get(4));
			tmp.setInspAgencyNo(csvList.get(i).get(5));
			tmp.setInspAgencyName(csvList.get(i).get(6));
			tmp.setInspCategory(csvList.get(i).get(7));
			tmp.setForDisposal(csvList.get(i).get(8));
			tmp.setInspDesc(csvList.get(i).get(9));
			tmp.setInspRes(csvList.get(i).get(10));
			tmp.setRoadNameAdd(csvList.get(i).get(11));
			tmp.setAddress(csvList.get(i).get(12));
			
			
			search.add(tmp);
			/*
			tmp.setAddr(csvList.get(i).get(26));
			tmp.setComName(csvList.get(i).get(1));
			tmp.setDong(csvList.get(i).get(16));
			tmp.setFloor(csvList.get(i).get(35));
			tmp.setGu(csvList.get(i).get(14));
			tmp.setMidKind(csvList.get(i).get(6));
			tmp.setSmallKind(csvList.get(i).get(8));
			tmp.setNo(i - 1);
			search.add(tmp);*/
		}
	}
	
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환한다.<br/>
	 * 법정동+아파트명을 이용하여 HomeInfo에서 건축연도, 법정코드, 지번, 이미지 정보를 찾아서 HomeDeal에 setting한 정보를 반환한다. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public EnvPollut search(int no) {
		// complete code #03
		// List<HomeDeal> search 로부터 no 에 해당하는 HomeDeal 정보를 검색하여 return 하도록 코드를 작성하세요.
		// 해당하는 no 가 없을 경우 null 을 리턴하세요.
		for(EnvPollut p:search) {
			if(p.getNo()==no) {
				return p;
			}
		}
		return null;
	}
	
	public static void print(List<EnvPollut> polluts) {
		for (EnvPollut p : polluts) {
			System.out.println(p);
		}
	}

	@Override
	public List<EnvPollut> searchAll() {
		
		return search;
	}
}
