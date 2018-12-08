package nl.hkolvoort.api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONDeserializingErrorMapper implements ExceptionMapper<Exception> {
	
	@Override
	public Response toResponse(Exception ex) { 
	    return Response.status(400)
	             .entity("{\"error\": \"error deserializing. Make sure to provide int value. }")
	             .type(MediaType.APPLICATION_JSON)
	             .build();
	}
}
