package week5_linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class FrequencySort {

	@Test
	public void test1() {
		int[] data = {3,4,6,2,4,2};
		int[] output = {3,6,2,2,4,4};
		Assert.assertTrue(Arrays.equals(output, frequencySort(data)));
	}


	private int[] frequencySort(int[] nums) {
		int[] output=new int[nums.length];
		int index=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		Map<Integer,Integer> treeMap=new TreeMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0)+1);
		}
		list.addAll(treeMap.values());
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			for (Entry eachEntry : treeMap.entrySet()) {
				if(eachEntry.getValue()==list.get(i)) {
					int frequency=list.get(i);
					while(frequency>0) {
						output[index++]=(int) eachEntry.getKey();
						frequency--;
					}
					treeMap.put((Integer) eachEntry.getKey(), 0);
				}
			}
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
}
