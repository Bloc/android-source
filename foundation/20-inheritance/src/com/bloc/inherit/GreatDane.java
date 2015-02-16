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
      GreatDane greatDane = new GreatDane();
        if(++mFeedCounter == 3){
        dogSize ++;
          // if ("large".equals(getSize())){
          //   mSize = new String[]{"tiny","small","average","large","huge"};
          //   dogSize++;
          //   getSizeIndex("huge");
          // }
        getSize();
          
        mFeedCounter = 0;}
      }

      
    }

          
    