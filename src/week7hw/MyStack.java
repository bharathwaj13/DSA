package week7hw;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class MyStack {


	/*
	 * https://leetcode.com/problems/implement-stack-using-queues/
	 * Leetcode : 225
	 * 
	 */

	Queue<Integer> queue;

	public MyStack() {
		queue=new ArrayDeque<Integer>();
	}

	public void push(int x) { 
		queue.offer(x);
		int size=queue.size();
		while(size>1) {
			queue.offer(queue.poll());
			size--;
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	
	@Test
	public void queueToStack() {
		MyStack myStack=new MyStack();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.empty());
		
		
	}
}
