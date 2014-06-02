package com.bloc.generics.things;

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