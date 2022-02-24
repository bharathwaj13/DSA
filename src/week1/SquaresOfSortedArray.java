package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SquaresOfSortedArray {

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
	 * 2) Loop through the given array and square each element
	 * 3) Sort the array after squaring
	 */


	private int[] squareSortedArray(int[] nums) {

		if(nums.length!=0) {
			for(int i=0;i<nums.length;i++) {
				nums[i]=nums[i]*nums[i];
			}
			Arrays.sort(nums);
		}

		return nums;
	}
}
