package week2;

import org.junit.Assert;
import org.junit.Test;

public class Arun_SubArraysThatAddsToTargetUsingSlidingWindow {


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

	//@Test
	public void example2() {
		int[] nums = {1,34,15,3,7,10};
		int k=3;
		int output=52;
		findSubArrays(nums, k);
		//Assert.assertTrue(output==maxSum(nums, k));
	}

	/*
	 * Pseudocode:
	 * 1) Add first k elements and have a sum
	 * 2) loop from k element until end 
	 * 		a) subtract the first element from the sum
	 * 		b) add the new element to the sum
	 * 		c) compare with existing sum --> whichever max --> make it max
	 */


	private void findSubArrays(int[] nums,int k) {
		int i=0,j=0,sum=0;

		while(j<=nums.length && i<=nums.length) {

			if (sum==k) {
				System.out.println((i)+" "+(j-1));
				sum=sum-nums[i++]+nums[j++];
			}
			else if(sum>k) {
				sum-=nums[i++];
			}
			else {
				sum+=nums[j++];
			}
		}
	}
}
