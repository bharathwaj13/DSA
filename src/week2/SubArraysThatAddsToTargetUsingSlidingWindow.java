package week2;

import org.junit.Test;

public class SubArraysThatAddsToTargetUsingSlidingWindow {

	/*
	 * 
	 * Given an array of positive integers, find the subarrays that adds up to the
	 *  given number (k)
	 *  
	 */

	@Test
	public void example1() {
		int[] nums = {1,7,4,3,1,2,1,5,1};
		int k = 7;
		findSubArrays(nums, k);
	}


	private void findSubArrays(int[] nums,int k) {
		int left=0,sum=0;
		for(int right=0;right<nums.length;right++) {
			sum+=nums[right];
			while(sum>k) {
				sum-=nums[left++];
			}
			if(sum==k) {
				System.out.println(left+" , "+right);
			}
		}


	}
}

