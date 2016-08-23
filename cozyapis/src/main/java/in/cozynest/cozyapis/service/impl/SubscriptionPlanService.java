package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.ISubscriptionPlanDao;
import in.cozynest.cozyapis.dao.impl.SubscriptionPlanDao;
import in.cozynest.cozyapis.model.SubscriptionPlan;
import in.cozynest.cozyapis.service.ISubscriptionPlanService;

public class SubscriptionPlanService  implements ISubscriptionPlanService  {

	ISubscriptionPlanDao subscriptionPlanDao=new SubscriptionPlanDao();

	@Override
	public boolean exists(int pk) {
		
		return subscriptionPlanDao.exists(pk);
	}

	@Override
	public long count() {
		return subscriptionPlanDao.count();
	}

	@Override
	public SubscriptionPlan create(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
		return subscriptionPlanDao.create(subscriptionPlan);
	}

	@Override
	public SubscriptionPlan update(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
		return subscriptionPlanDao.update(subscriptionPlan);
	}

	@Override
	public void delete(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
		subscriptionPlanDao.delete(subscriptionPlan);
	}

	@Override
	public ArrayList<SubscriptionPlan> findAll() {
		// TODO Auto-generated method stub
		return subscriptionPlanDao.findAll();
	}

	@Override
	public SubscriptionPlan findById(int id) {
		// TODO Auto-generated method stub
		return subscriptionPlanDao.findById(id);
	}

}
