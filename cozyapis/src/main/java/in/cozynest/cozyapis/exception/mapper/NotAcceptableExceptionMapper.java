package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.NotAcceptableException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class NotAcceptableExceptionMapper implements ExceptionMapper<NotAcceptableException> {
	@Override
	public Response toResponse(NotAcceptableException e) {
		ErrorMessage errorMessage = new ErrorMessage(406, e.getMessage());
		return Response.status((Response.Status) Response.Status.NOT_ACCEPTABLE).entity((Object) errorMessage).build();
	}
}