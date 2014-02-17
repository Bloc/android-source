package com.bloc.test;

public class Test extends Object {
	public static final boolean testBools(boolean[] bools) {
		if (bools == null || bools.length != 8) {
			return false;
		}
		return bools[0] == false &&
			   bools[1] == false &&
			   bools[2] == true &&
			   bools[3] == false &&
			   bools[4] == true &&
			   bools[5] == true &&
			   bools[6] == false &&
			   bools[7] == true;
	}

	public static final boolean testInts(int[] ints) {
		if (ints == null || ints.length != 8) {
			return false;
		}
		return ints[0] == 1 &&
			   ints[1] == 1 &&
			   ints[2] == 0 &&
			   ints[3] == 1 &&
			   ints[4] == 0 &&
			   ints[5] == 0 &&
			   ints[6] == 1 &&
			   ints[7] == 0;
	}
}