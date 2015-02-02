package com.bloc.securitypackages.citrus;

import com.bloc.securitypackages.Fruit; // added
import com.bloc.securitypackages.colors.ColorOrange; // added

public class Orange extends Fruit { // added public
	public Orange() {
		super("Orange", 130, new ColorOrange(), .21d);
	}
}