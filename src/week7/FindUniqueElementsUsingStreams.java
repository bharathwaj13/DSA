package week7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindUniqueElementsUsingStreams {
	
	/*
	 * 
	 * int[] --> find the number of unique elements using stream and filter !!
	 */
	
	@Test
	public void example1() {
		int[] nums= {1,2,3,4,5,5,4,8};
		int output= 4;
		countUniqueElements(nums);
	}
	
	
	private void countUniqueElements(int[] nums) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,5,4,8);
		long count = list.stream().distinct().count();
		System.out.println(count);
		
		List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
	}

}
