package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArunSquaresOfSortedArray {

	@Test
	public void example1() {
		int[] nums= {-4,-1,0,3,10};
		int[] out= {0, 1, 9, 16, 100};
		Assert.assertEquals(Arrays.toString(squareAndSort(nums)), Arrays.toString(out));
	}

	/* 
	 * Brute force !!
	 * Psuedo code:
	 * Traverse through the I/P array one at a time in for loop
	 * Square the particular element and save in the same index position
	 * Sort the array for Non Decreasing order
	 *  
	 */
	public int[] squareAndSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i]=nums[i]*nums[i];
		}
		Arrays.sort(nums);

		return nums;
	}

}
