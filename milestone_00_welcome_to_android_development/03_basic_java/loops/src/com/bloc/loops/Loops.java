package com.bloc.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loops extends Object {

	public static void main(String [] args) {
		boolean[] someBools = {true, false, true, true, false, true, false, false};
		boolean temp = false;

		//********************************** Starts Here *********************************
		// temp = someBools[7];
		// someBools[7] = someBools[0];
		// someBools[0] = temp;

		// temp = someBools[6];
		// someBools[6] = someBools[1];
		// someBools[1] = temp;

		// temp = someBools[5];
		// someBools[5] = someBools[2];
		// someBools[2] = temp;

		// temp = someBools[4];
		// someBools[4] = someBools[3];
		// someBools[3] = temp;
		//********************************** Ends Here ***********************************


		//********************************************************************************
		// ASSIGNMENT:
		// Replace the operations above with a while loop
		//********************************************************************************

		int i = 0;
		while (i < 4) {
			temp = someBools[7-i];
			// System.out.print(someBools[7-i] + "\n"); for debugging
			someBools[7-i] = someBools[i];
			// System.out.print(someBools[i] + "\n"); debugging
			someBools[i] = temp;
			i++;
			// System.out.print(i); debugging
			}


		if (testBools(someBools)) {
			System.out.print("Your booleans are in proper order!\n");
		} else {
			System.out.print("Your booleans are supposed to come out as Z@7afa0094 yet they are currently appearing as " + someBools + "\n"); // I rewrote this statement to be more helpful
			System.exit(0);
		}

		int[] numArray = new int[someBools.length];
		// This is known as an in-line conditional
		// learn more here: http://www.cafeaulait.org/course/week2/43.html

		//********************************** Starts Here *********************************
		numArray[0] = !someBools[0] ? 1 : 0;
		numArray[1] = !someBools[1] ? 1 : 0;
		numArray[2] = !someBools[2] ? 1 : 0;
		numArray[3] = !someBools[3] ? 1 : 0;
		numArray[4] = !someBools[4] ? 1 : 0;
		numArray[5] = !someBools[5] ? 1 : 0;
		numArray[6] = !someBools[6] ? 1 : 0;
		numArray[7] = !someBools[7] ? 1 : 0;
		//********************************** Ends Here ***********************************

for (int j = 0; j < 8; j++) {
	numArray[j] = !someBools[j] ? 1 : 0;
}

		//********************************************************************************
		// ASSIGNMENT:
		// Replace the operations above with a for loop
		//********************************************************************************

		if (testInts(numArray)) {
			System.out.print("And you nailed the number array!\n");
		} else {
			System.out.print("Issue with the numbers… the numArray is supposed to be [I@333c339f yet yours is " + numArray + " \n"); // rewritten test
		}
	}




	static final boolean testBools(boolean[] bools) {
		if (bools == null || bools.length != 8) {
			return false;
		}
		return bools[0] == false &&
			   bools[1] == false &&
			   bools[2] == true &&
			   bools[3] == false &&
			   bools[4] == true &&
			   bools[5] == true &&
			   bools[6] == false &&
			   bools[7] == true;
	}

	static final boolean testInts(int[] ints) {
		if (ints == null || ints.length != 8) {
			return false;
		}
		return ints[0] == 1 &&
			   ints[1] == 1 &&
			   ints[2] == 0 &&
			   ints[3] == 1 &&
			   ints[4] == 0 &&
			   ints[5] == 0 &&
			   ints[6] == 1 &&
			   ints[7] == 0;
	}
}
