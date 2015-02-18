 

class Ensemble extends Object {
	// Name
	String mName;

	// All of the artists in the group
	Artist[] mArtists;
	

	/*
	 * Ensemble
	 *
	 * This constructor takes in a variable length of Artist objects
	 *
	 * @param artists variable length artists (Artist... artists)
	 * // "..." means that in the parameter, you can put in any # of artists
	 * // i.e. artist 1, artist 2, etc. and it will automatically collapse them into
	 * // an array
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first Ensemble constructor
	/************************************************/
    Ensemble(Artist... bandMembers){
        mArtists = bandMembers;
        mName = mArtists[0].mFirstName + " " +mArtists[0].mLastName;
    // calling an already existing artist
}
	/*
	 * Ensemble
	 *
	 * This constructor takes a name and a variable length of Artist objects
	 * Side-effect: if the 'name' parameter is null, uses the first and
	 * 				last name of the first Artist
	 * Hint:		You can add Strings together with a '+'
	 *
	 * @param name the name of the group (String)
	 * @param artists variable length artists (Artist... artists)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second Ensemble constructor
	/************************************************/
	Ensemble(String name, Artist [] artists){
	    mName = name;
	    if(name == null)
	    name = mArtists[0].mFirstName + " " +mArtists[0].mLastName;
	   }
}