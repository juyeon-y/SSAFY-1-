package com.ssafy.rent.model.dao;

import java.util.List;

import com.ssafy.rent.model.dto.ComDeal;

public interface ComDao {
	
	public void loadData();
	
	public List<ComDeal> searchAll();
	
	public ComDeal search(int no);

}
