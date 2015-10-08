package com.bloc.objects;

class PopSong extends Song {
	// The number of weeks this song stayed on Billboard's top 100
	int mWeeksOnBillboard;

        PopSong(){
            mWeeksOnBillboard = 1;
            mTitle = "Generic Song #4356";
            mYearReleased = 2000;
            mEnsemble = "The ensemblers";
        }

	/*
	 * PopSong
	 *
	 * Side-effects: Assigns some default ensemble, title,
	 *				 year and number of weeks on billboard
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first PopSong constructor
	/************************************************/

        PopSong(String mEnsemble, String mTitle){
            mYearReleased = 0;
            this.mEnsemble = mEnsemble;
            this.mTitle = mTitle;
            mWeeksOnBillboard = 1;
        }

	/*
	 * PopSong
	 * 
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second PopSong constructor
	/************************************************/

        PopSong(String mEnsemble, String mTitle, int mYearReleased){
            this.mEnsemble = mEnsemble;
            this.mTitle = mTitle;
            this.mYearReleased = mYearReleased;
            mWeeksOnBillboard = 1;
        }

	/*
	 * PopSong
	 *
	 * Side-effects: Sets the weeks on billboard to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third PopSong constructor
	/************************************************/

        PopSong(String mEnsemble, String mTitle, int mYearReleased, int mWeeksOnBillboard){
            this.mEnsemble = mEnsemble;
            this.mTitle = mTitle;
            this.mYearReleased = mYearReleased;
            this.mWeeksOnBillboard = mWeeksOnBillboard;
        }

	/*
	 * PopSong
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 * @param weeksOnBillboard number of weeks this song lasted on the
	 *		  				   Billboard's top 100 (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the fourth PopSong constructor
	/************************************************/
}