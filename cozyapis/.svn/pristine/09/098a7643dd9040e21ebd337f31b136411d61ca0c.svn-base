package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
	@Override
    public Response toResponse(NotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(404, e.getMessage());
        return Response.status((Response.Status)Response.Status.NOT_FOUND).entity((Object)errorMessage).build();
    }
}