package week1;

import org.junit.Assert;
import org.junit.Test;


public class IsSubsequence {

	/*
	 *Given two strings s and t, return true if s is a subsequence of t, 
	 *or false otherwise.
	 *A subsequence of a string is a new string that is formed from the
	 *original string by deleting some (can be none) of the characters 
	 *without disturbing the relative positions of the remaining characters.
	 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not). 
	 * 
	 */

	@Test
	public void positive() {
		String s="abc";
		String t="ahbgdc";
		Assert.assertTrue(isSubsequence(s, t));
	}

	@Test
	public void edge1() {
		String s="b";
		String t="abc";
		Assert.assertTrue(isSubsequence(s, t));
	}

	@Test
	public void edge2() {
		String s="";
		String t="ahbgdc";
		Assert.assertTrue(isSubsequence(s, t));
	}

	@Test
	public void negative() {
		String s="ahbgdc";
		String t="axc";
		Assert.assertFalse(isSubsequence(s, t));
	}

	/*
	 * Pseudocode:
	 * 1)If two Strings are of the same length, verify if they are equal
	 * 2) If yes, return true else return false
	 * 3) if false in step1, then loop through the larger String and check if 
	 * contents of smaller String are present in the same order throughout the larger String
	 * 4) If yes then return true, else return false
	 */


	private boolean isSubsequence(String s,String t) {
		int counter=0;
		String temp="";
		if(s.equals(t)||s.length()==0) return true;
		else {
			if(s.length()>t.length()) {
				temp=s;
				s=t;
				t=temp;
			}
			for(int i=0;i<t.length();i++) {
				if((t.charAt(i)+"").equals(s.charAt(counter)+"")) {
					counter++;
					if(counter==s.length()) return true;
				}
			}
		}
		
		return false;

	}
}
