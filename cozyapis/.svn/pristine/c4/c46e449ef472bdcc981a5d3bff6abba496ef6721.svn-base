package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.CancelledSubscriptionDate;

public interface ICancelledSubscriptionDateDao {

	public boolean exists(int pk);

	public long count();

	public CancelledSubscriptionDate create(CancelledSubscriptionDate cancelledSubscriptionDate);

	public CancelledSubscriptionDate update(CancelledSubscriptionDate cancelledSubscriptionDate);

	public void delete(CancelledSubscriptionDate cancelledSubscriptionDate);

	public ArrayList<CancelledSubscriptionDate> findAll();

	public CancelledSubscriptionDate findById(int id);

	public ArrayList<CancelledSubscriptionDate> findByUserId(int userId);

	public ArrayList<CancelledSubscriptionDate> findBySubscriptionId(int subscriptionId);

	public ArrayList<CancelledSubscriptionDate> findByOrderId(int orderId);

	public ArrayList<CancelledSubscriptionDate> findByTransactionId(int transactionId);

	public ArrayList<CancelledSubscriptionDate> findByDate(String date);

	public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShift(String date, String shift);

	public ArrayList<CancelledSubscriptionDate> findByDateAndSubscriptionShiftAndUserId(String date, String subscriptionShift,
			int userId);

}