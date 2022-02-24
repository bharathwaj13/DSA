package week6hw;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BalanceParantheses_HackerRank {

	/*
	 * Leetcode: 1963
	 * 
	 * You are given a 0-indexed string s of even length n. The string consists of
	 * exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
	 * 
	 * A string is called balanced if and only if:
	 * 
	 * It is the empty string, or It can be written as AB, where both A and B are
	 * balanced strings, or It can be written as [C], where C is a balanced string.
	 * You may swap the brackets at any two indices any number of times.
	 * 
	 * Return the minimum number of swaps to make s balanced.
	 */

	@Test
	public void example1() {
		String s="][][";
		int output=1;
		Assert.assertTrue(output==balance(s));
	}

	@Test
	public void example2() {
		String s="]]][[[";
		int output=2;
		Assert.assertTrue(output==balance(s));
	}

	@Test
	public void example3() {
		String s="[]";
		int output=0;
		Assert.assertTrue(output==balance(s));
	}



	private int balance(String s) {
		Stack<Character> stack=new Stack<Character>();
		int counter=0;

		char[] charArray = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(charArray[i]==']' ) {
				if(!stack.isEmpty()) {
					if(stack.peek()=='[') stack.pop();
					else {
						counter++;
					}
				}
				else {
					counter++;
					stack.push(charArray[i]);
				}
			}
			else stack.push(charArray[i]);
		}
		System.out.println((counter+1)/2);
		//	It is (counter+1)/2 because every swap removes 2 unbalanced parantheses. 
		return (counter+1)/2;
	}
}
