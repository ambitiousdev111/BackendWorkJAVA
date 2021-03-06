package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IUserWalletDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.model.UserWallet;

public class UserWalletDaoImpl extends GenericDaoImpl<UserWallet>implements IUserWalletDao {
	Session session = null;

	public UserWalletDaoImpl() {
		super(UserWallet.class);
	}

	public boolean exists(int pk) {
		return super.exists(pk);
	}

	public long count() {
		return super.count();
	}

	public UserWallet create(UserWallet userWallet) {
		if (isExistingUserWallet(userWallet.getUser()))
			throw new InternalServerErrorException("Unable to add z : error while creating wallet");
		return super.create(userWallet);
	}

	public UserWallet update(UserWallet userWallet) {
		return super.update(userWallet);
	}

	public void delete(UserWallet userWallet) {
		super.delete(userWallet);
	}

	public ArrayList<UserWallet> findAll() {
		return super.findAll();
	}

	public UserWallet findById(int id) {
		return super.findById(id);
	}

	@Override
	public Double findAmountByUserId(int userId) {

		Double walletAmount = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			walletAmount = (Double) session.getNamedQuery("UserWallet.findAmountByUserId")
					.setInteger("userId", userId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"UserWalletDaoImpl [public Double getUserAmountByUserId(int userId)]:" + he);
			throw new InternalServerErrorException(
					"Unable to find wallet amount by userId due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"UserWalletDaoImpl [public Double getUserAmountByUserId(int userId)]::" + e);
			throw new InternalServerErrorException(
					"Unable to find wallet amount by userId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return walletAmount;
	}

	public Boolean isExistingUserWallet(User user) {
		UserWallet existingUserWallet = findByUserId(user.getId());
		if (existingUserWallet == null)
			return false;
		else
			return true;
	}

	public UserWallet findByUserId(int userId) {
		UserWallet userWallet = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userWallet = (UserWallet) session.getNamedQuery("UserWallet.findByUserId")
					.setInteger("userId", userId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + he);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + e);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return userWallet;

	}

	@Override
	public UserWallet addAmountToWallet(int userId, Double amount) {
		UserWallet userWallet = findByUserId(userId);
		if(userWallet == null)
			throw new NotFoundException("Wallet not found of this user");
		Double newAmount = (userWallet.getAmount()) + amount;
		userWallet.setAmount(newAmount);
		userWallet = update(userWallet);
		return userWallet;
	}

	@Override
	public UserWallet deductAmountFromWallet(int userId, Double amount) {
		UserWallet userWallet = findByUserId(userId);
		if(userWallet == null)
			throw new NotFoundException("Wallet not found of this user");
		Double newAmount = (userWallet.getAmount()) - amount;
		userWallet.setAmount(newAmount);
		update(userWallet);
		return userWallet;
	}

	@Override
	public UserWallet findByGeneratedUserId(String userId) {
		UserWallet userWallet = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userWallet = (UserWallet) session.getNamedQuery("UserWallet.findByGeneratedUserId")
					.setString("generatedUserId", userId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + he);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + e);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return userWallet;
	}

	@Override
	public UserWallet findByPhone(String phone) {
		UserWallet userWallet = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userWallet = (UserWallet) session.getNamedQuery("UserWallet.findByPhone")
					.setString("phone", phone).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + he);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserWalletDaoImpl [public UserWallet findByUserId(int id)] :" + e);
			throw new InternalServerErrorException("Unable to find WALLET AMOUNT BY ID due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return userWallet;
	}
}