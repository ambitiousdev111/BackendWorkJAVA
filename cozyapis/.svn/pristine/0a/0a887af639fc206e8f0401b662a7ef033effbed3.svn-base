package in.cozynest.cozyapis.service;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.UserWallet;

public interface IUserWalletService {

	public boolean exists(int pk);

	public long count();

	public UserWallet create(UserWallet userWallet);

	public UserWallet update(UserWallet userWallet);

	public void delete(UserWallet userWallet);

	public ArrayList<UserWallet> findAll();

	public UserWallet findById(int id);

	public Double findAmountByUserId(int userId);

	public UserWallet findByUserId(int userId);

	public UserWallet addAmountToWallet(int userPrimaryKey, Double amount);

	public UserWallet deductAmountFromWallet(int userPrimaryKey, Double amount);

	public UserWallet findByGeneratedUserId(String userId);

	public UserWallet findByPhone(String phone);
}