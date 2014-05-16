package com.bloc.generics;

class ToyBox extends Object {
	private Toy<?>[] mToys;

	public ToyBox() {
		this(new Toy<?>[0]);
	}

	public ToyBox(Toy<?>... toys) {
		super();
		mToys = toys;
	}

	public int addToy(Toy<?> newToy) {
		Toy<?>[] toysTemp = new Toy<?>[mToys.length + 1];
		for (int i = 0; i < mToys.length; i++) {
			toysTemp[i] = mToys[i];
		}
		toysTemp[mToys.length] = newToy;
		mToys = toysTemp;
		return mToys.length - 1;
	}

	public Toy<?> getToyAtIndex(int index) {
		if (index < 0 || index >= mToys.length) {
			return null;
		}
		return mToys[index];
	}

	public int getToyCount() {
		return mToys.length;
	}
}