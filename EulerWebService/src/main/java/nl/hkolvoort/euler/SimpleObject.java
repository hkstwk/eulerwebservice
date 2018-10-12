package nl.hkolvoort.euler;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleObject {
	private int sum;
	private int multiple1;
	private int multiple2;
	private int limit;
	
	public SimpleObject() {
		
	}
	
	public SimpleObject(int multiple1, int multiple2, int limit) {
		this.sum = 0;
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
	}
	
	@XmlElement
	public Integer getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
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
