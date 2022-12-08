package model.service;

import java.util.List;

import dto.Business;
import dto.Clinic;
import dto.Environment;
import dto.Hospital;
import model.dao.InterestDao;

public class InterestService {
	private static InterestService instance;
	InterestDao interestDao;
	
	private InterestService() {
		interestDao = InterestDao.getInstance();
	}
	
	public static InterestService getInstance() {
		if (instance == null) instance = new InterestService();
		return instance;
	}

	public List<Environment> getEnvInspInfo(String email) {
		return interestDao.getEnvInspInfo(email);
	}

	public List<Business> getBizInfo(String email) {
		return interestDao.getBizInfo(email);
	}

	public List<Hospital> getHospitalInfo(String email) {
		return interestDao.getHospitalInfo(email);
	}

	public List<Clinic> getClinicInfo(String email) {
		return interestDao.getClinicInfo(email);
	}
}
