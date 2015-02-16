 

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
        if(++mFeedCounter ==5){
        dogSize++;
        changeSize(true);
        mFeedCounter = 0;}
    }
}