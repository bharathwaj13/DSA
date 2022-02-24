package week9;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumber {

	/*
	 * 
	 * Leetcode # 202
	 * https://leetcode.com/problems/happy-number
	 * 
	 * Write an algorithm to determine if a number n is happy.
	 * A happy number is a number defined by the following process:
	 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
	 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
	 * which does not include 1.Those numbers for which this process ends in 1 are happy.
	 * Return true if n is a happy number, and false if not.
	 * 
	 */

	@Test
	public void example1() {
		int n=19;
		boolean output=true;
		Assert.assertTrue(findHappyNumber(n));
	}

	@Test
	public void example2() {
		int n=2;
		boolean output=false;
		Assert.assertFalse(findHappyNumber(n));
	}
	
	@Test
	public void example3() {
		int n=13;
		boolean output=true;
		Assert.assertTrue(findHappyNumber(n));
	}
	
	@Test
	public void example4() {
		int n=12;
		boolean output=false;
		Assert.assertFalse(findHappyNumber(n));
	}


	private boolean findHappyNumber(int n) {
		int sum=0;
		while(true) {
			while(n>0) {
				sum+=Math.pow(n%10, 2);
				n=n/10;
			}

			if(sum<10) {
				if(sum==1 || sum==7) return true;
				else return false;
			}
			else {
				n=sum;
				sum=0;
			}
		}

	}

}
