package com.bloc.collections;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import java.util.*;

public class Main extends Object {

	public static void main(String [] args) {
		try {
			Pastry[] pastries = new Pastry[8];
			// Let's get some pastries going
			pastries[0] = new Pastry("Cronut");
			pastries[1] = new Pastry("Pop-Tart");
			pastries[2] = new Pastry("Apple Pie");
			pastries[3] = new Pastry("Cherry Pie");
			pastries[4] = new Pastry("Bear Claw");
			pastries[5] = new Pastry("Croissant");
			pastries[6] = new Pastry("Danish");
			pastries[7] = new Pastry("Raspberry Tart");

			// Create a favorite pastries object
			FavoritePastries favoritePastries = new FavoritePastries();

			int[] ratings = new int[8];
			// Generate ratings
			Random rand = new Random();
			for (int i = 0; i < ratings.length; i++) {
				ratings[i] = rand.nextInt(5) + 1;
			}

			// Add Pastries
			for (int i = 0; i < pastries.length; i++) {
				favoritePastries.addPastry(pastries[i], ratings[i]);
			}

			// Test getRatingForPastry
			int pastryRating = 0;
			for (int i = 0; i < pastries.length; i++) {
				pastryRating = favoritePastries.getRatingForPastry(pastries[i]);
				assert pastryRating == ratings[i] : "getRatingForPastry returned an incorrect value";
			}
			pastryRating = favoritePastries.getRatingForPastry(new Pastry("Surprise!"));
			assert pastryRating == -1 : "getRatingForPastry returned an incorrect value when passed an unknown Pastry";
			pastryRating = favoritePastries.getRatingForPastry(null);
			assert pastryRating == -1 : "getRatingForPastry returned an incorrect value when passed an unknown Pastry";

			// Test addPastry with existing Pastries
			ratings[0]++;
			if (ratings[0] > 5) {
				ratings[0] = 1;
			}
			favoritePastries.addPastry(pastries[0], ratings[0]);
			pastryRating = favoritePastries.getRatingForPastry(pastries[0]);
			assert pastryRating == ratings[0] : "addPastry failed to update a rating for an existing Pastry";

			// Test removePastry
			assert favoritePastries.removePastry(pastries[0]) == true : "removePastry was supposed to return true";
			assert favoritePastries.getRatingForPastry(pastries[0]) == -1 : "removePastry failed to remove a Pastry";
			assert favoritePastries.removePastry(null) == false : "removePastry was supposed to return false when removing null";
			assert favoritePastries.removePastry(new Pastry("Surprise!")) == false : "removePastry was supposed to return false when removing a non-existent Pastry";

			// Re-add cronut
			favoritePastries.addPastry(pastries[0], ratings[0]);

			// Test getPastriesForRating
			Collection<Pastry> negOneSet = favoritePastries.getPastriesForRating(-1);
			assert negOneSet != null : "getPastriesForRating returned null when given -1";
			assert negOneSet.size() == 0 : "getPastriesForRating was supposed to return an empty set for rating -1";

			int[] pastryCounts = new int[8];
			Collection<Pastry> oneSet = favoritePastries.getPastriesForRating(1);
			returnCount(oneSet, pastries, pastryCounts);

			Collection<Pastry> twoSet = favoritePastries.getPastriesForRating(2);
			returnCount(twoSet, pastries, pastryCounts);

			Collection<Pastry> threeSet = favoritePastries.getPastriesForRating(3);
			returnCount(threeSet, pastries, pastryCounts);

			Collection<Pastry> fourSet = favoritePastries.getPastriesForRating(4);
			returnCount(fourSet, pastries, pastryCounts);

			Collection<Pastry> fiveSet = favoritePastries.getPastriesForRating(5);
			returnCount(fiveSet, pastries, pastryCounts);

			for (int i = 0; i < pastryCounts.length; i++) {
				assert pastryCounts[i] > 0 : "Pastry(" + pastries[i] + ") absent from Collection returned by getPastriesForRating";
				assert pastryCounts[i] == 1 : "Pastry(" + pastries[i] + ") had duplicate entries in Collections returned by getPastriesForRating";
			}
		} catch (Exception e) {
			System.out.println("Something went wrong with this pastry collection\n");
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}

	private static void returnCount(Collection<Pastry> coll, Pastry[] pastries, int[] pastryCounts) {
		for (int i = 0; i < pastries.length; i++) {
			pastryCounts[i] += coll.contains(pastries[i]) ? 1 : 0;
		}
	}
}
