package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.ISubscriptionDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.Subscription;
import in.cozynest.cozyapis.model.User;

public class SubscriptionDaoImpl extends GenericDaoImpl<Subscription> implements ISubscriptionDao {

	Session session;

	public SubscriptionDaoImpl() {
		super(Subscription.class);
	}

	public long count() {
		return super.count();
	}

	public Subscription create(Subscription subscription) {
		return super.create(subscription);
	}

	public Subscription update(Subscription subscription) {
		return super.update(subscription);
	}

	public void delete(Subscription subscription) {
		super.delete(subscription);
	}

	public ArrayList<Subscription> findAll() {
		return super.findAll();
	}

	public Subscription findById(int id) {
		return super.findById(id);
	}

	@Override
	public ArrayList<Subscription> findByStatus(String status) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByStatus")
					.setString("status", status).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByStatus(String status)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by status due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByStatus(String status)] :" + e);
			throw new InternalServerErrorException("Unable to find Subscriptions by status due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByStartDate(String startDate) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByStartDate")
					.setString("startDate", startDate).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByStratDate(String startDate)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by startDate due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByStartDate(String startDate)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by startDate due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByEndDate(String endDate) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByEndDate")
					.setString("endDate", endDate).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByEndDate(String endDate)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by endDate due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByEndDate(String endDate)] :" + e);
			throw new InternalServerErrorException("Unable to find Subscriptions by endDate due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByUserId(int userId) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByUserId")
					.setInteger("userId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByUserId(String userId)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by userId due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByUserId(String userId)] :" + e);
			throw new InternalServerErrorException("Unable to find Subscriptions by userId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByGeneratedUserId(String generatedUserId) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByGeneratedUserId")
					.setString("generatedUserId", generatedUserId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByGeneratedUserId(String generatedUserId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by generatedUserId due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByGeneratedUserId(String generatedUserId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by generatedUserId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByPhone(String phone) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByPhone")
					.setString("phone", phone).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByPhone(String phone)] :" + he);
			throw new InternalServerErrorException("Unable to find Subscriptions by phone due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByPhone(String phone)] :" + e);
			throw new InternalServerErrorException("Unable to find Subscriptions by phone due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByOrderId(int orderId) {
		ArrayList<Subscription> Subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			Subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByOrderId")
					.setInteger("orderId", orderId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [public ArrayList<Subscription> findByOrderId(String orderId)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by orderId due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("SubscriptionDaoImpl [public ArrayList<Subscription> findByUserId(String orderId)] :" + e);
			throw new InternalServerErrorException("Unable to find Subscriptions by orderId due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return Subscriptions;
	}

	@Override
	public ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,
			String subscriptionShift, String cancelShift) {
		ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			subscriptions = (ArrayList<Subscription>) session
					.getNamedQuery("Subscription.findTodaysDeliveryByCurrentDateAndCurrentShift")
					.setString("date", date).setString("subscriptionShift", subscriptionShift)
					.setString(cancelShift, cancelShift).list();
			session.getTransaction().commit();

		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,String subscriptionShift, String cancelShift)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by CurrentDateAndCurrentShift due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,String subscriptionShift, String cancelShift)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by CurrentDateAndCurrentShift due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return subscriptions;
	}

	@Override
	public ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift) {
		ArrayList<User> users = new ArrayList<User>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			users = (ArrayList<User>) session.getNamedQuery("Subscription.findByPlanDuration")
					.setString("endDate", endDate).setString("endShift", endShift).list();
			session.getTransaction().commit();

		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find Users by endDate and endShift due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find Users by endDate and endShift due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}

		return users;

	}

	@Override
	public ArrayList<Subscription> findByPlanDuration(String planDuration) {
		ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByPlanDuration")
					.setString("planDuration", planDuration).list();
			session.getTransaction().commit();

		} catch (HibernateException he) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<Subscription> findByPlanDuration(String planDuration)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by PlanDuration due to hibernate exception.");
		} catch (Exception e) {
			System.out.println(
					"SubscriptionDaoImpl [ArrayList<Subscription> findByPlanDuration(String planDuration)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by PlanDuration due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return subscriptions;
	}

	@Override
	public ArrayList<Subscription> findByPlanType(String planType) {
		ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			subscriptions = (ArrayList<Subscription>) session.getNamedQuery("Subscription.findByPlanType")
					.setString("planType", planType).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("SubscriptionDaoImpl [ArrayList<Subscription> findByPlanType(String planType)] :" + he);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by PlanType due to hibernate exception.");
		} catch (Exception e) {
			System.out.println("SubscriptionDaoImpl [ArrayList<Subscription> findByPlanType(String planType)] :" + e);
			throw new InternalServerErrorException(
					"Unable to find Subscriptions by PlanType due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return subscriptions;
	}

}