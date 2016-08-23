package in.cozynest.cozyapis.rest.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import in.cozynest.cozyapis.model.Order;
import in.cozynest.cozyapis.model.Order.OrderType;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.rest.IOrderRest;
import in.cozynest.cozyapis.service.IOrderService;
import in.cozynest.cozyapis.service.impl.OrderServiceImpl;
import in.cozynest.cozyapis.service.impl.UserServiceImpl;

@Path("order")
@Produces("application/json")
@Consumes("application/json")
public class OrderRestImpl implements IOrderRest {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	IOrderService orderService = new OrderServiceImpl();
    
	@GET
	@Path("findall")
	@AdminPath
	@Override
	public ArrayList<Order> findAll() {
		ArrayList<Order> orders = orderService.findAll();
		if(orders==null)
			throw new NotFoundException("No record found");
		if(orders.size()==0)
			throw new NotFoundException("No record found");
		return orders;
	}
	
	@GET
	@Path("findbyid/{id}")
	@UserAdminPath
	@Override
	public Order findById(@PathParam("id") int id) {
		Order order=orderService.findById(id);
		if(order==null)
			throw new NotFoundException("No record found for this id");
		return order;
	}

	@Override
	@GET
	@Path("findbydateoforder/{dateOfOrder}")
	@UserAdminPath
	public ArrayList<Order> findByDateOfOrder(@PathParam("dateOfOrder") String dateOfOrder) {
		ArrayList<Order> order=orderService.findByDateOfOrder(dateOfOrder);
		if(order==null)
			throw new NotFoundException("No record found for this dateOfOrder");
		return order;
	}

	@Override
	@GET
	@Path("findbyuserid/{userId}")
	@UserAdminPath
	public ArrayList<Order> findByUserId(@PathParam("userId") int userId) {
		ArrayList<Order> order=orderService.findByUserId(userId);
		if(order==null)
			throw new NotFoundException("No record found for this userId");
		return order;
	}

	@GET
	@Path("findbygenerateduserid/{generatedUserId}")
	@UserAdminPath
	public ArrayList<Order> findByGeneratedUserId(@PathParam("generatedUserId") String generatedUserId) {
		ArrayList<Order> order=orderService.findByGeneratedUserId(generatedUserId);
		
		if(order==null)
			throw new NotFoundException("No record found for this generatedUserId");
		return order;	
	}
	
	@GET
	@Path("findbyphone/{phone}")
	@UserAdminPath
	public ArrayList<Order> findByPhone(@PathParam("phone") String phone) {
		ArrayList<Order> order=orderService.findByPhone(phone);

		if(order==null)
			throw new NotFoundException("No record found for this phone");
		return order;	
		
	}
}