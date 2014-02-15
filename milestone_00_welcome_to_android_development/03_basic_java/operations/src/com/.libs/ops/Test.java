package com.bloc.libs.ops;

public class Test extends Object {
	public static final boolean testX(int x) {
		return x == 19;
	}

	public static final boolean testY(int y) {
		return y == 19;
	}

	public static final boolean testZ(int z) {
		return z == 361;
	}

	public static final boolean testRemainder(int rem) {
		return rem == 4;
	}

	public static final boolean testFloat(float floaty) {
		return 10.0f/3f == floaty;
	}

	public static final boolean testDouble(double dubs) {
		double testDub = 5.3d;
		testDub = testDub++ * testDub;
		return testDub == dubs;
	}
	
}