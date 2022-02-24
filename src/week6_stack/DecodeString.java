package week6_stack;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class DecodeString {


	/*
	 * Leetcode: 394
	 * 
	 * Given an encoded string, return its decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the
	 * square brackets is being repeated exactly k times. Note that k is guaranteed
	 * to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; there are no extra
	 * white spaces, square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any
	 * digits and that digits are only for those repeat numbers, k. For example,
	 * there will not be input like 3a or 2[4].
	 */

	@Test
	public void example1() {
		String s="3[a]2[bc]";
		String output="aaabcbc";
		Assert.assertTrue(output.equals(decodeString(s)));
	}
	
	
	@Test
	public void example2() {
		String s="3[a2[c]]";
		String output="accaccacc";
		Assert.assertTrue(output.equals(decodeString(s)));
	}



	private String decodeString(String s) {
		Stack stack = new Stack();
		String count="";
		int repeat=0;
		String temp="";
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)==']') {
				StringBuilder sb=new StringBuilder();
				while(!stack.peek().equals('[')) {
					sb.append(stack.pop());
				}
				stack.pop();
				while(!stack.isEmpty() && Character.isDigit(stack.peek().toString().charAt(0))) {
					count=stack.pop()+count;
				}
				repeat=Integer.parseInt(count);
				sb.reverse();
				while(repeat>0) {
					temp=temp+sb;
					repeat--;
				}
				count="";
				for(int j=0;j<temp.length();j++) {
					stack.push(temp.charAt(j)+"");
				}
				temp="";
			}
			else {
				stack.push(s.charAt(i));
			}
		}

		StringBuilder output=new StringBuilder();
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		temp=output.reverse().toString();
		return temp;
	}
}
