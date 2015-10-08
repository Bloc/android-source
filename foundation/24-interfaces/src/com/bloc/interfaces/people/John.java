package com.bloc.interfaces.people;

/************************************************
 *	ASSIGNMENT:
 *	Have John implement the Driver interface
/************************************************/

public class John extends Person implements Driver {
	public John() {
		super("John", "Smith", "Male", 1.7d, 69d, "Brown");

		@Override
		public void getInCar(){
			System.out.println("John gets in the car");
		}

		@Override
		public void startEngine(){
			System.out.println("John starts the car");
		}

		@Override
		public void driveFast(){
			System.out.println("John goes fast");
		}
	}
}