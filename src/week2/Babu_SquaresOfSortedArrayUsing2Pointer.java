package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Babu_SquaresOfSortedArrayUsing2Pointer {

	/*
	 * 
	 * Given an integer array nums sorted in non-decreasing order,
	 * return an array of the squares of each number sorted in non-decreasing order.
	 *  
	 */

	@Test
	public void positive() {
		int[] nums= {1,2,3,4};
		int[] output= {1,4,9,16};
		Assert.assertTrue(Arrays.equals(output, squareSortedArray(nums)));
	}

	@Test
	public void edge() {
		int[] nums= {-4,-1,0,3,10};
		int[] output= {0,1,9,16,100};
		Assert.assertTrue(Arrays.equals(output, squareSortedArray(nums)));
	}

	@Test
	public void negative() {
		int[] nums= {};
		int[] output= {};
		Assert.assertTrue(Arrays.equals(output, squareSortedArray(nums)));
	}

	/*
	 * Pseudocode:
	 * 1) Take the given array
	 * 2) Loop through the given array using while loop bidirectional two pointer
	 * 3) Square each element
	 * 4) Compare the squares and place the biggest element first starting from reverse
	 * 5) Increment the right counter if right square is bigger and vice versa
	 * 6) Exit loop when left becomes equal to right
	 *  
	 */


	private int[] squareSortedArray(int[] nums) {
		int[] squared = new int[nums.length];
		int left = 0, right = nums.length - 1;
		int insertIndex = nums.length - 1;

		while (left <= right) {
			if (Math.abs(nums[left]) < Math.abs(nums[right]))
				squared[insertIndex--] = nums[right] * nums[right--];
			else
				squared[insertIndex--] = nums[left] * nums[left++];
		}
		return squared;
	}

}
