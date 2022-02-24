package week3;



import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicate2_UsingHashSet {

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
	
	@Test
	public void example4() {
		int[] nums = { 0,1,2,3,2,5};
		int k = 3;
		boolean output = true;
		Assert.assertTrue(containsDuplicate(nums, k));
	}

	private boolean containsDuplicate(int[] nums, int k) {
		if (nums.length<=1)return false;
		HashSet<Integer> windowSet=new HashSet<Integer>();
		int left=0,right=0;
		while(right<nums.length) {
			if(windowSet.add(nums[right]))right++;
			else {
				if (Math.abs(right-left)<=k)return true;
				else {
					right = ++left;
					windowSet.clear();
				}
			}
		}
		return false;
	}
}
