package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EulerValidations {

	List<Euler001ValidationMessage>  validations;

	public EulerValidations() {
		validations = new ArrayList<Euler001ValidationMessage>();
	}

	@XmlElement
	public List<Euler001ValidationMessage> getValidations() {
		return validations;
	}

	public void setValidations(List<Euler001ValidationMessage> validations) {
		this.validations = validations;
	}

	public void add(Euler001ValidationMessage euler001ValidationMessage) {
		validations.add(euler001ValidationMessage);
	}
	
	@Override
	public String toString() {
		Iterator<Euler001ValidationMessage> iterator = this.validations.iterator();
		String str = "";
		while (iterator.hasNext()){
			iterator.next();
			str += iterator.toString();
		}
		return str;
	}
}
