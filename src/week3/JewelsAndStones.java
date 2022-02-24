package week3;

import org.junit.Assert;
import org.junit.Test;

public class JewelsAndStones {

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
		int left=0,right=stones.length()-1,output=0;
		while(left<=right) {
			if(jewels.contains(stones.charAt(left)+"") && jewels.contains(stones.charAt(right)+"")) {
				output=left==right? output+1: output+2;
			}
			else if (jewels.contains(stones.charAt(left)+"") || jewels.contains(stones.charAt(right)+"")) {
				output+=1;
			}
			left++;
			right--;
		}
		//if(left==right && jewels.contains(stones.charAt(left)+"")) output++;
		System.out.println(output);
		return output;
	}
}
