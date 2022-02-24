package week2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayIntersectionUsing2Pointer {

	/*
	 * 
	 * Given 2 int Sorted Arrays print the intersection elements of the arrays
	 * 
	 */

	@Test
	public void example1() {
		int[] arr1= {1,2,3,4,5,6,49,56};
		int[] arr2= {2,34,45,56,56};
		int[] output= {2,56};
		arrayIntersection(arr1, arr2);
	}
	
	@Test
	public void example2() {
		int[] arr1= {1,2,3,4,5,6,49,56};
		int[] arr2= {34,45};
		int[] output= {};
		arrayIntersection(arr1, arr2);
	}
	
	@Test
	public void example3() {
		int[] arr1= {1,2,3,4,5,6,49,56};
		int[] arr2= {1,2,3,4,5,6,49,56};
		int[] output= {1,2,3,4,5,6,49,56};
		arrayIntersection(arr1, arr2);
	}




	/*
	 * Pseudocode:
	 * 1) Take the given arrays
	 * 2) Using Two Pointer, set array1 with left pointer and array2 with right pointer
	 * 3) Loop through until left and right pointers are less than their corresponding array lengths
	 * 4) If the values are same then add to Target array and increment both the pointers
	 * 5) If the value of left pointer is less than the value of right pointer, then increment left pointer
	 * 6) If the value of right pointer is less than the value of less pointer, then increment right pointer
	 * 
	 * 
	 */


	private void arrayIntersection(int[] arr1,int[] arr2) {
		int left=0,right=0;
		while(left<arr1.length && right<arr2.length) {
			if(arr1[left]==arr2[right]) {
				System.out.print(arr1[left]+" ");
				left++;
				right++;
			}
			else if(arr1[left]<arr2[right]) left++;
			else right++;
		}
	}

}
