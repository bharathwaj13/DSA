package week6hw;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberOfPlatforms {

	/*
	 * Given the arrival and departure times of all trains that reach a railway station, 
	 * the task is to find the minimum number of platforms required for the railway station so that no train waits. 
	 * We are given two arrays that represent the arrival and departure times of trains that stop.
	 * 
	 */

	@Test
	public void example1() {
		String[] arr= {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"};
		String[] dep= {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
		int output=3;
		Assert.assertTrue(output==minPlatforms(arr, dep));
	}

	@Test
	public void example2() {
		String[] arr= {"9:00", "9:40"};
		String[] dep= {"9:10", "12:00"};
		int output=1;
		Assert.assertTrue(output==minPlatforms(arr, dep));
	}



	private int minPlatforms(String[] arr,String[] dep) {
		int[] intArr=new int[arr.length];
		int[] intDep=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			intArr[i]=Integer.parseInt(arr[i].replaceAll(":", ""));
			intDep[i]=Integer.parseInt(dep[i].replaceAll(":", ""));
		}
		Arrays.sort(arr);
		Arrays.sort(dep);
		int left=0,right=1,minPlatforms=arr.length;

		while(right<arr.length) {
			if(intArr[right]>intDep[left]) {
				minPlatforms--;
				left++;
			}
			right++;
		}
		System.out.println(minPlatforms);
		return minPlatforms;
	}

}
