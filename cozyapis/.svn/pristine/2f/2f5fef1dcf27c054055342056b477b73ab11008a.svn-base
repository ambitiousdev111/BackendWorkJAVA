package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.ICancelledSubscriptionDateDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.CancelledSubscriptionDate;

public class CancelledSubscriptionDateDaoImpl extends GenericDaoImpl<CancelledSubscriptionDate>
		implements ICancelledSubscriptionDateDao {

	Session session;

	public CancelledSubscriptionDateDaoImpl() {
		super(CancelledSubscriptionDate.class);
	}

	public boolean exists(int pk) {
		return super.exists(pk);
	}

	public long count() {
		return super.count();
	}

	public CancelledSubscriptionDate create(CancelledSubscriptionDate cancelledSubscriptionDate) {
		return super.create(cancelledSubscriptionDate);
	}

	public CancelledSubscriptionDate update(CancelledSubscriptionDate cancelledSubscriptionDate) {
		return super.update(cancelledSubscriptionDate);
	}

	public void delete(CancelledSubscriptionDate cancelledSubscriptionDate) {
		super.delete(cancelledSubscriptionDate);
	}

	public ArrayList<CancelledSubscriptionDate> findAll() {
		return super.findAll();
	}

	public CancelledSubscriptionDate findById(int id) {
		return super.findById(id);
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByUserId(int userId) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByUserId").setInteger("userId", userId)
					.list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByUserId(int userId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by user id due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByUserId(int userId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by user id due due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByUserId(int userId)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findBySubscriptionId(int subscriptionId) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findBySubscriptionId")
					.setInteger("subscriptionId", subscriptionId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findBySubscriptionId(int subscriptionId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by subscription id due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findBySubscriptionId(int subscriptionId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by subscription id due due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findBySubscriptionId(int subscriptionId)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByOrderId(int orderId) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByOrderId").setInteger("orderId", orderId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByorderId(int orderId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by order id due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByOrderId(int orderId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by order id due due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByOrderId(int orderId)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByTransactionId(int transactionId) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByTransactionId")
					.setInteger("transactionId", transactionId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByTransactionId(int transactionId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by transaction id due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByTransactionId(int transactionId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by transaction id due due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByTransactionId(int transactionId)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByDate(String date) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByDate").setString("date", date).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDate(String date)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by date due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDate(String date)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by date due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDate(String date)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShift(String date, String subscriptionShift) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByDateAndSubscriptionShift").setString("date", date)
					.setString("subscriptionShift", subscriptionShift).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShift(String date, String subscriptionShift)] :"
							+ he);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by date and subscriptionShift due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShift(String date, String subscriptionShift)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by date and subscriptionShift due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShift(String date, String subscriptionShift)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

	@Override
	public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShiftAndUserId(String date,
			String subscriptionShift, int userId) {
		ArrayList<CancelledSubscriptionDate> cancelledSubscriptionDates = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			cancelledSubscriptionDates = (ArrayList<CancelledSubscriptionDate>) session
					.getNamedQuery("CancelledSubscriptionDate.findByDateAndSubscriptionShiftAndUserId")
					.setString("date", date).setString("subscriptionShift", subscriptionShift)
					.setInteger("userId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShiftAndUserId(String date, String subscriptionShift, int userId)] :"
							+ he);
			throw new InternalServerErrorException(
					"Una ble to find CancelledSubscriptionDate by date, subscriptionShift and userId due to hibernate error");
		} catch (Exception e) {
			System.out.println(
					"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShiftAndUserId(String date, String subscriptionShift, int userId)] :"
							+ e);
			throw new InternalServerErrorException(
					"Unable to find CancelledSubscriptionDate by date, subscriptionShift and userId due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println(
						"CancelledSubscriptionDate [public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShiftAndUserId(String date, String subscriptionShift, int userId)] :"
								+ e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return cancelledSubscriptionDates;
	}

}