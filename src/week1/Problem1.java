package week1;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Problem1 {

	/*
	 * Given the integer array and the target, remove the matching target from the array
	 * 
	 */

	//@Test
	public void positive() {
		int[] nums= {1,2,3,4,5};
		int target= 5;
		int[] output= {1,2,3,4};
		Assert.assertTrue(Arrays.equals(output, verifyMatchAndRemove(nums, target)));
	}

	//@Test
	public void edge() {
		int[] nums= {1,2,2,3,4,5,2,0};
		int target= 2;
		int[] output= {1,3,4,5};
		Assert.assertTrue(Arrays.equals(output, verifyMatchAndRemove(nums, target)));
	}

	@Test
	public void negative() {
		int[] nums= {1,2,3,4,5};
		int target= 6;
		int[] output= {1,2,3,4,5};
		Assert.assertTrue(Arrays.equals(output, verifyMatchAndRemove(nums, target)));
	}

	/*Pesudocode:
	 * 1) Take the given array
	 * 2) Loop through and array and check for the matching target
	 * 3) If matching target found, remove it and add to arrayList
	 * 4) Convert arrayList to Array and return
	 * 4) Perform Assertion and verify
	 */	

	private int[] verifyMatchAndRemove(int[] arr,int target) {
		ArrayList<Integer> targetList=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=target)
				targetList.add(arr[i]);
		}
		int[] output=new int[targetList.size()];
		for (int i=0;i<targetList.size();i++) {
			output[i]=targetList.get(i);
		}
		return output;
	}
}
