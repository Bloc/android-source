 

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
        if(++mPlayCounter == 3)
        dogSize --;
        changeSize(true);
        mPlayCounter = 0;
    }
}