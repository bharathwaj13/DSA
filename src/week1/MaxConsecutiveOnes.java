package week1;

import org.junit.Assert;
import org.junit.Test;


public class MaxConsecutiveOnes {

	/*
	 * 
	 * Given a binary array nums, return the maximum number of consecutive 1's 
	 * in the array.
	 * 
	 */

	@Test
	public void positive() {
		int[] nums= {1,1,0,1,1,1};
		int output=3;	
		Assert.assertTrue(output==maxConsecutiveOnes(nums));
	}

	@Test
	public void edge() {
		int[] nums= {1,1,1,1,1,1};
		int output=6;
		Assert.assertTrue(output==maxConsecutiveOnes(nums));
	}

	@Test
	public void negative() {
		int[] nums= {0,0,0,0};
		int output=0;
		Assert.assertTrue(output==maxConsecutiveOnes(nums));
	}

	/*Pseudocode
	 * 
	 * 1) Take the given array
	 * 2) Loop through the array and check if value is equal to 1
	 * 3) If yes, then add counter
	 * 4) Assign max as counter if counter is greater than max
	 * 5) Else condition, repeat step 4.
	 */

	private int maxConsecutiveOnes(int[] nums) {
		int maxOnes=0;
		int counter=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) { counter++;
			maxOnes=(counter>maxOnes)? counter:maxOnes;
			}
			else {
				counter=0;
			}
		}
		return maxOnes;
	}

}
