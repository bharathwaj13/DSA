package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MoveZerosUsing2Pointer {

	/*
	 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	 * 
	 */

	@Test
	public void positive1() {
		int[] nums= {0,1,0,3,12};
		int[] output= {1,3,12,0,0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}

	//@Test
	public void positive2() {
		int[] nums= {1,0,0,3,12,0};
		int[] output= {1,3,12,0,0,0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}
	
	//@Test
	public void positive3() {
		int[] nums= {1,3,0,3,12,0};
		int[] output= {1,3,3,12,0,0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}

	//@Test
	public void edge() {
		int[] nums= {-1,-3,3,4,5};
		int[] output= {-1,-3,3,4,5};
		Assert.assertTrue(Arrays.equals(output,moveZero(nums)));
	}

	//@Test
	public void negative() {
		int[] nums= {0};
		int[] output= {0};
		Assert.assertTrue(Arrays.equals(output, moveZero(nums)));
	}

	/*
	 * 
	 * Pseudocode:
	 * 1) Take the given array
	 * 2) Both pointers start from 0.
	 * 3) Loop through using while until right pointer is lesser than the array's length
	 * 4) Check if the value of the right pointer is non-zero
	 * 5) If yes then swap the values of left and right pointers and increment them by one
	 * 6) Else increment the right pointer alone by one
	 */


	public int[] moveZero(int[] nums) {
		int left=0,right=0,temp=0;;
		while(right<nums.length) {
			if(nums[right]!=0) {
				temp=nums[left];
				nums[left++]=nums[right];
				nums[right++]=temp;
			}
			else right++;
			System.out.println(Arrays.toString(nums));
		}
		//System.out.println(Arrays.toString(nums));
		return nums;
	}
}
