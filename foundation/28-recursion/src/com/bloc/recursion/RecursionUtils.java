package com.bloc.recursion;

import java.util.*;
import java.lang.Math;

public class RecursionUtils extends Object {
	/*
	 * findMaxRecursively
	 *
	 * Takes a list of numbers and finds the largest among them
	 * using recursive calls.
	 *
	 * @param numbers a list of numbers, can be odd or even numbered
	 * @return the largest number in the list
	 *
	 * Hint: your base case may be a comparison of 2 numbers
	 */
	public static final int findMaxRecursively(List<Integer> numbers) {
		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Implement this method, the return value must
	 	 *	change
		/************************************************/
		// int maxNumber = 0;
		//Iterator<Integer> it = numbers.iterator();
		if (numbers.size() == 1){
			return numbers.get(0); //it.next();
		} else if (numbers.size() == 2){
			return Math.max(numbers.get(0), numbers.get(1)); //it.next(), it.next());
		} else if (numbers.size() > 2) {
			return Math.max(Math.max(numbers.get(0),numbers.get(1)), findMaxRecursively(numbers.subList(2,numbers.size())));//it.next(), it.next())), findMaxRecursively(numbers.subList(2,numbers.size())));
		}		
		return 0;
	}
}