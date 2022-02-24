package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class WordPatternUsingMap {

	/*Leetcode
	 * 
	 * Given a pattern and a string s, find if s follows the same pattern.
	 * Here follow means a full match, such that there is a bijection between
	 * a letter in pattern and a non-empty word in s.
	 * 
	 */

	//@Test
	public void example1() {
		String pattern="abba";
		String s="dog cat cat dog";
		boolean output=true;
		Assert.assertTrue(wordPattern(pattern, s));
	}

	@Test
	public void example2() {
		String pattern="abba";
		String s="dog cat cat fish";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}

	//@Test
	public void example3() {
		String pattern="aaaa";
		String s="dog cat cat dog";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}

	//@Test
	public void example4() {
		String pattern="aaa";
		String s="aa aa aa aa";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}


	/*
	 * 
	 * Pseudocode:
	 * Hash Table
	 * 1) Use two hash table to store the index of each character and word mapping
	 * 2) At any time if the index are different for the same word, we know the pattern and string don't match
	 * 3) We can take advantage of the return value of put function for java Hashmap, where it return value of the old mapping or null when the key is new
	 * 4) Time complexity O(n)
	 * 5) Space complexity O(n)
	 *  
	 */


	private boolean wordPattern(String pattern,String s) {
		char[] chars = pattern.toCharArray();
		String[] strs = s.split(" ");
		if (chars.length != strs.length) return false;
		Map<Character, Integer> cmap = new HashMap<>();
		Map<String, Integer> smap = new HashMap<>();
		for (Integer i = 0; i < chars.length; i++) {
			if (cmap.put(chars[i], i) != smap.put(strs[i], i)) return false;
		}
		return true;
	}
}
