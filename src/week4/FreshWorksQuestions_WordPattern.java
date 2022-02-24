package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FreshWorksQuestions_WordPattern {

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
	public void example2() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="mnn";
		ArrayList<String> output=new ArrayList(Arrays.asList("abb,xyy"));
		Assert.assertTrue(output.equals(wordPattern(ch, pattern)));
	}
	
	@Test
	public void example3() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="aba";
		ArrayList<String> output=new ArrayList(Arrays.asList(""));
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



	private List<String> wordPattern(String[] ch,String pattern){
		String intPattern="";
		String temp="";
		int counter=0;
		HashMap<String,Integer> patternMap=new HashMap<String,Integer>();
		ArrayList<String> output=new ArrayList<String>();

		for(int i=0;i<pattern.length();i++) {
			if(patternMap.containsKey(pattern.charAt(i)+"")) {
				intPattern=intPattern+patternMap.get(pattern.charAt(i)+"");
			}
			else patternMap.put(pattern.charAt(i)+"", counter++);
		}

		for (String string : ch) {
			patternMap.clear();
			counter=0;
			temp="";
			for(int i=0;i<string.length();i++) {
				if(patternMap.containsKey(string.charAt(i)+"")) {
					temp=temp+patternMap.get(string.charAt(i)+"");
				}
				else patternMap.put(string.charAt(i)+"", counter++);
			}
			if(temp.equals(intPattern)) output.add(string);
		}
		System.out.println(output.toString());
		return output;
	}

}
