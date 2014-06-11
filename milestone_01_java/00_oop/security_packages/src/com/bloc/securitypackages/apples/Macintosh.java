package com.bloc.securitypackages.apples;

class Macintosh extends Apple {

	Macintosh() {
		super(Macintosh.class.getSimpleName(), 200, new Red(), 0.14d);
	}

	void bite() {
		setWeight(getWeight() - 0.01d);
	}

}