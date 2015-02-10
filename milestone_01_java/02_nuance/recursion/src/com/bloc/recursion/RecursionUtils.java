package com.bloc.recursion;

import java.util.*;

public class RecursionUtils extends Object {
	/*
	 * findMaxRecursively
	 * Takes a list of numbers and finds the largest among them
	 * using recursive calls.
	 *
	 * @param numbers a list of numbers, can be odd or even numbered
	 * @return the largest number in the list
	 *
	 * Hint: your base case may be a comparison of 2 numbers
	 */
	public static final int findMaxRecursively(List<Integer> numbers) {

		if (numbers.size() > 1) {
			if (numbers.get(0) > numbers.get(1)) {
					numbers.remove(1);
				}
			else {
					numbers.remove(0);
				}
			findMaxRecursively(numbers);
			}
		return numbers.get(0);
	}

}