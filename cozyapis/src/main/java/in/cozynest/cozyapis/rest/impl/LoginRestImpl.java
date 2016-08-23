package in.cozynest.cozyapis.rest.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Token;
import in.cozynest.cozyapis.model.UserPassword;
import in.cozynest.cozyapis.rest.ILoginRest;
import in.cozynest.cozyapis.security.CryptoAlgo;
import in.cozynest.cozyapis.service.ITokenService;
import in.cozynest.cozyapis.service.IUserPasswordService;
import in.cozynest.cozyapis.service.impl.TokenServiceImpl;
import in.cozynest.cozyapis.service.impl.UserPasswordServiceImpl;

@Path("login")
public class LoginRestImpl implements ILoginRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@QueryParam("email") String email, @QueryParam("password") String password) {
		IUserPasswordService userService = new UserPasswordServiceImpl();
		ITokenService tokenService = new TokenServiceImpl();
		Token token = null;
		if (email == null || password == null)
			throw new InternalServerErrorException("Email / Password cannot be null");
		if (email.trim().equals("") || password.trim().equals(""))
			throw new InternalServerErrorException("All fields are required");
		Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
		UserPassword userPassword;
		String encryptedGeneratedUserId = "";
		CryptoAlgo cryptoAlgo = new CryptoAlgo();
		token = new Token();
		try {
			Matcher matcher = pattern.matcher(email);
			try {
			if (matcher.matches())
				userPassword = userService.findByEmailAndPassword(email, password);
			else
				userPassword = userService.findByPhoneAndPassword(String.valueOf(Long.parseLong(email)), password);
			} catch (NumberFormatException nfe) {
				userPassword = userService.findByGeneratedUserIdAndPassword(email, password);
			}
			if (userPassword == null)
				throw new NotFoundException("user not registered");
			token.setUser(userPassword.getUser());
			encryptedGeneratedUserId = cryptoAlgo.encrypt("kelkarsirjiuserid", userPassword.getUser().getGeneratedUserId());
			token.setAccessToken(
					cryptoAlgo.encrypt("kelkarsirjitoken", userPassword.getUser().getGeneratedUserId() + System.currentTimeMillis()));
			token.setIssueDate(new Date());
			token.setExpire(addDays(new Date(), 365));
			tokenService.create(token);
		}  catch (NullPointerException npe) {
			throw new InternalServerErrorException("Unknown Error occured");
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| UnsupportedEncodingException | InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Error occured due to Cryptography");
		}
		String retValue = "{\"ui\":\"" + encryptedGeneratedUserId + "\"," + "\"ut\": \"" + token.getAccessToken()
				+ "\"," + "\"id\": \"" + token.getUser().getId() + "\"}";
		return retValue;
	}

	private static Date addDays(Date d, int days) {
		d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
		return d;
	}

}