package in.cozynest.cozyapis.errorpage;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import in.cozynest.cozyapis.exception.BadRequestException;
import in.cozynest.cozyapis.exception.MethodNotAllowedException;
import in.cozynest.cozyapis.exception.NotAcceptableException;
import in.cozynest.cozyapis.exception.NotFoundException;

@Path("/ClientExceptions")
@Produces(MediaType.APPLICATION_JSON)
public class ClientException {

	@Path("/URLNotFound")
	@GET
	public Response urlNotFound() {
		throw new NotFoundException("Requested URL not found");
	}

	@Path("/BadRequest")
	@GET
	public Response badRequest() {
		throw new BadRequestException("Bad Request");
	}

	@Path("/NotAcceptable")
	@GET
	public Response notAcceptable() {
		throw new NotAcceptableException("Not Acceptable");
	}

	@Path("/MethodNotAllowed")
	@POST
	public Response postMethodNotAllowed() {
		throw new MethodNotAllowedException("POST method not allowed");
	}

	@Path("/MethodNotAllowed")
	@PUT
	public Response putMethodNotAllowed() {
		throw new MethodNotAllowedException("PUT method not allowed");
	}

	@Path("/MethodNotAllowed")
	@DELETE
	public Response deleteMethodNotAllowed() {
		throw new MethodNotAllowedException("DELETE method not allowed");
	}

	@Path("/MethodNotAllowed")
	@GET
	public Response getMethodNotAllowed() {
		throw new MethodNotAllowedException("GET method not allowed");
	}

	@Path("/MethodNotAllowed")
	@HEAD
	public Response headMethodNotAllowed() {
		throw new MethodNotAllowedException("HEAD method not allowed");
	}
}