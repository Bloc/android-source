package com.bloc.securitypackages;

import com.bloc.securitypackages.colors.*; // added

public class Color extends Object { // added public
	// Name of the color
	String mName;
	// Alpha value
	int mAlpha;
	// Red value
	int mRed;
	// Green value
	int mGreen;
	// Blue value
	int mBlue;

	public Color(int red, int green, int blue) { // added public
		this(null, red, green, blue);
	}

	public Color(String name, int red, int green, int blue) { // added public
		mName = name;
		mRed = red;
		mGreen = green;
		mBlue = blue;
	}
}