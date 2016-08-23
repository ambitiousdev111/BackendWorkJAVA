package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IUserPasswordDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.UserPassword;

public class UserPasswordDaoImpl extends GenericDaoImpl<UserPassword> implements IUserPasswordDao {
	Session session;

	public UserPasswordDaoImpl() {
		super(UserPassword.class);
	}

	@Override
	public boolean exists(int pk) {
		return super.exists(pk);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public UserPassword create(UserPassword userPassword) {
		return super.create(userPassword);
	}

	@Override
	public UserPassword update(UserPassword userPassword) {
		return super.update(userPassword);
	}

	@Override
	public void delete(UserPassword userPassword) {
		super.delete(userPassword);
	}

	@Override
	public ArrayList<UserPassword> findAll() {
		return super.findAll();
	}

	@Override
	public UserPassword findById(int id) {
		return super.findById(id);
	}

	@Override
	public UserPassword findByPhone(String phone) {
		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByPhone").setString("phone", phone)
					.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserPasswordDaoImpl [ArrayList<UserPassword> findByPhone(int phone)] :" + he);
			he.printStackTrace();
			throw new InternalServerErrorException("Unable to find User by Phone due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("ArrayList<UserPasswordDaoImpl> findByPhone(int phone)] :" + e);
			throw new InternalServerErrorException("Unable to find User by Phone due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return userPassword;
	}

	@Override
	public UserPassword findByEmail(String email) {
		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByEmail").setString("email", email)
					.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserPasswordDaoImpl [ArrayList<UserPassword> findByEmail(String email)] :" + he);
			throw new InternalServerErrorException("Unable to find User by email due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("ArrayList<UserPasswordDaoImpl> findByEmail(String email)] :" + e);
			throw new InternalServerErrorException("Unable to find User by email due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return userPassword;
	}

	@Override
	public UserPassword findByUserId(int userId) {

		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByUserId")
					.setInteger("userId", userId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserPasswordDaoImpl [ArrayList<UserPassword> findByUserId(int userId)] :" + he);
			throw new InternalServerErrorException("Unable to find User by userId due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("ArrayList<UserPasswordDaoImpl> findByUserId(int userId)] :" + e);
			throw new InternalServerErrorException("Unable to find User by useId due to unknown exception.");

		} finally {
			if (session != null)
				session.close();
		}

		return userPassword;
	}

	@Override
	public UserPassword findByPhoneAndPassword(String phone, String password) {
		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByPhoneAndPassword")
					.setString("phone", phone).uniqueResult();
			session.getTransaction().commit();
			if (userPassword != null)
				if (!userPassword.getPassword().equals(password))
					userPassword = null;
		} catch (HibernateException he) {
			System.out.println(
					"UserPasswordDaoImpl [UserPassword findByPhoneAndPassword(String phone, String password)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find User by phone and password due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserPasswordDaoImpl findByPhoneAndPassword(String phone, String password)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find User by phone and password due to unknown exception.");

		} finally {
			if (session != null)
				session.close();
		}

		return userPassword;
	}

	@Override
	public UserPassword findByEmailAndPassword(String email, String password) {
		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByEmailAndPassword")
					.setString("email", email).uniqueResult();
			session.getTransaction().commit();
			if (userPassword != null)
				if (!userPassword.getPassword().equals(password))
					userPassword = null;
		} catch (HibernateException he) {
			System.out.println(
					"UserPasswordDaoImpl [UserPassword findByEmailAndPassword(String email, String password)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find User by email and password due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserPasswordDaoImpl [findByEmailAndPassword(String email, String password)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find User by email and password due to unknown exception.");

		} finally {
			if (session != null)
				session.close();
		}

		return userPassword;
	}

	@Override
	public UserPassword findByGeneratedUserIdAndPassword(String generatedUserId, String password) {
		UserPassword userPassword = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userPassword = (UserPassword) session.getNamedQuery("UserPassword.findByGeneratedUserIdAndPassword")
					.setString("generatedUserId", generatedUserId).uniqueResult();
			session.getTransaction().commit();
			if (userPassword != null)
				if (!userPassword.getPassword().equals(password))
					userPassword = null;
		} catch (HibernateException he) {
			System.out.println(
					"UserPasswordDaoImpl [UserPassword findByGeneratedUserIdAndPassword(String generatedUserId, String password)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find User by generatedUserId and password due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"UserPassword findByGeneratedUserIdAndPassword(String generatedUserId, String password)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find User by generatedUserId and password due to unknown exception.");

		} finally {
			if (session != null)
				session.close();
		}

		return userPassword;
	}
}