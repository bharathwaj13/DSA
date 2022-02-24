package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductDifferenceBetweenTwoPairs {

	/*
	 * 
	 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
	 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
	 * Given an integer array nums, choose four distinct indices w, x, y, and z such that the
	 * product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
	 * Return the maximum such product difference.
	 */


	@Test
	public void positive() {
		int[] nums= {5,6,2,7,4};
		int output=34;
		Assert.assertTrue(output==maxProductDifference(nums));
	}

	@Test
	public void edge() {
		int[] nums= {6,6,7,7,2,2,4,4};
		int output=45;
		Assert.assertTrue(output==maxProductDifference(nums));
	}


	/*
	 * 
	 * Pesudocode:
	 * 1) Take the given array
	 * 2) Calculate the size of the array. Return 0 if it is less than 4.
	 * 3) Sort the array.
	 * 4) Multiply the elements of the first 2 indices to get the least product.
	 * 5) Multiply the elements of the last indices to get the highest product.
	 * 6) Then subtract them to get the maximum product difference.
	 * 
	 */

	private int maxProductDifference(int[] nums) {
		Arrays.sort(nums);
		return ((nums[nums.length-1]*nums[nums.length-2])-(nums[0]*nums[1]));
	}
}
