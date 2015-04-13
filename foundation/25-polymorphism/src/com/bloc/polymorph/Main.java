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

		dog.feed();
		dog.wash();
		dog.exercise();

		cat.feed();
		cat.wash();
		cat.exercise();

		bird.feed();
		bird.wash();
		bird.exercise();

		snake.feed();
		snake.wash();
		snake.exercise();

		tarantula.feed();
		tarantula.wash();
		tarantula.exercise();

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations above by employing polymorphism
		/************************************************/

		assert dog.isFed() && dog.isWashed() && dog.isExercised() : "Your dog needs a little more attention";
		assert cat.isFed() && cat.isWashed() && cat.isExercised() : "Your cat needs a little more attention";
		assert bird.isFed() && bird.isWashed() && bird.isExercised() : "Your bird needs a little more attention";
		assert snake.isFed() && snake.isWashed() && snake.isExercised() : "Your snake needs a little more attention";
		assert tarantula.isFed() && tarantula.isWashed() && tarantula.isExercised() : "Your tarantula needs a little more attention";
		
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
