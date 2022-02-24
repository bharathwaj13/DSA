package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Anagrams {

	@Test
	public void example1() {
		String s = "cbaebabacd";
		String p = "abc";
		ArrayList<Integer> output=new ArrayList<Integer>(Arrays.asList(0,6));
		Assert.assertTrue(output.equals(findAllAnagrams(s,p)));
	}
	
	@Test
	public void example2() {
		String s = "abab";
		String p = "ab";
		ArrayList<Integer> output=new ArrayList<Integer>(Arrays.asList(0,1,2));
		Assert.assertTrue(output.equals(findAllAnagrams(s,p)));
	}


	private List<Integer> findAllAnagrams(String s,String p) {
		Map<Character,Integer> pMap=new HashMap<Character,Integer>();
		Map<Character,Integer> sMap=new HashMap<Character,Integer>();
		ArrayList<Integer> list=new ArrayList<Integer>();

		for(int i=0;i<p.length();i++) {
			pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
		}

		/*
		 * for(int i=0;i<p.length();i++) { sMap.put(s.charAt(i),
		 * sMap.getOrDefault(p.charAt(i), 0)+1); }
		 */
		if(pMap.equals(sMap)) list.add(0);
		for(int i=p.length();i<s.length();i++) {

			if(sMap.get(s.charAt(i-p.length()))>1){
				sMap.put(s.charAt(i-p.length()), sMap.get(s.charAt(i-p.length()))-1);
			}
			else {
				sMap.remove(s.charAt(i-p.length()));
			}
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
			//if(pMap.equals(sMap)) System.out.println("Anagram");
			if(pMap.equals(sMap)) list.add(i-p.length()+1);
		}
		System.out.println(list.toString());
		return list;
	}

}
