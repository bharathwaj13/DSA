package week1;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ThirdMaximumNumber {

	/*
	 * 
	 * Given an integer array nums, return the third distinct maximum number in this array.
	 * If the third maximum does not exist, return the maximum number.
	 * 
	 */

	@Test
	public void positive() {
		int[] nums= {1,2,3};
		int output=1;
		Assert.assertTrue(output==thirdMaximumNumber(nums));
	}

	@Test
	public void edge() {
		int[] nums= {1,2,2,3};
		int output=1;
		Assert.assertTrue(output==thirdMaximumNumber(nums));
	}

	@Test
	public void negative() {
		int[] nums= {45,2};
		int output=45;
		Assert.assertTrue(output==thirdMaximumNumber(nums));
	}

	/*
	 * Pseudocode:
	 * 
	 * 1) Given an integer array
	 * 2) Sort the array in descending order
	 * 3) Loop through the given array until you reach the third distinct max number
	 * 4) If present return it, else return the maximum number
	 */


	private int thirdMaximumNumber(int[] nums) {
		Arrays.sort(nums);
		int tempMax=nums[nums.length-1];
		int counter=0;
		for(int i=nums.length-1;i>=0;i--) {
			if(tempMax>nums[i]) {
				tempMax=nums[i];
				counter++;
			}
			if(counter==2) {
				break;
			}
		}
		if(counter==2) return tempMax;
		else return nums[nums.length-1];

	}
}
