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

Ensemble(String mName, Artist [] mArtists) { // feels correct
	if (mArtists[].class == null) {
		this.mArtists = mArtists[0];
		// lines 33-34 are where I am stuck - how do I access the firstName lastName variables from the Artist class?
	}

// some non-functional code I worked on earlier

// 		if (mName == null) {
// 			this.mName = mArtists[0].mFirstName + " " + mArtists[0].mLastName;
// 		}
// 		else {
// 			this.mName = mName;
// 		}
// 		this.mArtists = mArtists[];
	} // ends Ensemble constructor
} // ends Ensemble class