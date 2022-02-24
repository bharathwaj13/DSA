package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FreshWorksQuestions_WordPattern_Optimized {

	/*
	 * Example 1:
	 * String[] ch = {"abb", "abc", "xyz", "xyy"};
	 * String pattern = "mnn";
	 * Output: ["xyy","abb"] --> List -> Any order
	 * Answer: xyy and abb have same character at index 1 and 2 like the pattern
	 * 
	 * Example 2:
	 * String[] ch = {"abb", "abc", "xyz", "xyy"};
	 * String pattern =  "mno";
	 * Output: ["abc", "xyz"]
	 * Output: abc and xyz have all distinct characters, similar to the pattern.
	 * 
	 * Example 3:
	 * String[] ch = ["abb", "abc", "xyz", "xyy"];
	 * String pattern = "aba";
	 * Output: [] 
	 * Pattern has same character at index 0 and 2. No word in dictionary follows the pattern.
	 * 
	 */


	@Test
	public void example1() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="mno";
		ArrayList<String> output=new ArrayList(Arrays.asList("abc","xyz"));
		Assert.assertTrue(output.equals(wordPattern(ch, pattern)));
	}

	@Test
	public void example2() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="mnn";
		ArrayList<String> output=new ArrayList(Arrays.asList("abb","xyy"));
		Assert.assertTrue(output.equals(wordPattern(ch, pattern)));
	}

	@Test
	public void example3() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="aba";
		ArrayList<String> output=new ArrayList();
		Assert.assertTrue(output.equals(wordPattern(ch, pattern)));
	}


	/*
	 * Pseudocode:
	 * 1) Loop through the pattern String and form an Integer associated with it.
	 * 2) Map every unique character of the String pattern to an Integer
	 * 3) For every String in the String array also, repeat Step 2
	 * 4) If the Integer is same as that of Pattern String, then add to ArrayList
	 * 
	 */

	//String[] ch={"abb", "abc", "xyz", "xyy"};
	//String pattern="mno";

	private List<String> wordPattern(String[] ch,String pattern){

		Map<Character,Character> patternMap=new HashMap<>();
		Map<Character,Character> wordMap=new HashMap<>();
		List<String> output=new ArrayList<String>();
		Boolean bFlag=false;

		for (int j=0;j<ch.length;j++) {
			String word=ch[j];
			bFlag=false;
			if(word.length()!=pattern.length()) continue;
			for(int i=0;i<word.length();i++) {

				if(!patternMap.containsKey(pattern.charAt(i)) && !wordMap.containsKey(word.charAt(i))) {
					patternMap.put(pattern.charAt(i), word.charAt(i));
					wordMap.put(word.charAt(i),pattern.charAt(i));
				}
				else if(patternMap.containsKey(pattern.charAt(i)) && !patternMap.get(pattern.charAt(i)).equals(word.charAt(i))) {
					bFlag=true;
					break;
				}
				else if(wordMap.containsKey(word.charAt(i)) && !wordMap.get(word.charAt(i)).equals(pattern.charAt(i))) {
					bFlag=true;
					break;
				}
			}
			if(!bFlag) output.add(word);
			wordMap.clear(); patternMap.clear();
		}
		System.out.println(output);
		return output;
	}

}
