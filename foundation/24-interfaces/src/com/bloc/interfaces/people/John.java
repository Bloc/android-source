package com.bloc.interfaces.people;

import com.bloc.interfaces.people.hobbies.*;

/************************************************
 *	ASSIGNMENT:
 *	Have John implement the Driver interface
/************************************************/

public class John extends Person implements Driver{
	public John() {
		super("John", "Smith", "Male", 1.7d, 69d, "Brown");
	}
	
	//@override
	public void getInCar(){
		// Do Something here...
	}

	//@override
	public void startEngine(){
		// Do Something here...
	}
	
	//@override
	public void driveFast(){
		// Do Something here...
	}
}