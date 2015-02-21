package com.bloc.securitypackages.apples;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

class Green extends Apple {

	Green() {
		super(Green.class.getSimpleName(), 230, new LimeGreen(), 0.21d);
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}