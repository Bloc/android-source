package com.bloc.generics;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

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