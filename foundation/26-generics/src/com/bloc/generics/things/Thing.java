package com.bloc.generics.things;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

public class Thing extends Object {
	private String mName;

	public Thing(String name) {
		mName = name;
	}

	@Override
	public String toString() {
		return mName;
	}
}