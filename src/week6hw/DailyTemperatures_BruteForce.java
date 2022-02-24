package week6hw;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DailyTemperatures_BruteForce {

	/*
	 * Leetcode: 739
	 * 
	 * Given an array of integers temperatures represents the daily temperatures,
	 * return an array answer such that answer[i] is the number of days you have to
	 * wait after the ith day to get a warmer temperature. If there is no future day
	 * for which this is possible, keep answer[i] == 0 instead.
	 */

	@Test
	public void example1() {
		int[] temperatures= {73,74,75,71,69,72,76,73};
		int[] output= {1,1,4,2,1,1,0,0};
		Assert.assertTrue(Arrays.equals(output, dailyTemperatures(temperatures)));
	}

	@Test
	public void example2() {
		int[] temperatures= {30,40,50,60};
		int[] output= {1,1,1,0};
		Assert.assertTrue(Arrays.equals(output, dailyTemperatures(temperatures)));
	}

	@Test
	public void example3() {
		int[] temperatures= {30,60,90};
		int[] output= {1,1,0};
		Assert.assertTrue(Arrays.equals(output, dailyTemperatures(temperatures)));
	}


	private int[] dailyTemperatures(int[] temp) {

		int[] output=new int[temp.length];
		output[temp.length-1]=0;
		for(int i=0;i<temp.length-1;i++) {
			for(int j=i+1;j<temp.length;j++) {
				if(temp[j]>temp[i]) {
					output[i]=j-i;
					break;
				}
			}
		}
		return output;
	}
}
