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
    void feed(){
    	mFeedCounter++;

    if (mFeedCounter < 5)
    setSize("tiny");
    else if(getSize().equals("tiny")&&mFeedCounter%5==0)
    setSize("small");
    else if (getSize().equals("small")&& mFeedCounter%5==0)
    setSize("average");
    else if (getSize().equals("average")&& mFeedCounter%5==0)
    setSize("large");
        
    }
}