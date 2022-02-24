package week4;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class KthMissingPositiveNumber_BinarySearch{

	/*
	 * Given an array arr of positive integers sorted in a strictly increasing
	 * order, and an integer k.
	 * 
	 * Find the kth positive integer that is missing from this array.
	 */


	@Test
	public void example1() {
		int[] arr= {2,3,4,7,11};
		int k=5;
		int output=9;
		Assert.assertTrue((output==missingPositiveNumber(arr,k)));
	}

	@Test
	public void example2() {
		int[] arr= {1,2,3,4};
		int k=2;
		int output=6;
		Assert.assertTrue((output==missingPositiveNumber(arr,k)));
	}
	
	@Test
	public void example3() {
		int[] arr= {1,2};
		int k=1;
		int output=3;
		Assert.assertTrue((output==missingPositiveNumber(arr,k)));
	}


	/*
	 * Pseudocode:
	 * 
	 * 1) Initialize a counter variable
	 * 2) Loop through the given input array starting from 1
	 * 3) For every number missing in the input array, add it to an ArrayList and increment the counter
	 * 4) Exit Loop when counter is equal to k
	 * 5) Return the last value in the ArrayList
	 * 
	 */


	private int missingPositiveNumber(int[] arr,int k) {

		int left=0,right=arr.length-1,mid=0;

		while(left<=right) {

			mid=(left+right)/2;

			if(arr[mid]-mid <= k) left=mid+1;

			else right=mid-1;

		}

		return left+k;

	}

}
