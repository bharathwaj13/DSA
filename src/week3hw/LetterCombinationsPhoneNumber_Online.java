package week3hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationsPhoneNumber_Online {

	/*Leetcode: 17
	 * 
	 * Given a string containing digits from 2-9 inclusive, return all possible letter 
	 * combinations that the number could represent. Return the answer in any order.
	 * A mapping of digit to letters (just like on the telephone buttons) is given below.
	 * Note that 1 does not map to any letters.
	 */

	@Test
	public void example1() {
		String digits="23";
		List<String> output=new ArrayList<String>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
		Assert.assertTrue(output.equals(letterCombinations(digits)));
	}


	@Test
	public void example2() {
		String digits="";
		List<String> output=new ArrayList<String>();
		Assert.assertTrue(output.equals(letterCombinations(digits)));
	}

	@Test
	public void example3() {
		String digits="2";
		List<String> output=new ArrayList<String>(Arrays.asList("a","b","c"));
		Assert.assertTrue(output.equals(letterCombinations(digits)));
	}


	private List<String> letterCombinations(String digits){
		HashMap<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		List<String> l = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return l;
		}

		l.add("");

		for (int i = 0; i < digits.length(); i++) {
			ArrayList<String> temp = new ArrayList<>();
			String option = map.get(digits.charAt(i));

			for (int j = 0; j < l.size(); j++) {
				for (int p = 0; p < option.length(); p++) {
					temp.add(new StringBuilder(l.get(j)).append(option.charAt(p)).toString());
				}
			}

			l.clear();
			l.addAll(temp);
		}

		return l;


	}

}
