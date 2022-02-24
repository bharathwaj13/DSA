package week2hw;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SubStringDistinctCharSizeThree {

	/*Leetcode: 1876
	 * 
	 * A string is good if there are no repeated characters.Given a string s,
	 * return the number of good substrings of length three in s.Note that if 
	 * there are multiple occurrences of the same substring, every occurrence 
	 * should be counted.A substring is a contiguous sequence of characters in a string.
	 * 
	 */

	@Test
	public void example1() {
		String s="xyzzaz";
		int output=1;
		Assert.assertTrue(output==subStringDistinctSizeThree(s));
	}

	@Test
	public void example2() {
		String s="aababcabc";
		int output=4;
		Assert.assertTrue(output==subStringDistinctSizeThree(s));
	}


	private int subStringDistinctSizeThree(String s) {
		Set<String> elements=new HashSet<String>();
		int counter=0;
		for(int i=0;i<=s.length()-3;i++) {
			for(int j=i;j<i+3;j++) {
				elements.add(s.charAt(j)+"");
			}
			if(elements.size()==3) {
				counter++;
			}
			elements.clear();
		}
		return counter;
	}

}
