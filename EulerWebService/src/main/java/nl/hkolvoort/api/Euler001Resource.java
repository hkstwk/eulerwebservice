package nl.hkolvoort.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import nl.hkolvoort.euler.P001_SumOfMultiples;
import nl.hkolvoort.euler.SimpleObject;

@Path("/euler/1")
public class Euler001Resource extends Application{
	
	// http://localhost:8080/EulerWebService/api/euler/1
	// sample json payload: {"multiple1":3, "multiple2":5,"limit":10}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	public SimpleObject getSimpleObject2(SimpleObject simpleObj) {
       return new P001_SumOfMultiples(simpleObj.getMultiple1(),simpleObj.getMultiple2(),simpleObj.getLimit()).getEuler001();
	}
}
