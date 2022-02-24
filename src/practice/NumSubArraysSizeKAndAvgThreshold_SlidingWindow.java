package practice;

import org.junit.Assert;
import org.junit.Test;

public class NumSubArraysSizeKAndAvgThreshold_SlidingWindow {

	/*
	 * Leetcode: 1343
	 * 
	 * Given an array of integers arr and two integers k and threshold, return the
	 * number of sub-arrays of size k and average greater than or equal to
	 * threshold.
	 */

	@Test
	public void example1() {
		int[] arr= {2,2,2,2,5,5,5,8};
		int k=3;
		int threshold=4;
		int output=3;
		Assert.assertTrue(output==numSubArraysSizeKAvgThreshold(arr, k, threshold));
	}

	@Test
	public void example2() {
		int[] arr= {11,13,17,23,29,31,7,5,2,3};
		int k=3;
		int threshold=5;
		int output=6;
		Assert.assertTrue(output==numSubArraysSizeKAvgThreshold(arr, k, threshold));
	}


	private int numSubArraysSizeKAvgThreshold(int[] arr,int k,int threshold) {

		if(arr.length<k) return 0;
		int counter=0,sum=0;
		for(int i=0;i<k;i++) {
			sum+=arr[i];
		}
		counter=sum/k>=threshold? counter+1 : counter;
		if(arr.length==k) return counter;
		else {
			for(int i=k;i<arr.length;i++) {
				sum+=arr[i]-arr[i-k];
				counter=sum/k>=threshold? counter+1 : counter;
			}
		}
		return counter;
	}
}
