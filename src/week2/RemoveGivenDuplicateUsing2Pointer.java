package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RemoveGivenDuplicateUsing2Pointer {
	/*
	 * 
	 * Remove the given duplicate in the given array
	 *
	 */


	@Test // positive
	public void example1() {
		int[] nums = {5,3,2,1,2,3};
		int target =  3;
		int[] output= {5,2,1,2};
		removeElement(nums, target);
	}

	@Test // negative
	public void example2() {
		int[] nums = {};
		int target =  3;
		int[] output= {};
		removeElement(nums, target);

	}

	/*
	 * 
	 * Pseudocode:
	 * 
	 * 1) Take the given array
	 * 2) Using 2 pointer traverse from left and right to check if element is equal to given target
	 * 3) If the element is equal, then add it to an ArrayList and increment the left pointer
	 * and decrement the right pointer
	 */


	private void removeElement(int[] nums,int target) {

		int left=0,right=nums.length-1;
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(left<right) {
			if(nums[left]!=target && nums[right]!=target) {
				list.add(nums[left++]);
				list.add(nums[right--]);
			}
			else if(nums[left]!=target) {
				list.add(nums[left++]);
				right--;
			}
			else {
				list.add(nums[right--]);
				left++;
			}

		}

		System.out.println(list.toString());


	}

}
