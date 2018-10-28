package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EulerValidationMessages {

	List<Euler001ValidationMessage>  validations;

	public EulerValidationMessages() {
		validations = new ArrayList<Euler001ValidationMessage>();
	}

	@XmlElement
	public List<Euler001ValidationMessage> getValidations() {
		return validations;
	}

	public void add(Euler001ValidationMessage euler001ValidationMessage) {
		validations.add(euler001ValidationMessage);
	}
}
