package com.bloc.polymorph;

import com.bloc.polymorph.pets.*;

public class Main extends Object {

	public static void main(String [] args) {

		Pet dog = new Dog();
		Pet cat = new Cat();
		Pet bird = new Bird();
		Pet snake = new Snake();
		Pet tarantula = new Tarantula();

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations below by employing polymorphism
		/************************************************/

		((Pet)dog).feed();
		((Pet)dog).wash();
		((Pet)dog).exercise();

		((Pet)cat).feed();
		((Pet)cat).wash();
		((Pet)cat).exercise();

		((Pet)bird).feed();
		((Pet)bird).wash();
		((Pet)bird).exercise();

		((Pet)snake).feed();
		((Pet)snake).wash();
		((Pet)snake).exercise();

		((Pet)tarantula).feed();
		((Pet)tarantula).wash();
		((Pet)tarantula).exercise();

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
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
