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
public class Euler001IsMultiplesTest {
	
    private Integer number;
    private Integer divider;
    private boolean expected;
    
    // constructor @RunWith Annotation uses to populate test data
    public Euler001IsMultiplesTest(Integer multiple1, Integer multiple2, boolean expected) {
		super();
		this.number = multiple1;
		this.divider = multiple2;
		this.expected = expected;
	}

	// creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        	{ 6, 3, true }, { 8, 5, false }, {0, 4, true }, { -12, 4, true }, { 5, 0, false } 
        }; 
        return Arrays.asList(data);
    }

	@Test
	public void shouldCheckExpectationForNumberModDivider() {
		assertEquals(expected, Euler001SumOfMultiples.isMultiple(number, divider));	
	}

}
