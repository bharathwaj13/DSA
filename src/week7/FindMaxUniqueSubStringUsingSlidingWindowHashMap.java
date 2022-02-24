package week7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxUniqueSubStringUsingSlidingWindowHashMap {
	
	
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


	private int maxUniqueSubString(int[] nums,int k) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int max=0,i=0;

		for(i=0;i<k;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		max=Math.max(max, map.size());
		if(max==k) return max;
		while(i<nums.length) {
			if(map.get(nums[i-k])>1) map.put(nums[i-k], map.get(nums[i-k])-1);
			else map.remove(nums[i-k]);
			map.put(nums[i], map.getOrDefault(nums[i++], 0)+1);
			max=Math.max(max, map.size());
			if(max==k) return max;
		}
		return max;
	}

}
