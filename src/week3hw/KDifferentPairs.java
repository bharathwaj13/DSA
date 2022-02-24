package week3hw;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class KDifferentPairs {

	/*
	 * Leetcode: 532
	 * 
	 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
	 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
	 * 0 <= i < j < nums.length
	 * |nums[i] - nums[j]| == k
	 * Notice that |val| denotes the absolute value of val.
	 *  
	 */


	@Test
	public void example1() {
		int[] nums= {3,1,4,1,5};
		int k=2;
		int output=2;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}

	@Test
	public void example2() {
		int[] nums= {1,2,3,4,5};
		int k=1;
		int output=4;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}

	@Test
	public void example3() {
		int[] nums= {1,3,1,5,4};
		int k=0;
		int output=1;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}

	@Test
	public void example4() {
		int[] nums= {1,2,4,4,3,3,0,9,2,3};
		int k=3;
		int output=2;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}
	
	@Test
	public void example5() {
		int[] nums= {-1,-2,-3};
		int k=1;
		int output=2;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}
	
	@Test
	public void example6() {
		int[] nums= {-1,1};
		int k=2;
		int output=1;
		Assert.assertTrue(output==kDiffPairs(nums, k));
	}


	private int kDiffPairs(int[] nums,int k) {
		int count=0;
		HashSet<Integer> pair=new HashSet<Integer>();
		if(nums.length==1) return 0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {

				if((nums[i]>0  && nums[j]>0)|| (nums[i]<0  && nums[j]<0)){
					if(Math.abs(nums[i]-nums[j])==k && !pair.contains(nums[i]+nums[j])) {
						count++;
						pair.add(nums[i]+nums[j]);
						continue;
					}
				}

				else {
					if((nums[i]-nums[j]==k || nums[j]-nums[i]==k) && !pair.contains(nums[i]+nums[j])) {
						count++;
						pair.add(nums[i]+nums[j]);
						continue;
					}
				}
			}
		}
		return count;
	}

}
