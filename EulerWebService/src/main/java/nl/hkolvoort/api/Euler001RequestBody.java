package nl.hkolvoort.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Euler001RequestBody {
	
	@Positive
	private int multiple1;
	
	@Positive
	private int multiple2;
	
	@Positive
	@Max(80265)
	private int limit;
	
	public Euler001RequestBody() {

	}
	
	public Euler001RequestBody(int multiple1, int multiple2, int limit) {
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
	}

	@XmlElement
	public Integer getMultiple1() {
		return multiple1;
	}

	public void setMultiple1(int multiple1) {
		this.multiple1 = multiple1;
	}

	@XmlElement
	public Integer getMultiple2() {
		return multiple2;
	}

	public void setMultiple2(int multiple2) {
		this.multiple2 = multiple2;
	}

	@XmlElement
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
