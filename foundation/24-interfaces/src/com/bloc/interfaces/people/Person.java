package com.bloc.interfaces.people;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

public abstract class Person extends Object {
	// First name
	private String mFirstName;
	// Sur name
	private String mLastName;
	// Gender
	private String mGender;
	// Height in meters
	private double mHeight;
	// Weight(mass) in kilograms
	private double mWeight;
	// Eye color
	private String mEyeColor;

	public Person() {

	}

	public Person(String firstName, String lastName,
				  String gender, double height, double weight,
				  String eyeColor) {
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setHeight(height);
		setWeight(weight);
		setEyeColor(eyeColor);
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public String getGender() {
		return mGender;
	}

	public void setGender(String gender) {
		mGender = gender;
	}

	public double getHeight() {
		return mHeight;
	}

	public void setHeight(double height) {
		mHeight = height;
	}

	public double getWeight() {
		return mWeight;
	}

	public void setWeight(double weight) {
		mWeight = weight;
	}

	public String getEyeColor() {
		return mEyeColor;
	}

	public void setEyeColor(String eyeColor) {
		mEyeColor = eyeColor;
	}
}