package com.bloc.generics;

public class Toy<T extends Object> extends Object {
	// The toy!
	private T mToy;

	public Toy(T item) {
		mToy = item;
	}

	public T get() {
		return mToy;
	}
}