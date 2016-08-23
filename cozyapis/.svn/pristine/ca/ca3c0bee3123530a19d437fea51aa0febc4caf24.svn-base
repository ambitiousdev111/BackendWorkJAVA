package in.cozynest.cozyapis.dao.impl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.cozynest.cozyapis.dao.IUserScopeDao;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.hibernate.HibernateUtility;
import in.cozynest.cozyapis.model.UserScope;

public class UserScopeDaoImpl extends GenericDaoImpl<UserScope> implements  IUserScopeDao {
	
	Session session;
	
	public UserScopeDaoImpl() {
		super(UserScope.class);
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
	public UserScope create(UserScope userScope) {
		// TODO Auto-generated method stub
		return super.create(userScope);
	}

	@Override
	public UserScope update(UserScope userScope) {
		// TODO Auto-generated method stub
		return super.update(userScope);
	}

	@Override
	public void delete(UserScope pakage) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserScope> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public UserScope findById(int id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}


	@Override
	public UserScope findByScope(String scope) {
		UserScope userScope = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			session.beginTransaction();
			userScope = (UserScope) session.getNamedQuery("UserScope.findByScope").setString("scope", scope).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			System.out.println("UserScopeDaoImpl [public UserScope findByScope(String scope)] :" + he);
			throw new InternalServerErrorException("Unable to find UserScope by date due to hibernate error");
		} catch (Exception e) {
			System.out.println("UserScopeDaoImpl [UserScope findByScope(String scope)] :" + e);
			throw new InternalServerErrorException("Unable to find UserScope by date due to hibernate error");
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				System.out.println("UserScopeDaoImpl [UserScope findByScope(String scope)] :" + e);
				throw new InternalServerErrorException("Unable to close session");
			}
		}
		return userScope;
	}

}
