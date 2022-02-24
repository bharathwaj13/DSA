package week6hw;

import org.junit.Assert;
import org.junit.Test;

public class CircularPrinter_HackerRank {


	/*
	 * https://leetcode.com/discuss/interview-question/1263982/thomson-reuters-oa-circular-printer
	 * 
	 * A company has invented a new type of printing technology - a circular printer.
	 * Its a circular printer wheel with the letters A through Z in sequence . It wraps so 
	 * A and Z are adjacent. The printer has a pointer that is initially at 'A'. Moving
	 * from any character to any adjacent character takes 1 second. It can move in either 
	 * direction. Given a string of letters , what is the minimum time needed to print
	 * the string?
	 * Note: Assume that printing does not take any time. Only consider the time it takes 
	 * for the pointer to move.  
	 * 
	 * Example:
	 * s="BZA"
	 * 
	 * Total time to print "BZA" = 1+2+1 = 4 seconds
	 * 
	 * First, move the pointer from 'A' to 'B'(1 second), then from 'B'to 'Z'(2 seconds),
	 * and finally from 'Z' to 'A'(1 second). So the minimum time needed to print "BZA"
	 * is 4 seconds. 
	 */

	@Test
	public void example1() {
		String s="BZA";
		int output=4;
		Assert.assertTrue(output==circularPrinter(s));
	}
	
	@Test
	public void example2() {
		String s="AZGB";
		int output=13;
		Assert.assertTrue(output==circularPrinter(s));
	}
	
	@Test
	public void example3() {
		String s="ZNMD";
		int output=23;
		Assert.assertTrue(output==circularPrinter(s));
	}



	private int circularPrinter(String s) {
		int output=0;
		int diff= Math.abs(s.charAt(0)-'A');
		if(diff >13) output=26-diff;
		else output=diff;

		for(int i=1;i<s.length();i++) {
			diff=Math.abs(s.charAt(i)-s.charAt(i-1));

			if(diff>13) output+=(26-diff);
			else output+=diff;
		}

		return output;
	}
}
