package com.bloc.singletons.talkers;

import com.bloc.singletons.Talker;

public class Parent extends Object implements Talker {

	@Override
	public String getMessage() {
		return "Clean your room!";
	}
	
}