import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	
    }
    
    @Test
    public void insertionTest() {
    	double[] numbers = SortComparison.getDoubles("numbers10.txt");
    	assertFalse("Unordered 10 values", SortComparison.isOrdered(numbers));
    	numbers = SortComparison.insertionSort(numbers);
    	assertTrue("Ordered 10 values", SortComparison.isOrdered(numbers));
    }
    
    @Test
    public void selectionTest() {
    	double[] numbers = SortComparison.getDoubles("numbers10.txt");
    	assertFalse("Unordered 10 values", SortComparison.isOrdered(numbers));
    	numbers = SortComparison.selectionSort(numbers);
    	assertTrue("Ordered 10 values", SortComparison.isOrdered(numbers));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

