package com.bloc.inherit;

abstract class Dog {

	/************************************************
 	*	YOU MAY MODIFY THIS FILE
	/************************************************/

	// Add this amount for each meal
	final static float WEIGHT_GAINED_FROM_FEEDING = .1f;
	// Reduce this amount for each play
	final static float WEIGHT_LOST_FROM_FEEDING = .2f;
	// Minimum weight (1 pound)
	final static float MINIMUM_WEIGHT = 1f;
	// Hair length reduced by this value
	final static float HAIR_LENGTH_REDUCED_FROM_CUT = .2f;
	// Hair length
	float mHairLength;
	// Gender, either "male" or "female"
	String mGender;
	// Size, either "tiny", "small", "average", or "large"
	String mSize;
	// Its age
	int mAge;
	// Its weight in pounds
	float mWeight;
	// The color of its coat
	String mColor;
	// Tracks how many times the dog has been fed
	int mFeedCounter;
	// Tracks how many times the dog has played
	int mPlayCounter;

	/* Abstract Methods */

	/*
	 * getHairLength
	 * @return this Dog's hair length
	 */
	float getHairLength() {
		return mHairLength;
	}


	/*
	 * setHairLength
	 * Sets the length of the Dog's hair
	 * @param hairLength the new length of the hair, a float
	 * @return nothing
	 */
	void setHairLength(float length) {
		mHairLength = length;
	}

	/*
	 * getGender
	 * @return this Dog's gender
	 */
	String getGender() {
		return mGender;
	}

	/*
	 * setGender
	 * Sets this Dog's gender
	 * @param gender the new gender of the Dog, a String
	 * @return nothing
	 */
	void setGender(String gender) {
		mGender = gender;
	}

	/*
	 * getSize
	 * @return the size of the dog
	 */
	String getSize() {
		return mSize;
	}

	/*
	 * setSize
	 * Sets the size of the Dog
	 * @param size the new size of the Dog, a String
	 * @return nothing
	 */
	void setSize(String size) {
		mSize = size;
	}

	/*
	 * getAge
	 * @return this Dog's age
	 */
	int getAge() {
		return mAge;
	}

	/*
	 * setAge
	 * Sets the age of the Dog
	 * @param age the new age of the Dog, an int
	 * @return nothing
	 */
	void setAge(int age) {
		mAge = age;
	}

	/*
	 * getWeight
	 * @return this Dog's weight
	 */
	float getWeight() {
		return mWeight;
	}

	/*
	 * setWeight
	 * Sets the weight of the Dog
	 * @param age the new weight of the Dog, a float
	 * @return nothing
	 */
	void setWeight(float weight) {
		mWeight = weight;
	}

	/*
	 * getColor
	 * @return this Dog's color
	 */
	String getColor() {
		return mColor;
	}

	/*
	 * setColor
	 * Sets the color of the Dog
	 * @param color the new color of the Dog's coat, a String
	 * @return nothing
	 */
	void setColor(String color) {
		mColor = color;
	}

	/*
	 * feed
	 * Side-effect: 1. The Dog gains weight
	 * 				2. Every 3 meals, the Dog grows to a larger size, if possible
	 *				i.e. "tiny" -> "small" -> "average" -> "large"
	 * @return nothing
	 */
	void feed() {
		mWeight += WEIGHT_GAINED_FROM_FEEDING;
		// Pre-increment feed counter
		if (++mFeedCounter == 3) {
			changeSize(true);
			mFeedCounter = 0;
		}
	}

	/*
	 * play
	 * Side-effect: 1. The Dog loses weight
	 *				2. Every 6 play invocations, the Dog shrinks to a smaller size, if possible
	 *				i.e. "large" -> "average" -> "small" -> "tiny"
	 * @return nothing
	 */
	void play() {
		setWeight(getWeight() - WEIGHT_LOST_FROM_FEEDING);
		if (getWeight() < MINIMUM_WEIGHT) {
			setWeight(MINIMUM_WEIGHT);
		}
		// Pre-increment play counter
		if (++mPlayCounter == 6) {
			changeSize(false);
			mPlayCounter = 0;
		}
	}

	/*
	 * cutHair
	 * Side-effect: the Dog's hair length is reduced
	 * @return nothing
	 */
	void cutHair() {
		setHairLength(getHairLength() - HAIR_LENGTH_REDUCED_FROM_CUT);
		// Check if we're in the negative hair length a.k.a impossible
		if (getHairLength() < 0f) {
			setHairLength(0f);
		}
	}

	/*
	 * final changeSize
	 * Modify the size of the Dog by 1 move
	 * @param grow if true, gain a size, shrink otherwise
	 * @return nothing
	 */
	void changeSize(boolean grow) {
		int sizeIndex = getSizeIndex();
		sizeIndex = sizeIndex + (grow ? 1 : -1);
		if (sizeIndex > 3) {
			sizeIndex = 3;
		} else if (sizeIndex < 0) {
			sizeIndex = 0;
		}
		setSize(fromSizeIndex(sizeIndex));
	}

	/*
	 * getSizeIndex
	 * A short-cut for calling #getSizeIndex(java.lang.String) with
	 * the result of #getSize
	 */
	int getSizeIndex() {
		return getSizeIndex(getSize());
	}

	/*
	 * getSizeIndex
	 * @param size the string value representing the size
	 * @return an index between 0 and 3 in the
	 * 		   array of {"tiny", "small", "average", "large"}
	 */
	int getSizeIndex(String size) {
		if (size == null) {
			// Return default "average" when missing size
			return 2;
		}

		if( "tiny".equals(size) ) {
			return 0;
		} else if( "small".equals(size) ) {
			return 1;
		} else if( "average".equals(size) ) {
			return 2;
		} else if( "large".equals(size) ) {
			return 3;
		} else {
			return 2;
		}
	}

	/*
	 * fromSizeIndex
	 * @param index the index into the sizes array
	 * @return a String, one of {"tiny", "small", "average", "large"}
	 */
	String fromSizeIndex(int index) {
		switch(index) {
			case 0: return "tiny";
			case 1: return "small";
			case 2: return "average";
			case 3:
			default: return "large";
		}
	}

}