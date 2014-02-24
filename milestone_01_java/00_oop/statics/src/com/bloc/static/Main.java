package com.bloc.statics;

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
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
