package week2hw;

import org.junit.Assert;
import org.junit.Test;

public class LongestNiceSubstringUsingBruteForce {

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
		int maxLength=0,index=0;
		boolean bFlag=false;
		for(int i=0;i<s.length();i++) {
			int j=0;
			while(j<s.length()-1-i) {
				bFlag=false;
				copyOfs=s.substring(i, i+j+2);
				while(index<copyOfs.length()) {
					if(Character.isLowerCase(copyOfs.charAt(index))) {
						if(!copyOfs.contains((copyOfs.charAt(index++)+"").toUpperCase())) {
							bFlag=true;
							index=0;
							break;
						}
					}
					else {
						if(!copyOfs.contains((copyOfs.charAt(index++)+"").toLowerCase())) {
							bFlag=true;
							index=0;
							break;
						}
					}

				}
				j++;
				if(!bFlag) {
					if(copyOfs.length()>maxLength) {
						maxLength=copyOfs.length();
						maxString=copyOfs;
					}

				}

			}
		}
		System.out.println(maxString);
		return maxString;

	}


}
