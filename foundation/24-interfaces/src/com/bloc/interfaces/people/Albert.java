package com.bloc.interfaces.people;

/************************************************
 *	ASSIGNMENT:
 *	Have Albert implement the SalsaDancer interface
/************************************************/

public class Albert extends Person implements SalsaDancer{
	public Albert() {
		super("Albert", "Cobb", "Male", 1.8d, 72d, "Green");

		@Override
		public void putOnShoes(){
			System.out.println("ALbert begrudgingly puts on footwear");
		}

		@Override
		public void findAPartner(){
			System.out.println("Albert gets himself a lady");
        }

	    @Override
	    public void salsa(){
	    	System.out.println("Albert goes ham gettin his salsa on");
	    }
	}
}