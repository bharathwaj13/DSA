package week4hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedDNASequence_Arun {


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
		 HashSet<String> sequenceSet=new HashSet<String>();
			LinkedList <String> resultList=new LinkedList <String>();
			if(s.length()<10)return resultList;
			int left=0;	
			String windowString;
			
			for (int right=10;right<=s.length();right++) {
				windowString=s.substring(left++, right);
				if (!sequenceSet.add(windowString)) {
					if(!resultList.contains(windowString))resultList.add(windowString);
				}
					
			}
		    return resultList;
	}

}
