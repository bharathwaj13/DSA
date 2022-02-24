package week2hw;

import org.junit.Assert;
import org.junit.Test;

public class MaxAvgSubArray1UsingSlidingWindow {

	/*
	 *
	 * You are given an integer array nums consisting of n elements, 
	 * and an integer k.Find a contiguous subarray whose length is equal to k
	 * that has the maximum average value and return this value.
	 * Any answer with a calculation error less than 10^-5 will be accepted
	 * 
	 */

	@Test
	public void example1() {
		int[] nums= {1,12,-5,-6,50,3};
		double output=12.75;
		int k=4;
		Assert.assertTrue(output==maxAvgSubArray(nums, k));
	}

	@Test
	public void example2() {
		int[] nums= {5};
		double output=5.00000;
		int k=1;
		Assert.assertTrue(output==maxAvgSubArray(nums, k));
	}


	/*
	 * 
	 * Pseudocode:
	 * 1) Using Sliding window technique ,slide through the given array 
	 * for a subarray of size k.
	 * 2) Find the sum for each subarray
	 * 3) If the sum is greater than Max then store the sum of the subarray
	 * 4) Calculate the average and return.
	 * 
	 */


	private double maxAvgSubArray(int[] nums,int k) {
		int sum=0,max=0;
		for(int i=0;i<k;i++) {
			sum+=nums[i];
		}
		max=sum;
		for(int i=k;i<nums.length;i++) {
			sum=sum-nums[i-k]+nums[i];
			max=Math.max(sum, max);
		}
		return (double)max/k;
	}

}
