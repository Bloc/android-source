package com.bloc.methods;

import java.lang.reflect.Method;

public class Methods extends Object {

	// DO NOT MODIFY BELOW
	public static void main(String [] args) {
		Methods methods = new Methods();
		Method method = null;
		if ((method = testMethods(methods)) == null) {
			System.out.println("Excellent, all of your methods worked!\n");
		} else {
			System.out.println("Looks like your \'" + method.getName() + "\' method has an issue with it.\n");
		}
	}

	/************************************************
	 *	DO NOT MODIFY ABOVE THIS BLOCK
	/************************************************/


	/*
	 * giveMeTheOpposite
	 * 
	 * Returns the logical opposite of a given boolean
	 *
	 * This method returns the logical opposite value
	 * of its given parameter.
	 *
	 * @param original Is the boolean variable which must be flipped
	 * @return the logical opposite of the original
	 */
	public boolean giveMeTheOpposite(boolean original) {
		/************************************************
		 * Your work goes here
		 ************************************************/

		// You are free to modify the return statement
		return false;
	}

	/*
	 * flipTheSign
	 *
	 * This method reverses the sign of each integer in a
	 * given array
	 *
	 * Given a variable length array consisting of integers,
	 * this method changes the sign of each value found in the
	 * array to its opposite, e.g. {1, 54, -12} becomes
	 * {-1, -54, 12} and {42, -57, 24, -182, 9521} becomes
	 * {-42, 57, -24, 182, -9521}.
	 *
	 * @param numbers The array consisting of values whose
	 * 		  sign must be flipped
	 * @return nothing
	 */
	public void flipTheSign(int[] numbers) {
		/************************************************
		 * Your work goes here
		 ************************************************/
	}


	/*
	 * boolsRule
	 *
	 * This method returns an array of booleans based on
	 * comparisons made in a given integer array with an
	 * integer floor.
	 *
	 * Given an array and a floor, this method compares each
	 * value in the array to the floor. If the value at that
	 * index is at least floor or greater, the corresponding
	 * index in a boolean array is set to `true`, `false`
	 * otherwise.
	 * 
	 * E.g. {0, 5, 18, 2} with a floor of 6 returns
	 * {false, false, true, false}
	 * 
	 * {16, 20} with a floor of 21 will return the following
	 * array of booleans: {false, false}
	 *
	 * @param floor The integer to compare each value to
	 * @param someNumbers The array of integers
	 * @return an array of booleans
	 */
	public boolean[] boolsRule(int floor, int[] someNumbers) {
		/************************************************
		 * Your work goes here
		 ************************************************/

		// You are free to modify the return statement
		return new boolean [0];
	}

	/*
	 * getMinAndMax
	 *
	 * Recover the minimum and maximum value found in an
	 * array of numbers.
	 *
	 * This method traverses a given array to discover its
	 * smallest value and its largest value. These two integers
	 * are returned in an array whose 0th index contains
	 * the minumum value and 1st index contains the maximum.
	 *
	 * E.g. given {3, 6, 202, 2, 9986, 5}, this method returns
	 * {2, 9986}
	 *
	 * @param someNumbers The array whose maxmimum and minimum
	 *		  must be recovered
	 * @return an array of length 2: {min, max}
	 */
	public int[] getMinAndMax(int[] someNumbers) {
		/************************************************
		 * Your work goes here
		 ************************************************/

		// You are free to modify the return statement
		return new int[2];
	}


	/************************************************
	 *	DO NOT MODIFY BELOW THIS BLOCK
	/************************************************/


	public static final Method testMethods(Methods methods) {
		String methodName = null;
		Class<?>[] classArray = null;

		if (!testGiveMeTheOpposite(methods)) {
			methodName = "giveMeTheOpposite";
			classArray = new Class<?>[]{boolean.class};
		} else if (!testFlipTheSign(methods)) {
			methodName = "flipTheSign";
			classArray = new Class<?>[]{int[].class};
		} else if (!testBoolsRule(methods)) {
			methodName = "boolsRule";
			classArray = new Class<?>[]{int.class, int[].class};
		} else if (!testGetMinAndMax(methods)) {
			methodName = "getMinAndMax";
			classArray = new Class<?>[]{int[].class};
		}

		if (methodName == null) {
			return null;
		}
		Method badMethod = null;
		try {
			badMethod = methods.getClass().getMethod(methodName, classArray);
		} catch (Exception e) {
			// Crap
			e.printStackTrace();
		}
		return badMethod;
	}

	private static final boolean testGiveMeTheOpposite(Methods methods) {
		try {
			if (methods.giveMeTheOpposite(true)) {
				return false;
			} else if (!methods.giveMeTheOpposite(false)) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static final boolean testFlipTheSign(Methods methods) {
		try {
			int[] empty = new int[0];
			methods.flipTheSign(empty);

			int[] flipThis = {1};
			methods.flipTheSign(flipThis);
			if (flipThis[0] != -1) {
				return false;
			}

			int[] flipThisToo = {-1, 18, -22, 0, 65, 82, -8};
			methods.flipTheSign(flipThisToo);
			if (flipThisToo[0] != 1 || flipThisToo[1] != -18 || flipThisToo[2] != 22
									|| flipThisToo[3] != 0 || flipThisToo[4] != -65
									|| flipThisToo[5] != -82 || flipThisToo[6] != 8) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static final boolean testBoolsRule(Methods methods) {
		try {
			int[] empty = new int[0];
			methods.boolsRule(18, empty);

			int[] single = {20};
			boolean[] returnBools = methods.boolsRule(5, single);
			if (returnBools == null || returnBools.length != 1 || returnBools[0] == false) {
				return false;
			}

			int[] more = {-54, 32, 43, -87, 245, 821, -2};
			returnBools = methods.boolsRule(-18, more);
			if (returnBools == null || returnBools.length != more.length
							 		|| returnBools[0] || !returnBools[1]
							 		|| !returnBools[2] || returnBools[3]
							 		|| !returnBools[4] || !returnBools[5]
							 		|| !returnBools[6]) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static final boolean testGetMinAndMax(Methods methods) {
		try {
			int[] onlyOne = {5};
			int[] minMax = methods.getMinAndMax(onlyOne);
			if (minMax == null || minMax.length != 2 || minMax[0] != 5 || minMax[1] != 5) {
				return false;
			}

			int[] someMore = {-18, 18};
			minMax = methods.getMinAndMax(someMore);
			if (minMax == null || minMax.length != 2 || minMax[0] != -18 || minMax[1] != 18) {
				return false;
			}

			int[] thirdRound = {-288, -88811, 34, 76, 76, 34, 1999942, -9992732};
			minMax = methods.getMinAndMax(thirdRound);
			if (minMax == null || minMax.length != 2 || minMax[0] != -9992732 || minMax[1] != 1999942) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
