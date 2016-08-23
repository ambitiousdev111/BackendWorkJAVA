package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.ITransactionDao;
import in.cozynest.cozyapis.dao.impl.TransactionDaoImpl;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Transaction;
import in.cozynest.cozyapis.service.ITransactionService;

public class TransactionServiceImpl implements ITransactionService {
	
	ITransactionDao transactionDao = new TransactionDaoImpl();
	
	public boolean exists(int pk) {
		return transactionDao.exists(pk);
	}

	public long count() {
		return transactionDao.count();
	}

	public Transaction create(Transaction transaction) {
		return transactionDao.create(transaction);
	}

	public Transaction update(Transaction transaction) {
		return transactionDao.update(transaction);
	}

	public void delete(Transaction transaction) {
		transactionDao.delete(transaction);
	}

	public ArrayList<Transaction> findAll() {
		return transactionDao.findAll();
	}

	public Transaction findById(int id) {
		return transactionDao.findById(id);
	}
	
	public ArrayList<Transaction> findByDate(String date) {
		return transactionDao.findByDate(date);
	}

	public ArrayList<Transaction> findByOrderId(int orderId) {
		return transactionDao.findByOrderId(orderId);
	}

	public ArrayList<Transaction> findByUserId(int userId) {
		return transactionDao.findByUserId(userId);
	}
}