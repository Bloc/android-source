package com.bloc.polymorph.pets;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

public abstract class Pet extends Object {
	private boolean mWashed = false;
	private boolean mFed = false;
	private boolean mExercised = false;

	public void wash() {
		mWashed = true;
	}

	public void feed() {
		mFed = true;
	}

	public void exercise() {
		mExercised = true;
	}

	public boolean isWashed() {
		return mWashed;
	}

	public boolean isFed() {
		return mFed;
	}

	public boolean isExercised() {
		return mExercised;
	}
}