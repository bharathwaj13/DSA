package week9;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueCharacterInAString {


	/*
	 * 
	 * Leetcode: 387
	 * Given a string s, find the first non-repeating character in it and return its index. 
	 * If it does not exist, return -1.
	 * 
	 */

	@Test
	public void example1() {
		String s="leetcode";
		int output=0;
		Assert.assertTrue(output==firstUniqueCharacter(s));
	}
	
	@Test
	public void example2() {
		String s="loveleetcode";
		int output=2;
		Assert.assertTrue(output==firstUniqueCharacter(s));
	}
	
	@Test
	public void example3() {
		String s="aabb";
		int output=-1;
		Assert.assertTrue(output==firstUniqueCharacter(s));
	}

	private int firstUniqueCharacter(String s) {
		int[] countArray=new int[26];
		for(int i=0;i<s.length();i++) {
			countArray[s.charAt(i)-'a']++;
		}
		for(int i=0;i<s.length();i++) {
			if(countArray[s.charAt(i)-'a']==1) return i;
		}
		return -1;
	}
}