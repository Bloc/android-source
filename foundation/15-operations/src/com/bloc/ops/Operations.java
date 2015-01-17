package com.bloc.ops;

public class Operations extends Object {

	public static void main(String [] args) {

		
		/************************************************
	 	 *	ASSIGNMENT	
	 	 *	Place 18 into x
		/************************************************/

		int x;	

		/************************************************
		 *  ASSIGNMENT:
		 *	Pre-increment x and assign it to y in a single statement
		/************************************************/

		int y;

		/************************************************
		 *	ASSIGNMENT:
		 *	Multiply x by y, assign it to z
		/************************************************/

		int z;

		/************************************************
		 *	ASSIGNMENT:
		 *	Mod z by 17 and assign the result to remainder
		/************************************************/

		int remainder;

		/************************************************
		 *	ASSIGNMENT:
		 *	Assign 5 to floaty and then divide it by 3
		/************************************************/

		float floaty;

		/************************************************
		 *	ASSIGNMENT:
		 *	Assign 5.3 into dubs
		 *	Then multiply dubs by itself
		/************************************************/

		double dubs;

		/************************************************
		 *	DO NOT MODIFY BELOW THIS CALLOUT
		/************************************************/

		if (!testX(x)) {
			System.out.print("Sorry, looks like something's wrong with 'x'\n");
		} else if (!testY(y)) {
			System.out.print("Sorry, looks like something's wrong with 'y'\n");
		} else if (!testZ(z)) {
			System.out.print("Sorry, looks like something's wrong with 'z'\n");
		} else if (!testRemainder(remainder)) {
			System.out.print("Sorry, looks like something's wrong with 'remainder'\n");
		} else if (!testFloat(floaty)) {
			System.out.print("Sorry, looks like something's wrong with 'floaty'\n");
		} else if (!testDouble(dubs)) {
			System.out.print("Sorry, looks like something's wrong with 'dubs'\n");
		} else {
			System.out.print("Congratulations! Everything works!\n");
		}
	}

	static boolean testX(int x) {
		return x == 19;
	}

	static boolean testY(int y) {
		return y == 19;
	}

	static boolean testZ(int z) {
		return z == 361;
	}

	static boolean testRemainder(int remainder) {
		return 4 == remainder;
	}

	static boolean testFloat(float f) {
		return 1.6666666f == f;
	}

	static boolean testDouble(double d) {
		return 28.09d == d;
	}
}
