package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesLeetcode {

	/*
	 * 
	 * Given an integer array nums sorted in non-decreasing order, 
	 * remove the duplicates in-place such that each unique element appears only once.
	 * The relative order of the elements should be kept the same.
	 * Since it is impossible to change the length of the array in some languages,
	 * you must instead have the result be placed in the first part of the array nums.
	 * More formally, if there are k elements after removing the duplicates, then the
	 * first k elements of nums should hold the final result. It does not matter what
	 * you leave beyond the first k elements.
	 * Return k after placing the final result in the first k slots of nums.
	 * Do not allocate extra space for another array. You must do this by modifying
	 *  the input array in-place with O(1) extra memory.
	 *  
	 *  Custom Judge:
	 *  The judge will test your solution with the following code:
	 *  
	 *  int[] nums = [...]; // Input array
	 *  int[] expectedNums = [...]; // The expected answer with correct length
	 *  int k = removeDuplicates(nums); // Calls your implementation
	 *  
	 *  assert k == expectedNums.length;
	 *  for (int i = 0; i < k; i++) {
	 *  	assert nums[i] == expectedNums[i];
	 *  }
	 *  
	 *  If all assertions pass, then your solution will be accepted.
	 */


	int counter=0;


	@Test
	public void positive() { 

		int[] nums= {0,0,1,1,1,2,2,3,3,4};
		int[] output= {0,1,2,3,4,2,2,3,3,4}; 
		int target=5; 
		Assert.assertTrue(Arrays.equals(output, removeDuplicates(nums)));
	}

	/*public void edge() { int[] nums= {0,0,0,0,0,0}; int[] output= {0,0,0,0,0,0};
	  int target=0;

	 * }
	 * 
	 * public void negative() { int[] nums= {1,2,3,4,5,6,7}; int[] output=
	 * {1,2,3,4,5,6,7}; int target=7; }
	 */

	/*
	 * Pseudocode:
	 * 1) Take the given array
	 * 2) Loop through the given array using Nested for Loop.
	 * 3) Add the unique element to a String for verifying further duplicates and 
	 *  also add it to the same array starting from 0(counter) index
	 * 4) Increment the counter index
	 * 5) For every element, check if already present in String. If not add in String 
	 * and Array and increment the counter
	 * 6) Return the counter and array 
	 * 
	 */


	private int[] removeDuplicates(int[] nums) {
		String uniqueElements="";
		for(int i=0;i<nums.length;i++) {
			if(!uniqueElements.contains(nums[i]+"")) {
				nums[counter]=nums[i];
				uniqueElements=uniqueElements+nums[i];
				counter++;
			}
		}
		return nums;
	}


}
