package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PlusOne {

	/*
	 * 
	 * You are given a large integer represented as an integer array digits, 
	 * where each digits[i] is the ith digit of the integer. The digits are 
	 * ordered from most significant to least significant in left-to-right order.
	 * The large integer does not contain any leading 0's.Increment the large integer
	 * by one and return the resulting array of digits.
	 * 
	 */


	@Test
	public void example1() {
		int[] digits= {1,2,3};
		int[] output= {1,2,4};
		Assert.assertTrue(Arrays.equals(output, plusOne(digits)));
	}

	@Test
	public void example2() {
		int[] digits= {4,3,2,1};
		int[] output= {4,3,2,2};
		Assert.assertTrue(Arrays.equals(output, plusOne(digits)));
	}

	@Test
	public void example3() {
		int[] digits= {0};
		int[] output= {1};
		Assert.assertTrue(Arrays.equals(output, plusOne(digits)));
	}

	@Test
	public void example4() {
		int[] digits= {9};
		int[] output= {1,0};
		Assert.assertTrue(Arrays.equals(output, plusOne(digits)));
	}

	/*
	 * 
	 * Pseudocode:
	 * 1) Take the given array
	 * 2) Initialize a String
	 * 3) Loop through the array and append each integer as a String
	 * 4) Convert the String to an Integer and increment by one
	 * 5) Convert it back to String and Find the number of digits in it.
	 * 6) Initialize an Integer Array with the size of the String
	 * 6) Using while loop , add the reminder after dividing by 10 to the Integer array
	 *   
	 */


	private int[] plusOne(int[] digits) {
		String digitString="";
		int counter=0;
		for(int i=0;i<digits.length;i++) {
			digitString=digitString+digits[i];
		}
		int number=(Integer.parseInt(digitString))+1;
		digitString=number+"";
		counter=digitString.length();
		int[] output=new int[counter];
		while(number>0) {
			output[counter-1]=number%10;
			number=number/10;
			counter--;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
}


