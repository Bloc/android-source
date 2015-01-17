package com.bloc.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryExercises extends Object {

	public static void main(String [] args) {
		System.out.print("Excited for some Binary exercises? We sure are!\n\nType your answers in the command prompt and hit return to submit.\n\nEnter 'Q' if you'd like to quit.\n\nLet's get started!\n\n");

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

		System.out.print("Congratulations! It's over!\nFor future reference, type \"152 in hex\" into Google and watch the magic happen.\n");
	}

	private static boolean test1() {
		System.out.print("1. Which DECIMAL number does 10 (BINARY) represent? Answer: ");
		int input = getInteger();
		if (input == 2) {
			System.out.print("Great!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test1();
	}

	private static boolean test2() {
		System.out.print("2. How do you represent the number 10 (DECIMAL) in BINARY? Answer: ");
		int input = getInteger();
		if (input == 1010) {
			System.out.print("Rock on!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test2();
	}

	private static boolean test3() {
		System.out.print("3. How do you represent the number 10 (DECIMAL) in HEXADECIMAL? Answer: ");
		String input = getHex();
		if (input.equals("a")) {
			System.out.print("You're killing it!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test3();
	}

	private static boolean test4() {
		System.out.print("4. Please convert 0x42E3 (HEXADECIMAL) into BINARY. Answer: ");
		String input = getBinary();
		if (input.equals("100 0010 1110 0011") || input.equals("100001011100011")) {
			System.out.print("You're getting this.\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test4();
	}

	private static boolean test5() {
		System.out.print("5. Please convert 1001110101011011 into HEXADECIMAL. Answer: ");
		String input = getHex();
		if (input.equals("9d5b")) {
			System.out.print("Way to go!\n\n");
			return true;
		}
		System.out.print("Sorry, try again!\n\n");
		return test5();
	}

	private static boolean test6() {
		System.out.print("6. Please convert 353 (DECIMAL) into HEXADECIMAL.\nHINT: Convert to binary first, then to hex\nAnswer: ");
		String input = getHex();
		if (input.equals("161")) {
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
