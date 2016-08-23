package in.cozynest.cozyapis.service;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.OrderedSubscription;

public interface IOrderedSubscriptionService {

	public boolean exists(int pk);

	public long count();

	public OrderedSubscription create(OrderedSubscription orderedSubscription);
	
	public OrderedSubscription update(OrderedSubscription orderedSubscription);

	public void delete(OrderedSubscription orderedSubscription);

	public ArrayList<OrderedSubscription> findAll();

	public OrderedSubscription findById(int id);
	
	public ArrayList<OrderedSubscription> findByUserId(int userId);
	
	public ArrayList<OrderedSubscription> findByStartDate(String startDate);

	public ArrayList<OrderedSubscription> findByEndDate(String endDate);

	public ArrayList<OrderedSubscription> findByPlanType(String orderedSubscriptionShift);

	public ArrayList<OrderedSubscription> findByGeneratedUserId(String userId);

	public ArrayList<OrderedSubscription> findByPhone(String phone);
	
	public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift);
	
	 public OrderedSubscription checkAndUpdateStatus(OrderedSubscription orderedSubscription);
}