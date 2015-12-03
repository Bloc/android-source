package com.bloc.securitypackages.apples;
import com.bloc.securitypackages.colors.LimeGreen;


/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Green extends Apple {

	public Green() {
		super(Green.class.getSimpleName(), 230, new LimeGreen(), 0.21d);
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}