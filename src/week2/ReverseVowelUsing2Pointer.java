package week2;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ReverseVowelUsing2Pointer {

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
	 * 
	 * Pseudocode:
	 * 1) Take the given array
	 * 2) Using Two Pointer, traverse through the array
	 * 3) If the right and left indices both are vowels, then swap and increment both the pointers
	 * 4) If the right is vowel and left is not, then increment left pointer
	 * 5) If the left is vowel and right is not, then decrement right pointer
	 * 6) Exit loop when left is greater than right
	 * 
	 */


	private String reverseVowels(String input) {
		int left=0,right=input.length()-1;
		ArrayList<String> listVowels=new ArrayList<String>();
		listVowels.add("a");
		listVowels.add("e");
		listVowels.add("i");
		listVowels.add("o");
		listVowels.add("u");
		listVowels.add("A");
		listVowels.add("E");
		listVowels.add("I");
		listVowels.add("O");
		listVowels.add("U");
		char[] charArray = input.toCharArray();


		while(left<right) {
			if(listVowels.contains(charArray[left]+"")&&listVowels.contains(charArray[right]+"")) {
				char temp=charArray[left];
				charArray[left++]=charArray[right];
				charArray[right--]=temp;
			}
			else if(listVowels.contains(charArray[left]+"")) right--;
			else if(listVowels.contains(charArray[right]+"")) left++;
			else {
				left++;
				right--;
			}
		}
		return new String(charArray);
	}

}
