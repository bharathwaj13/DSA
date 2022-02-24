package week3hw;



import org.junit.Assert;
import org.junit.Test;

public class GrumpyBookStoreOwner_AssignmentReview {


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

	/*
	 * Problem Statement:
	 * 
	 * https://leetcode.com/problems/grumpy-bookstore-owner/
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[] customers, int[] grumpy and int minutes
	 * What is the expected output? - int
	 * Do I have constraints to solve the problem? - Slinding Window
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1]  minutes = 3
	 *   
	 *  Edge     : customers = [1], grumpy = [1]  minutes = 1
	 *  
	 *  Negative : customers = [1], grumpy = [1,1]  minutes = 1
	 *
	 */

	@Test
	public void test1() {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy    = {0,1,0,1,0,1,0,1};
		int minutes		= 5;
		System.out.println(maxSatisfied(customers, grumpy, minutes));
	}


	@Test
	public void test2() {
		int[] customers = {3,2,5};
		int[] grumpy    = {0,1,1};
		int minutes		= 2;
		System.out.println(maxSatisfied1(customers, grumpy, minutes));
	}

	//Three Pass
	public int maxSatisfied(int[] customers, int[] grumpy, int k) {
		int maxCustomers = 0, currentCustomers = 0;
		for (int i = 0; i < grumpy.length; i++) {
			if (grumpy[i] == 0)
				currentCustomers += customers[i];
		}
		maxCustomers = currentCustomers;
		for (int i = 0; i < k; i++) {
			if (grumpy[i] == 1)
				currentCustomers += customers[i];

		}
		maxCustomers = Math.max(maxCustomers, currentCustomers);
		for (int i = k; i < grumpy.length; i++) {
			if (grumpy[i - k] == 1)
				currentCustomers -= customers[i - k];
			if (grumpy[i] == 1)
				currentCustomers += customers[i];
			maxCustomers = Math.max(maxCustomers, currentCustomers);
		}
		return maxCustomers;
	}

	//TwoPass
	public int maxSatisfied1(int[] customers, int[] grumpy, int k) {
		int maxCustomers = 0, currentCustomers = 0, j=0;
		for (int i = 0; i < grumpy.length; i++)
			if (grumpy[i] == 0) currentCustomers += customers[i];

		maxCustomers = currentCustomers;
		for (int i = 0; i < grumpy.length; i++) {
			if (grumpy[i] == 1) currentCustomers += customers[i];
			if(i >=k && (grumpy[i-k] == 1)) currentCustomers -= customers[i-k];
			maxCustomers = Math.max(maxCustomers, currentCustomers);
		}
		return maxCustomers;
	}

	//Optimized
	public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
		int happyCustomers = 0, maxChange = 0, currentChange=0;
		for (int i = 0; i < customers.length; i++) {
			if(grumpy[i] == 0) happyCustomers += customers[i];
			if(grumpy[i] == 1) currentChange += customers[i];
			if(i>=minutes && grumpy[i-minutes] == 1) currentChange -= customers[i-minutes];
			maxChange = Math.max(currentChange, maxChange);
		}
		return happyCustomers+maxChange;
	}
}
