package com.bloc.securitypackages.apples;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

class Macintosh extends Apple {

	Macintosh() {
		super(Macintosh.class.getSimpleName(), 200, new Red(), 0.14d);
	}

	void bite() {
		setWeight(getWeight() - 0.01d);
	}

}