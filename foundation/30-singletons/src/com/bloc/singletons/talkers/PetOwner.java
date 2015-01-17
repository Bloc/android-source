package com.bloc.singletons.talkers;

import com.bloc.singletons.Talker;

public class PetOwner extends Object implements Talker {

	@Override
	public String getMessage() {
		return "Sit";
	}
	
}