package com.bloc.exceptions;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.IndexOutOfBoundsException;

public class FunMethods extends Object {

	public static Integer getMax(Integer... numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("Numbers must be a valud array");
		}
		Integer max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == null) {
				throw new IllegalStateException("All numbers in array must be valid");
			}
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}

	public static Object[] remove(Object[] original, int index) throws IllegalArgumentException, IndexOutOfBoundsException {
		if (original == null) {
			throw new IllegalArgumentException("Original array must be valid");
		} else if (index < 0 || !(index < original.length)) {
			throw new IndexOutOfBoundsException("index must be between 0 and original.length - 1");
		}
		for (int i = index; i < original.length - 1; i++) {
			original[index] = original[index + 1];
		}

		Object[] copyArray = new Object[original.length - 1];
		for (int i = 0; i < copyArray.length; i++) {
			copyArray[i] = original[i];
		}
		return copyArray;
	}

}