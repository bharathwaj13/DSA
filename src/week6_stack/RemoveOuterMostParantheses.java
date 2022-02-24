package week6_stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class RemoveOuterMostParantheses {


	/*
	 * Leetcode# 1021
	 * 
	 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where
	 * A and B are valid parentheses strings, and + represents string concatenation.
	 * 
	 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses
	 * strings. A valid parentheses string s is primitive if it is nonempty, and
	 * there does not exist a way to split it into s = A + B, with A and B nonempty
	 * valid parentheses strings.
	 * 
	 * Given a valid parentheses string s, consider its primitive decomposition: s =
	 * P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
	 * 
	 * Return s after removing the outermost parentheses of every primitive string
	 * in the primitive decomposition of s.
	 */


	@Test
	public void example1() {
		String s="(()())(())";
		String output="()()()";
		Assert.assertTrue(output.equals(removeOuterParenthese(s)));
	}

	@Test
	public void example2() {
		String s="(()())(())(()(()))";
		String output="()()()()(())";
		Assert.assertTrue(output.equals(removeOuterParenthese(s)));
	}

	@Test
	public void example3() {
		String s="()()";
		String output="";
		Assert.assertTrue(output.equals(removeOuterParenthese(s)));
	}



	private String removeOuterParenthese(String s) {

		if(s.length()<4) return new String();
		Stack<String> stack=new Stack<String>();
		String out="";
		StringBuilder sb=new StringBuilder(); 

		int openCount=0;
		int closeCount=0;

		for(int i=0;i<s.length();i++) {
			stack.push(s.charAt(i)+"");
			if(s.charAt(i)=='(') openCount++;
			else closeCount++;

			if(openCount==closeCount) {
				stack.pop();
				while(stack.size()>1) {
					out=stack.pop()+out;
				}
				sb.append(out);
				out="";
				stack.pop();
				openCount=0;
				closeCount=0;
			}
		}

		out=sb.toString();
		return out;
	}
}
