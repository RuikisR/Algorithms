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

/*	Runtime Tests for various Array scenarios (Recorded in Microseconds)
 * 
 * 							Insert		Selection		Merge (Recursive)		Merge (Iterative)		Quick
 * 10 Random				    2		     3				    6						  4					 3
 * 100 Random				  138		    84				   61						 22					24
 * 1000 Random				 5932		  3680				  821						345				   433
 * 1000 Few Unique			 1060		  2012				  196						155				   214
 * 1000 Nearly Ordered		  161		   659				  149						150				   141
 * 1000 Reverse Order		 3497		  1822				  200						 99				  1840
 * 1000 Sorted				    2		   333				  133						102				   633
 * 10000 Random				42122		 33564				 2443					   1893				   737
 * 10000 Few Unique			42170		 32366				 5297					   1661				   786
 * 10000 Nearly Ordered		 5988		 33708				 1673					   1559				   612
 * 10000 Reverse Order		90265		 40423				  684					   1112				 53103
 * 10000 Sorted				   16		 33485				  748					   1277				 74829
 * 100000 Random		  4364672	   3228129	 			18796					  18971				 10193
 * 
 * 	A) The effectiveness of all these algorithms is affected by the order of the input:
 * 			Insertion: Already sorted arrays are ideal, while reverse sorted arrays give the worst case
 * 			Selection: Same as Insertion
 * 			Merge (Both): Better with a partially sorted array
 * 			Quick: Best on average but terrible with the array sorted or reverse sorted
 * 
 * 	B) Insertion sort performs poorly with large unsorted arrays but quickly handles near sorted array
 * 	C) Quick Sort seems to scale the best to larger inputs
 *  D) In general the iterative version appears to work better on smaller inputs and randomised ones, while they 
 *  		perform near identically at large inputs with the exception of recursive working better for arrays
 *  		already in some order.
 *  E)  1. Insertion
 *  	2. Iterative Merge
 *  	3. Iterative Merge
 *  	4. Iterative Merge
 *  	5. Quick
 *  	6. Iterative Merge
 *  	7. Insertion
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
    	double[] empty = {};
    	assertTrue("Empty is sorted", SortComparison.isOrdered(empty));
    	SortComparison.insertionSort(empty);
    	SortComparison.selectionSort(empty);
    	SortComparison.mergeSortRecursive(empty);
    	SortComparison.mergeSortIterative(empty);
    	SortComparison.quickSort(empty);
    	double[] fail = SortComparison.getDoubles("NA");
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
    
    @Test
    public void mergeRecursiveTest() {
    	double[] numbers = SortComparison.getDoubles("numbers10.txt");
    	assertFalse("Unordered 10 values", SortComparison.isOrdered(numbers));
    	numbers = SortComparison.mergeSortRecursive(numbers);
    	assertTrue("Ordered 10 values", SortComparison.isOrdered(numbers));
    }
    
    @Test
    public void mergeIterativeTest() {
    	double[] numbers = SortComparison.getDoubles("numbers10.txt");
    	assertFalse("Unordered 10 values", SortComparison.isOrdered(numbers));
    	numbers = SortComparison.mergeSortIterative(numbers);
    	assertTrue("Ordered 10 values", SortComparison.isOrdered(numbers));
    }
    
    @Test
    public void quickTest() {
    	double[] numbers = SortComparison.getDoubles("numbers10.txt");
    	assertFalse("Unordered 10 values", SortComparison.isOrdered(numbers));
    	numbers = SortComparison.quickSort(numbers);
    	assertTrue("Ordered 10 values", SortComparison.isOrdered(numbers));
    }
    
    @Test
    public void runtimeTests() {
    	main(null);
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) {
        String[] files = {"numbers10.txt",
        				  "numbers100.txt",
        				  "numbers1000.txt",
        				  "numbers1000Duplicates.txt",
        				  "numbersNearlyOrdered1000.txt",
        				  "numbersReverse1000.txt",
        				  "numbersSorted1000.txt",
        				  "numbers10000.txt",
        				  "numbers10000Duplicates.txt",
        				  "resNearlyOrdered10000.txt",
        				  "numbersReverse10000.txt",
        				  "numbersSorted10000.txt",
        				  "numbers100000.txt"};
        
        for (int i = 0; i < files.length; i++) {
        	double[] doubles = SortComparison.getDoubles(files[i]);
        	long start = System.nanoTime();
        	SortComparison.insertionSort(doubles);
        	long end = System.nanoTime();
        	System.out.println("Insersion on " + files[i] + ": " + (end - start) + " nanoseconds, " 
        					   + ((end - start) / 1000) + " microseconds");
        }
        for (int i = 0; i < files.length; i++) {
        	double[] doubles = SortComparison.getDoubles(files[i]);
        	long start = System.nanoTime();
        	SortComparison.selectionSort(doubles);
        	long end = System.nanoTime();
        	System.out.println("Selection on " + files[i] + ": " + (end - start) + " nanoseconds, " 
        					   + ((end - start) / 1000) + " microseconds");
        }
        for (int i = 0; i < files.length; i++) {
        	double[] doubles = SortComparison.getDoubles(files[i]);
        	long start = System.nanoTime();
        	SortComparison.mergeSortRecursive(doubles);
        	long end = System.nanoTime();
        	System.out.println("Merge (Recur) on " + files[i] + ": " + (end - start) + " nanoseconds, " 
        					   + ((end - start) / 1000) + " microseconds");
        }
        for (int i = 0; i < files.length; i++) {
        	double[] doubles = SortComparison.getDoubles(files[i]);
        	long start = System.nanoTime();
        	SortComparison.mergeSortIterative(doubles);
        	long end = System.nanoTime();
        	System.out.println("Merge (Iter) on " + files[i] + ": " + (end - start) + " nanoseconds, " 
        					   + ((end - start) / 1000) + " microseconds");
        }
        for (int i = 0; i < files.length; i++) {
        	double[] doubles = SortComparison.getDoubles(files[i]);
        	long start = System.nanoTime();
        	SortComparison.quickSort(doubles);
        	long end = System.nanoTime();
        	System.out.println("Quick on " + files[i] + ": " + (end - start) + " nanoseconds, " 
        					   + ((end - start) / 1000) + " microseconds");
        }
    }  
}

