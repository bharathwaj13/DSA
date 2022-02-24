package week8_recursion;

import org.junit.Test;

public class Fibonacci_BruteForce {

	@Test
	public void example1() {
		int n=5;
		printFibonacci(n);
	}
	
	@Test
	public void example2() {
		int n=10;
		printFibonacci(n);
	}


	private void printFibonacci(int n) {
		System.out.print(0+" "+1);
		int num1=0, num2=1;
		int sum=0;
		for(int i=3;i<=n;i++) {
			sum=num1+num2;
			System.out.print(" "+sum);
			num1=num2;
			num2=sum;
		}
		System.out.println();
	}
}
