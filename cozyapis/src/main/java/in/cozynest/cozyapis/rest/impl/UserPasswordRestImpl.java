package in.cozynest.cozyapis.rest.impl;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import in.cozynest.cozyapis.annotations.AdminPath;
import in.cozynest.cozyapis.annotations.UserAdminPath;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.exception.NotAcceptableException;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.UserPassword;
import in.cozynest.cozyapis.rest.IUserPasswordRest;
import in.cozynest.cozyapis.service.IUserPasswordService;
import in.cozynest.cozyapis.service.impl.UserPasswordServiceImpl;

@Path("userpassword")
@Produces("application/json")
@Consumes("application/json")

public class UserPasswordRestImpl implements IUserPasswordRest {
	
	IUserPasswordService userPasswordService=new UserPasswordServiceImpl();
    
	@PUT
	@Path("update")
	@AdminPath
	public UserPassword update(@QueryParam("id") int id, @QueryParam("password")String password) {
		if(password.equals(""))
			throw new NotAcceptableException("All feilds required");
		UserPassword userPassword=userPasswordService.findById(id);
		if(userPassword==null)
			throw new NotFoundException("No user exist for this id");
		userPassword.setPassword(password);
		
		UserPassword updatedUserPassword=new UserPasswordServiceImpl().update(userPassword);
		if(updatedUserPassword==null)
			throw new InternalServerErrorException("unable to update userpassword");
		
			return updatedUserPassword;
	}

	@GET
	@Path("findbyid/{id}")

	public UserPassword findById(@QueryParam("id")int id) {
		UserPassword userPassword=userPasswordService.findById(id);
		if(userPassword==null)
			throw new NotFoundException("No user exist for this id");
		return null;
	}

	@Override
	@GET
	@Path("findall")
	
	public ArrayList<UserPassword> findAll() {
		// TODO Auto-generated method stub
		ArrayList<UserPassword> userPassword=userPasswordService.findAll();
		if(userPassword==null)
			throw new NotFoundException("No record found");
		return userPassword;
	}

	@Override
	@GET
	@Path("findbyphone/{phone}")
	
	public UserPassword findByPhone(@QueryParam("phone")String phone) {
		
		UserPassword userPassword=userPasswordService.findByPhone(phone);
		if(userPassword==null)
			throw new NotFoundException("No user found for this phone");
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	@GET
	@Path("findbyemail/{email}")
	
	public UserPassword findByEmail(@QueryParam("email")String email) {
		UserPassword userPassword=userPasswordService.findByEmail(email);
		if(userPassword==null)
			throw new NotFoundException("No user found for this email");
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	@GET
	@Path("findbyuser_id/{user_id}")

	public UserPassword findByUserId(@QueryParam("user_id")int userId) {
		UserPassword userPassword=userPasswordService.findByUserId(userId);
		if(userPassword==null)
			throw new NotFoundException("No user found for this userId");
		// TODO Auto-generated method stub
		return userPassword;
	}

	
}
