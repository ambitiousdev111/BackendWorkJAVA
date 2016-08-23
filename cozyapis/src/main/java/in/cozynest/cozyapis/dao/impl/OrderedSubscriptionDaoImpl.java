package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IOrderedSubscriptionDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.OrderedSubscription;
import in.cozynest.cozyapis.model.OrderedSubscription.OrderedSubscriptionStatus;

public class OrderedSubscriptionDaoImpl extends GenericDaoImpl<OrderedSubscription> implements IOrderedSubscriptionDao {

	Session session;
	
	public OrderedSubscriptionDaoImpl() {
		super(OrderedSubscription.class);
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
	public OrderedSubscription create(OrderedSubscription orderedSubscription) {
		return super.create(orderedSubscription);
	}

	@Override
	public OrderedSubscription update(OrderedSubscription orderedSubscription) {
		return super.update(orderedSubscription);
	}

	@Override
	public void delete(OrderedSubscription orderedSubscription) {
		super.delete(orderedSubscription);
	}

	@Override
	public ArrayList<OrderedSubscription> findAll() {
		return super.findAll();
	}

	@Override
	public OrderedSubscription findById(int id) {
		return super.findById(id);
	}
			
	@Override
	public ArrayList<OrderedSubscription> findByStartDate(String startDate) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByStartDate")
					.setString("startDate", startDate).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByStratDate(String startDate)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by startDate due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByStartDate(String startDate)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by startDate due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	@Override
	public ArrayList<OrderedSubscription> findByEndDate(String endDate) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByEndDate")
					.setString("endDate", endDate).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByEndDate(String endDate)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by endDate due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByEndDate(String endDate)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by endDate due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	

	@Override
	public ArrayList<OrderedSubscription> findByUserId(int userId) {
		ArrayList<OrderedSubscription> orderedSubscriptions = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByUserId")
					.setInteger("userId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByUserId(String userId)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by userId due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByUserId(String userId)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by userId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	@Override
	public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByGeneratedUserId")
					.setString("generatedUserId", generatedUserId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by generatedUserId due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by generatedUserId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	@Override
	public ArrayList<OrderedSubscription> findByPhone(String phone) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByPhone")
					.setString("phone", phone).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByPhone(String phone)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by phone due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByPhone(String phone)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by phone due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	@Override
	public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findUsersByEndDateAndEndShift")
					.setString("endDate", endDate).setString("endShift", endShift).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by endDate and endShift due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by endShift and endDate due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}

	@Override
	public ArrayList<OrderedSubscription> findByPlanType(String planType) {
		ArrayList<OrderedSubscription> orderedSubscriptions = new ArrayList<OrderedSubscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orderedSubscriptions = (ArrayList<OrderedSubscription>) session.getNamedQuery("OrderedSubscription.findByPlanType")
					.setString("planType", planType).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByPlanType(String planType)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find orderedSubscriptions by planType due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderedSubscriptionDaoImpl [public ArrayList<OrderedSubscription> findByPlanType(String planType)] :" + e);
			throw new InternalServerErrorException("Unable to find orderedSubscriptions by planType due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orderedSubscriptions;
	}
	@Override
	public OrderedSubscriptionStatus getStatusById(int id){
		OrderedSubscriptionStatus status=null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			status=(OrderedSubscriptionStatus)session.getNamedQuery("OrderedSubscription.getStatusById").setInteger("id",id).uniqueResult();
			}catch (HibernateException he) {
				System.out
				.println("OrderedSubscriptionDaoImpl [public OrderedSubscriptionStatus getStatusById(int id)] :" + he);
		throw new InternalServerErrorException(
				"Unable to find Status by id due to hibernate exception.");
	} catch (Exception e) {
		System.out
				.println("OrderedSubscriptionDaoImpl [public OrderedSubscriptionStatus getStatusById(int id)] :" + e);
		throw new InternalServerErrorException("Unable to find status by id due to unknown exception.");
	} finally {
		if (session != null)
			session.close();
	}
		return status;
	}
}