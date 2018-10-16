package nl.hkolvoort.api;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
	public SimpleObject getSimpleObject2(@Valid SimpleObject simpleObj) {
		
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<SimpleObject>> violations = validator.validate(simpleObj);
	   
	   if  (violations.isEmpty()){
		   return new P001_SumOfMultiples(simpleObj.getMultiple1(),simpleObj.getMultiple2(),simpleObj.getLimit()).getEuler001();
	   		}	
	   else {
			   for (ConstraintViolation<SimpleObject> violation : violations) {
				    System.out.println(violation.getPropertyPath().toString() + " => " + violation.getMessage()); 
			}
			   return new SimpleObject();
	   }
	}
}
