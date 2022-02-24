package week4hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedDNASequence {


	/*
	 * Leetcode: 187
	 * 
	 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
	 * 'C', 'G', and 'T'.
	 * 
	 * For example, "ACGAATTCCG" is a DNA sequence. When studying DNA, it is useful
	 * to identify repeated sequences within the DNA.
	 * 
	 * Given a string s that represents a DNA sequence, return all the
	 * 10-letter-long sequences (substrings) that occur more than once in a DNA
	 * molecule. You may return the answer in any order.
	 */

	@Test
	public void example1() {
		String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> output=new ArrayList<String>(Arrays.asList("AAAAACCCCC","CCCCCAAAAA"));
		Assert.assertTrue(output.equals(repeatedDNA(s)));
	}

	@Test
	public void example2() {
		String s="AAAAAAAAAAAAA";
		List<String> output=new ArrayList<String>(Arrays.asList("AAAAAAAAAA"));
		Assert.assertTrue(output.equals(repeatedDNA(s)));
	}
	
	@Test
	public void example3() {
		String s="AAAAAAAAAAA";
		List<String> output=new ArrayList<String>(Arrays.asList("AAAAAAAAAA"));
		Assert.assertTrue(output.equals(repeatedDNA(s)));
	}


	private List<String> repeatedDNA(String s){
		if(s.length()<10) return new ArrayList<>();
		List<String> output=new ArrayList<String>();
		HashSet<String> set=new HashSet<String>();
		String sub="";
		int left=0,right=10;
		while(right<=s.length()) {
			sub=s.substring(left++, right++);
			if(!set.add(sub) && !output.contains(sub)) {
				output.add(sub);
			}
		}
		System.out.println(output.toString());
		return output;
	}

}
