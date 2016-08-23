package in.cozynest.cozyapis.service;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Order;

public interface IOrderService {
	public boolean exists(int pk);

	public long count();

	public Order create(Order order);

	public Order update(Order order);

	public void delete(Order order);

	public ArrayList<Order> findAll();

	public Order findById(int id);

	public ArrayList<Order> findByDateOfOrder(String orderDate);

	public ArrayList<Order> findByUserId(Integer userId);
	
	public ArrayList<Order> findByGeneratedUserId(String userId);
	
	public ArrayList<Order> findByPhone(String phone);
}
