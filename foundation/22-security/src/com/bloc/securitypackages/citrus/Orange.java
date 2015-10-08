package com.bloc.securitypackages.citrus;
import com.bloc.securitypackages.Fruit;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

class Orange extends Fruit {
	Orange() {
		super("Orange", 130, new Orange(), .21d);
	}
}