package week3;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;



public class WordPatternUsingBruteForce {

	/*Leetcode
	 * 
	 * Given a pattern and a string s, find if s follows the same pattern.
	 * Here follow means a full match, such that there is a bijection between
	 * a letter in pattern and a non-empty word in s.
	 * 
	 */

	@Test
	public void example1() {
		String pattern="abba";
		String s="dog cat cat dog";
		boolean output=true;
		Assert.assertTrue(wordPattern(pattern, s));
	}

	@Test
	public void example2() {
		String pattern="abba";
		String s="dog cat cat fish";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}

	@Test
	public void example3() {
		String pattern="aaaa";
		String s="dog cat cat dog";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}
	
	@Test
	public void example4() {
		String pattern="aaa";
		String s="aa aa aa aa";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}


	/*
	 * 
	 * Pseudocode:
	 * 1) Loop through the pattern and each character to a Map
	 * 2) For every unique character , add a unique number to the Map and and a Pattern ArrayList.
	 * 3) If the character is already present in the key, then get the same value
	 * From the map and add it to the ArrayList.
	 * 4) Repeat steps 2) and 3) for String s and store it in a separate HashMap and a s ArrayList
	 * 5) Loop through the arraylists and check if they are equal until the length of the pattern
	 * 6) If yes return true else return false
	 *  
	 */


	private boolean wordPattern(String pattern,String s) {
		int counter=0;
		if(pattern.length()!=s.split(" ").length) return false;
		HashMap<Character,Integer> patternMap=new HashMap<Character,Integer>();
		HashMap<String,Integer> sMap=new HashMap<String,Integer>();
		ArrayList<Integer> patternList=new ArrayList<Integer>();
		ArrayList<Integer> sList=new ArrayList<Integer>();

		/*
		 * For every unique character in pattern String, associate it to an Integer and
		 * add it to patternList ArrayList
		 */
		
		for(int i=0;i<pattern.length();i++) {
			if(patternMap.containsKey(pattern.charAt(i))){
				patternList.add(patternMap.get(pattern.charAt(i)));				
			}
			else {
				patternMap.put(pattern.charAt(i), counter);
				patternList.add(counter++);
			}
		}
		counter=0;
		/*
		 * For every unique character in pattern s, associate it to an Integer and
		 * add it to sList ArrayList
		 */
		String[] split = s.split(" ");
		for(int i=0;i<split.length;i++) {
			if(sMap.containsKey(split[i])){
				sList.add(sMap.get(split[i]));				
			}
			else {
				sMap.put(split[i], counter);
				sList.add(counter++);
			}
		}

		for(int i=0;i<patternList.size();i++) {
			if(patternList.get(i)!=sList.get(i)){
				return false;
			}
		}
		return true;
	}
}
