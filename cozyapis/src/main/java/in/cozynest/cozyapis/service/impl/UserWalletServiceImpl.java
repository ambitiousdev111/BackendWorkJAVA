package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.IUserWalletDao;
import in.cozynest.cozyapis.dao.impl.UserWalletDaoImpl;
import in.cozynest.cozyapis.model.UserWallet;
import in.cozynest.cozyapis.service.IUserWalletService;

public class UserWalletServiceImpl implements IUserWalletService {

	IUserWalletDao userWalletDao = new UserWalletDaoImpl();

	public boolean exists(int pk) {
		return userWalletDao.exists(pk);
	}

	public long count() {
		return userWalletDao.count();
	}

	public UserWallet create(UserWallet userWallet) {
		return userWalletDao.create(userWallet);
	}

	public UserWallet update(UserWallet userWallet) {
		return userWalletDao.update(userWallet);
	}

	public void delete(UserWallet userWallet) {
		userWalletDao.delete(userWallet);
	}

	public ArrayList<UserWallet> findAll() {
		return userWalletDao.findAll();
	}

	public UserWallet findById(int id) {
		return userWalletDao.findById(id);
	}

	@Override
	public Double findAmountByUserId(int userId) {
		return userWalletDao.findAmountByUserId(userId);

	}

	public UserWallet findByUserId(int userId) {
		return userWalletDao.findByUserId(userId);
	}

	@Override
	public UserWallet addAmountToWallet(int userPrimaryKey, Double amount) {
		// will recieve checked value of amount i.e. it must not be -ve value
		UserWallet updatedUserWallet = userWalletDao.addAmountToWallet(userPrimaryKey, amount);
		return updatedUserWallet;
	}

	@Override
	public UserWallet deductAmountFromWallet(int userPrimaryKey, Double amount) {
		UserWallet updatedUserWallet = userWalletDao.deductAmountFromWallet(userPrimaryKey, amount);
		// transaction table me
		return updatedUserWallet;
	}

	@Override
	public UserWallet findByGeneratedUserId(String userId) {
		UserWallet userWallet = userWalletDao.findByGeneratedUserId(userId);
		return userWallet;
	}

	@Override
	public UserWallet findByPhone(String phone) {
		UserWallet userWallet = userWalletDao.findByPhone(phone);
		return userWallet;
	}
	
	
}