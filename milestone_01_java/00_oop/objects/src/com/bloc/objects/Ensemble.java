package com.bloc.objects;

class Ensemble extends Object {
	// Name
	String mName;

	// All of the artists in the group
	Artist[] mArtists;

	/*
	 * First Constructor
	 * This constructor takes in a variable length of Artist objects
	 * @param artists variable length artists
	 */
	// CONSTRUCTOR CODE GOES HERE

	Ensemble(Artist [] mArtists) { // a string of artists
		this.mArtists = mArtists;
		this.mName = mArtists[0].mFirstName + mArtists[0].mLastName;
	} // I believe that this is correct.

	/*
	 * Second Constructor
	 * This constructor takes a name and a variable length of Artist objects
	 * Side-effect: if the 'name' parameter is null, uses the first and
	 * 				last name of the first Artist
	 * Hint:		You can add Strings together with a '+'
	 * @param name the name of the group
	 * @param artists variable length artists
	 */
	// CONSTRUCTOR CODE GOES HERE

Ensemble(String pName, Artist [] pArtists) { // feels correct
		if (pName == null) {
			pName = pArtists[0].mFirstName + pArtists[0].mLastName;
		} // closes if
		this.mName = pName;
		this.mArtists = pArtists;
		// pName stands for a parameter variable, v. a member variable
	} // ends Ensemble constructor

} // ends Ensemble class