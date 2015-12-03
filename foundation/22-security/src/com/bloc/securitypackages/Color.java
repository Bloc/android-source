package com.bloc.securitypackages;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Color extends Object {
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

	public Color(int red, int green, int blue) {
		this(null, red, green, blue);
	}

	public Color(String name, int red, int green, int blue) {
		mName = name;
		mRed = red;
		mGreen = green;
		mBlue = blue;
	}
}