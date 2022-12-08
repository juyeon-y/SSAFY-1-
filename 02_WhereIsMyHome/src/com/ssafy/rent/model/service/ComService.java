package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dto.ComDeal;

public interface ComService {
	
	public List<ComDeal> searchAll();
	
	public ComDeal search(int no);

}
