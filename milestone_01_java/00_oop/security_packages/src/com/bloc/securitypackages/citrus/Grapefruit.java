package com.bloc.securitypackages.citrus;

import com.bloc.securitypackages.Fruit; // added
import com.bloc.securitypackages.Color; // added
import com.bloc.securitypackages.colors.OrangeRed; // added

public class Grapefruit extends Fruit { // added public
	public Grapefruit() { // why do we have to add public here?
		super(Grapefruit.class.getSimpleName(), 210, new OrangeRed(), .48d);
	}
}