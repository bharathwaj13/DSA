package week3hw;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStringUniqueCharacters {

	/*
	 * 
	 * In the given string find the longest substring having all the  unique characters
	 */

	@Test
	public void example1() {
		String input="abbcafcb";
		String output="bcaf";
		Assert.assertTrue(output.equals(longestSubstring(input)));
	}

	@Test
	public void example2() {
		String input="xxyyzzyyxxzzy";
		String output="xy";
		Assert.assertTrue(output.equals(longestSubstring(input)));
	}


	private String longestSubstring(String input) {
		int left=0,right=0,maxLength=0;
		String maxSub="",tempSub="";
		Set<String> subSet=new HashSet<String>();
		while(right<input.length()) {
			if(subSet.add(input.charAt(right)+"")) {
				tempSub=tempSub+input.charAt(right);
				right++;
				if(subSet.size()>maxLength) {
					maxLength=subSet.size();
					maxSub=tempSub;
				}
			}
			else {
				right=++left;
				subSet.clear();
				tempSub="";
			}
		}
		System.out.println(maxSub);
		return maxSub;
	}


}
