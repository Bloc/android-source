package com.bloc.classes;

import java.lang.reflect.Method;

public class Main extends Object {

	public static void main(String [] args) {
		// Test for methods

		Method getHairLength = recoverMethod("getHairLength");
		Method setHairLength = recoverMethod("setHairLength", float.class);
		Method getGender = recoverMethod("getGender");
		Method setGender = recoverMethod("setGender", String.class);
		Method getSize = recoverMethod("getSize");
		Method setSize = recoverMethod("setSize", String.class);
		Method getAge = recoverMethod("getAge");
		Method setAge = recoverMethod("setAge", int.class);
		Method getWeight = recoverMethod("getWeight");
		Method setWeight = recoverMethod("setWeight", float.class);
		Method getColor = recoverMethod("getColor");
		Method setColor = recoverMethod("setColor", String.class);
		Method feed = recoverMethod("feed");
		Method play = recoverMethod("play");
		Method cutHair = recoverMethod("cutHair");

		Dog dog = new Dog();

		// Test Getters and Setters
		testGetSet(dog, getHairLength, setHairLength, 10.0f);
		testGetSet(dog, getGender, setGender, "female");
		testGetSet(dog, getSize, setSize, "small");
		testGetSet(dog, getAge, setAge, 62);
		testGetSet(dog, getWeight, setWeight, 32f);
		testGetSet(dog, getColor, setColor, "brown");

		// Test feed
		try {
			float weight = (Float) getWeight.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			if (((Float) getWeight.invoke(dog, new Object[0])) <= weight) {
				System.out.println("Your Dog should have gained some weight");
				System.exit(1);
			}
			feed.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			if (!"average".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog didn't grow to average after 3 meals :(");
				System.exit(1);		
			}
			feed.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			if (!"large".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog didn't grow to large after 3 more meals :(");
				System.exit(1);		
			}

			feed.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			feed.invoke(dog, new Object[0]);
			if (!"large".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog should stay large if it keeps feeding like this");
				System.exit(1);		
			}
		} catch (Exception e) {
			System.out.println("Something went wrong with " + feed.getName());
			System.exit(1);
		}

		// Test play
		try {
			float weight = (Float) getWeight.invoke(dog, new Object[0]);
			play.invoke(dog, new Object[0]);
			if (((Float)getWeight.invoke(dog, new Object[0])) >= weight) {
				System.out.println("Your Dog should have lost some weight");
				System.exit(1);
			}

			play.invoke(dog, new Object[0]);
			play.invoke(dog, new Object[0]);
			play.invoke(dog, new Object[0]);
			play.invoke(dog, new Object[0]);

			if (!"large".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog shrank too soon");
				System.exit(1);		
			}

			play.invoke(dog, new Object[0]);
			if (!"average".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog should have shrank by now");
				System.exit(1);		
			}

			for (int i = 0; i < 6; i++) {
				play.invoke(dog, new Object[0]);
			}

			if (!"small".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog should have shrank by now");
				System.exit(1);		
			}

			for (int i = 0; i < 6; i++) {
				play.invoke(dog, new Object[0]);
			}

			if (!"tiny".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog should have shrank by now");
				System.exit(1);		
			}

			for (int i = 0; i < 6; i++) {
				play.invoke(dog, new Object[0]);
			}

			if (!"tiny".equals(getSize.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog should stay tiny once its tiny");
				System.exit(1);		
			}

		} catch (Exception e) {
			System.out.println("Something went wrong with " + play.getName());
			System.exit(1);
		}


		// Test cutHair
		try {
			float hairLength = (Float) getHairLength.invoke(dog, new Object[0]);
			cutHair.invoke(dog, new Object[0]);
			if (hairLength <= ((Float) getHairLength.invoke(dog, new Object[0]))) {
				System.out.println("Your Dog's hair should be shorter :(");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong with " + cutHair.getName());
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

	private static void testGetSet(Dog dog, Method getter, Method setter, Object arg) {
		try {
			setter.invoke(dog, arg);
			Object result = getter.invoke(dog, new Object[0]);
			if (result == null || !(result.getClass().isAssignableFrom(arg.getClass()))) {
				System.out.println("'" + getter.getName() + "' returning incorrect type");
				System.exit(1);
			}
			if (!result.equals(arg)) {
				System.out.println("'" + setter.getName() + "' may have a bug in it");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static Method recoverMethod(String name) {
		return Main.recoverMethod(name, new Class<?>[0]);
	}

	private static Method recoverMethod(String name, Class<?>... params) {
		Method method = null;
		try {
			method = Dog.class.getDeclaredMethod(name, params);
		} catch (Exception e) {
			System.out.println("'" + name + "' method is either missing or has an inaccurate signature");
			System.exit(1);
		}
		return method;
	}
}
