package week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class LongestSubstringWithoutRepeatingCharsUsingSet {


	/*
	 * Leetcode:290
	 * 
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
	 * /*
	 * Algorithm : Sliding Window / Hashing Algorithm
	 * 
	 * 1) Two pointers - equi - left , right = 0
	 * 2) Create HashSet 
	 * 3) Right -> Fast Pointer -> Move to every character
	 * 4) Check if that character exist in the set --> 
	 * 		a) reset your right with left, increment before reset !!
	 * 		b) clear your set !!
	 * 
	 */



	private int longestSubStringWithoutRepeat(String s) {
		int left = 0, right = 0, maxCount = 0;
		HashSet<Character> set = new HashSet<Character>();

		while(right < s.length()) {
			if(set.add(s.charAt(right++))) {
				maxCount = Math.max(maxCount, set.size());
			} else {
				right = ++left;
				set.clear();
			}
		}
		return maxCount;

	}


}
