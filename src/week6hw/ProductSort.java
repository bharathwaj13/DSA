package week6hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class ProductSort {


	/*
	 * In a warehouse , a manager would like to sort the items in the stock. Given an array of n 
	 * item values, sort the array in ascending order, first by the number of items with a 
	 * certain value, then by the value themselves.
	 * 
	 * Example: 
	 * n=6
	 * items= {4,5,6,5,4,3}
	 * 
	 * - There are 2 values that occur twice: {4,4,5,5}
	 * - There are 2 values that occur once: {3,6}
	 * - The array of items sorted by quantity and then by value in ascending order
	 * is {3,6,4,4,5,5}
	 * 
	 * Function Description:
	 * Complete the function itemsSort in the editor below:
	 * 
	 *  itemsSort has the following parameter(s):
	 *  int items[n]: an array of integers to sort
	 *  Returns: int[n]: An array of integers sorted as described
	 *  
	 *  Constraints:
	 *  
	 *  - 1 <= n <= 2 *10^5
	 *  - 1 < items[i] <= 10^6
	 *  
	 * 
	 */

	@Test
	public void example1() {
		int[] input = {4,5,6,4,5,3,4};
		int[] output = {3,6,5,5,4,4,4};
		Assert.assertTrue(Arrays.equals(output,productSort(input)));
	}

	@Test
	public void example2() {
		int[]input = {4,3,1,6};
		int[] output = {1,3,4,6};
		Assert.assertTrue(Arrays.equals(output,productSort(input)));
	}

	@Test
	public void example3() {
		int[]input = {1,1,1,1,2,2,2,3,3,4};
		int[] output = {4,3,3,2,2,2,1,1,1,1};
		Assert.assertTrue(Arrays.equals(output,productSort(input)));
	}



	private int[] productSort(int[] input) {

		Map<Integer,Integer> map=new HashMap<Integer,Integer>();

		for(int i=0;i<input.length;i++) {
			map.put(input[i], map.getOrDefault(input[i], 0)+1);
		}

		List<Entry<Integer,Integer>> list=new ArrayList<Entry<Integer,Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {

				if(e1.getValue() > e2.getValue()) return 1;
				else if(e1.getValue() < e2.getValue()) return -1; 
				else return 0;
			}

		}

				);
		int i=0, frequency=0;
		for (Entry<Integer, Integer> entry : list) {
			frequency=entry.getValue();
			while(frequency>0) {
				input[i++]=entry.getKey();
				frequency--;
			}
		}
		
		return input;
	}

}
