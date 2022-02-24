package week4hw;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition_BinarySearch {

	/*
	 * Leetcode: 35
	 * 
	 * Given a sorted array of distinct integers and a target value, return the index
	 * if the target is found. If not, return the index where it would be if it were 
	 * inserted in order.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 */

	@Test
	public void example1() {
		int[] nums= {1,3,5,6};
		int target=5;
		int output=2;
		Assert.assertTrue(output==searchInsertPosition(nums, target));
	}

	@Test
	public void example2() {
		int[] nums= {1,3,5,6};
		int target=2;
		int output=1;
		Assert.assertTrue(output==searchInsertPosition(nums, target));
	}


	private int searchInsertPosition(int[] nums,int target) {

		int left=0, right=nums.length-1,mid=0;

		while(left<=right) {
			mid=(left+right)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]>target) right=mid-1;
			else left=mid+1;
		}
		System.out.println(left);
		return left;
	}


}
