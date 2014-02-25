package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		/*
		 * Put a bunch of Toys in the toybox!
		 */
		ToyBox toyBox = new ToyBox();

		if (toyBox.getToyCount() == 0) {
			System.out.println("Let's get some toys in that box!");
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
}
