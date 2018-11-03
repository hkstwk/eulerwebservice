package nl.kolvoort.euler.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import nl.hkolvoort.euler.Euler001SumOfMultiples;

@RunWith(Parameterized.class)
public class Euler001SumOfMultiplesTest2 {
	
    // fields used together with @Parameter must be public
    @Parameter(0)
    public Integer multiple1;
    @Parameter(1)
    public Integer multiple2;
    @Parameter(2)
    public Integer limit;
    @Parameter(3)
    public Integer expected;
    
    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        	{ 3 , 5, 10, 23 }, 
        	{ 3, 7, 25, 129 },
        	{ 4, 9, 30, 166 },
        	{ -3, -5, 10, 23}
        	};
        return Arrays.asList(data);
    }
	
	@Test
	public void shouldCalculateCorrectSumOfMultiples() {
				assertEquals(expected, Euler001SumOfMultiples.sumOfMultiples(multiple1, multiple2, limit));
	}
	
//	@Test(expected=ArithmeticException.class)
//	public void shouldThrowArithmaticException() {
//				assertEquals(expected, Euler001SumOfMultiples.sumOfMultiples(0, 3, 10));
//	}
}
