package week2hw;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class Arun_ContainsDuplicate2 {

	/*
	 * 
	 * Given an integer array nums and an integer k, return true if there are two
	 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
	 * - j) <= k.
	 * 
	 */

	//@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;
		boolean output = true;
		Assert.assertTrue(containsDuplicate(nums, k));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 0, 1, 1 };
		int k = 1;
		boolean output = true;
		Assert.assertTrue(containsDuplicate(nums, k));
	}

	//@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		boolean output = false;
		Assert.assertFalse(containsDuplicate(nums, k));
	}

	private boolean containsDuplicate(int[] nums, int k) {
		int i=0,j=1;
		Boolean result=false;
		while (nums[i]!=nums[j]) {//&& Math.abs(nums[i]-nums[j])<=k) {
			if (j<nums.length)j++;
			if(nums[i]==nums[j]&& Math.abs(i-j)<=k) result= true;
			else if(nums[i]==nums[j]&& !(Math.abs(i-j)<=k))	{
				if (j<nums.length-2)i++;
				else return result;
				if (j<nums.length)j=i+1;
			}
		}
		return result;
	}
}
