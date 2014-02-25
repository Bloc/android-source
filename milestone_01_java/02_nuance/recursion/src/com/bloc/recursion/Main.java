package com.bloc.recursion;

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
		int recursedMax = RecursionUtils.findMaxRecursively(numberList);
		if (recursedMax != max) {
			System.out.println("Max was supposed to be " + max + ", returned: " + recursedMax);
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
