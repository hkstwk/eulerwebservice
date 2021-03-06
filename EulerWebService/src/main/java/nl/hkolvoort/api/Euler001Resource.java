package nl.hkolvoort.api;

import java.util.Set;

/**
 * <h1>Webservice for calculating sum of multiples.</h1>
 * 
 * See https://projecteuler.net/problem=1
 * <p>
 * URI: http://localhost:8080/EulerWebService/api/euler/1 
 * sample json payload: {"multiple1":3, "multiple2":5,"limit":10}
 * 
 * @author 	Harm Kolvoort
 * @version 1.0
 * @since   November 2, 2018
 * 
 */

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

import nl.hkolvoort.euler.Euler001SumOfMultiples;
import nl.hkolvoort.euler.Euler001ValidationMessage;
import nl.hkolvoort.euler.EulerValidationMessages;

@Path("/euler/1")
public class Euler001Resource extends Application {
	
	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doEuler001(Euler001RequestBody Euler001ReqBody) {

		// Do validations
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Euler001RequestBody>> violations = validator.validate(Euler001ReqBody);

		// No violations found
		if (violations.isEmpty()) {
			// determine sum of multiples using input provided in Request Body
			Integer sum = Euler001SumOfMultiples.sumOfMultiples(
					Euler001ReqBody.getMultiple1(),
					Euler001ReqBody.getMultiple2(), 
					Euler001ReqBody.getLimit()
					);
			
			// Create response body
			Euler001ResponseBody resp = new Euler001ResponseBody(
					Euler001ReqBody.getMultiple1(),
					Euler001ReqBody.getMultiple2(), 
					Euler001ReqBody.getLimit(), 
					sum);

			return Response.status(Response.Status.OK).entity(resp).build();
		}
		
		// One or more violation found
		else {
			// create response body
			EulerValidationMessages ev = new EulerValidationMessages();
			for (ConstraintViolation<Euler001RequestBody> violation : violations) {
				ev.add(new Euler001ValidationMessage(
						violation.getRootBeanClass().toString(),
						violation.getPropertyPath().toString(), 
						violation.getInvalidValue().toString(),
						violation.getMessage().toString()
						));
			}

			return Response.status(Response.Status.BAD_REQUEST).entity(ev).build();
		}
	}
}
