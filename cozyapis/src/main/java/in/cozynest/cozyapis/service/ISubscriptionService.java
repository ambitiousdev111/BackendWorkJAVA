package in.cozynest.cozyapis.service;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.model.Subscription;

public interface ISubscriptionService {

	public boolean exists(int pk);

	public long count();

	public Subscription create(Subscription subscription);

	public Subscription createNewSubscription(Subscription subscription);

	public Subscription update(Subscription subscription);

	public void delete(Subscription subscription);

	public ArrayList<Subscription> findAll();

	public Subscription findById(int id);

	public ArrayList<Subscription> findByStatus(String status);

	public ArrayList<Subscription> findByStartDate(String startDate);

	public ArrayList<Subscription> findByEndDate(String endDate);

	public ArrayList<Subscription> findByPlanType(String planType);

	public ArrayList<Subscription> findByUserId(int userId);

	public ArrayList<Subscription> findByGeneratedUserId(String userId);

	public ArrayList<Subscription> findByPhone(String phone);
	
	public ArrayList<Subscription> findByOrderId(int orderId);

	public ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,
			String subscriptionShift, String cancelShift);

	public ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift);
	public ArrayList<Subscription> findByPlanDuration(String planDuration);
}