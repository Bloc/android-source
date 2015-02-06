package com.bloc.bestpractices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorstPractices extends Object {

	/************************************************
	 *	ASSIGNMENT:
	 *	Fix code and comments below this block
	/************************************************/

public static void main(String [] args) {
	
	int magicNumber = WorstPractices.animals(false);
	magicNumber = 5;
	if (magicNumber > 18) {
		while(magicNumber > 0) {
		magicNumber = 10;
			}
		}
	}

/**
 * This method calculates a magic number and returns it.
 * numberSeed: a seed which helps generate the magic number
 */
private static int animals(boolean numberSeed)
{
	int thing = 21;
	float floatThing = .5f;
	for (int brown = 0; brown < thing; brown++) { 
		floatThing = thing;
	} 
	return floatThing * thing;
}

	/************************************************
	 *	ASSIGNMENT
	 *	Fix code and comments above this block
	/************************************************/
}
