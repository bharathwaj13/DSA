package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class MoveZero {


	/*
	 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	 * 
	 */

	@Test
	public void positive() {
		int[] nums= {0,1,0,3,12};
		int[] output= {1,3,12,0,0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}

	@Test
	public void edge() {
		int[] nums= {-1,-3,3,4,5};
		int[] output= {-1,-3,3,4,5};
		Assert.assertTrue(Arrays.equals(output,moveZero(nums)));
	}

	@Test
	public void negative() {
		int[] nums= {0};
		int[] output= {0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}

	/*Pseudocode
	 * 
	 * 1) Take the given array
	 * 2) Loop through the given array and check if any element n is nonzero
	 * 3) If Yes, then increment counter and fill out the array from the start
	 * 4) After the loop, start another for loop for counter length and fill zeros from
	 * the end of the array
	 * 5) Verify output
	 */


	private int[] moveZero(int[] nums) {
		int counter=0;

		if(nums.length==1) return nums;

		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[counter]=nums[i];
				counter++;
			}
		}

		if(counter==nums.length)
			return nums;
		else {
			for(int i=counter;i<nums.length;i++) {
				nums[i]=0;
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
