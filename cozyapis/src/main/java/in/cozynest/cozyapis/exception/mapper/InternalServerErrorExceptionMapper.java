package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class InternalServerErrorExceptionMapper implements ExceptionMapper<InternalServerErrorException> {
	@Override
	public Response toResponse(InternalServerErrorException e) {
		ErrorMessage errorMessage = new ErrorMessage(500, e.getMessage());
		return Response.status((Response.Status) Response.Status.INTERNAL_SERVER_ERROR).entity((Object) errorMessage)
				.build();
	}
}