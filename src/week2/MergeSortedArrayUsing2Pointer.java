package week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;



public class MergeSortedArrayUsing2Pointer {

	/*
	 * 
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
	 *  representing the number of elements in nums1 and nums2 respectively.Merge nums1 and nums2 into a single 
	 *  array sorted in non-decreasing order.The final sorted array should not be returned by the function,
	 *  but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
	 *  where the first m elements denote the elements that should be merged, and the last n elements are set to 0 
	 *  and should be ignored. nums2 has a length of n.
	 */

	@Test
	public void example1() {
		int[] nums1={1,2,3};
		int m=3;
		int[] nums2= {2,5,6};
		int n=3;
		int[] output= {1,2,2,3,5,6};
		Assert.assertTrue(Arrays.equals(output, mergeSortedArray(nums1, m, nums2, n)));

	}


	private int[] mergeSortedArray(int[] nums1,int m,int[] nums2,int n) {
		int[] result=new int[n+m];
		int left=0,right=0,insert=0;
		while(left<m || right<n) {
			if(left==m) result[insert++]=nums2[right++];
			else if(right==n) result[insert++]=nums1[left++];
			else if(nums1[left]<=nums2[right]) result[insert++]=nums1[left++];
			else result[insert++]=nums2[right++];
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

}
