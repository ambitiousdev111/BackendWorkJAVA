package in.cozynest.cozyapis.rest.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import in.cozynest.cozyapis.annotations.AdminPath;
import in.cozynest.cozyapis.annotations.UserAdminPath;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.exception.NotAcceptableException;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.model.User.Gender;
import in.cozynest.cozyapis.model.User.UserType;
import in.cozynest.cozyapis.model.UserPassword;
import in.cozynest.cozyapis.rest.IUserRest;
import in.cozynest.cozyapis.service.IUserPasswordService;
import in.cozynest.cozyapis.service.IUserService;
import in.cozynest.cozyapis.service.impl.UserPasswordServiceImpl;
import in.cozynest.cozyapis.service.impl.UserServiceImpl;

@Path("user")
@Produces("application/json")
@Consumes("application/json")
public class UserRestImpl implements IUserRest {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	IUserService userService = new UserServiceImpl();
	IUserPasswordService userPasswordService = new UserPasswordServiceImpl();
	
	@POST
	@Path("create")
	public User create(@QueryParam("name") String name, @QueryParam("phone") String phone,
			@QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("gender") Gender gender,
			@QueryParam("email") String email,@QueryParam("profession") String profession,
			@QueryParam("password") String password) {
		if (name==null || phone==null || dateOfBirth==null ||email==null||profession==null||password==null)
			throw new NotAcceptableException("All feilds required");
		if (name.equals("") || phone.equals("") || dateOfBirth.equals("") ||email.equals("")||profession.equals("")||password.equals(""))
			throw new NotAcceptableException("All feilds required");
		if(userService.findByPhone(phone) != null)
			throw new NotAcceptableException("Mobile number already exists");
		if(userService.findByEmail(email) != null)
			throw new NotAcceptableException("Email already exists");
		User user = new User();
		try {
			user.setDateOfBirth(formatter.parse(dateOfBirth));
		} catch (ParseException pe) {
			System.out.println(
					"public class UserRestImpl [public User create(String name, String phone, String dateOfBirth, Gender gender)] : "
							+ pe);
			throw new InternalServerErrorException("Invalid dateOfBirth");
		}
		user.setUserType(UserType.USER);
		user.setGender(gender);
		user.setName(name);
		user.setPhone(phone);
		user.setDateOfJoining(new Date());
		try {
			user.setDateOfBirth(formatter.parse(dateOfBirth));
		}catch(ParseException pe) {
			throw new InternalServerErrorException("Invalid date of birth");
		}
		user.setEmail(email);
		user.setProfession(profession);
		user.setGeneratedUserId(generateUserId(name));
		
		UserPassword userPassword = new UserPassword();
		userPassword.setPassword(password);
		userPassword.setUser(user);
		
		UserPassword newUserPassword = userPasswordService.create(userPassword);
		if(newUserPassword == null)
			throw new InternalServerErrorException("Unable to create new user");
		return newUserPassword.getUser();
	}

	private String generateUserId(String name) {
		Date date = new Date();
		String generatedUserId = name.substring(0, 2)+userService.count()+date.getYear()+date.getMonth()+date.getDate()+date.getHours()+date.getMinutes()+date.getSeconds();
		return generatedUserId;
	}
	
	@GET
	@Path("hi")
	public String hi() {
		return "[\"hi\"]";
	}

	@GET
	@Path("hello")
	@UserAdminPath
	public String hello() {
		return "[\"hello\"]";
	}
	
	@PUT
	@Path("update")
	@AdminPath
	public User update(@QueryParam("id") int id, @QueryParam("name") String name, @QueryParam("phone") String phone,
			@QueryParam("gender") Gender gender, @QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("profession") String profession,
			@QueryParam("email") String email) {
		if (name==null || phone==null || dateOfBirth==null ||email==null||profession==null)
			throw new NotAcceptableException("All feilds required");
		if (name.equals("") || phone.equals("") || dateOfBirth.equals("") ||email.equals("")||profession.equals(""))
			throw new NotAcceptableException("All feilds required");
		User user = userService.findByPhone(phone);
		if(user != null)
			if(user.getId() != id)
				throw new NotAcceptableException("Mobile number already exists");
		user = userService.findByEmail(email);
		if(user != null)
			if(user.getId() != id)
				throw new NotAcceptableException("Email already exists");
		user = userService.findById(id);
		if(user == null)
			throw new NotFoundException("Unable to update record : Invalid user id");
		try {
			user.setDateOfBirth(formatter.parse(dateOfBirth));
		} catch (ParseException pe) {
			System.out.println(pe);
		}
		user.setEmail(email);
		user.setProfession(profession);
		user.setGender(gender);
		user.setName(name);
		user.setPhone(phone);
		User updatedUser = userService.update(user);
		return updatedUser;
	}

	@GET
	@Path("findall")
	public ArrayList<User> findAll() {
		ArrayList<User> users = userService.findAll();
		if (users == null)
			throw new NotFoundException("No record found ");
		return users;
	}

	@GET
	@Path("findbygenerateduserid/{userId}")
	@UserAdminPath
	public User findByUserId(@PathParam("userId") String userId) {
		User user = userService.findByGeneratedUserId(userId);
		if (user == null)
			throw new NotFoundException("No record found for this generatedUserId and userId");
		return user;
	}

	@GET
	@Path("findbyphone/{phone}")
	@UserAdminPath
	public User findByPhone(@PathParam("phone") String phone) {
		User user = userService.findByPhone(phone);
		if (user == null)
			throw new NotFoundException("No record found for this phone");
		return user;
	}

	@GET
	@Path("findbyphone/{phone}/userid/{userId}")
	@UserAdminPath
	public User findByGeneratedUserIdOrPhone(@PathParam("phone") String phone, @PathParam("userId") String userId) {
		User user = userService.findByGeneratedUserIdOrPhone(userId, phone);
		if (user == null)
			throw new NotFoundException("No record found for this phone and userId");
		return user;
	}

	

	
	@GET
	@Path("findbyemail/{email}")
	@UserAdminPath
	public User findByEmail(@PathParam("email") String email) {
		User user = userService.findByEmail(email);
		if (user == null)
			throw new NotFoundException("No record found for this email");
		return user;
	}
	
	@GET
	@Path("findbyid/{id}")
	@UserAdminPath
	public User findById(@PathParam("id") int id)
	{
		User user=userService.findById(id);
		if(user==null)
			throw new NotFoundException("No record found for this id");
		return user;
	}


}