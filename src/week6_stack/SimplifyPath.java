package week6_stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class SimplifyPath {


	/*
	 * Leetcode# 71
	 * 
	 * Given a string path, which is an absolute path (starting with a slash '/') to
	 * a file or directory in a Unix-style file system, convert it to the simplified
	 * canonical path.
	 * 
	 * In a Unix-style file system, a period '.' refers to the current directory, a
	 * double period '..' refers to the directory up a level, and any multiple
	 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
	 * problem, any other format of periods such as '...' are treated as
	 * file/directory names.
	 * 
	 * The canonical path should have the following format:
	 * 
	 * The path starts with a single slash '/'. Any two directories are separated by
	 * a single slash '/'. The path does not end with a trailing '/'. The path only
	 * contains the directories on the path from the root directory to the target
	 * file or directory (i.e., no period '.' or double period '..') Return the
	 * simplified canonical path.
	 */

	@Test
	public void example1() {
		String s="/home//foo";
		Assert.assertTrue(findPath(s).equals("/home/foo"));
	}

	@Test
	public void example2() {
		String s="/../";
		Assert.assertTrue(findPath(s).equals("/"));
	}

	@Test
	public void example3() {
		String s="/home/";
		Assert.assertTrue(findPath(s).equals("/home"));
	}

	private String findPath(String s) {
		Stack<String> stack=new Stack<String>();
		StringBuilder sb=new StringBuilder();
		//s=s.replaceAll("//", "/");
		String[] split=s.split("/");
		for(int i=0;i<split.length;i++) {
			if(split[i].isEmpty() || split[i].contentEquals(".")) continue;
			else if (split[i].equals("..")) {
				if(!stack.isEmpty()) stack.pop();
			}
			else stack.push(split[i]);
		}
		if(stack.isEmpty()) sb.append("/");
		while(!stack.isEmpty()) {
			sb.insert(0,"/"+stack.pop());
		}


		System.out.println(sb.toString());
		return sb.toString();
	}
}
