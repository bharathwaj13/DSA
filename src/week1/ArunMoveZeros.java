package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArunMoveZeros {

	@Test
	public void positive() {
		int[] nums= {1,5,0,7,9,0,45,78,0,0};
		int[] output= {1,5,7,9,45,78,0,0,0,0};
		Assert.assertTrue(Arrays.equals(output, zeros2Last(nums)));
	}


	private int[] zeros2Last(int[] nums) {
		//	int [] resultArr=new int[nums.length];
		List<Integer> resultList = new ArrayList<Integer>();
		int Zeros=0;
		for (int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				Zeros++;
				resultList.add((nums.length)-Zeros, 0);
			}
			else {
				resultList.add((i-Zeros), nums[i]);
			}
		}
		System.out.println(resultList.toArray());
		//resultArr=resultList.toArray();
		return nums;	
	}

}
