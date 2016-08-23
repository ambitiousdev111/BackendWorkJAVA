package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.UnauthorizedException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class UnauthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {
    @Override
    public Response toResponse(UnauthorizedException e) {
        ErrorMessage errorMessage = new ErrorMessage(401, e.getMessage());
        return Response.status((Response.Status)Response.Status.UNAUTHORIZED).entity((Object)errorMessage).build();
    }
}