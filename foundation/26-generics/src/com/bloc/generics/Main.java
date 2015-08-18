package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		ToyBox toyBox = new ToyBox();
		
		/************************************************
 		 *	ASSIGNMENT:
 		 *	Place several Toy objects into toyBox
		/************************************************/
		
		Toy<ActionFigure> toy = new Toy<ActionFigure>(new ActionFigure());
		Toy<Book> toy2 = new Toy<Book>(new Book());
		Toy<Book> toy3 = new Toy<Book>(new Book());
		Toy<Spoon> toy4 = new Toy<Spoon>(new Spoon());
		
		toyBox.addToy(toy);
		toyBox.addToy(toy2);
		toyBox.addToy(toy3);
		toyBox.addToy(toy4);
		
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
