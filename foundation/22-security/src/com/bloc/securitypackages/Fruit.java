package com.bloc.securitypackages;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public abstract class Fruit extends Object {
	// The name of the fruit
	protected String mName;
	// Number of calories
	protected int mCalories;
	// Color of the fruit
	protected Color mColor;
	// Weight of the fruit, in pounds
	protected double mWeight;

	Fruit() {
		this("Apple");
		// Default fruit
	}

	Fruit(String name) {
		this(name, 0);
	}

	Fruit(String name, int calories) {
		this(name, calories, null);
	}

	Fruit(String name, int calories, Color color) {
		this(name, calories, color, 0d);
	}

	Fruit(String name, int calories, Color color, double weight) {
		this.mName = name;
		this.mCalories = calories;
		this.mColor = color;
		this.mWeight = weight;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	int getCalories() {
		return mCalories;
	}

	void setCalories(int calories) {
		mCalories = calories;
	}

	public Color getColor() {
		return mColor;
	}

	public void setColor(Color color) {
		mColor = color;
	}

	double getWeight() {
		return mWeight;
	}

	public void setWeight(double weight) {
		mWeight = weight;
	}
}