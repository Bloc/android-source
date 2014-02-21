package com.bloc.objects;

class Song extends Object {
	// The ensemble which produced it
	Ensemble mEnsemble;
	// Title of the song
	String mTitle;
	// The year it was released
	int mYearReleased;

	/*
	 * Basic Constructor
	 */
	Song() {

	}

	/*
	 * Partial Constructor
	 * @param ensemble the artist(s) responsible
	 * @param title the song title
	 */
	Song(Ensemble ensemble, String title) {
		this(ensemble, title, 0);
	}

	/*
	 * Full Constructor
	 * @param ensemble the artist(s) responsible
	 * @param title the song title
	 * @param yearReleased the year the song was released
	 */
	Song(Ensemble ensemble, String title, int yearReleased) {
		mEnsemble = ensemble;
		mTitle = title;
		mYearReleased = yearReleased;
	}
}