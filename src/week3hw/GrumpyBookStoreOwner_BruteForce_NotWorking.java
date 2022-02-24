package week3hw;



import org.junit.Assert;
import org.junit.Test;

public class GrumpyBookStoreOwner_BruteForce_NotWorking {


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

	@Test
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


	@Test
	public void example2() {
		int[] customers= {1};
		int[] grumpy= {0};
		int minutes=1;
		int output=1;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}

	@Test
	public void example3() {
		int[] customers= {4,10,10};
		int[] grumpy= {1,1,0};
		int minutes=2;
		int output=24;
		Assert.assertTrue(output==grumpyBookStoreOwner(customers, grumpy, minutes));
	}

	@Test
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

		if((customers.length==1 && minutes>=1) || (customers.length==1 && grumpy[0]==0)) return customers[0];
		else if((customers.length==1 && grumpy[0]==1) || customers.length==0) return 0;

		int maxminuteSum=0,left=0,right=0,sum=0,minuteSum=0;

		for(int i=0;i<customers.length;i++) {
			if(grumpy[i]!=1){
				sum+=customers[i];
			}
		}
		System.out.println(sum);
		
		/*
		 * while(right<customers.length) { for(int i=left;i<=right;i++) {
		 * if(grumpy[i]==1) minuteSum+=customers[i]; }
		 * maxminuteSum=Math.max(maxminuteSum, minuteSum); minuteSum=0; left++; right++;
		 * }
		 */

		//Below While Loop is faster than the above while loop as it uses Sliding Window
		
		while(right<customers.length) {
			if(right-left==minutes) {
				minuteSum+=(customers[right]*grumpy[right])-(customers[left]*grumpy[left]);
				maxminuteSum=Math.max(maxminuteSum, minuteSum);
				left++;
				right++;
			}
			else {
				if(grumpy[right]==1) {
					minuteSum+=customers[right];
					maxminuteSum=Math.max(maxminuteSum, minuteSum);
				}
				right++;
			}
		}
		System.out.println(sum+maxminuteSum);
		return sum+maxminuteSum;
	}
}
