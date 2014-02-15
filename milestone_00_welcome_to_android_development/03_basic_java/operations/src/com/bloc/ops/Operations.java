package com.bloc.ops;

import com.bloc.libs.ops.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Operations extends Object {

	public static void main(String [] args) {
		int x = 0;
		/*
			ASSIGNMENT:
			Place 18 into x
		*/
		int y = 0;
		/*
			ASSIGNMENT:
			Pre-increment x and assign it to y in a single statement
		*/
		int z = 0;
		/*
			ASSIGNMENT:
			Multiply x by y, assign it to z
		*/
		int remainder = 0;
		/*
			ASSIGNMENT:
			Mod z by 17 and assign the result to remainder
		*/
		float floaty = 0f;
		/*
			ASSIGNMENT:
			Assign 5 to floaty and then divide it by 3
		*/
		double dubs = 0d;
		/*
			ASSIGNMENT:
			Assign 5.3 into dubs
			Then post-Decrement dubs and multiply it by itself in a single statement
		*/

		if (Test.testX(x) && Test.testY(y)
						  && Test.testZ(z)
						  && Test.testRemainder(remainder)
						  && Test.testFloat(floaty)
						  && Test.testDouble(dubs)) {
			System.out.print("Congratulations! Everything works!\n");
		} else {
			System.out.print("Sorry, looks like something's not right…\n");
		}
	}
}
