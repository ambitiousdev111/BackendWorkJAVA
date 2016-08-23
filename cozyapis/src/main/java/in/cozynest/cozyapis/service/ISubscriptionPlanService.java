package in.cozynest.cozyapis.service;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.SubscriptionPlan;

public interface ISubscriptionPlanService {
	public boolean exists(int pk);

	public long count();

	public SubscriptionPlan create(SubscriptionPlan subscription);

	public SubscriptionPlan update(SubscriptionPlan subscription);

	public void delete(SubscriptionPlan subscription);

	public ArrayList<SubscriptionPlan> findAll();

	public SubscriptionPlan findById(int id);
}
