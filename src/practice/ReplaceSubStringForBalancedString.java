package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class ReplaceSubStringForBalancedString {


	/*
	 * Leetcode: 1234 You are given a string s of length n containing only four
	 * kinds of characters: 'Q', 'W', 'E', and 'R'.
	 * 
	 * A string is said to be balanced if each of its characters appears n / 4 times
	 * where n is the length of the string.
	 * 
	 * Return the minimum length of the substring that can be replaced with any
	 * other string of the same length to make s balanced. If s is already balanced,
	 * return 0.
	 */

	@Test
	public void example1() {
		String s="QWER";
		int output=0;
		Assert.assertTrue(output==replaceSubForBalancedString(s));
	}

	@Test
	public void example2() {
		String s="QQWE";
		int output=1;
		Assert.assertTrue(output==replaceSubForBalancedString(s));
	}

	@Test
	public void example3() {
		String s="QQQW";
		int output=2;
		Assert.assertTrue(output==replaceSubForBalancedString(s));
	}

	@Test
	public void example4() {
		String s="QQQWREEE";
		int output=4;
		Assert.assertTrue(output==replaceSubForBalancedString(s));
	}

	@Test
	public void example5() {
		String s= "WQWRQQQW";
		int output=3;
		Assert.assertTrue(output==replaceSubForBalancedString(s));
	}


	private int replaceSubForBalancedString(String s) {
		int output=0;
		String input="QWER";
		Map<Character,Integer> sMap=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
		}
		for (int i=0;i<input.length();i++) {
			if(sMap.getOrDefault(input.charAt(i), 0)!=(s.length()/4)) {
				output= output+Math.abs(s.length()/4-sMap.getOrDefault(input.charAt(i), 0)) ;
			}
		}

		System.out.println(output);
		return output;
	}

}
