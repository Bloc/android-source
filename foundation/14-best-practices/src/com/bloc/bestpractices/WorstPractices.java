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
		int MagicNumber = WorstPractices.animals(false);
		MagicNumber *= 5;
	if (MagicNumber > 18) {
		while(MagicNumber > 0)
	{
			MagicNumber--;
			}
		}
	}	

// animals
// this method takes in a single parameter, yeswellheresthething. Using a very elaborate and complex algorithm, it calculate a magic number
// yeswellheresthething: a seed which helps generate the magic number
// returns: a magical number


	private static int animals(boolean yeswellheresthething)
{
		/*
			Start off with one of these
		*/
	int aInt = yeswellheresthething ? 34 : 21;
		float sparklesfairy = .5f;
	for (int brown = 0; brown < aInt; brown++) { sparklesfairy *= aInt;
	} return (int) sparklesfairy * aInt;
}

	/************************************************
	 *	ASSIGNMENT
	 *	Fix code and comments above this block
	/************************************************/
}
