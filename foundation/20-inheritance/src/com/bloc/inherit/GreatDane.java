package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the GreatDane class below
 *
 *	Great Danes have an extra size category, "huge".
 *	After growing to a "large" size, they may grow
 *	to an additional, "huge" size after 3 meals.
/************************************************/
class GreatDane extends Dog{
     
    @Override
    void feed(){
      mFeedCounter++;
        if (mFeedCounter < 3)
    setSize("large");
    else if(getSize().equals("large")&&mFeedCounter%3==0)
    setSize("huge");
  //   else if (getSize().equals("small")&& mFeedCounter%3==0)
  //   setSize("average");
  //   else if (getSize().equals("average")&& mFeedCounter%3==0)
  //   setSize("large");
  // else if (getSize().equals("large")&& mFeedCounter%3==0)
  //   setSize("huge");
      }
      }

      
    

          
    