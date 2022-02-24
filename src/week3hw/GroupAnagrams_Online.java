package week3hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagrams_Online{

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
		//Assert.assertTrue(output.equals(groupAnagrams(strs)));
		groupAnagrams(strs);
	}

	@Test
	public void example2() {
		String[] strs= {""};
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		//Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}

	@Test
	public void example3() {
		String[] strs= {"a"};
		ArrayList<String> al1=new ArrayList<String>(Arrays.asList("a"));
		List<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
		output.add(al1);
		//Assert.assertTrue(output.equals(groupAnagrams(strs)));
	}


	private List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String str: strs){
			char[] arr = new char[26];
			for(int i=0; i<str.length(); i++){
				arr[str.charAt(i)-'a']++;
				System.out.println(arr[str.charAt(i)-'a']++);
			}
			System.out.println("arr Array: "+ Arrays.toString(arr));
			String ns = new String(arr);
			System.out.println("ns: "+ns);
			if(map.containsKey(ns)){
				map.get(ns).add(str);
			}else{
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}

		result.addAll(map.values());
		System.out.println(result.toString());
		return result;
	}
}
