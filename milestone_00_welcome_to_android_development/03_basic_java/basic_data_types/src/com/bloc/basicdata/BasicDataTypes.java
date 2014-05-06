package com.bloc.basicdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicDataTypes extends Object {

	public static void main(String [] args) {
		System.out.print("Let's tackle some types!\n\nType your answers in the command prompt and hit return to submit.\n\nEnter 'Q' if you'd like to quit.\n\nLet's get started!\n\n");

		while (!test1()) {
			// Wait
		}

		while (!test2()) {
			// Wait
		}

		while (!test3()) {
			// Wait
		}

		while (!test4()) {
			// Wait
		}

		while (!test5()) {
			// Wait
		}

		while (!test6()) {
			// Wait
		}

		System.out.print("Congratulations! Go learn something else!\n");
	}

	private static boolean test1() {
		System.out.print("1. How many bits are reserved for the following number? 18. Answer: ");
		int input = getInteger();
		if (input == 32) {
			System.out.print("Yup!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test1();
	}

	private static boolean test2() {
		System.out.print("2. How about this one? 18f. Answer: ");
		int input = getInteger();
		if (input == 32) {
			System.out.print("Yes'm!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test2();
	}

	private static boolean test3() {
		System.out.print("3. And finally, this one? 18d. Answer: ");
		int input = getInteger();
		if (input == 64) {
			System.out.print("We agree!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test3();
	}

	private static boolean test4() {
		System.out.print("4. Given this array {1, 2, 3}, what's the value at index 1? Answer: ");
		int input = getInteger();
		if (input == 2) {
			System.out.print("Right on.\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test4();
	}

	private static boolean test5() {
		System.out.print("5. What's the highest index of this array: {false, true, true, false, true, false}? Answer: ");
		int input = getInteger();
		if (input == 5) {
			System.out.print("Totes m'gotes.\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test5();
	}

	private static boolean test6() {
		System.out.print("6. True or false, pi (π) can be accurately expressed as a double. Answer: ");
		String input = getInput();
		if (input.equals("false")) {
			System.out.print("All done!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test6();
	}

	private static Integer getInteger() {
		String input = getInput();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			// Needs to be a number
			return getInteger();
		}
	}

	private static String getHex() {
		String input = getInput().toLowerCase();
		int indexOfX = input.indexOf("x");
		if (indexOfX > 0 || input.startsWith("x")) {
			input = input.substring(indexOfX + 1, input.length());
		}

		int indexOfHash = input.indexOf("#");
		if (indexOfHash > 0 || input.startsWith("#")) {
			input = input.substring(indexOfHash + 1, input.length());
		}
		return input;
	}

	private static String getBinary() {
		String input = getInput();
		int indexOfFirst1 = input.indexOf("1");
		if (indexOfFirst1 > 0) {
			input = input.substring(indexOfFirst1, input.length());
		}
		return input;
	}

	private static String getInput() {
		String input = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while ((input = br.readLine()) == null) {
				// Do nothing
			}
			input = input.trim();
		} catch (IOException io){
			io.printStackTrace();
		} finally {
			if (input != null && input.toLowerCase().equals("q")) {
				System.exit(0);
			}
			return input;
		}
	}
}
