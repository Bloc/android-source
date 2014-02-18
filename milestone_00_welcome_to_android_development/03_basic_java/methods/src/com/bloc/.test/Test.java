package com.bloc.test;

import java.lang.reflect.Method;

import com.bloc.methods.Methods;

public class Test extends Object {
	public static final Method testMethods(Methods methods) {
		String methodName = null;
		Class<?>[] classArray = null;

		if (!Test.testGiveMeTheOpposite(methods)) {
			methodName = "giveMeTheOpposite";
			classArray = new Class<?>[]{boolean.class};
		} else if (!Test.testFlipTheSign(methods)) {
			methodName = "flipTheSign";
			classArray = new Class<?>[]{int[].class};
		} else if (!Test.testBoolsRule(methods)) {
			methodName = "boolsRule";
			classArray = new Class<?>[]{int.class, int[].class};
		} else if (!Test.testGetMinAndMax(methods)) {
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