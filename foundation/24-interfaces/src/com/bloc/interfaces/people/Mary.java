package com.bloc.interfaces.people;

/************************************************
 *	ASSIGNMENT:
 *	Have Mary implement the Skydiver interface
/************************************************/

public class Mary extends Person implements Skydiver {
	public Mary() {
		super("Mary", "Whiters", "Female", 1.65d, 62d, "Blue");

		@Override
		public void getInPlane(){
            System.out.println("Mary hops all up in that plane");
		}

		@Override
		public void jumpFromPlane(){
            System.out.println("Mary JUMPS ON OUTTA THAT PLANE");
		}

		@Override
		public void releaseParachute(){
            System.out.println("Mary opens dat chute");
		}
	}
}