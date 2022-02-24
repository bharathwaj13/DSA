package week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceToCharacter {

	/*
	 * Leetcode: #821
	 * 
	 * Given a string s and a character c that occurs in s, return an array of integers answer where 
	 * answer.length == s.length and answer[i] is the distance from index i to the closest occurrence
	 * of character c in s.
	 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
	 * 
	 */

	@Test
	public void example1() {
		String s="loveleetcode";
		char c='e';
		int[] output= {3,2,1,0,1,0,0,1,2,2,1,0};
		Assert.assertTrue(Arrays.equals(output, shortestDistance(s, c)));
	}

	@Test
	public void example2() {
		String s="aaab";
		char c='b';
		int[] output= {3,2,1,0};
		Assert.assertTrue(Arrays.equals(output, shortestDistance(s, c)));
	}


	private int[] shortestDistance(String s,char c) {
		List<Integer> list=new ArrayList<Integer>();

		int index=Integer.MAX_VALUE;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c) list.add(i);
		}
		int[] output=new int[s.length()];
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c) output[i]=0;
			else {
				for(int j=0;j<list.size();j++) {
					index=Math.min(index, Math.abs(i-list.get(j)));
				}
				output[i]=index;
				index=Integer.MAX_VALUE;
			}
		}
		return output;
	}
}
