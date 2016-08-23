package in.cozynest.cozyapis.rest;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.UserScope;
import in.cozynest.cozyapis.model.UserScope.Authority;
import in.cozynest.cozyapis.model.UserScope.Method;

public interface IUserScopeRest {
	
	public UserScope create(Authority authority,Method method, String scope);
	
	public UserScope update(int id,String scope);
	
	public ArrayList<UserScope>findAll();
	
	public  UserScope findById(int id);

}
