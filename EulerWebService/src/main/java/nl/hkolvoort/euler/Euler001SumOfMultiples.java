package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @version %I%, %G%
 * @date 14-11-2014
 * 
 * Inspired by https://projecteuler.net/ 
 * 
 * Problem 1: Multiples of 3 and 5
 * If we list all the natural numbers below 10 
 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

public class Euler001SumOfMultiples {
	
	/** 
	 * Static method that returns true if number is a multiple of divider
	 * Example 1: 6 (number) is multiple of 3 (divider)
	 * Example 2: 8 (number) not multiple of 5 (divider)
	 * @param number
	 * @param divider
	 * @return boolean
	 */
	public static boolean isMultiple(Integer number, Integer divider) {
		if (number % divider == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Static method to determine sum of multiples below (not including) limit
	 * 
	 * Problem 1: Multiples of 3 and 5
	 * If we list all the natural numbers below 16
	 * that are multiples of 3 or 5, we get 3, 5, 6, 9, 10, 12 and 15. 
	 * The sum of these multiples is 60.
	 * Mind that 15 is both multiple of 3 and 5, but is only added to sum once
	 * 
	 * @param multiple1
	 * @param multiple2
	 * @param limit
	 * @return Integer
	 */
	public static Integer sumOfMultiples(Integer multiple1, Integer multiple2, Integer limit) {
		Integer sum = 0;		
		for (int naturalNumber=1; naturalNumber<limit; naturalNumber++) {
			if (Euler001SumOfMultiples.isMultiple(naturalNumber,multiple1) || Euler001SumOfMultiples.isMultiple(naturalNumber,multiple2)){
				sum += naturalNumber;
			}
		}
		return sum;
	}

}