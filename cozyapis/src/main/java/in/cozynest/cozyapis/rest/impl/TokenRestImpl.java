package in.cozynest.cozyapis.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import in.cozynest.cozyapis.annotations.UserAdminPath;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Token;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.rest.ITokenRest;
import in.cozynest.cozyapis.service.ITokenService;
import in.cozynest.cozyapis.service.impl.TokenServiceImpl;

@Path("token")
@Produces ("application/json")
public class TokenRestImpl implements ITokenRest {

	ITokenService tokenService = new TokenServiceImpl();
	
	@GET
	@Path("finduserbyaccesstoken/{accessToken}")
	@UserAdminPath
	@Override
	public User findUserByAccessToken(@PathParam("accessToken") String accessToken) {
		Token token = tokenService.findByAccessToken(accessToken);
		if(token == null)
			throw new NotFoundException("Invalid access token");
		return token.getUser();
	}
}