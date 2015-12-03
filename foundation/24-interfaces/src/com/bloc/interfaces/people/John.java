package com.bloc.interfaces.people;
import com.bloc.interfaces.people.hobbies.Driver;

/************************************************
 *	ASSIGNMENT:
 *	Have John implement the Driver interface
/************************************************/

public class John extends Person implements Driver {

	public John() {
		super("John", "Smith", "Male", 1.7d, 69d, "Brown");
	}

	public void getInCar(){
		System.out.println("John gets in the car");
	}

	public void startEngine(){
		System.out.println("John starts the car");
	}

	public void driveFast(){
	    System.out.println("John goes fast");
	}
}