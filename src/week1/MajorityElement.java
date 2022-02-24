package week1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


public class MajorityElement {

	/*
	 * Given an array nums of size n, return the majority element.
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
	 * You may assume that the majority element always exists in the array.
	 * 
	 */

	@Test
	public void example1() {
		int[] nums= {3,2,3};
		int output=3;
		Assert.assertTrue(output==majorityElement(nums));
	}

	@Test
	public void example2() {
		int[] nums= {2,2,1,1,1,2,2};
		int output=2;
		Assert.assertTrue(output==majorityElement(nums));
	}

	@Test
	public void example3() {
		int[] nums= {1};
		int output=1;
		Assert.assertTrue(output==majorityElement(nums));
	}

	/*
	 * Pseudocode:
	 * 
	 * 1) Take the given array
	 * 2) Initialize a HashMap
	 * 3) Loop through the given array and add the contents to the Map
	 * 4) If the key is already present,then increment the value by one
	 * 5) Else add a new key to the map
	 * 6) After the loop, return the element whose value in the map is greater than n/2
	 */


	private int majorityElement(int[] nums) {
		int maxValue=0;
		int maxKey=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
				if(maxValue<map.get(nums[i])) {
					maxValue=map.get(nums[i]);
					maxKey=nums[i];
				}
			}
			else {
				map.put(nums[i], 1);
				if(maxValue<map.get(nums[i])) {
					maxValue=map.get(nums[i]);
					maxKey=nums[i];
				}
			}
		}
		return maxKey;
	
	}
}
