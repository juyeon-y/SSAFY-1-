package model.service;


import dto.InterestCity;
import dto.User;
import model.dao.InterestDao;
import model.dao.UserDao;

public class UserService {

	private static UserService instance;
	UserDao userDao;
	
	private UserService() {
		userDao = UserDao.getInstance();
	}
	
	public static UserService getInstance() {
		if (instance == null) instance = new UserService();
		return instance;
	}

	public boolean regist(InterestCity interestCity, User user) {
		return userDao.regist(user) > 0 && userDao.registInterestCity(interestCity) > 0;
	}
	
	public User login(String email, String pw) {
		return userDao.login(email, pw);
	}
	
	public boolean update(InterestCity interestCity, User user) {
		return userDao.registInterestCity(interestCity) > 0 &&userDao.update(user) > 0;
	}
	
	public void delete(String email) {
		userDao.delete(email);
	}

	public User get(String email) {
		return userDao.get(email);
	}

	public boolean checkEmail(String email) {
		return userDao.checkEmail(email);
	}

	public String getInterestCity(String email) {
		return userDao.getInterestCity(email);
	}
}
