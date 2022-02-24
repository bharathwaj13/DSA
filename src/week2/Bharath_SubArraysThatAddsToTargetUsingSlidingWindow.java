package week2;

import org.junit.Test;

//Not Working

public class Bharath_SubArraysThatAddsToTargetUsingSlidingWindow {

	/*
	 * 
	 * Given an array of positive integers, find the subarrays that adds up to the
	 *  given number (k)
	 *  
	 */

	@Test
	public void example1() {
		int[] nums = {8,7,4,3,1,2,1,5,1};
		int k = 7;
		findSubArrays(nums, k);
	}




	private void findSubArrays(int[] nums,int k) {
		int left=0,right=0,sum=nums[left];
		while(right<=nums.length || left<=nums.length) {
			if(sum==k) {
				System.out.println(left+" , "+right);
				left++;
				right++;
				sum=0;
				if(right==nums.length) break;
//				else sum-=nums[left]+nums[right];
			}
			else if(sum>k) sum-=nums[left++];
			else {
				right++;
				if(right<=nums.length) sum+=nums[right];
				else break;
			}
		}

	}
}

