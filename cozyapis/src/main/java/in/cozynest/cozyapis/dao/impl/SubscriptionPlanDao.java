package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;

import in.cozynest.cozyapis.dao.ISubscriptionPlanDao;
import in.cozynest.cozyapis.model.SubscriptionPlan;

public class SubscriptionPlanDao extends GenericDaoImpl<SubscriptionPlan>  implements ISubscriptionPlanDao {

	Session session;
	public SubscriptionPlanDao() {
		super(SubscriptionPlan.class);
		
	}
	@Override
	public boolean exists(int pk) {
		// TODO Auto-generated method stub
		return super.exists(pk);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.count();
	}

	@Override
	public SubscriptionPlan create(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
		return super.create(subscriptionPlan);
	}

	@Override
	public SubscriptionPlan update(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
		return super.update(subscriptionPlan);
	}

	@Override
	public void delete(SubscriptionPlan subscriptionPlan) {
		// TODO Auto-generated method stub
      super.delete(subscriptionPlan);
	}

	@Override
	public ArrayList<SubscriptionPlan> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public SubscriptionPlan findById(int id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

}
