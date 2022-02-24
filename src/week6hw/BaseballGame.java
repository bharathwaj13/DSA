package week6hw;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BaseballGame {


	/*
	 * LeetCode: 682 You are keeping score for a baseball game with strange rules.
	 * The game consists of several rounds, where the scores of past rounds may
	 * affect future rounds' scores.
	 * 
	 * At the beginning of the game, you start with an empty record. You are given a
	 * list of strings ops, where ops[i] is the ith operation you must apply to the
	 * record and is one of the following:
	 * 
	 * An integer x - Record a new score of x. "+" - Record a new score that is the
	 * sum of the previous two scores. It is guaranteed there will always be two
	 * previous scores. "D" - Record a new score that is double the previous score.
	 * It is guaranteed there will always be a previous score. "C" - Invalidate the
	 * previous score, removing it from the record. It is guaranteed there will
	 * always be a previous score. Return the sum of all the scores on the record.
	 */

	@Test
	public void example1() {
		String[] ops= {"5","2","C","D","+"};
		int output=30;
		Assert.assertTrue(output==baseballScore(ops));
	}

	@Test
	public void example2() {
		String[] ops= {"5","-2","4","C","D","9","+","+"};
		int output=27;
		Assert.assertTrue(output==baseballScore(ops));
	}


	@Test
	public void example3() {
		String[] ops= {"1"};
		int output=1;
		Assert.assertTrue(output==baseballScore(ops));
	}


	private int baseballScore(String[] ops) {

		Stack<String> stack=new Stack<String>();
		int sum=0;
		for(int i=0;i<ops.length;i++) {
			if(ops[i].equals("C")) stack.pop();
			else if(ops[i].equals("D")) stack.push(2*Integer.parseInt(stack.peek())+"");
			else if(ops[i].equals("+")) {
				stack.push(Integer.parseInt(stack.get(stack.size()-1)) + Integer.parseInt(stack.get(stack.size()-2))+"");
			}
			else stack.push(ops[i]);
		}

		while(!stack.isEmpty()) {
			sum+=Integer.parseInt(stack.pop());
		}
		return sum;
	}

}
