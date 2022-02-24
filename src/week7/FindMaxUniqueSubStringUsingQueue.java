package week7;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxUniqueSubStringUsingQueue {
	
	
	/*
	 * 
	 * Return the max number of unique elements in a subarray of size k
	 * 
	 */

	@Test
	public void example1() {
		int[] nums= {1,5,2,3,4,5,8};
		int k=3;
		int output=3;
		Assert.assertTrue(output==maxUniqueSubString(nums, k));
	}

	@Test
	public void example2() {
		int[] nums= {1,1,2,2,4,4,8};
		int k=3;
		int output=2;
		Assert.assertTrue(output==maxUniqueSubString(nums, k));
	}
	
	@Test
	public void example3() {
		int[] nums= {1,1,1};
		int k=3;
		int output=1;
		Assert.assertTrue(output==maxUniqueSubString(nums, k));
	}
	
	@Test
	public void example4() {
		int[] nums= {1,1,3};
		int k=2;
		int output=1;
		Assert.assertTrue(output==maxUniqueSubString(nums, k));
	}


	private int maxUniqueSubString(int[] nums,int k) {
		ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
		int max=0,i=0;
		for(i=0;i<k;i++) {
			if(!queue.contains(nums[i])) queue.offer(nums[i]);
		}
		max=Math.max(max, queue.size());
		if(max==k) return max;
		while(i<nums.length) {
			queue.pop();
			if(!queue.contains(nums[i])) queue.offer(nums[i]);
			i++;
			max=Math.max(max, queue.size());
			if(max==k) return max;
		}
		return max;
	}

}
