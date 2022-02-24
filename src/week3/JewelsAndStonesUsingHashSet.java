package week3;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class JewelsAndStonesUsingHashSet {
	
	//This method is faster than my BruteForce Implementation

	/*Leetcode:771
	 * 
	 * You're given strings jewels representing the types of stones that are jewels,
	 * and stones representing the stones you have. Each character in stones is a 
	 * type of stone you have. You want to know how many of the stones you have 
	 * are also jewels.Letters are case sensitive, so "a" is considered a
	 * different type of stone from "A".
	 */

	@Test
	public void example1() {
		String jewels="aA";
		String stones="aAAbbbb";
		int output=3;
		Assert.assertTrue(output==jewelsAndStones(jewels, stones));
	}

	@Test
	public void example2() {
		String jewels="z";
		String stones="ZZ";
		int output=0;
		Assert.assertTrue(output==jewelsAndStones(jewels, stones));
	}

	@Test
	public void example3() {
		String jewels="ebd";
		String stones="bbb";
		int output=3;
		Assert.assertTrue(output==jewelsAndStones(jewels, stones));
	}


	/*
	 * 
	 * Pseudocode:
	 * 
	 * 1) Using Two pointer bidrectional loop through the String stones
	 * 2) Use a while loop until left pointer is less than or equal to right pointer
	 * 3) Verify if each character of stones is present in jewels String using contains
	 * 4) If the characters from both the left and right indices is contained in the
	 * jewels String then add 2 to the output.
	 * 5) If character from only one of the index is contained in the jewels String
	 * then add 1 to the Output
	 * 6) Return the output.
	 * 
	 */



	private int jewelsAndStones(String jewels,String stones) {
		int output=0;
		HashSet<Character> set=new HashSet<Character>();
		for(int i=0;i<jewels.length();i++) {
			set.add(jewels.charAt(i));
		}
		for(int i=0;i<stones.length();i++) {
			if(set.contains(stones.charAt(i))) output++;
		}
		return output;
	}
}
