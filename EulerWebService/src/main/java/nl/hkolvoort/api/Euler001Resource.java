package nl.hkolvoort.api;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hkolvoort.euler.Euler001RequestBody;
import nl.hkolvoort.euler.Euler001ValidationMessage;
import nl.hkolvoort.euler.EulerValidations;
import nl.hkolvoort.euler.P001_SumOfMultiples;
import nl.hkolvoort.euler.SimpleObject;

@Path("/euler/1")
public class Euler001Resource extends Application{
	
/*	
 * URI: http://localhost:8080/EulerWebService/api/euler/1
 * sample json payload: {"multiple1":3, "multiple2":5,"limit":10}
 */
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSimpleObject2(Euler001RequestBody Euler001ReqBody) {
		
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Euler001RequestBody>> violations = validator.validate(Euler001ReqBody);
	   
	   if  (violations.isEmpty()){
		   SimpleObject resp = new P001_SumOfMultiples(Euler001ReqBody.getMultiple1(),Euler001ReqBody.getMultiple2(), Euler001ReqBody.getLimit()).getEuler001();
		   return Response.status(Response.Status.OK).entity(resp).build();
	   }	
	   else {
		   EulerValidations ev = new EulerValidations();
		   String errMsg = "";
		   for (ConstraintViolation<Euler001RequestBody> violation : violations) {
			   ev.add(new Euler001ValidationMessage(
					   		violation.getRootBeanClass().toString(),
					   		violation.getPropertyPath().toString(),
					   		violation.getInvalidValue().toString(),
					   		violation.getMessage().toString()
					   ));
			   errMsg += violation.getRootBeanClass().toString()
					   	+ " / " + violation.getPropertyPath().toString() 
					   	+ " / " + violation.getInvalidValue().toString() 
					   	+ " / " + violation.getMessage().toString()
					   	+ "\n";
		   }
		   return Response.status(Response.Status.BAD_REQUEST).entity(errMsg).build();
	   }
	}
}
