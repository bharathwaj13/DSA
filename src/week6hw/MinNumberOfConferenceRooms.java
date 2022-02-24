package week6hw;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberOfConferenceRooms {

	/*
	 * Given an String array A of size N denoting time intervals of different meetings.
	 * Find the minimum number of conference rooms required so that all meetings can be
	 * done.
	 * 
	 */


	//@Test
	public void example1() {
		String[][] meetingTimes= {{"09 00", "09 45"},{"09 30", "10 30"},  {"10 40", "12 00"},{"11 00", "13 00"},  {"11 45", "14 00"},{"16 00", "17 00"}};
		int output=3;
		Assert.assertTrue(output==conferenceRooms(meetingTimes));
	}

	@Test
	public void example2() {
		String[][] meetingTimes= {{"09 00", "09 30"},{"11 00", "11 10"},{"10 30", "11 00"},{"10 40", "11 40"}};
		int output=2;
		Assert.assertTrue(output==conferenceRooms(meetingTimes));
	}

	//@Test
	public void example3() {
		String[][] meetingTimes= {{"09 00", "09 30"},{"12 00", "12 10"},{"13 30", "13 50"},{"10 40", "11 40"}};
		int output=1;
		Assert.assertTrue(output==conferenceRooms(meetingTimes));
	}


	private int conferenceRooms(String[][] meetingTimes) {

		int meetingRoom=meetingTimes.length;
		int[][] integerTimings=new int[meetingTimes.length][2];

		for(int i=0;i<meetingTimes.length;i++) {

			integerTimings[i][0]= Integer.parseInt(meetingTimes[i][0].replace(" ", ""));
			integerTimings[i][1]= Integer.parseInt(meetingTimes[i][1].replace(" ", ""));
		}

		System.out.println(Arrays.deepToString(integerTimings));
		/*Arrays.sort(integerTimings, (a,b) -> {
			if(a[1] != b[1]) return a[1]-b[1]; //end times	
			else return a[0]-b[0]; //start times
		});*/
		
		Arrays.sort(integerTimings, (a,b) -> a[1]-b[1]);
		System.out.println("After Sorting");
		System.out.println(Arrays.deepToString(integerTimings));
		int right=1, left=0;

		while(right<integerTimings.length) {
			int nextStartTime= integerTimings[right][0]; // Second Meeting Start Time
			int endTime= integerTimings[left][1]; //First Meeting End Time
			if(endTime <= nextStartTime) {
				meetingRoom--;
				left++;
			}
			right++;
		}
		System.out.println(meetingRoom);
		return meetingRoom;
	}
}
