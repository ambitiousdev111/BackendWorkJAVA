package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;
import java.util.Date;

import in.cozynest.cozyapis.dao.IOrderedSubscriptionDao;
import in.cozynest.cozyapis.dao.impl.OrderedSubscriptionDaoImpl;
import in.cozynest.cozyapis.model.OrderedSubscription;
import in.cozynest.cozyapis.model.OrderedSubscription.OrderedSubscriptionStatus;
import in.cozynest.cozyapis.service.IOrderedSubscriptionService;

public class OrderedSubscriptionServiceImpl implements IOrderedSubscriptionService {

	IOrderedSubscriptionDao orderedSubscriptionDao = new OrderedSubscriptionDaoImpl();
	
	@Override
	public boolean exists(int pk) {
		return orderedSubscriptionDao.exists(pk);
	}

	@Override
	public long count() {
		return orderedSubscriptionDao.count();
	}

	@Override
	public OrderedSubscription create(OrderedSubscription orderedSubscription) {
		return orderedSubscriptionDao.create(orderedSubscription);
	}

	

	@Override
	public OrderedSubscription update(OrderedSubscription orderedSubscription) {
		return orderedSubscriptionDao.update(orderedSubscription);
	}

	@Override
	public void delete(OrderedSubscription orderedSubscription) {
		orderedSubscriptionDao.delete(orderedSubscription);
		
	}

	@Override
	public ArrayList<OrderedSubscription> findAll() {
		return orderedSubscriptionDao.findAll();
	}

	@Override
	public OrderedSubscription findById(int id) {
		return orderedSubscriptionDao.findById(id);
	}

	@Override
	public ArrayList<OrderedSubscription> findByStartDate(String startDate) {
		return orderedSubscriptionDao.findByStartDate(startDate);
	}

	@Override
	public ArrayList<OrderedSubscription> findByEndDate(String endDate) {
		return orderedSubscriptionDao.findByEndDate(endDate);
	}

	@Override
	public ArrayList<OrderedSubscription> findByPlanType(String planType) {
		return orderedSubscriptionDao.findByPlanType(planType);
	}

	@Override
	public ArrayList<OrderedSubscription> findByUserId(int userId) {
		return orderedSubscriptionDao.findByUserId(userId);
	}

	@Override
	public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId) {
		return orderedSubscriptionDao.findByGeneratedUserId(generatedUserId);
	}

	@Override
	public ArrayList<OrderedSubscription> findByPhone(String phone) {
		return orderedSubscriptionDao.findByPhone(phone);
	}

	@Override
	public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift) {
		return orderedSubscriptionDao.findByEndDateAndEndShift(endDate, endShift);
	}
	
	public OrderedSubscriptionStatus getStatus(int id){
		return orderedSubscriptionDao.getStatusById(id);
	}
	
	public OrderedSubscription checkAndUpdateStatus(OrderedSubscription orderedSubscription)
    {
    	if(new Date().after(orderedSubscription.getStartDate())){
    		orderedSubscription.setOrderStatus(OrderedSubscriptionStatus.CANCELLED);
    		orderedSubscription.setRemark("cancelled due to passed start date");
    		update(orderedSubscription);
    		
    	}
    	return orderedSubscription;
    }
}
