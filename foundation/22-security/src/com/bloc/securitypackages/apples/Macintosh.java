package com.bloc.securitypackages.apples;
import com.bloc.securitypackages.colors.Red;
import com.bloc.securitypackages.Fruit;
import com.bloc.securitypackages.apples.Apple;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Macintosh extends Apple {

	public Macintosh() {
		super(Macintosh.class.getSimpleName(), 200, new Red(), 0.14d);
	}

	void bite() {
		setWeight(getWeight() - 0.01d);
	}

}