package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IOrderDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.Order;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements IOrderDao {

	Session session;

	public OrderDaoImpl() {
		super(Order.class);
	}

	@Override
	public boolean exists(int pk) {
		return super.exists(pk);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public Order create(Order order) {
		return super.create(order);
	}

	@Override
	public Order update(Order order) {
		return super.update(order);
	}

	@Override
	public void delete(Order order) {
		super.delete(order);
	}

	@Override
	public ArrayList<Order> findAll() {
		return super.findAll();
	}

	@Override
	public Order findById(int id) {
		return super.findById(id);
	}

	@Override
	public ArrayList<Order> findByDateOfOrder(String dateOfOrder) {
		ArrayList<Order> orders = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orders = (ArrayList<Order>) session.getNamedQuery("Order.findByOrderDate")
					.setString("dateOfOrder", dateOfOrder).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderDaoImpl [public ArrayList<Order> findByOrderDate(java.util.Date orderDate)] :" + he);
			throw new InternalServerErrorException("Unable to find Orders by ORDER DATE due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("OrderDaoImpl [public ArrayList<Order> findByOrderDate(java.util.Date orderDate)] :" + e);
			throw new InternalServerErrorException("Unable to find Orders by ORDER DATE due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orders;
	}

	@Override
	public ArrayList<Order> findByUserId(int userId) {
		ArrayList<Order> orders = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orders = (ArrayList<Order>) session.getNamedQuery("Order.findByUserId")
					.setInteger("userId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderDaoImpl [ArrayList<Order> findByUserId(int userId)] :" + he);
			throw new InternalServerErrorException("Unable to find ORDERS by CUSTOMER ID due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("ArrayList<Order> findByUserId(int userId)] :" + e);
			throw new InternalServerErrorException("Unable to find ORDERS by CUSTOMER ID due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orders;
	}

	@Override
	public ArrayList<Order> findByGeneratedUserId(String userId) {
		ArrayList<Order> orders = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orders = (ArrayList<Order>) session.getNamedQuery("Order.findByGeneratedUserId")
					.setString("generatedUserId", userId).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderDaoImpl [ArrayList<Order> findByUserId(int userId)] :" + he);
			throw new InternalServerErrorException("Unable to find ORDERS by CUSTOMER ID due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("ArrayList<Order> findByUserId(int userId)] :" + e);
			throw new InternalServerErrorException("Unable to find ORDERS by CUSTOMER ID due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orders;
	}
	
	@Override
	public ArrayList<Order> findByPhone(String phone) {
		ArrayList<Order> orders = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			orders = (ArrayList<Order>) session.getNamedQuery("Order.findByPhone")
					.setString("phone", phone).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out
					.println("OrderDaoImpl [ArrayList<Order> findByUserId(int userId)] :" + he);
			throw new InternalServerErrorException("Unable to find ORDERS by Phone due to hibernate exception.");
		} catch (Exception e) {
			System.out
					.println("ArrayList<Order> findByUserId(int userId)] :" + e);
			throw new InternalServerErrorException("Unable to find ORDERS by Phone due to unknown exception.");
		} finally {
			if (session != null)
				session.close();
		}
		return orders;
	}
}
