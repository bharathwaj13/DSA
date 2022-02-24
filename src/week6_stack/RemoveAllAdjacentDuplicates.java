package week6_stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class RemoveAllAdjacentDuplicates {


	/*
	 * Leetcode: 1047
	 * 
	 * You are given a string s consisting of lowercase English letters. A duplicate
	 * removal consists of choosing two adjacent and equal letters and removing
	 * them.
	 * 
	 * We repeatedly make duplicate removals on s until we no longer can.
	 * 
	 * Return the final string after all such duplicate removals have been made. It
	 * can be proven that the answer is unique.
	 */

	@Test
	public void example1() {
		String s="abbaca";
		String output="ca";
		Assert.assertTrue(output.equals(removeAdjacentDups(s)));
	}


	@Test
	public void example2() {
		String s="azxxzy";
		String output="ay";
		Assert.assertTrue(output.equals(removeAdjacentDups(s)));
	}



	private String removeAdjacentDups(String s) {
		Stack<Character> stack=new Stack<Character>();
		stack.push(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			if(!stack.isEmpty() && stack.peek()==(s.charAt(i))) {
				stack.pop();
			}
			else {
				stack.push(s.charAt(i));
			}
		}

		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.reverse().toString();

	}
}
