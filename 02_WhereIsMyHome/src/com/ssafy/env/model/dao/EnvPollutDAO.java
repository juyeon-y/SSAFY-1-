package com.ssafy.env.model.dao;

import java.util.List;

import com.ssafy.env.model.dto.EnvPollut;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;

public interface EnvPollutDAO {
	public void loadData();
	public List<EnvPollut> searchAll();
	public EnvPollut search(int no);
}