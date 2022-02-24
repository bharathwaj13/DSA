package week3hw;



import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class GrumpyBookStoreOwner_Arun {


	/*
	 * Leetcode: 1052
	 * 
	 * There is a bookstore owner that has a store open for n minutes.
	 * Every minute, some number of customers enter the store. You are given an integer array
	 * customers of length n where customers[i] is the number of the customer that enters
	 * the store at the start of the ith minute and all those customers leave after the end
	 * of that minute. On some minutes, the bookstore owner is grumpy. You are given 
	 * a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during
	 * the ith minute, and is 0 otherwise.When the bookstore owner is grumpy, the customers
	 * of that minute are not satisfied, otherwise, they are satisfied.The bookstore owner 
	 * knows a secret technique to keep themselves not grumpy for minutes consecutive minutes
	 * , but can only use it once.Return the maximum number of customers that can be
	 * satisfied throughout the day.
	 * 
	 */

	//@Test
	public void example1() {
		int[] customers= {1,0,1,2,1,1,7,5};
		int[] grumpy= {0,1,0,1,0,1,0,1};
		int minutes=3;
		int output=16;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));

		/*
		 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3
		 * minutes. The maximum number of customers that can be satisfied = 1 + 1 + 1 +
		 * 1 + 7 + 5 = 16.
		 */
	}


	//@Test
	public void example2() {
		int[] customers= {1};
		int[] grumpy= {0};
		int minutes=1;
		int output=1;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}
	
	//@Test
	public void example3() {
		int[] customers= {4,10,10};
		int[] grumpy= {1,1,0};
		int minutes=2;
		int output=24;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}
	
	//@Test
	public void example4() {
		int[] customers= {7,8,8,6};
		int[] grumpy= {0,1,0,1};
		int minutes=3;
		int output=29;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}
	
	@Test
	public void example5() {
		int[] customers= {6,10,2,1,7,9};
		int[] grumpy= {1,0,0,0,0,1};
		int minutes=3;
		int output=29;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}



	private int grumpyBookStoreOwner(int[] customers,int[] grumpy,int minutes) {

		int sum=0,maxSum=0,left=0;
		//Creating a map that holds sum of Satisfied and dissatisfied customer count
		HashMap<Integer,Integer> GrumpSatCustMap=new HashMap<Integer,Integer>();
		for(int i=0;i<customers.length;i++) {
			GrumpSatCustMap.put(grumpy[i], GrumpSatCustMap.getOrDefault(grumpy[i], 0)+customers[i]);
		}
		//Considering from 0th index to minutes-1 index, consider all dissatisfied customer all so Satisfied
		for(int i=0;i<minutes;i++) {
			if(grumpy[i]!=0) {
				GrumpSatCustMap.put(0, GrumpSatCustMap.getOrDefault(0, 0)+customers[i]);
		//		GrumpSatCustMap.put(1, GrumpSatCustMap.getOrDefault(1, 0)-customers[i]);
			}
		}
		sum=GrumpSatCustMap.get(0);
		maxSum=sum;
		//Move the window with size as minutes if left min is 1 the subtract the customer count from sum else do 
		//nothing, if right = 1 add the dissatisfed cust as sat cust
		for(int right=minutes;right<grumpy.length;right++) {
			if(grumpy[right-minutes]==1)sum-=customers[right-minutes];
			if(grumpy[right]==1)sum+=customers[right];
			maxSum=Math.max(maxSum, sum);
		}
		
		return maxSum;
	}
}
