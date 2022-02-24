package week4hw;

import org.junit.Assert;
import org.junit.Test;

public class SmallestLetterGreaterThanTarget_Arun {

	/*
	 * 
	 * Leetcode: 744
	 * 
	 * Given a characters array letters that is sorted in non-decreasing order and a
	 * character target, return the smallest character in the array that is larger than target.
	 * Note that the letters wrap around.
	 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
	 * 
	 */

	@Test
	public void example1() {
		char[] letters= {'c','f','j'};
		char target='a';
		char output='c';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example2() {
		char[] letters= {'c','f','j'};
		char target='c';
		char output='f';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example3() {
		char[] letters= {'c','f','j'};
		char target='d';
		char output='f';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example4() {
		char[] letters= {'a','b'};
		char target='z';
		char output='a';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example5() {
		char[] letters= {'c','f','j'};
		char target='j';
		char output='c';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example6() {
		char[] letters= {'e','e','e','e','e','e','n','n','n','n'};
		char target='e';
		char output='n';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}

	@Test
	public void example7() {
		char[] letters= {'e','e','e','k','q','q','q','v','v','y'};
		char target='j';
		char output='k';
		Assert.assertTrue(smallestLetterGreaterThanTarget(letters, target)==output);
	}


	private char smallestLetterGreaterThanTarget(char[] letters,char target) {

		int low=0,high=letters.length-1;
		if(letters[low]>target||letters[high]<=target)return letters[low];
		else {
			while(low<=high) {
				int mid=(low+high)/2;
				if (letters[mid]>target)high=mid-1;
				else low=mid+1;

			}
		}

		return letters[low];
	}

}
