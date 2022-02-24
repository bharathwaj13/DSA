package week1;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ReverseVowels {

	/*
	 * 
	 * Given a string s, reverse only all the vowels in the string and return it.
	 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
	 * 
	 */

	@Test
	public void example1() {
		String input="hello";
		String output="holle";
		Assert.assertTrue(output.equals(reverseVowels(input)));
	}

	@Test
	public void edge1() {
		String input="bcdgh";
		String output="bcdgh";
		Assert.assertTrue(output.equals(reverseVowels(input)));
	}
	
	@Test
	public void edge2() {
		String input="aA";
		String output="Aa";
		Assert.assertTrue(output.equals(reverseVowels(input)));
	}

	@Test
	public void example2() {
		String input="leetcode";
		String output="leotcede";
		Assert.assertTrue(output.equals(reverseVowels(input)));
	}

	/*
	 * Pseudocode
	 * 
	 * 1) Take the given array
	 * 2) Find the vowels in a string and store it in a separate string
	 * 3) Also store the indices of the vowels in an arrayList
	 * 4) Loop through arrayList and replace the vowel character in the String 
	 * from the vowelString
	 * 
	 */

	private String reverseVowels(String input) {
		if(input.toLowerCase().contains("a")||input.toLowerCase().contains("e")||input.toLowerCase().contains("i")||input.toLowerCase().contains("o")||input.toLowerCase().contains("u")||!input.equals("")){
			String vowelStr="";
			ArrayList<Integer> vowelIndices=new ArrayList<Integer>();

			for(int i=0;i<input.length();i++) {
				if(("aeiouAEIOU").contains(input.charAt(i)+"")){
					vowelStr=input.charAt(i)+vowelStr;
					vowelIndices.add(i);
				}
			}
			System.out.println(vowelIndices.toString());
			System.out.println(vowelStr);
			char[] charArray = input.toCharArray();
			for(int i=0;i<vowelIndices.size();i++) {
				charArray[vowelIndices.get(i)]=vowelStr.charAt(i);
			}
			input=String.copyValueOf(charArray);
		}
		else return input;

		System.out.println(input);
		return input;

	}
}

