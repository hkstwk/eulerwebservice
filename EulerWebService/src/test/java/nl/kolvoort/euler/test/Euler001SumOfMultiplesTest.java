package nl.kolvoort.euler.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import nl.hkolvoort.euler.Euler001SumOfMultiples;

@RunWith(Parameterized.class)
public class Euler001SumOfMultiplesTest {
	
    private Integer multiple1;
    private Integer multiple2;
    private Integer limit;
    private Integer expected;
    
    public Euler001SumOfMultiplesTest(Integer multiple1, Integer multiple2, Integer limit, Integer expected) {
		super();
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
		this.expected = expected;
	}

	// creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        	{ 3 , 5, 10, 23 }, 
        	{ 3, 7, 25, 129 },
        	{ 4, 9, 30, 166 },
        	{ 3, 5, 16, 60}
        	};
        return Arrays.asList(data);
    }
	
	@Test
	public void shouldCalculateCorrectSumOfMultiples() {
				assertEquals(expected, Euler001SumOfMultiples.sumOfMultiples(multiple1, multiple2, limit));
	}
}
