package com.bloc.interfaces.people;
import com.bloc.interfaces.people.hobbies.Driver;
/************************************************
 *	ASSIGNMENT:
 *	Have John implement the Driver interface
/************************************************/

public class John extends Person implements Driver{
	public John() {
		super("John", "Smith", "Male", 1.7d, 69d, "Brown");
	}
	@Override
	public void getInCar(){
	   }
	@Override
	public void startEngine(){
	   }
	@Override
	public void driveFast(){
	   }
}