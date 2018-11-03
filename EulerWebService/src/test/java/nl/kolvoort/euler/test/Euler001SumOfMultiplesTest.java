package nl.kolvoort.euler.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.hkolvoort.euler.Euler001SumOfMultiples;

public class Euler001SumOfMultiplesTest {

	@Test(expected=ArithmeticException.class)
	public void should_ThrowException_When_DividerIsZero() {
		Euler001SumOfMultiples.isMultiple(3, 0);
	}
	
	@Test
	public void should_BeTrue_When_NumberSixDividerThree() {
		assertTrue(Euler001SumOfMultiples.isMultiple(6, 3));
	}
	
	@Test
	public void should_BeFalse_When_NumberEightDividerFive() {
		assertFalse(Euler001SumOfMultiples.isMultiple(8, 5));
	}

	@Test
	public void should_BeTrue_When_NumberZeroDividerFour() {
		assertTrue(Euler001SumOfMultiples.isMultiple(0, 4));
	}
	
	@Test
	public void should_BeTrue_When_NumberMinusTwelfDividerFour() {
		assertTrue(Euler001SumOfMultiples.isMultiple(-12, 4));
	}
}
