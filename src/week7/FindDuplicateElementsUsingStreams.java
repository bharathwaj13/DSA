package week7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateElementsUsingStreams {
	
	/*
	 * 
	 * int[] --> find the number of duplicate elements using stream and filter !!
	 */
	
	@Test
	public void example1() {
		int[] nums= {1,2,3,4,5,5,4,8};
		int output= 4;
		countDuplicateElements(nums);
	}
	
	
	private void countDuplicateElements(int[] nums) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,5,4,8);
		Set<Integer> set=new HashSet<Integer>(list);
		
		Set<Integer> collect = list.stream().filter(item -> !set.add(item)).collect(Collectors.toSet());
		System.out.println(collect);
	}

}
