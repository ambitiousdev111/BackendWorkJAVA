package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.UserScope;



public interface IUserScopeDao {
	
	
	public boolean exists(int pk);

	public long count();

	public UserScope create(UserScope userScope);

	public UserScope update(UserScope userScope);

	public void delete(UserScope pakage);

	public ArrayList<UserScope> findAll();

	public UserScope findById(int id);
	
	public UserScope findByScope(String scope);

}
