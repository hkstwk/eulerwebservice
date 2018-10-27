package nl.hkolvoort.euler;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Euler001ValidationMessage {

	private String rootBeanClass;
	private String propertyPath;
	private String inValidValue;
	private String message;
	
	public Euler001ValidationMessage() {
		super();
	}
	
	public Euler001ValidationMessage(String rbc, String pp, String iv, String m) {
		super();
		this.rootBeanClass = rbc;
		this.propertyPath = pp;
		this.inValidValue = iv;
		this.message = m;
	}

	@XmlElement
	public String getRootBeanClass() {
		return rootBeanClass;
	}
	
	public void setRootBeanClass(String rootBeanClass) {
		this.rootBeanClass = rootBeanClass;
	}
	
	@XmlElement
	public String getPropertyPath() {
		return propertyPath;
	}
	
	public void setPropertyPath(String propertyPath) {
		this.propertyPath = propertyPath;
	}
	
	@XmlElement
	public String getInValidValue() {
		return inValidValue;
	}
	
	public void setInValidValue(String inValidValue) {
		this.inValidValue = inValidValue;
	}
	
	@XmlElement
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.getRootBeanClass().toString()
			+ " / " + this.getPropertyPath().toString() 
			+ " / " + this.getInValidValue().toString() 
			+ " / " + this.getMessage().toString()
			+ "\n";
	}
	
}
