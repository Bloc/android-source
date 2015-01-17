package com.bloc.recursion;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import java.util.ArrayList;
import java.util.Random;

public class Main extends Object {

	public static void main(String [] args) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		int max = 0;
		int temp = 0;
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			temp = random.nextInt(500);
			if (temp > max) {
				max = temp;
			}
			numberList.add(temp);
		}

		try {
			int recursedMax = RecursionUtils.findMaxRecursively(numberList);
			if (recursedMax != max) {
				System.out.println("Max was supposed to be " + max + ", returned: " + recursedMax);
				System.exit(1);
			}

			numberList.clear();
			numberList.add(2);
			recursedMax = RecursionUtils.findMaxRecursively(numberList);
			if (recursedMax != 2) {
				System.out.println("Max was supposed to be 2, returned: " + recursedMax);
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong in your recursion");
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
