package week1;

import java.util.Arrays;

public class MergeSort {

	/*
	 * 
	 * Its time complexity is O(nlogn)
	 * 
	 */

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");			
		}
	}

	public static int[] mergeSort(int[] arr) {

		if(arr.length<2) return arr;
		int midpoint=arr.length/2;
		int[] leftArr=new int[midpoint];
		int[] rightArr=new int[arr.length-midpoint];

		for(int i=0;i<midpoint;i++) {
			leftArr[i]=arr[i];
		}

		for(int i=0;i<rightArr.length;i++) {
			rightArr[i]=arr[midpoint+i];
		}

		int[] result=new int[arr.length]; 

		leftArr=mergeSort(leftArr);
		System.out.println(Arrays.toString(leftArr));
		rightArr=mergeSort(rightArr);
		System.out.println(Arrays.toString(rightArr));

		result=merge(leftArr,rightArr);
		return result;

	}

	private static int[] merge(int[] left,int[] right) {

		int[] result=new int[left.length+right.length];
		int leftPointer,rightPointer,resultPointer;
		leftPointer=rightPointer=resultPointer=0;

		while(leftPointer<left.length || rightPointer<right.length) {
			if(leftPointer<left.length && rightPointer<right.length) {
				if(left[leftPointer]<right[rightPointer]) result[resultPointer++]=left[leftPointer++];
				else result[resultPointer++]=right[rightPointer++];
			}
			else if(leftPointer<left.length) result[resultPointer++]=left[leftPointer++];

			else if(rightPointer<right.length) result[resultPointer++]=right[rightPointer++];

		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums= {45,6,245,36,7,245,23,78,8,235,25,7,9,0};
		nums=mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}



