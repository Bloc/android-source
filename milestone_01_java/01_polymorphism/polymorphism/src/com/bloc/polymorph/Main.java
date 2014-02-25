package com.bloc.polymorph;

import com.bloc.polymorph.pets.*;

public class Main extends Object {

	public static void main(String [] args) {

		Dog dog = new Dog();
		Cat cat = new Cat();
		Bird bird = new Bird();
		Snake snake = new Snake();
		Tarantula tarantula = new Tarantula();

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
