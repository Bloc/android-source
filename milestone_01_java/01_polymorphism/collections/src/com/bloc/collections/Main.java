package com.bloc.collections;

public class Main extends Object {

	public static void main(String [] args) {
		try {
			MyArrayList<String> myStringList = new MyArrayList<String>();

			myStringList.add("Some Stringy Thingy");
			if (!myStringList.contains("Some Stringy Thingy")) {
				System.out.println("ERROR: .contains should've returned true\n");
				System.exit(1);
			}

			if (myStringList.size() != 1) {
				System.out.println("ERROR: Size should be 1\n");
				System.exit(1);
			}

			myStringList.add("Another Stringy");

			if (myStringList.size() != 2) {
				System.out.println("ERROR: Size should be 2\n");
				System.exit(1);
			}

			if (myStringList.contains("Another Stringy") == false) {
				System.out.println("ERROR: .contains should've returned true\n");
				System.exit(1);
			}

			if ("Another Stringy".equals(myStringList.get(1)) == false) {
				System.out.println("ERROR: The object at index 1 doesn't match\n");
				System.exit(1);
			}

			if (1 != myStringList.indexOf("Another Stringy")) {
				System.out.println("ERROR: The object at index 1 doesn't match\n");
				System.exit(1);
			}

			if (!myStringList.remove("Another Stringy")) {
				System.out.println("ERROR: Failed to remove object\n");
				System.exit(1);
			}

			if (myStringList.size() != 1) {
				System.out.println("ERROR: The size of the list should be 1\n");
				System.exit(1);
			}

			String sStrTh = myStringList.remove(0);
			if ("Some Stringy Thingy".equals(sStrTh) == false) {
				System.out.println("ERROR: The item removed doesn't match the original\n");
				System.exit(1);	
			}

			if (myStringList.isEmpty() == false) {
				System.out.println("ERROR: isEmpty should be returning true\n");
				System.exit(1);
			}

			String one = "one";
			String two = "two";
			String three = "three";

			myStringList.add(one);
			myStringList.add(two);
			myStringList.add(three);

			myStringList.set(0, three);

			if (three != myStringList.get(0)) {
				System.out.println("ERROR: object at index 0 did not match\n");
				System.exit(1);
			}

			myStringList.clear();
			if (myStringList.isEmpty() == false) {
				System.out.println("ERROR: List should be empty\n");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in MyArrayList :(\n");
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
}
