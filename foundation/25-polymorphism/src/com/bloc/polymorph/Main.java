package com.bloc.polymorph;

import com.bloc.polymorph.pets.*;

public class Main extends Object {

	public static void main(String [] args) {

		Dog dog = new Dog();
		Cat cat = new Cat();
		Bird bird = new Bird();
		Snake snake = new Snake();
		Tarantula tarantula = new Tarantula();

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations below by employing polymorphism
		/************************************************/

		Pet[] pets = new Pet[5];
		pets[0] = dog;
		pets[1] = cat;
		pets[2] = bird;
		pets[3] = snake;
		pets[4] = tarantula;

		for(int i = 0; i < pets.length; i++){
			pets[i].feed();
			pets[i].wash();
			pets[i].exercise();
		}

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations above by employing polymorphism
		/************************************************/

		for(int i = 0; i < pets.length; i++){
			assert pets[i].isFed() && pets[i].isWashed() && pets[i].isExercised() : "Your " + pets[i] + " needs a little more attention";
		}

		
		
		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*  If you see this,    */");
		System.out.println("/*  it only means that  */");
		System.out.println("/*  the program ran     */");
		System.out.println("/*  successfully. It    */");
		System.out.println("/*  may require         */");
		System.out.println("/*  additional work.    */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
