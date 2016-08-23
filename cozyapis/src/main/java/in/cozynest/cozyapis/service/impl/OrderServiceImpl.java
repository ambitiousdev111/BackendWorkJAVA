package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import javax.ws.rs.BadRequestException;

import in.cozynest.cozyapis.dao.IOrderDao;
import in.cozynest.cozyapis.dao.impl.OrderDaoImpl;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Order;
import in.cozynest.cozyapis.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public boolean exists(int pk) {
		return orderDao.exists(pk);
	}

	@Override
	public long count() {
		return orderDao.count();
	}

	@Override
	public Order create(Order order) {
		return orderDao.create(order);
	}

	@Override
	public Order update(Order order) {
		return orderDao.update(order);
	}

	@Override
	public void delete(Order order) {
		orderDao.delete(order);
	}

	@Override
	public ArrayList<Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Order findById(int id) {
		return orderDao.findById(id);
	}

	@Override
	public ArrayList<Order> findByDateOfOrder(String dateOfOrder) {
		return orderDao.findByDateOfOrder(dateOfOrder);
	}

	@Override
	public ArrayList<Order> findByUserId(Integer userId) {
		return orderDao.findByUserId(userId);
	}

	@Override
	public ArrayList<Order> findByGeneratedUserId(String userId) {
		return orderDao.findByGeneratedUserId(userId);
	}

	@Override
	public ArrayList<Order> findByPhone(String phone) {
		return orderDao.findByPhone(phone);
	}

}