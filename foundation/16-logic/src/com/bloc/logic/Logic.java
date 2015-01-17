package com.bloc.logic;

// import com.libs.logic.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logic extends Object {

	public static void main(String [] args) {
		StringBuffer buffer = new StringBuffer();

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Change the following logical operation such 
	 	 *	that the statement evaluates to 'true' 
		/************************************************/

		if (false && true) { // Change something here
			buffer.append("r");
		} else {
			buffer.append("w");
		}

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Change a single character in the following 4
	 	 *	lines of code in order to evaluate
		 *	the conditional as 'true'
		/************************************************/

		int x = 5; // Change here
		int y = 10; // Or here
		int z = 30; // Or here
		if (x == 6 || y == 11 || z == 83) { // Or even here, who knows
			buffer.append("i");
		} else {
			buffer.append("r");
		}

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Add a single operator to the conditional
	 	 *	statement in order to evaluate it as 'true'
		/************************************************/

		boolean aSincereFalsehood = false;
		if (aSincereFalsehood) { // Add an operator to this line
			buffer.append("g");
		} else {
			buffer.append("o");
		}

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Change the comparison below in order for the
	 	 *	statement to evaluate as 'true'
		/************************************************/

		if (200 > 200) {
			buffer.append("h");
		} else {
			buffer.append("n");
		}

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Alter the statements within parenthesis in 
	 	 *	order for all 3 statements to evaluate
		 * 	as 'true'
		/************************************************/

		boolean lastOne = false;
		if ((8 < 0) && !(15 == 15) && (lastOne == true)) { // Modify this line
			buffer.append("t");
		} else {
			buffer.append("g");
		}

		System.out.print("If the following word looks appealing: " + buffer.toString() + ", then you've done it!\n");
		if (!buffer.toString().equals("right")) {
			System.out.print("Try again!\n");
		}
	}
}
