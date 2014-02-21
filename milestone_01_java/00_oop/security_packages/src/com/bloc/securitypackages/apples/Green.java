package com.bloc.securitypackage.apples;

class Green extends Apple {

	Green() {
		super(Green.class.getSimpleName(), 230, new LimeGreen() 0.21d);
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}