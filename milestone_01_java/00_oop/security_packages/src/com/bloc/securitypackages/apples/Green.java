package com.bloc.securitypackages.apples;

public class Green extends Apple { // added public abstract

	public Green() { // added public
		super(Green.class.getSimpleName(), 230, new LimeGreen(), 0.21d);
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}