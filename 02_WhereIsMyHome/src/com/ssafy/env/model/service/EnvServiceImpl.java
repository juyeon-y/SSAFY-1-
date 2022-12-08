package com.ssafy.env.model.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ssafy.env.model.dao.EnvPollutDAO;
import com.ssafy.env.model.dao.EnvPollutDAOImpl;
import com.ssafy.env.model.dto.EnvPollut;
import com.ssafy.rent.model.dao.ComDaoImpl;
import com.ssafy.rent.model.dao.HomeDao;
import com.ssafy.rent.model.dao.HomeDaoImpl;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomeInfo;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.util.HomeSaxParser;

public class EnvServiceImpl implements EnvService{
	private EnvPollutDAO dao;

	public EnvServiceImpl() {
		 dao = new EnvPollutDAOImpl();
	}
	
	@Override
	public EnvPollut search(int no) {

		return dao.search(no);
	}

	@Override
	public List<EnvPollut> searchAll() {
		return dao.searchAll();
	}
}
