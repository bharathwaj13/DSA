package week6_sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {


	@Test
	public void example1() {
		int[] input= {4,6,2,1,10,99,5,8};
		int[] output= {1,2,4,5,6,8,10,99};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}

	@Test
	public void example2() {
		int[] input= {4,11,2,17,1,8,18,22};
		int[] output= {1,2,4,8,11,17,18,22};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}

	@Test
	public void example3() {
		int[] input= {4,6,2,1,10,99,5};
		int[] output= {1,2,4,5,6,10,99};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}

	@Test
	public void example4() {
		int[] input= {4,6,2,1,10,99,5,5};
		int[] output= {1,2,4,5,5,6,10,99};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}

	@Test
	public void example5() {
		int[] input= {1,1,1,1};
		int[] output= {1,1,1,1};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}

	@Test
	public void example6() {
		int[] input= {-2,0,12,-4,13,8,11};
		int[] output= {-4,-2,0,8,11,12,13};
		Assert.assertTrue(Arrays.equals(output, selectionSort(input)));
	}


	private int[] selectionSort(int[] input) {
		int j=0,min=Integer.MAX_VALUE,minIndex=0,temp=0;
		for(int i=0;i<input.length;i++) {
			j=i;
			while(j<input.length) {
				if(input[j]<min) {
					min=input[j];
					minIndex=j;
				}
				j++;
			}
			temp=input[i];
			input[i]=min;
			min=Integer.MAX_VALUE;
			input[minIndex]=temp;
		}
		System.out.println(Arrays.toString(input));
		return input;
	}

}
