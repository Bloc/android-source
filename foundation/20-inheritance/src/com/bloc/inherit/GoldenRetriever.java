package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the GoldenRetriever class below
 *
 *	Golden Retrievers shrink to a smaller size after
 *	playing only 3 times.
/************************************************/
class GoldenRetriever extends Dog{
    @Override
    void play(){
    	mPlayCounter++;
        if(mPlayCounter<3)
        	setSize("large");
        else if (getSize().equals("large") && mPlayCounter%3==0)
        	setSize("average");
        else if (getSize().equals("average") && mPlayCounter%3==0)
			setSize("small");
		else if (getSize().equals("small") && mPlayCounter%3==0)
			setSize("tiny");
    }
}