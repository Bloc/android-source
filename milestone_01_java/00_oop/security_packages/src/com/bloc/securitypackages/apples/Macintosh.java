package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.apples.Apple; // added
import com.bloc.securitypackages.Color; // added
import com.bloc.securitypackages.colors.Red; // added

public class Macintosh extends Apple { // added public

	public Macintosh() { // added public
		super(Macintosh.class.getSimpleName(), 200, new Red(), 0.14d);
	}

	void bite() {
		setWeight(getWeight() - 0.01d);
	}

}