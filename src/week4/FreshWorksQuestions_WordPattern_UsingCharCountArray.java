package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FreshWorksQuestions_WordPattern_UsingCharCountArray {

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
		Assert.assertTrue(output.equals(getAllMatchingPatterns(ch, pattern)));
	}

	@Test
	public void example2() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="mnn";
		ArrayList<String> output=new ArrayList(Arrays.asList("abb","xyy"));
		Assert.assertTrue(output.equals(getAllMatchingPatterns(ch, pattern)));
	}

	@Test
	public void example3() {
		String[] ch={"abb", "abc", "xyz", "xyy"};
		String pattern="aba";
		ArrayList<String> output=new ArrayList();
		Assert.assertTrue(output.equals(getAllMatchingPatterns(ch, pattern)));
	}


	private boolean isMatchingPattern(String word, String pattern) {

		int len = word.length();
		if (pattern.length() != len) return false;
		int[] ch = new int[128];

		for(int i = 0; i < len; i++){
			if (ch[(int)pattern.charAt(i)] == 0) { // should check that value does not exist in the given char array
				for (int j = 0; j < ch.length; j++) {
					if(ch[j] ==  word.charAt(i)) return false;
				}
				ch[(int)pattern.charAt(i)] = word.charAt(i);
			}else if (ch[(int)pattern.charAt(i)] != word.charAt(i))
				return false;
		}
		return true;
	}


	// Time complexity: O[n*m*128]
	private List<String> getAllMatchingPatterns(String[] str, String pattern){
		List<String> lst = new ArrayList<String>();
		for(String word : str)
			if (isMatchingPattern(word, pattern)) lst.add(word);
		return lst;
	}

}
