package week3;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class LongestSubstringWithoutRepeatingCharsUsingMap {


	/*
	 * Given a string s, find the length of the longest substring without repeating characters.
	 * 
	 */

	@Test
	public void example1() {
		String s="abcabcbb";
		int output=3;
		Assert.assertTrue(output==longestSubStringWithoutRepeat(s));
	}

	@Test
	public void example2() {
		String s="bbbbb";
		int output=1;
		Assert.assertTrue(output==longestSubStringWithoutRepeat(s));
	}

	@Test
	public void example3() {
		String s="pwwkew";
		int output=3;
		Assert.assertTrue(output==longestSubStringWithoutRepeat(s));
	}

	@Test
	public void example4() {
		String s="pwwkewa";
		int output=4;
		Assert.assertTrue(output==longestSubStringWithoutRepeat(s));
	}

	@Test
	public void example5() {
		String s="abccbcbb";
		int output=3;
		Assert.assertTrue(output==longestSubStringWithoutRepeat(s));
	}


	/*
	 * Pseudocode:
	 * 1) Initialize a Map, left and right pointers as zero and a Max variable
	 * 1) Using Sliding Window Two Pointer loop through the String
	 * 2) Keep adding the characters to a Map if they are unique
	 * 3) If Not , then store the length of the SubString using Math.max
	 * 4) Also remove the first character of the Substring from the Map and increment left
	 * 5) Increment right until less than s.length
	 * 
	 */



	private int longestSubStringWithoutRepeat(String s) {
		if(s.length()==0) return 0;
		Map<Character,Integer> sMap=new HashMap<Character,Integer>();
		int left=0,max=Integer.MIN_VALUE;
		for(int right=0;right<s.length();right++) {
			while(sMap.containsKey(s.charAt(right))) {
				sMap.remove(s.charAt(left++));
			}
			sMap.put(s.charAt(right), 0);
			max=Math.max(max, sMap.size());
		}
		return max;

	}


}
