package week2hw;

import java.util.Arrays;

//not Working

import org.junit.Assert;
import org.junit.Test;

public class LongestNiceSubstringUsingBruteForce_Better {

	/*
	 * 
	 * A string s is nice if, for every letter of the alphabet that s contains,
	 * it appears both in uppercase and lowercase. For example, "abABB" is
	 * nice because 'A' and 'a' appear, and 'B' and 'b' appear. However,
	 * "abA" is not because 'b' appears, but 'B' does not.Given a string s,
	 * return the longest substring of s that is nice. If there are multiple,
	 * return the substring of the earliest occurrence. If there are none, 
	 * return an empty string.
	 */

	@Test
	public void example1() {
		String s="YazaAay";
		String output="aAa";
		Assert.assertTrue(output.equals(longestNiceSubString(s)));
	}

	@Test
	public void example2() {
		String s="c";
		String output="";
		Assert.assertTrue(output.equals(longestNiceSubString(s)));
	}

	@Test
	public void example3() {
		String s="dDzeE";
		String output="dD";
		Assert.assertTrue(output.equals(longestNiceSubString(s)));
	}

	@Test
	public void example4() {
		String s="abABB";
		String output="abABB";
		Assert.assertTrue(output.equals(longestNiceSubString(s)));
	}



	private String longestNiceSubString(String s) {
		String copyOfs="",maxString="";
		int maxLength=0;
		for(int i=0;i<=s.length()-1;i++) {
			for(int j=i;j<s.length();j++) {
				copyOfs=s.substring(i,j+1);
				if(isNice(copyOfs)) {
					if(copyOfs.length()>maxLength) maxString=copyOfs;
				}

			}
		}
		return maxString;

	}


	private boolean isNice(String sub) {
		int[] ch=new int[128];
		Arrays.fill(ch, 0);
		for (char c : sub.toCharArray()) {
			int k=(int)c;
			ch[k]++;
		}

		for(int j=0;j<sub.length();j++) {
			System.out.println(ch[(int)sub.charAt(j)+32]);
			if(Character.isUpperCase(sub.charAt(j))) {
				if(ch[(int)sub.charAt(j)+32]==0) return false;
			}
			else
				if(ch[(int)sub.charAt(j)-32]==0) return false;
		}
		return true;
	}


}
