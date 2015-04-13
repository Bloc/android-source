package com.bloc.statics;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.statics.appliances.*;

public class Main extends Object {

	public static void main(String [] args) {

		Toaster toaster = new Toaster();
		Refrigerator frige = new Refrigerator();
		Oven oven = new Oven();

		toaster.plugIn();
		toaster.flipPowerSwitch();
		if (!toaster.isOn()) {
			System.out.println("Something went wrong powering on the toaster");
			System.exit(1);
		}

		frige.plugIn();
		frige.flipPowerSwitch();
		frige.unplug();
		if (frige.isOn()) {
			System.out.println("The frige should be off… hmm");
			System.exit(1);
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
