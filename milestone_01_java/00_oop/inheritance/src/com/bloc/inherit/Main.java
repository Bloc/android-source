package com.bloc.inherit;

import java.lang.reflect.Method;

public class Main extends Object {

	public static void main(String [] args) {
		// Check for Dog subclasses
		Class<?> chihuahuaClass = chihuahuaClass("com.bloc.inherit.Chihuahua");
		Class<?> greatDaneClass = chihuahuaClass("com.bloc.inherit.GreatDane");
		Class<?> goldenRetrieverClass = chihuahuaClass("com.bloc.inherit.GoldenRetriever");

		try {
			// Test Chihuahua : Higher Metabolism
			Dog chihuahua = (Dog) chihuahuaClass.newInstance();
			chihuahua.setSize(chihuahua.fromSizeIndex(0));
			if (chihuahua.getSizeIndex() != 0) {
				System.out.println("Something wrong with setting the size of your chihuahua");
				System.exit(1);
			}
			chihuahua.feed(); // First
			chihuahua.feed(); // Second
			chihuahua.feed(); // Third
			if (chihuahua.getSizeIndex() != 0) {
				System.out.println("Your chihuahua grew too early");
				System.exit(1);
			}
			chihuahua.feed(); // Fourth
			if (chihuahua.getSizeIndex() != 0) {
				System.out.println("Your chihuahua grew too early");
				System.exit(1);
			}
			chihuahua.feed(); // Fifth
			if (chihuahua.getSizeIndex() == 1) {
				System.out.println("Your chihuahua's getting a bit chubby… But that was expected\n");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in the Chihuahua code… Can't believe I just typed that");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			// Test GreatDane : Extra size available
			Dog greatDane = (Dog) greatDaneClass.newInstance();

			greatDane.setSize(greatDane.fromSizeIndex(3));
			if (greatDane.getSizeIndex() != 3) {
				System.out.println("Failed to set GreatDane's size properly");
				System.exit(1);
			}

			greatDane.feed(); // First
			if (greatDane.getSizeIndex() != 3) {
				System.out.println("Your great dane grew too early");
				System.exit(1);
			}

			greatDane.feed(); // Second
			if (greatDane.getSizeIndex() != 3) {
				System.out.println("Your great dane grew too early");
				System.exit(1);
			}

			greatDane.feed(); // Third
			if (greatDane.getSizeIndex() != 4) {
				System.out.println("Your great dane should be at size index 4");
				System.exit(1);
			}

			if (!"huge".equals(greatDane.getSize())) {
				System.out.println("Your great dane should be \"huge\"");
				System.exit(1);
			}

			greatDane.feed(); // Fourth
			greatDane.feed(); // Fifth
			greatDane.feed(); // Sixth

			if (greatDane.getSizeIndex() != 4) {
				System.out.println("Your great dane should still be at size index 4");
				System.exit(1);
			}

			if (4 != greatDane.getSizeIndex("huge")) {
				System.out.println("Did you forget to Override getSizeIndex in GreatDane?");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in the GreatDane code… My mother still loves me");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			// Test GoldenRetriever
			Dog golden = goldenRetrieverClass.newInstance();

			golden.changeSize(true);
			if (3 != golden.getSizeIndex()) {
				System.out.println("Your GoldenRetriever should be \"large\" right now");
				System.exit(1);
			}

			golden.play(); // First
			if (3 != golden.getSizeIndex()) {
				System.out.println("Your GoldenRetriever shrank too soon");
				System.exit(1);
			}

			golden.play(); // Second
			if (3 != golden.getSizeIndex()) {
				System.out.println("Your GoldenRetriever shrank too soon");
				System.exit(1);
			}

			golden.play(); // First
			if (2 != golden.getSizeIndex()) {
				System.out.println("Your GoldenRetriever should have shrank to \"average\"");
				System.exit(1);
			}

		} catch (Exception e) {
			System.out.println("Something went wrong in the GoldenRetriever code… Yup, wrote that too");
			e.printStackTrace();
			System.exit(1);
		}


		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/* Nice work, you pass! */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}

	private Class<?> checkForClass(String name) {
		try {
			Class<?> dogSub = Class.forName(name);
			if (!Dog.class.isAssignableFrom(dogSub)) {
				System.out.println("Your " + dogSub.getName() + " class is not a subclass of Dog");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Failed to find " + name + " class");
			System.exit(1);
		}
		return null;
	}

	private static Method recoverMethod(String name) {
		return Main.recoverMethod(name, new Class<?>[0]);
	}

	private static Method recoverMethod(String name, Class<?>... params) {
		Method method = null;
		try {
			method = Dog.class.getMethod(name, params);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(name + " method missing");
			System.exit(1);
		}
		return method;
	}
}
