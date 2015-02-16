 

/************************************************
 *  ASSIGNMENT:
 *  Define the GreatDane class below
 *
 *  Great Danes have an extra size category, "huge".
 *  After growing to a "large" size, they may grow
 *  to an additional, "huge" size after 3 meals.
/************************************************/
class GreatDane extends Dog{
    
    @Override
    void feed(){
        if(++mFeedCounter == 3){
        dogSize ++;
        changeSize(true);
          if (mSize[dogSize].equals("large")){
                if (++mFeedCounter ==3)
                mSize[dogSize] = "huge";
        mFeedCounter = 0;}
    }
}
          
    }
    

    