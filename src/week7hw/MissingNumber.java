package week7hw;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumber {
	
	
	/*
	 * Leetcode: 268
	 * 
	 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
	 * that is missing from the array
	 * 
	 */
	
	@Test
	public void example1() {
		int[] nums= {3,0,1};
		int output=2;
		Assert.assertTrue(output==findMissingNumber(nums));
	}
	
	@Test
	public void example2() {
		int[] nums= {0,1};
		int output=2;
		Assert.assertTrue(output==findMissingNumber(nums));
	}
	
	@Test
	public void example3() {
		int[] nums= {9,6,4,2,3,5,7,0,1};
		int output=8;
		Assert.assertTrue(output==findMissingNumber(nums));
	}
	
	
	
	/*
	 * 
	 * To find the sum of 'n' continuous numbers starting from 0 = n(n+1)/2
	 * 
	 * To find the sum of 'n' continuous starting from any number other than 0 = n(n+1)/2 - m(m+1)/2
	 * where m = starting number -1
	 *  
	 */
	
	private int findMissingNumber(int[] nums) {
		Arrays.sort(nums);
		int n=nums.length;
		if(nums[0]==0){
			return n*(n+1)/2 - Arrays.stream(nums).sum();
		}
		else {
			int m=nums[0]-1;
			return n*(n+1)/2 - m*(m+1)/2- Arrays.stream(nums).sum();
		}
	}

}
