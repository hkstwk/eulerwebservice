package nl.hkolvoort.euler;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Harm Kolvoort
 * @date 14-11-2014
 * 
 * Problem 1: Multiples of 3 and 5
 * If we list all the natural numbers below 10 
 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

@XmlRootElement
public class P001_SumOfMultiples {
	private SimpleObject euler001;
	private Integer sum = 0;
	
	@Positive
	private Integer multiple1;
	private Integer multiple2;
	private Integer limit;
	
	public SimpleObject getEuler001() {
		return euler001;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getMultiple1() {
		return multiple1;
	}

	public void setMultiple1(Integer multiple1) {
		this.multiple1 = multiple1;
	}

	public Integer getMultiple2() {
		return multiple2;
	}

	public void setMultiple2(Integer multiple2) {
		this.multiple2 = multiple2;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * Constructor 1
	 */
	public P001_SumOfMultiples() {
		
	}
	
	/**
	 * Constructor 1
	 */
//	public P001_SumOfMultiples() {
//		this.sum = 0;
//	}
	
	/**
	 * Constructor 2
	 */
	public P001_SumOfMultiples(Integer multiple1, Integer multiple2, Integer limit) {
		this.euler001 = new SimpleObject(multiple1, multiple2, limit);
		this.sum = 0;
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
		this.sumOfMultiples();
		this.euler001.setSum(this.sum);
	}
	
	/**
	 * Returns true if number is a multiple of divider
	 * Example 1: 6 (number) is multiple of 3 (divider)
	 * Example 2: 8 (number) not multiple of 5 (divider)
	 * @param number
	 * @param divider
	 * @return
	 */
	private boolean isMultiple(Integer number, Integer divider) {
		if (number % divider == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Method to determine sum of multiples below (not including) limit
	 * @param multiple2
	 * @param limit
	 * @return
	 */
	private void sumOfMultiples() {
		this.sum = 0;		
		for (int i=1; i<limit; i++) {
			if (isMultiple(i,this.multiple1) || isMultiple(i,this.multiple2)){
				this.sum += i;
			}
		}
	}

}