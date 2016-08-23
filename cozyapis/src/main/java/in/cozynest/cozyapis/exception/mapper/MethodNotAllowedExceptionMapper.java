package in.cozynest.cozyapis.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.MethodNotAllowedException;
import in.cozynest.cozyapis.utils.ErrorMessage;

@Provider
public class MethodNotAllowedExceptionMapper implements ExceptionMapper<MethodNotAllowedException> {
    @Override
    public Response toResponse(MethodNotAllowedException e) {
        ErrorMessage errorMessage = new ErrorMessage(405, e.getMessage());
        return Response.status((Response.Status)Response.Status.METHOD_NOT_ALLOWED).entity((Object)errorMessage).build();
    }
}