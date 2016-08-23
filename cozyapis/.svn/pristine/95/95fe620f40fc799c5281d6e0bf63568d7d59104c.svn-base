package in.cozynest.cozyapis.errorpage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import in.cozynest.cozyapis.exception.NotFoundException;


@Path("/ServerExceptions")
public class ServerException {
    
    @Path("/InvalidURL")
    @GET
    public Response invalidURL() {
        throw new NotFoundException("Invalid request");
    }
    
}