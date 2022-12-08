package com.ssafy.rent.model.service;

import java.io.DataOutput;
import java.util.List;

import com.ssafy.rent.model.dao.ComDaoImpl;
import com.ssafy.rent.model.dto.ComDeal;

public class ComServiceImpl implements ComService{
	
	private ComDaoImpl dao;

	public ComServiceImpl() {
		dao=new ComDaoImpl();
	}

	public ComServiceImpl(String dong) {
		// TODO Auto-generated constructor stub
		dao=new ComDaoImpl(dong);
	}

	@Override
	public List<ComDeal> searchAll() {
		// TODO Auto-generated method stub
		return dao.searchAll();
	}

	@Override
	public ComDeal search(int no) {
		// TODO Auto-generated method stub
		return dao.search(no);
	}

}
