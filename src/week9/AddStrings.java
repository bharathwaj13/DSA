package week9;

import org.junit.Assert;
import org.junit.Test;

public class AddStrings {

	/*
	 * Leetcode: #415
	 * 
	 * https://leetcode.com/problems/add-strings/
	 * 
	 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
	 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
	 * You must also not convert the inputs to integers directly.
	 * 
	 */

	@Test
	public void example1() {
		String num1="11";
		String num2="123";
		String output="134";
		Assert.assertTrue(output.equals(addStrings(num1, num2)));
	}

	@Test
	public void example2() {
		String num1="456";
		String num2="77";
		String output="533";
		Assert.assertTrue(output.equals(addStrings(num1, num2)));
	}

	private String addStrings(String num1,String num2) {
		int length1=num1.length()-1;
		int length2=num2.length()-1;
		int carry=0;
		int sum=0;
		StringBuilder output=new StringBuilder();
		while(length1>=0 || length2>=0) {
			if(length1>=0 && length2>=0) {
				sum=Integer.parseInt(num1.charAt(length1--)+"")+Integer.parseInt(num2.charAt(length2--)+"")+carry;
				if(sum>9) {
					output.append(sum%10);
					carry=sum/10;
				}
				else {
					output.append(sum);
					carry=0;
				}
				sum=0;
			}
			else if(length1>=0 && length2<0) {
				sum=Integer.parseInt(num1.charAt(length1--)+"")+carry;
				if(sum>9) {
					output.append(sum%10);
					carry=sum/10;
				}
				else {
					output.append(sum);
					carry=0;
				}
				sum=0;
			}
			else {
				sum=Integer.parseInt(num2.charAt(length2--)+"")+carry;
				if(sum>9) {
					output.append(sum%10);
					carry=sum/10;
				}
				else {
					output.append(sum);
					carry=0;
				}
				sum=0;
			}
		}
		output=carry==0? output:output.append(carry);
		String str=output.reverse().toString();
		return str;
	}

}
