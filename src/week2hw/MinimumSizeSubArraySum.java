package week2hw;

import org.junit.Test;

public class MinimumSizeSubArraySum {

	/*
	 * 
	 * Given an array of positive integers nums and a positive integer target,
	 * return the minimal length of a contiguous subarray 
	 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or
	 *  equal to target. If there is no such subarray, return 0 instead
	 *  
	 */


	@Test
	public void example1() {
		int[] nums= {2,3,1,2,4,3};
		int target=7;
		int output=2;
	}

	@Test
	public void example2() {
		int[] nums= {1,4,4};
		int target=4;
		int output=1;
	}

	@Test
	public void example3() {
		int[] nums= {1,1,1,1,1,1,1,1};
		int target=11;
		int output=0;
	}



	private int minSizeSubArraySum(int[] nums,int target) {
		int left=0,minSubArray=Integer.MAX_VALUE,sum=0;
		boolean bFlag=false;
		for(int right=1;right<nums.length;right++) {
			sum+=nums[right];
			while(sum>target) sum-=nums[left++];
			if(sum==target) {
				bFlag=true;
				minSubArray=Math.min(minSubArray, right-left+1);
				if(minSubArray==1) return 1;
			}
		}
		if(!bFlag) return 0;
		else return minSubArray;
	}
}
