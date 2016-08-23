package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Transaction;

public interface ITransactionDao {

	public boolean exists(int pk);

	public long count();

	public Transaction create(Transaction transaction);

	public Transaction update(Transaction transaction);

	public void delete(Transaction transaction);

	public ArrayList<Transaction> findAll();

	public Transaction findById(int id);

	public ArrayList<Transaction> findByDate(String date);

	public ArrayList<Transaction> findByOrderId(int orderId);

	public ArrayList<Transaction> findByUserId(int userId);
}