package week3hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagrams_BruteForce {

	/*
	 * 
	 * Given an array of strings strs, group the anagrams together. 
	 * You can return the answer in any order.An Anagram is a word or phrase 
	 * formed by rearranging the letters of a different word or phrase,
	 * typically using all the original letters exactly once.
	 * 
	 */


	@Test
	public void example1() {
		String[] strs= {"eat","tea","tan","ate","nat","bat"};
		ArrayList<String> al1=new ArrayList<String>(Arrays.asList("bat"));
		ArrayList<String> al2=new ArrayList<String>(Arrays.asList("nat","tan"));
		ArrayList<String> al3=new ArrayList<String>(Arrays.asList("ate","tea","eat"));
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		output.add(al1); output.add(al2); output.add(al3);
		Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}

	@Test
	public void example2() {
		String[] strs= {""};
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}

	@Test
	public void example3() {
		String[] strs= {"a"};
		ArrayList<String> al1=new ArrayList<String>(Arrays.asList("a"));
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		output.add(al1);
		Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}

	@Test
	public void example4() {
		String[] strs= {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
		ArrayList<String> al1=new ArrayList<String>(Arrays.asList("a"));
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		output.add(al1);
		Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}


	private List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> output=new ArrayList<List<String>>();
		ArrayList<String> inputList=new ArrayList<String>(Arrays.asList(strs));
		List<String> tempList=new ArrayList<String>();

		while(inputList.size()>0) {
			tempList=returnAnagrams(inputList);
			output.add(tempList);
			for (String string : tempList) {
				inputList.remove(string);
			}
		}
		System.out.println(output.toString());
		return output;
	}

	private List<String> returnAnagrams(List checkList){
		LinkedList<String> returnList=new LinkedList<String>();
		char[] char1=checkList.get(0).toString().toCharArray();
		char[] char2=new char[100];
		Arrays.sort(char1);
		for(int i=0;i<checkList.size();i++) {
			char2=checkList.get(i).toString().toCharArray();
			Arrays.sort(char2);
			if(Arrays.equals(char1,char2))
				returnList.add((String) checkList.get(i));
		}

		return returnList;
	}

}
