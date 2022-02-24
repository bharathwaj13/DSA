package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindAllAnagrams {

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
		int left=0, right=0;
		Map<Character,Integer> sMap=new HashMap();
		Map<Character,Integer> pMap=new HashMap();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<p.length();i++) {
			pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
		}

		for(right=0;right<s.length();right++) {
			if(right>=p.length()) {
				if(sMap.get(s.charAt(left))>1) {
					sMap.put(s.charAt(left), sMap.get(s.charAt(left))-1);
				}
				else sMap.remove(s.charAt(left));
				sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0)+1);
				left++;
			}
			else sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0)+1);
			if(sMap.equals(pMap)) {
				list.add(left);
			}
		}
		return list;
	}
}
