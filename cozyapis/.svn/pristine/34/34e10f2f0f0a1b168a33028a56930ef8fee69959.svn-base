package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.IUserPasswordDao;
import in.cozynest.cozyapis.dao.impl.UserPasswordDaoImpl;
import in.cozynest.cozyapis.model.UserPassword;
import in.cozynest.cozyapis.service.IUserPasswordService;

public class UserPasswordServiceImpl implements IUserPasswordService {
	
	
	
	IUserPasswordDao userPasswordDao=new UserPasswordDaoImpl();

	@Override
	public boolean exists(int pk) {
		// TODO Auto-generated method stub
		return userPasswordDao.exists(pk);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return userPasswordDao.count();
	}

	@Override
	public UserPassword create(UserPassword userPassword) {
		// TODO Auto-generated method stub
		return userPasswordDao.create(userPassword);
	}

	@Override
	public UserPassword update(UserPassword userPassword) {
		// TODO Auto-generated method stub
		return userPasswordDao.update(userPassword);
	}

	@Override
	public void delete(UserPassword userPassword) {
		// TODO Auto-generated method stub
           userPasswordDao.delete(userPassword);
	}

	@Override
	public ArrayList<UserPassword> findAll() {
		// TODO Auto-generated method stub
		return userPasswordDao.findAll();
	}

	@Override
	public UserPassword findById(int id) {
		// TODO Auto-generated method stub
		return userPasswordDao.findById(id);
	}

	@Override
	public UserPassword findByPhone(String phone) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByPhone(phone);
	}

	@Override
	public UserPassword findByEmail(String email) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByEmail(email);
	}

	@Override
	public  UserPassword findByUserId(int userId) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByUserId(userId);
	}

	@Override
	public UserPassword findByPhoneAndPassword(String phone, String password) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByPhoneAndPassword(phone, password);
	}

	@Override
	public UserPassword findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByEmailAndPassword(email, password);
	}

	@Override
	public UserPassword findByGeneratedUserIdAndPassword(String generatedUserId, String password) {
		// TODO Auto-generated method stub
		return userPasswordDao.findByGeneratedUserIdAndPassword(generatedUserId, password);
	}

}
