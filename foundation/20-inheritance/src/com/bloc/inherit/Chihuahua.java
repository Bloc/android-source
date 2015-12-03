package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the Chihuahua class below
 *
 *	Chiuahuas must be fed 5 times in order to grow
 *	larger.
/************************************************/

class Chihuahua extends Dog{
	@Override
  void feed() {
		mWeight += WEIGHT_GAINED_FROM_FEEDING;
		// Pre-increment feed counter
		if (++mFeedCounter == 5) {
			changeSize(true);
			mFeedCounter = 0;
		}
	}
}