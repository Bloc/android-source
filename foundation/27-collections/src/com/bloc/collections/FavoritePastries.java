package com.bloc.collections;

import java.util.*;

/*
 * FavoritePastries
 * 
 * This class maintains a record of Pastry objects and their
 * relation to a 1 to 5 rating scale.
 *
 * For example:
 * 5 Star Pastries: Cronut, Cherry Pie
 * 4 Star Pastries: Strudel, Apple Pie
 * 3 Star Pastries: Bear Claw
 * 2 Star Pastries: Pop-Tart
 * 1 Star Pastries: Pot Pie
 *
 * A pastry may not have duplicate entries
 */
public class FavoritePastries {

	/************************************************
 	 *	ASSIGNMENT:
	 *	Use a HashMap to store the relationship
	 *	between rating and pastry: HashMap<Integer, List<Pastry>>
	/************************************************/

	private HashMap<Integer,ArrayList<Pastry>> mFavoritePastries;

	public FavoritePastries() {
		/************************************************
 	 	 *	WORK HERE
		/************************************************/
		mFavoritePastries = new HashMap<Integer,ArrayList<Pastry>>();
	}

	/* 
	 * addPastry
	 *
	 * Add a Pastry to the FavoritePastries class.
	 *
	 * This method stores this Pastry and its
	 * associated rating in some sort of data structure.
	 *
	 * If this Pastry already exists in FavoritePastries,
	 * its old rating should be updated.
	 *
	 * @param pastry The Pastry to store
	 * @param rating The rating to associate with it
	 * @return nothing
	 */
	public void addPastry(Pastry pastry, int rating) {
		/************************************************
 	 	 *	WORK HERE
		/************************************************/
		ArrayList<Pastry> listOfPastries = mFavoritePastries.get(rating);
		if (listOfPastries == null){
			listOfPastries = new ArrayList<Pastry>();
		}
		listOfPastries.add(pastry);
		mFavoritePastries.put(rating, listOfPastries);
	}

	/* 
	 * removePastry
	 *
	 * Remove a Pastry from FavoritePastries
	 *
	 * This method removes any reference to this exact
	 * Pastry object and its associated rating
	 *
	 * @param pastry The Pastry to remove
	 * @return true if the Pastry was found and removed,
	 *		   false otherwise
	 */
	public boolean removePastry(Pastry pastry) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		ArrayList<Pastry> listOfPastries;
		Boolean returnBoolean = false;
		int counter = 0;
		for(Map.Entry<Integer, ArrayList<Pastry>> entry: mFavoritePastries.entrySet()){
			listOfPastries = entry.getValue();
			//System.out.println(listOfPastries.toString());
			System.out.println("Size is: " + listOfPastries.size());
			//System.out.println("Counter is: " + counter++);
			System.out.println("Pastry is: " + pastry);
			Iterator<Pastry> it = listOfPastries.iterator();
			while(it.hasNext()){
				System.out.println("Element is: " + it.next().toString());
			}
			if (listOfPastries.remove(pastry)){
				returnBoolean = true;
			}
			System.out.println("Success Removal: " + returnBoolean);
		}
		return returnBoolean;
	}

	/* 
	 * getRatingForPastry
	 *
	 * Return the associated rating for a given Pastry
	 *
	 * This method will find the associated rating for
	 *7 this Pastry inside of FavoritePastries and return
	 * it to its caller.
	 *
	 * @param  pastry The Pastry for which a rating must
	 * 		   be recovered
	 * @return the rating associated with this Pastry or
	 *		   -1 if not found among FavoritePastries
	 */
	public int getRatingForPastry(Pastry pastry) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		ArrayList<Pastry> listOfPastries;
		int key = -1;
		Boolean containsPastry = false;
		for(Map.Entry<Integer, ArrayList<Pastry>> entry: mFavoritePastries.entrySet()){
			listOfPastries = entry.getValue();
			containsPastry = listOfPastries.contains(pastry);
			if (containsPastry){
				key = entry.getKey();
			}
		}
		return key;
	}

	/* 
	 * getPastriesForRating
	 *
	 * Return a Set of all the Pastries with a given
	 * rating.
	 *
	 * This method returns a Set<Pastry> object containing
	 * references to all of the Pastries associated with
	 * a particular rating.
	 *
	 * @param  rating The rating of the Pastry objects the
	 *		   caller wishes to recover
	 * @return A Set of all the Pastry objects with a rating
	 * 		   of `rating`. Returns an empty set if none are
	 *         found
	 */
	public Collection<Pastry> getPastriesForRating(int rating) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		ArrayList<Pastry> returnCollection = mFavoritePastries.get(rating);
		if(returnCollection != null){
			return returnCollection;
		} else {
			return new ArrayList<Pastry>();
		}
	}

}