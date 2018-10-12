package nl.hkolvoort.api;



import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import nl.hkolvoort.euler.P001_SumOfMultiples;
import nl.hkolvoort.euler.SimpleObject;

@Path("/api")
@ApplicationPath("/resources")
public class RestService extends Application{
	
	// http://localhost:8080/RestExample/resources/MyRestService/sayHello
	@GET
	@Path("/sayHello")
	public String getHelloMsg() {
		return "yeah it works!! Phew!";
	}

	// http://localhost:8080/RestExample/resources/MyRestService/euler/1?multipleA=3&multipleB=5&limit=10000
	@GET
	@Path("/euler/1")
	public String getSumOfMultiples(
			@QueryParam("multipleA") int multipleA,
			@QueryParam("multipleB") int multipleB,
			@QueryParam("limit")     int limit){
		
		P001_SumOfMultiples som = new P001_SumOfMultiples(multipleA,multipleB,limit);
		return som.getSum().toString() + " " + new Date().toString();
	}
	
	// http://localhost:8080/RestExample/resources/MyRestService/euler/11?multipleA=3&multipleB=5&limit=10000
	@GET
	@Path("/euler/11")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleObject getSimpleObject(
			@QueryParam("multipleA") int multipleA,
			@QueryParam("multipleB") int multipleB,
			@QueryParam("limit")     int limit){
       return new P001_SumOfMultiples(multipleA,multipleB,limit).getEuler001();
	}
	
	// http://localhost:8080/RestExample/resources/MyRestService/euler/11
	@POST
	@Path("/euler/12")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	public SimpleObject getSimpleObject2(SimpleObject simpleObj) {
       return new P001_SumOfMultiples(simpleObj.getMultiple1(),simpleObj.getMultiple2(),simpleObj.getLimit()).getEuler001();
	}
}
