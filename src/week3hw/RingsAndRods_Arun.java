package week3hw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class RingsAndRods_Arun {


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
		 int allColRods=0,j=1,ringsLen=rings.length();
			HashSet<Character> rodSet=new HashSet<Character>();
			HashSet<Character> rodColours=new HashSet<Character>();
			for(int i=1;i<ringsLen;i+=2) {
				rodSet.add(rings.charAt(i));
			}
			for(Character eachRod:rodSet) {
				while(j<ringsLen) {
					if(rings.charAt(j)==eachRod) {
						rodColours.add(rings.charAt(j-1));
					}
					j+=2;
				}
				j=1;
				if(rodColours.size()==3)allColRods+=1;
				rodColours.clear();
			}
			return allColRods ;	
	}


}
