package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.colors.LimeGreen; // added import

public class Green extends Apple { // added public

	public Green() { // added public
		super(Green.class.getSimpleName(), 230, new LimeGreen(), 0.21d);
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}