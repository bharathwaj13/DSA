package week1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



public class CheckIntegersCoveredInRange {

	/*
	 *Leetcode: 1893
	 * 
	 * You are given a 2D integer array ranges and two integers left and right. 
	 * Each ranges[i] = [starti, endi] represents an inclusive interval between 
	 * starti and endi.Return true if each integer in the inclusive range 
	 * [left, right] is covered by at least one interval in ranges. 
	 * Return false otherwise.An integer x is covered by an interval 
	 * ranges[i] = [starti, endi] if starti <= x <= endi.
	 * 
	 */

	@Test
	public void positive() {
		int[][] ranges= {{1,2},{3,4},{5,6}};
		int left=2;
		int right=5;
		Assert.assertTrue(checkIfIntegersCovered(ranges, left, right));
	}

	@Test
	public void edge() {
		int[][] ranges= {{1,2},{3,4},{6,6}};
		int left=2;
		int right=5;
		Assert.assertFalse(checkIfIntegersCovered(ranges, left, right));
	}

	@Test
	public void negative() {
		int[][] ranges= {{1,10},{10,20}};
		int left=21;
		int right=21;
		Assert.assertFalse(checkIfIntegersCovered(ranges, left, right));
	}

	@Test
	public void example1() {
		int[][] ranges= {{1,50}};
		int left=1;
		int right=50;
		Assert.assertTrue(checkIfIntegersCovered(ranges, left, right));
	}

	/*
	 * Pesudocode:
	 * 1) Initialize an arrayList
	 * 2) Loop through the given 2D array and add each element to the arrayList
	 * 3) Loop through the range and check if the arrayList contains each element
	 * 4) If no then return false
	 * 5) Else return true
	 * 
	 */

	private boolean checkIfIntegersCovered(int[][] ranges,int left,int right) {
		ArrayList<Integer> arrList=new ArrayList<Integer>();
		for(int i=0;i<ranges.length;i++) {
			int start=ranges[i][0];
			int end=ranges[i][1];
			for(int j=start;j<=end;j++) {
				arrList.add(j);
			}
		}
		for(int i=left;i<=right;i++) {
			if(!arrList.contains(i)) return false; 
		}
		return true;
	}
}
