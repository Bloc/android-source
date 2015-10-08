package com.bloc.objects;

class Artist extends Object {
    // The artist's first name
    String mFirstName;
    // The artist's last name
    String mLastName;

    Artist(){
        this("No FN", "no LN");
    }

    Artist(String mFirstName, String mLastName){
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

	/*
	 * Artist
	 *
	 * @param firstName (String)
	 * @param lastName (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the Artist constructor
	/************************************************/
}