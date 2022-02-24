package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchUsingRecursion {

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
		int start=0;
		int end=nums.length-1;
		Assert.assertTrue(performBinarySearch(nums, target,start,end));
	}


	public void negative() {
		int[] nums= {1,3,4,5,6,7,8,8,9,45};
		int target=2;
		int start=0;
		int end=nums.length-1;
		Assert.assertFalse(performBinarySearch(nums, target,start,end));
	}


	public boolean performBinarySearch(int[] nums,int target,int start,int end) {
		int midIndex=(int)(Math.floor((start+end)/2));
		if(start>end) return false;
		if(nums[midIndex]==target) return true;
		else if(nums[midIndex]>target){
			end=midIndex-1;
			return performBinarySearch(nums, target, start, end);
		}
		else {
			start=midIndex+1;
			return performBinarySearch(nums, target, start, end);
		}
	}


}
