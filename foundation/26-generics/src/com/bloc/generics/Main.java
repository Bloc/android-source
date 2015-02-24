package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		ToyBox toyBox = new ToyBox();
		ActionFigure lukeSkywalker = new ActionFigure();
        Book danceOfDragons = new Book();
        
        Toy<ActionFigure> starWarsToy = new Toy<ActionFigure>(lukeSkywalker);
        Toy<Book> aSongOfFireAndIce = new Toy<Book>(danceOfDragons);
        /************************************************
         *  ASSIGNMENT:
         *  Place several Toy objects into toyBox
        /************************************************/
        toyBox.addToy(starWarsToy);
        toyBox.addToy(aSongOfFireAndIce);

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
