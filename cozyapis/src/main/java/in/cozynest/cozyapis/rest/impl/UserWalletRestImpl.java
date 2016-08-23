package in.cozynest.cozyapis.rest.impl;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import in.cozynest.cozyapis.annotations.UserAdminPath;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.UserWallet;
import in.cozynest.cozyapis.rest.IUserWalletRest;
import in.cozynest.cozyapis.service.IUserWalletService;
import in.cozynest.cozyapis.service.impl.UserWalletServiceImpl;

@Path("userwallet")
@Produces("application/json")
@Consumes("application/json")
public class UserWalletRestImpl implements IUserWalletRest {

	IUserWalletService userWalletService = new UserWalletServiceImpl();

	@Override
	@GET
	@Path("findall")
	public ArrayList<UserWallet> findAll() {
		ArrayList<UserWallet> userWallet=userWalletService.findAll();
		if(userWallet==null)
			throw new NotFoundException("No record found");
		return userWallet;
	}
	
	@Override
	@GET
	@Path("findbyphone/{phone}")
	@UserAdminPath
	public UserWallet findByPhone(@PathParam("phone") String phone) {
		UserWallet userWallet=userWalletService.findByPhone(phone);
		if(userWallet==null)
			throw new NotFoundException("No record found for this phone");
		return userWallet;
	}

	@Override
	@GET
	@Path("findbygenerateduserid/{generatedUserId}")
	@UserAdminPath
	public UserWallet findByGeneratedUserId(@PathParam("generatedUserId") String generatedUserId) {
		UserWallet userWallet=userWalletService.findByGeneratedUserId(generatedUserId);
		
		if(userWallet==null)
			throw new NotFoundException("No record found for this generatedUserId");
		return userWallet;

	}

}
