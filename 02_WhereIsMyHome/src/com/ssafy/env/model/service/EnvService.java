package com.ssafy.env.model.service;

import java.util.List;

import com.ssafy.env.model.dto.EnvPollut;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;

public interface EnvService {
	public List<EnvPollut> searchAll();
	public EnvPollut search(int no);
	
	
}
