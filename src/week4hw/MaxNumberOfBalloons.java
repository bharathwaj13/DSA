package week4hw;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MaxNumberOfBalloons {

	/*
	 * Leetcode: 1189
	 * 
	 * Given a string text, you want to use the characters of text to form as many
	 * instances of the word "balloon" as possible.You can use each character in text 
	 * at most once. Return the maximum number of instances that can be formed.
	 * 
	 */

	@Test
	public void example1() {
		String text="nlaebolko";
		int output=1;
		Assert.assertTrue(output==maxNumOfBalloons(text));
	}

	@Test
	public void example2() {
		String text="loonbalxballpoon";
		int output=2;
		Assert.assertTrue(output==maxNumOfBalloons(text));
	}

	@Test
	public void example3() {
		String text="leetcode";
		int output=0;
		Assert.assertTrue(output==maxNumOfBalloons(text));
	}


	private int maxNumOfBalloons(String text) {
		int count=0;
		Map<String,Integer> countMap=new HashMap<String,Integer>();
		for(int i=0;i<text.length();i++) {
			countMap.put(text.charAt(i)+"", countMap.getOrDefault(text.charAt(i)+"", 0)+1);
		}
		if(countMap.containsKey("b") && countMap.containsKey("a") && countMap.containsKey("l") &&
				countMap.containsKey("o") && countMap.containsKey("n")) {
			while(countMap.get("b")>=1 && countMap.get("a")>=1 && countMap.get("l")>=2 &&
					countMap.get("o")>=2 && countMap.get("n")>=1) {
				count++;
				countMap.put("b", countMap.get("b")-1);
				countMap.put("a", countMap.get("a")-1);
				countMap.put("l", countMap.get("l")-2);
				countMap.put("o", countMap.get("o")-2);
				countMap.put("n", countMap.get("n")-1);
			}
		}
		return count;
	}

}
