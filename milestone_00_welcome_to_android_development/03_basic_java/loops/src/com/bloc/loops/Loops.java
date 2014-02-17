package com.bloc.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bloc.test.Test;

public class Loops extends Object {

	public static void main(String [] args) {
		boolean[] someBools = {true, false, true, true, false, true, false, false};
		boolean temp = false;

		// Starts here
		temp = someBools[7];
		someBools[7] = someBools[0];
		someBools[0] = temp;

		temp = someBools[6];
		someBools[6] = someBools[1];
		someBools[1] = temp;

		temp = someBools[5];
		someBools[5] = someBools[2];
		someBools[2] = temp;

		temp = someBools[4];
		someBools[4] = someBools[3];
		someBools[3] = temp;
		// Ends here

		/*
		 * ASSIGNMENT:
		 * Replace the operations above with a while loop
		 */

		if (Test.testBools(someBools)) {
			System.out.print("Your booleans are in proper order!\n");
		} else {
			System.out.print("Something in the while loop…\n");
			System.exit(0);
		}

		int[] numArray = new int[someBools.length];
		// This is known as an in-line conditional
		// learn more here: http://www.cafeaulait.org/course/week2/43.html

		// Starts here
		numArray[0] = !someBools[0] ? 1 : 0;
		numArray[1] = !someBools[1] ? 1 : 0;
		numArray[2] = !someBools[2] ? 1 : 0;
		numArray[3] = !someBools[3] ? 1 : 0;
		numArray[4] = !someBools[4] ? 1 : 0;
		numArray[5] = !someBools[5] ? 1 : 0;
		numArray[6] = !someBools[6] ? 1 : 0;
		numArray[7] = !someBools[7] ? 1 : 0;
		// Ends here

		/*
		 * ASSIGNMENT:
		 * Replace the operations above with a for loop
		 */

		if (Test.testInts(numArray)) {
			System.out.print("And you nailed the number array!\n");
		} else {
			System.out.print("Issue with the numbers…\n");
		}
	}
}
