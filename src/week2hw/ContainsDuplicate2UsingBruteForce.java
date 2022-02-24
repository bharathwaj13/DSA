package week2hw;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicate2UsingBruteForce {

	/*
	 * 
	 * Given an integer array nums and an integer k, return true if there are two
	 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
	 * - j) <= k.
	 * 
	 */

	@Test
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

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		boolean output = false;
		Assert.assertFalse(containsDuplicate(nums, k));
	}

	private boolean containsDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> subArray = new HashMap<Integer, Integer>();

		for(int i=0;i<nums.length;i++) { subArray.put(nums[i], i); }



		for(int i=0;i<nums.length-k;i++) {
			if(subArray.containsKey(nums[i])) {
				if(Math.abs(i-subArray.get(nums[i]))<=k && i-subArray.get(nums[i])!=0) return true; 
			} 
		}
		return false;

	}
}
