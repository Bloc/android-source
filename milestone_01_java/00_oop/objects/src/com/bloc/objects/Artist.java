package com.bloc.objects;

class Artist extends Object {
	// The artist's first name
	String mFirstName;
	// The artist's last name
	String mLastName;

	/*
	 * Only Constructor
	 * @param firstName
	 * @param lastName
	 */
	// CONSTRUCTOR CODE GOES HERE

	Artist(String mFirstName, String mLastName) {
		this.mFirstName = mFirstName;
		this.mLastName = mLastName;
	}

}