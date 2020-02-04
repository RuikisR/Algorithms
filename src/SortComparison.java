import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */


class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	for (int i = 1; i < a.length; i++) {
    		int j = i;
    		while (j > 0 && a[j - 1] > a[j]) {
    			swap(a, j - 1, j);
    			j--;
    		}
    	}
    	return a;
    }

	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	return null;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	return null;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	return null;
    }



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	return null;
   }


    private static void swap(double[] a, int i, int j) {
    	double tmp = a[i];
    	a[i] = a[j];
    	a[j] = tmp;
    }
    
    public static boolean isOrdered(double[] a) {
    	for (int i = 1; i < a.length; i++) {
    		if (a[i] < a[i - 1]) {
    			return false; 
    		}
    	}
    	return true;
    }


    public static double[] getDoubles(String fileName) {
    	ArrayList<Double> doubles = new ArrayList<Double>();
    	try {
    		FileReader reader = new FileReader(fileName);
    		BufferedReader buffer = new BufferedReader(reader);
    		boolean end = false;
    		while (!end) {
    			String value = buffer.readLine();
    			if (value != null) {
    				doubles.add(Double.parseDouble(value));
    			}
    			else {
    				end = true;
    			}
    		}
    		buffer.close();
    		reader.close();
    	} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	double[] doublesA = new double[doubles.size()];
    	for (int i = 0; i < doubles.size(); i++) {
    		doublesA[i] = doubles.get(i);
    	}
    	return doublesA;
    }

    public static void main(String[] args) {

    }
}//end class

