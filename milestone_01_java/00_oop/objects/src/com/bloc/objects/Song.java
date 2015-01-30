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
	 * Side-effects: Assigns some default ensemble, title and
	 *				 and year of your choosing
	 */
	// CONSTRUCTOR CODE GOES HERE
Song() {
		Artist kurtCobain = new Artist("Kurt", "Cobain"); // instantiates a new artist
		Artist[] nvm = { kurtCobain }; // adding the new artist into the array nvm
		Ensemble Nirvana = new Ensemble(nvm); // instantiates a new ensemble w/the array of artists
		this.mEnsemble = Nirvana; // sets ensemble to this artist
		this.mTitle = "Smells like teen spirit";
		this.mYearReleased = 1994;
} // I believ this is correct


	// Song(Ensemble ensemble, String title, int yearReleased) {
	// 	this.ensemble = ensemble;
	// 	this.title = title;
	// 	this.yearReleased = yearReleased;
	// }
	/*
	 * Partial Constructor
	 * Side-effects: Sets the year of release to 0
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 */
	// CONSTRUCTOR CODE GOES HERE

Song(Ensemble mEnsemble, String mTitle) {
		this.mEnsemble = mEnsemble;
		this.mTitle = mTitle;
		this.mYearReleased = 0;
} // I believe this is correct

	/*
	 * Full Constructor
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 * @param yearReleased the year the song was released
	 */
	// CONSTRUCTOR CODE GOES HERE

Song(Ensemble pEnsemble, String pTitle, int pYearReleased) {
		this.mEnsemble = pEnsemble;
		this.mTitle = pTitle;
		this.mYearReleased = pYearReleased;
}

}