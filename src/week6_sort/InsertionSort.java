package week6_sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {


	@Test
	public void example1() {
		int[] input= {4,6,2,1,10,99,5,8};
		int[] output= {1,2,4,5,6,8,10,99};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}
	
	@Test
	public void example2() {
		int[] input= {4,11,2,17,1,8,18,22};
		int[] output= {1,2,4,8,11,17,18,22};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}
	
	@Test
	public void example3() {
		int[] input= {4,6,2,1,10,99,5};
		int[] output= {1,2,4,5,6,10,99};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}
	
	@Test
	public void example4() {
		int[] input= {4,6,2,1,10,99,5,5};
		int[] output= {1,2,4,5,5,6,10,99};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}
	
	@Test
	public void example5() {
		int[] input= {1,1,1,1};
		int[] output= {1,1,1,1};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}
	
	@Test
	public void example6() {
		int[] input= {-2,0,12,-4,13,8,11};
		int[] output= {-4,-2,0,8,11,12,13};
		Assert.assertTrue(Arrays.equals(output, insertionSort(input)));
	}


	private int[] insertionSort(int[] input) {
		int temp=0,m=0,j=0;
		for(int i=0;i<input.length-1;i++) {
			j=i+1;
				m=i;
				while(i>=0 && input[i]>input[j]) {
					temp=input[i];
					input[i]=input[j];
					input[j]=temp;
					i--;j--;
				}
				i=m;
			
		}
		System.out.println(Arrays.toString(input));
		return input;
	}

}
