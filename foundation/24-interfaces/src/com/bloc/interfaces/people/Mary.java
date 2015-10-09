package com.bloc.interfaces.people;
import com.bloc.interfaces.people.hobbies.Skydiver;

/************************************************
 *	ASSIGNMENT:
 *	Have Mary implement the Skydiver interface
/************************************************/

public class Mary extends Person implements Skydiver {

	public Mary() {
		super("Mary", "Whiters", "Female", 1.65d, 62d, "Blue");
    }

	public void getInPlane(){
        System.out.println("Mary hops all up in that plane");
	}

	public void jumpFromPlane(){
        System.out.println("Mary JUMPS ON OUTTA THAT PLANE");
	}

	public void releaseParachute(){
        System.out.println("Mary opens dat chute");
	}
}