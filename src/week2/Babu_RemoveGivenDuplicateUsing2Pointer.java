package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Babu_RemoveGivenDuplicateUsing2Pointer {
	/*
	 * 
	 * Remove the given duplicate in the given array
	 *
	 */


	@Test // positive
	public void example1() {
		int[] nums = {5,3,2,1,2,3};
		int target =  3;
		int[] output= {5,2,1,2};
		Assert.assertTrue(Arrays.equals(output, removeElement(nums, target)));
	}

	@Test // negative
	public void example2() {
		int[] nums = {};
		int target =  3;
		int[] output= {};
		Assert.assertTrue(Arrays.equals(output, removeElement(nums, target)));

	}

	/*
	 * 
	 * Pseudocode:
	 * 
	 * 1) Take the given array
	 * 2) Using 2 pointer traverse from left and right to check if element is equal to given target
	 * 3) If the element is equal, then add it to an ArrayList and increment the left pointer
	 * and decrement the right pointer
	 */

	// Single pass
	// Time Complexity : O(n)
	// Space Complexity : You need measure --> new memory !!
	// O(1) + O(1) + O(n) --> O(n)

	/*
	 * Time Complexity --> Execution iterations / time  --> CPU  !!
	 * Space Complexity --> Number of variables / data created --> Memory
	 * 
	 */


	private int[] removeElement(int[] nums,int target) {

		int left = 0;
		for (int right = 0; right < nums.length; right++)
			if(nums[right] != target) nums[left++] = nums[right];
		System.out.println(Arrays.toString(Arrays.copyOf(nums, left)));
		return Arrays.copyOf(nums, left);

	}

}
