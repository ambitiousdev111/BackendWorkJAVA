package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IGenericDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;

public class GenericDaoImpl<Entity> implements IGenericDao<Entity> {

	private Session session;
	private String className;
	private Class<Entity> cls;

	public GenericDaoImpl(Class<Entity> cls) {
		this.cls = cls;
		className = cls.getName();
	}

	public boolean exists(int pk) {
		Entity entity = null;
		try {
			openSession();
			entity = (Entity) session.get(cls, pk);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("GenericDao [public boolean exists(int pk)] :" + he);
			throw new InternalServerErrorException("Unable to check existance due to hibernate error");
		} catch (Exception e) {
			System.out.println("GenericDao [public boolean exists(int pk)] :" + e);
			throw new InternalServerErrorException("Unable to check existance due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public boolean exists(int pk)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return entity != null;
	}

	public long count() {
		long count = 0;
		try {
			openSession();
			count = (long) session.createQuery("select count(*) from " + className).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("GenericDao [public long count()] :" + he);
			throw new InternalServerErrorException("Unable to count records due to hibernate error");
		} catch (Exception e) {
			System.out.println("GenericDao [public long count()] :" + e);
			throw new InternalServerErrorException("Unable to count records due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public long count()] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return count;
	}

	public Entity create(Entity entity) {
		Entity ent = null;
		try {
			openSession();
			ent = (Entity) session.merge(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public Entity create(Entity entity)] :" + he);
			throw new InternalServerErrorException("Unable to create record due to hibernate error");
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public Entity create(Entity entity)] :" + e);
			throw new InternalServerErrorException("Unable to create record due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public Entity create(Entity entity)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return ent;
	}

	public Entity update(Entity entity) {
		try {
			openSession();
			session.update(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public Entity update(Entity entity)] :" + he);
			throw new InternalServerErrorException("Unable to update record due to hibernate error");
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public Entity update(Entity entity)] :" + e);
			throw new InternalServerErrorException("Unable to update record due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public Entity update(Entity entity)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return entity;
	}

	public void delete(Entity entity) {
		try {
			openSession();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public void delete(Entity entity)] :" + he);
			throw new InternalServerErrorException("Unable to delete record due to hibernate error");
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public void delete(Entity entity)] :" + e);
			throw new InternalServerErrorException("Unable to delete record due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public void delete(Entity entity)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
	}

	public ArrayList<Entity> findAll() {
		ArrayList<Entity> nEntity = null;
		try {
			openSession();
			ArrayList<Entity> list = (ArrayList<Entity>) session.createQuery("from " + className).list();
			nEntity = list;
			session.getTransaction().commit();
		} catch (HibernateException he) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public ArrayList<Entity> findAll()] :" + he);
			throw new InternalServerErrorException("Unable to find records due to hibernate error");
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println("GenericDao [public ArrayList<Entity> findAll()] :" + e);
			throw new InternalServerErrorException("Unable to find records due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public ArrayList<Entity> findAll()] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return nEntity;
	}

	public Entity findById(int id) {
		Entity entity = null;
		try {
			openSession();
			entity = (Entity) session.get(cls, id);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("GenericDao [public Entity findById(int id)] :" + he);
			throw new InternalServerErrorException("Unable to find record due to hibernate error");
		} catch (Exception e) {
			System.out.println("GenericDao [public Entity findById(int id))] :" + e);
			throw new InternalServerErrorException("Unable to find record due to unknown error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("GenericDao [public Entity findById(int id)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return entity;
	}

	private void openSession() {
		session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
	}

}