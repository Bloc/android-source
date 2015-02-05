package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		ToyBox toyBox = new ToyBox();
		/*
		 * Put a bunch of Toys in toyBox!
		 */

Thing pandorasBox = new Thing("Pandoras Box");
Thing batGirl = new ActionFigure();
Thing whyASpoon = new Spoon();
Thing whereTheSidewalkEnds = new Book();

toyBox.addToy(new Toy<Thing>(pandorasBox));
toyBox.addToy(new Toy<Thing>(batGirl)); // why is it that I don't use ActionFigure here?
toyBox.addToy(new Toy<Thing>(whyASpoon));
toyBox.addToy(new Toy<Thing>(whereTheSidewalkEnds));

		assert toyBox.getToyCount() > 0 : "Let's get some toys in that box!";
		System.out.println("Inside your toybox you've got:");
		for (int i = 0; i < toyBox.getToyCount(); i++) {
			System.out.println("- " + toyBox.getToyAtIndex(i).get());
		}
		System.out.println("Sounds like fun!\n");

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
