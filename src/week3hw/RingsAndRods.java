package week3hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class RingsAndRods {


	/*
	 * 
	 * Leetcode: 2103
	 * 
	 * There are n rings and each ring is either red, green, or blue. 
	 * The rings are distributed across ten rods labeled from 0 to 9.
	 * You are given a string rings of length 2n that describes the n rings that are 
	 * placed onto the rods. Every two characters in rings forms a color-position pair 
	 * that is used to describe each ring where:
	 * The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
	 * The second character of the ith pair denotes the rod that the ith ring is placed
	 * on ('0' to '9').
	 * For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod
	 * labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed 
	 * onto the rod labeled 1.
	 * Return the number of rods that have all three colors of rings on them.
	 */

	@Test
	public void example1() {
		String rings="B0B6G0R6R0R6G9";
		int output=1;
		Assert.assertTrue(output==ringsAndRods(rings));
	}

	@Test
	public void example2() {
		String rings="B0R0G0R9R0B0G0";
		int output=1;
		Assert.assertTrue(output==ringsAndRods(rings));
	}

	@Test
	public void example3() {
		String rings="G4";
		int output=0;
		Assert.assertTrue(output==ringsAndRods(rings));
	}



	private int ringsAndRods(String rings) {
		int output=0;
		Map<String,String> ringsMap=new HashMap<String,String>();
		for(int i=1;i<rings.length();i=i+2) {
			ringsMap.put(rings.charAt(i)+"", ringsMap.getOrDefault(rings.charAt(i)+"", rings.charAt(i-1)+"")+rings.charAt(i-1));
		}

		for (Entry<String,String> eachEntry : ringsMap.entrySet()) {
			if(eachEntry.getValue().toString().contains("R") && eachEntry.getValue().toString().contains("G") && eachEntry.getValue().toString().contains("B")) {
				output++;
			}
		}	

		return output;
	}


}
