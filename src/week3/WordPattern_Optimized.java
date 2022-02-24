package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class WordPattern_Optimized {

	/*Leetcode
	 * 
	 * Given a pattern and a string s, find if s follows the same pattern.
	 * Here follow means a full match, such that there is a bijection between
	 * a letter in pattern and a non-empty word in s.
	 * 
	 */

	//@Test
	public void example1() {
		String pattern="abba";
		String s="dog cat cat dog";
		boolean output=true;
		Assert.assertTrue(wordPattern(pattern, s));
	}

	//@Test
	public void example2() {
		String pattern="abba";
		String s="dog cat cat fish";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}
	
	@Test
	public void example6() {
		String pattern="abbc";
		String s="dog cat cat dog";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}

	//@Test
	public void example3() {
		String pattern="aaaa";
		String s="dog cat cat dog";
		boolean output=false;
		Assert.assertFalse(wordPattern(pattern, s));
	}

	//@Test
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

	//String pattern="abbc";
	//String s="dog cat cat dog";

	private boolean wordPattern(String pattern,String s) {

		Map<Character,String> charMap=new HashMap<>();
		Map<String,Character> wordMap=new HashMap<>();

		String[] words=s.split(" ");
		if(pattern.length() != words.length) return false;

		int i=0;
		while(i<words.length) {
			char c=pattern.charAt(i);
			String word=words[i++];

			if(!charMap.containsKey(c) && !wordMap.containsKey(word)) {
				charMap.put(c, word);
				wordMap.put(word, c);
			}else if(charMap.containsKey(c) && !word.equals(charMap.get(c))){
				return false;
			}
			else if(wordMap.containsKey(word) && c!=wordMap.get(word)) {
				System.out.println("word: " +word+ "c: "+c);
				return false;
			}
		}
		return true;
	}
}
