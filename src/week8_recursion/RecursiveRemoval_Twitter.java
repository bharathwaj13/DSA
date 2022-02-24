package week8_recursion;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveRemoval_Twitter {

	//Given two Strings s and t, find the maximum number of times that one can recursively remove t from s.

	//@Test
	public void example1() {
		String s="aabcbc";
		String t="abc";
		int output=2;
		// Explanation: We can first remove s[1:3] and s becomes "abc". We can then remove it all.
		Assert.assertTrue(output==recursiveRemoval(s, t));
	}
	
	
	@Test
	public void example2() {
		String s="abababaaba";
		String t="ababa";
		int output=2;
		Assert.assertTrue(output==recursiveRemoval(s, t));
	}

	int count=0;

	private int recursiveRemoval(String s,String t) {

		System.out.println(s);
		if(!s.contains(t)) return count;

		count++;
		s=s.replaceFirst(t, "");
		return recursiveRemoval(s, t);
	}


}
