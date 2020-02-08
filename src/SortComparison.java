import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    	for (int i = 0; i < a.length - 1; i++) {
    		int lo = i;
    		for (int j = i + 1; j < a.length; j++) {
    			if (a[j] < a[lo]) {
    				lo = j;
    			}
    		}
    		swap(a, i, lo);
    	}
    	return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	quickSort(a, 0, a.length - 1);
    	return a;
    }
    
    private static void quickSort(double[] a, int l, int r) {
    	if (l < r) {
    		int p = partition(a, l, r);
    		quickSort(a, l, p - 1);
    		quickSort(a, p + 1, r);
    	}
    }
    
    private static int partition(double[] a, int l, int r) {
    	double p = a[r];
    	int i = l - 1;
    	for (int j = l; j < r; j++) {
    		if (a[j] < p) {
    			swap(a, ++i, j);
    		}
    	}
    	swap(a, i + 1, r);
    	return i + 1;
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
    	int n = a.length;
    	for (int m = 1; m <= n - 1; m *= 2) {
    		for (int l = 0; l < n - 1; l += 2 * m) {
    			int mid = Integer.min(l + m - 1, n - 1);
    			int r = Integer.min(l + 2 * m - 1, n - 1);
    			merge(a, l, mid, r);
    		}
    	}
    	return a;
    }



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	mergeSortRecursive(a, 0, a.length - 1);
    	return a;
   }
    
    private static void mergeSortRecursive(double[] a, int l, int r) {
    	if (l < r) {
    		int m = (l + r) / 2;
    		
    		mergeSortRecursive(a, l, m);
    		mergeSortRecursive(a, m + 1, r);
    		
    		merge(a, l, m, r);
    	}
    }
    
    
    private static void merge(double[] a, int l, int m, int r) {
    	int n1 = m - l + 1;
    	int n2 = r - m;
    	
    	double[] L = new double[n1];
    	double[] R = new double[n2];
    	
    	for (int i = 0; i < n1; ++i) {
    		L[i] = a[l + i];
    	}
    	for (int j = 0; j < n2; ++j) {
    		R[j] = a[m + 1 + j];
    	}
    	
    	int i = 0, j = 0, k = l;
 
    	while (i < n1 && j < n2) {
    		if (L[i] <= R[j]) {
    			a[k++] = L[i++];
    		}
    		else {
    			a[k++] = R[j++];
    		}
    	}
    	while (i < n1) {
    		a[k++] = L[i++];
    	}
    	while (j < n2) {
    		a[k++] = R[j++];
    	}
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
    	} catch (FileNotFoundException e) {} 
    	  catch (IOException e) {}
    	double[] doublesA = new double[doubles.size()];
    	for (int i = 0; i < doubles.size(); i++) {
    		doublesA[i] = doubles.get(i);
    	}
    	return doublesA;
    }

    public static void main(String[] args) {

    }
}//end class

