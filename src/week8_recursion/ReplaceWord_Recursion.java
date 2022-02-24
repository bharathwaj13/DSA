package week8_recursion;

import org.junit.Test;

public class ReplaceWord_Recursion {

	@Test
	public void example1() {
		String s1= "Welcome to the interview. All the best to your test";
		String s2="to";
		System.out.println(replaceWord(s1, s2));
	}


	private String replaceWord(String s1,String s2) {
		if(!s1.contains(s2)) return s1;

		//1st Method
		//s1=s1.substring(0, s1.indexOf(s2)) + s1.substring(s1.indexOf(s2)+s2.length(), s1.length());

		//2nd Method
		s1=s1.replaceFirst(s2, "");
		return replaceWord(s1, s2);
	}

}
