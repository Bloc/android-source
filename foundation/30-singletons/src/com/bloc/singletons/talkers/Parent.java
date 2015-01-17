package com.bloc.singletons.talkers;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.singletons.Talker;

public class Parent extends Object implements Talker {

	@Override
	public String getMessage() {
		return "Clean your room!";
	}
	
}