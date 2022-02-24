package week3hw;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RomanToInteger {


	/*
	 * Leetcode: 13
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	 * Symbol       Value
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 * For example, 2 is written as II in Roman numeral, just two one's added together.
	 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
	 * which is XX + V + II.
	 * 
	 * Roman numerals are usually written largest to smallest from left to right. 
	 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
	 * Because the one is before the five we subtract it making four. The same principle applies
	 * to the number nine, which is written as IX. There are six instances where subtraction is
	 * used:
	 * I can be placed before V (5) and X (10) to make 4 and 9.
	 * X can be placed before L (50) and C (100) to make 40 and 90.
	 * C can be placed before D (500) and M (1000) to make 400 and 900.
	 * 
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * 
	 */

	@Test
	public void example1() {
		String s="III";
		int output=3;
		Assert.assertTrue(output==romanToInteger(s));
	}

	@Test
	public void example2() {
		String s="LVIII";
		int output=58;
		Assert.assertTrue(output==romanToInteger(s));
	}

	@Test
	public void example3() {
		String s="MCMXCIV";
		int output=1994;
		Assert.assertTrue(output==romanToInteger(s));
	}


	private int romanToInteger(String s) {

		Map<Character,Integer> sMap=new HashMap<Character,Integer>();
		sMap.put('I', 1);
		sMap.put('V', 5);
		sMap.put('X', 10);
		sMap.put('L', 50);
		sMap.put('C', 100);
		sMap.put('D', 500);
		sMap.put('M', 1000);

		//Loop through the String from the end

		int sum=sMap.get(s.charAt(s.length()-1));
		if(s.length()==1) return sum;

		for(int i=s.length()-2;i>=0;i--) {

			//If the previous Roman Numeral is lesser then subtract from sum

			if(sMap.get(s.charAt(i+1)) > sMap.get(s.charAt(i))) sum-=sMap.get(s.charAt(i));
			else sum+=sMap.get(s.charAt(i));
		}
		return sum;
	}


}
