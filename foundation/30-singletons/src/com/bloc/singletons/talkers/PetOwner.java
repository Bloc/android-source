package com.bloc.singletons.talkers;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.singletons.Talker;

public class PetOwner extends Object implements Talker {

	@Override
	public String getMessage() {
		return "Sit";
	}
	
}