package week1;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

	/*
	 * 
	 * This search can be used only when the array is sorted. 
	 * To find whether an element is present in an array
	 * 
	 */

	@Test
	public void positive() {
		int[] nums= {1,3,4,5,6,7,8,8,9,45};
		int target=45;
		Assert.assertTrue(performBinarySearch(nums, target));
	}

	@Test
	public void negative() {
		int[] nums= {1,3,4,5,6,7,8,8,9,45};
		int target=2;
		Assert.assertFalse(performBinarySearch(nums, target));
	}


	public boolean performBinarySearch(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		int midIndex=(int) (Math.floor((start+end)/2));
		while(start<=end) {
			if(nums[midIndex]==target) return true;
			else if(nums[midIndex]>target){
				end=midIndex-1;
				midIndex=(int)(Math.floor((start+end)/2));
			}
			else {
				start=midIndex+1;
				midIndex=(int)(Math.floor((start+end)/2));
			}
		}
		return false;
	}


}
