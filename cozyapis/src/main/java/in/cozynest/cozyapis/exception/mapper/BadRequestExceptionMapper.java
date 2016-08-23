package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.BadRequestException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException e) {
        ErrorMessage errorMessage = new ErrorMessage(400, e.getMessage());
        return Response.status((Response.Status)Response.Status.BAD_REQUEST).entity((Object)errorMessage).build();
    }
}