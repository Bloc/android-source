package com.bloc.singletons;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.singletons.listeners.*;
import com.bloc.singletons.talkers.*;

public class Main extends Object {

	public static void main(String [] args) {

		Speakerphone singleton = Speakerphone.get();
		Speakerphone singleton2 = Speakerphone.get();

		if (singleton != singleton2) {
			System.out.println("A singleton Speakerphone is not being returned by `get`");
			System.exit(0);
		}

		Pet pet = new Pet();
		Child child = new Child();
		AudienceMember audienceMember = new AudienceMember();

		Parent parent = new Parent();
		PetOwner petOwner = new PetOwner();
		Singer singer = new Singer();

		singleton.addListener(pet);
		singleton.addListener(child);
		singleton.addListener(audienceMember);

		if (!singleton.contains(pet)) {
			System.out.println("`pet` is missing from Speakerphone");
			System.exit(0);
		}

		if (!singleton.contains(child)) {
			System.out.println("`child` is missing from Speakerphone");
			System.exit(0);
		}

		if (!singleton.contains(audienceMember)) {
			System.out.println("`audienceMember` is missing from Speakerphone");
			System.exit(0);
		}

		singleton.shoutMessage(parent);
		singleton.shoutMessage(petOwner);
		singleton.shoutMessage(singer);

		singleton.shoutMessage(parent, Child.class);
		singleton.shoutMessage(petOwner, Pet.class);
		singleton.shoutMessage(singer, AudienceMember.class);

		singleton.removeListener(child);
		if (singleton.contains(child)) {
			System.out.println("`child` shouldn't be in Speakerphone");
			System.exit(0);
		}

		singleton.removeAll();
		if (singleton.contains(pet) || singleton.contains(audienceMember)) {
			System.out.println("Neither `pet` nor `audienceMember` should be in Speakerphone");
			System.exit(0);
		}

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/* Nice work, you pass! */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");		
	}
}
