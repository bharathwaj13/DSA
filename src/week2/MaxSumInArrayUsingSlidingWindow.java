package week2;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumInArrayUsingSlidingWindow {

	/*
	 * Given an array of integers and a number k.
	 * Return the highest sum of any k consecutive elements in the array.
	 * 
	 */

	@Test
	public void example1() {
		int[] nums = {1,5,2,3,7,1};
		int k=3;
		int output=12;
		Assert.assertTrue(output==maxSum(nums, k));
	}
	
	@Test
	public void example2() {
		int[] nums = {1,34,15,3,7,10};
		int k=3;
		int output=52;
		Assert.assertTrue(output==maxSum(nums, k));
	}
	
	/*
	 * Pseudocode:
	 * 1) Add first k elements and have a sum
	 * 2) loop from k element until end 
	 * 		a) subtract the first element from the sum
	 * 		b) add the new element to the sum
	 * 		c) compare with existing sum --> whichever max --> make it max
	 */


	private int maxSum(int[] nums,int k) {
		int sum=0,left=0,right=k,max=0;
		for(int i=0;i<k;i++) {
			sum+=nums[i];
		}
		max=sum;
		while(right<nums.length) {
			sum+=nums[right]-nums[left];
			right++;
			left++;
			max=Math.max(sum, max);
		}

		return max;
	}
}
