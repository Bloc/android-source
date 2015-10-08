package com.bloc.objects;

class Song extends Object {
	// The ensemble which produced it
	String mEnsemble;
	// Title of the song
	String mTitle;
	// The year it was released
	int mYearReleased;

        Song(){
            mEnsemble = "Generic";
            mTitle = "Title";
            mYearReleased = 1;
        }

	/*
	 * Song
	 *
	 * Default Constructor
	 * Side-effects: Assigns some default ensemble, title and
	 *				 and year of your choosing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first Song constructor
	/************************************************/

        Song(String mTitle, String mEnsemble){
            mYearReleased = 0;
            this.mTitle = mTitle;
            this.mEnsemble = mEnsemble;
        }

	/*
	 * Song
	 *
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second Song constructor
	/************************************************/

        Song(int mYearReleased, String mTitle, String mEnsemble){
            this.mYearReleased = mYearReleased;
            this.mTitle = mTitle;
            this.mEnsemble = mEnsemble;
        }

	/*
	 * Song
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third Song constructor
	/************************************************/
}