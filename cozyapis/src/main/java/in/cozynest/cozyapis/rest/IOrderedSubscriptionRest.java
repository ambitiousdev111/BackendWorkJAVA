package in.cozynest.cozyapis.rest;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.OrderedSubscription;
import in.cozynest.cozyapis.model.OrderedSubscription.Shift;
import in.cozynest.cozyapis.model.Subscription;
import in.cozynest.cozyapis.model.SubscriptionPlan.PlanDuration;
import in.cozynest.cozyapis.model.SubscriptionPlan.PlanType;

public interface IOrderedSubscriptionRest {

	public OrderedSubscription create(String startDate, String address, Shift startShift, PlanDuration planDuration, PlanType planType, int packageId, int userId);

	public ArrayList<OrderedSubscription> findAll();

	public OrderedSubscription findById(int id);

	public ArrayList<OrderedSubscription> findByStartDate(String startDate);

	public ArrayList<OrderedSubscription> findByEndDate(String endDate);

	public ArrayList<OrderedSubscription> findByPlanType(String planType);

	public ArrayList<OrderedSubscription> findByUserId(int userId);

	public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId);
	
	public ArrayList<OrderedSubscription> findByPhone(String phone);

	public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift);

	public Subscription convertOrderToSubscription(int orderedSubscriptionId);
}
