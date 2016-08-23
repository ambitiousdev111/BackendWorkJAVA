package in.cozynest.cozyapis.rest;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Subscription;
import in.cozynest.cozyapis.model.Subscription.Status;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.utils.DailyCommingStatusWrapper;

public interface ISubscriptionRest {

	public Subscription updateStatus(int id, Status status);


	public ArrayList<Subscription> findAll();

	public Subscription findById(int id);

	public ArrayList<Subscription> findByStatus(String status);

	public ArrayList<Subscription> findByStartDate(String startDate);

	public ArrayList<Subscription> findByEndDate(String endDate);

	public ArrayList<Subscription> findByPlanType(String planType);

	public ArrayList<Subscription> findByUserId(int userId);

	public ArrayList<Subscription> findByOrderId(int orderId);
	
	public ArrayList<Subscription> findByGeneratedUserId(String generatedUserId);
	
	public ArrayList<Subscription> findByPhone(String phone);

	public ArrayList<Subscription> findTodaysDeliveriesByCurrentDateAndCurrentShift(String date,
			String subscriptionShift, String cancelShift);

	public DailyCommingStatusWrapper findDailyCommingStatus(int subscriptionId);

	public ArrayList<User> findByEndDateAndEndShift(String endDate, String endShift);
	
	public ArrayList<Subscription> findByPlanDuration(String planDuration);
}