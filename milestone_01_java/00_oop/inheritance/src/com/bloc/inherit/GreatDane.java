package com.bloc.inherit;

// CLASS DEFINITION GOES HERE

class GreatDane extends Dog {

  @Override
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
    } else if( "huge".equals(size) ) {
      return 4;
    } else {
      return 2;
    }
  }

  @Override
    String fromSizeIndex(int index) {
    switch(index) {
      case 0: return "tiny";
      case 1: return "small";
      case 2: return "average";
      case 3:
      default: return "large";
      case 4: return "huge";
    }
  }

  @Override
    void changeSize(boolean grow) {
    int sizeIndex = getSizeIndex();
    sizeIndex = sizeIndex + (grow ? 1 : -1);
    if (sizeIndex > 4) {
      sizeIndex = 4;
    } else if (sizeIndex < 0) {
      sizeIndex = 0;
    }
    setSize(fromSizeIndex(sizeIndex));
  }

}