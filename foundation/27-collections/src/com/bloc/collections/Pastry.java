package com.bloc.collections;

public class Pastry {
	private String mName;

	public Pastry(String name) {
		mName = name;
	}

	@Override
	public String toString() {
		return mName;
	}
}