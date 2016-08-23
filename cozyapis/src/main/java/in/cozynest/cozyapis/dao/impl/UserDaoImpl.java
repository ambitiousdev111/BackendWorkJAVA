package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IUserDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {

	Session session;

	public UserDaoImpl() {
		super(User.class);
	}

	public long count() {
		return super.count();
	}

	public User create(User user) {
		return super.create(user);
	}

	public User update(User user) {
		return super.update(user);
	}

	public void delete(User user) {
		super.delete(user);
	}

	public ArrayList<User> findAll() {
		return super.findAll();
	}

	public User findById(int id) {
		return super.findById(id);
	}

	public User findByPhone(String phone) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByPhone").setString("phone", phone).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserDaoImpl [public User findByPhone(String phone)] :" + he);
			throw new InternalServerErrorException("Unable to find user by phone number due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserDaoImpl [public User findByPhone(String phone)] :" + e);
			throw new InternalServerErrorException("Unable to find user by phone number due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public User findByGeneratedUserId(String userId) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByUserId").setString("userId", userId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserDaoImpl [public User getUserByUserId(int userId)] :" + he);
			throw new InternalServerErrorException("Unable to get user by CUSTOMER Id due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserDaoImpl [public User getUserByUserId(int userId)] :" + e);
			throw new InternalServerErrorException("Unable to get user by CUSTOMER Id due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public User findByGeneratedUserIdOrPhone(String userId, String phone) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByUserIdOrPhone").setString("userId", userId)
					.setString("phone", phone).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + he);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + e);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	public User findByPhoneAndWithoutCurrentPK(String phone, int pk) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByPhoneAndWithoutCurrentPK").setString("phone", phone)
					.setInteger("id", pk).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + he);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + e);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	public User findByGeneratedUserIdAndWithoutCurrentPK(String generatedUserId, int pk) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByGeneratedUserIdAndWithoutCurrentPK")
					.setString("generatedUserId", generatedUserId).setInteger("id", pk).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + he);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("public User getUserByUserIdOrPhone(String userId,String phone)] :" + e);
			throw new InternalServerErrorException(
					"Unable to get user by CUSTOMER Id or PHONE due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}



	public User findByEmail(String email) {
		User user = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			user = (User) session.getNamedQuery("User.findByEmail").setString("email", email).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserDaoImpl [public User findByEmail(String email)] :" + he);
			throw new InternalServerErrorException("Unable to find user by email due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("UserDaoImpl [public User findByEmail(String email)] :" + e);
			throw new InternalServerErrorException("Unable to find user by email due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}
}
