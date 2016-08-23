package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.ITransactionDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.Transaction;

public class TransactionDaoImpl extends GenericDaoImpl<Transaction>implements ITransactionDao {

	Session session = null;

	public TransactionDaoImpl() {
		super(Transaction.class);
	}

	public boolean exists(int pk) {
		return super.exists(pk);
	}

	public long count() {
		return super.count();
	}

	public Transaction create(Transaction transaction) {
		return super.create(transaction);
	}

	public Transaction update(Transaction transaction) {
		return super.update(transaction);
	}

	public void delete(Transaction transaction) {
		super.delete(transaction);
	}

	public ArrayList<Transaction> findAll() {
		return super.findAll();
	}

	public Transaction findById(int id) {
		return super.findById(id);
	}

	public ArrayList<Transaction> findByDate(String date) {
		ArrayList<Transaction> transactions = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			transactions = (ArrayList<Transaction>) session.getNamedQuery("Transaction.findByDate")
					.setString("date", date).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByDate(String date)] :" + he);
			throw new InternalServerErrorException("Unable to find transactions by date due to hibernate error");
		} catch (Exception e) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByDate(String date)] :" + e);
			throw new InternalServerErrorException("Unable to find transactions by date due to hibernate error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public long count()] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return transactions;
	}

	public ArrayList<Transaction> findByOrderId(int orderId) {
		ArrayList<Transaction> transactions = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			transactions = (ArrayList<Transaction>) session.getNamedQuery("Transaction.findByOrderId")
					.setInteger("orderId", orderId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByOrderId(int orderId)] :" + he);
			throw new InternalServerErrorException("Unable to find transactions by orderId due to hibernate error");
		} catch (Exception e) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByOrderId(int orderId)] :" + e);
			throw new InternalServerErrorException("Unable to find transactions by orderId due to hibernate error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public long count()] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return transactions;
	}

	public ArrayList<Transaction> findByUserId(int userId) {
		ArrayList<Transaction> transactions = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			transactions = (ArrayList<Transaction>) session.getNamedQuery("Transaction.findByUserId")
					.setInteger("userId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByOrderId(int orderId)] :" + he);
			throw new InternalServerErrorException("Unable to find transactions by userId due to hibernate error");
		} catch (Exception e) {
			System.out.println("TransactionDaoImpl [public ArrayList<Transaction> findByOrderId(int orderId)] :" + e);
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public long count()] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return transactions;
	}

}