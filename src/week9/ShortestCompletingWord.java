package week9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class ShortestCompletingWord {

	/*
	 * 
	 * Leetcode: 748
	 * 
	 * https://leetcode.com/problems/shortest-completing-word/
	 */

	@Test
	public void example1() {
		String licensePlate = "1s3 PSt";
		String[] words= {"step","steps","stripe","stepple"};
		Assert.assertTrue(shortestCompletingWord(licensePlate, words).equalsIgnoreCase("steps"));
	}

	@Test
	public void example2() {
		String licensePlate = "1s3 456";
		String[] words= {"looks","pest","stew","show"};
		Assert.assertTrue(shortestCompletingWord(licensePlate, words).equalsIgnoreCase("pest"));
	}
	
	@Test
	public void example3() {
		String licensePlate = "TE73696";
		String[] words= {"ten","two","better","talk","suddenly","stand","protect","collection","about","southern"};
		Assert.assertTrue(shortestCompletingWord(licensePlate, words).equalsIgnoreCase("ten"));
	}
	
	@Test
	public void example4() {
		String licensePlate = "GrC8950";
		String[] words= {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
		Assert.assertTrue(shortestCompletingWord(licensePlate, words).equalsIgnoreCase("according"));
	}

	private String shortestCompletingWord(String licensePlate, String[] words) {

		licensePlate=licensePlate.replaceAll( "[^a-zA-Z]", "").replaceAll("\\s", "").toLowerCase();
		Map<Character,Integer> countMap=new HashMap<Character,Integer>();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		List<String> list=new ArrayList<String>();
		boolean bMatch=true;

		for(int i=0;i<licensePlate.length();i++) {
			countMap.put(licensePlate.charAt(i), countMap.getOrDefault(licensePlate.charAt(i), 0)+1);
		}

		for (String string : words) {
			for(int i=0;i<string.length();i++) {
				map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0)+1);
			}

			for (Entry each : countMap.entrySet()) {
				if(map.containsKey(each.getKey())) {
					if((Integer)each.getValue()<=map.get(each.getKey())) {
						continue;
					}
					else {
						bMatch=false;
						break;
					}
				}
				else {
					bMatch=false;
					break;
				}
			}
			if (bMatch) list.add(string);
			bMatch=true;
			map.clear();
		}

		int minIndex=Integer.MAX_VALUE;
		int index=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).length()<minIndex) {
				minIndex=list.get(i).length();
				index=i;
			}
			//if(list.get(i-1).length() > list.get(i).length()) minIndex=i;
		}
		System.out.println(list);
		System.out.println(index);
		return list.get(index);
	}
}
