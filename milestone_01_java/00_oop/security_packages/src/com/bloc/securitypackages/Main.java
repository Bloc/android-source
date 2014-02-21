package com.bloc.securitypackages;

// YOUR IMPORTS GO HERE
// import com.bloc.{your_package};

public class Main extends Object {

	public static void main(String [] args) {
		Fruit[] fruits = new Fruits[4];
		fruits[0] = new Macintosh();
		fruits[1] = new Green();
		fruits[2] = new Orange();
		fruits[3] = new Grapefruit();

		Color[] colors = new Colors[4];
		colors[0] = new Red();
		colors[1] = new LimeGreen();
		colors[2] = new Orange();
		colors[3] = new OrangeRed();

		
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
