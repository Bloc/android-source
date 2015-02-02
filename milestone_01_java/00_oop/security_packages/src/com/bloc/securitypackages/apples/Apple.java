package com.bloc.securitypackages.apples; // this remains the same

import com.bloc.securitypackages.Fruit; // added
import com.bloc.securitypackages.*; // added

public abstract class Apple extends Fruit { // added public

    Apple(String name, int calories, Color color, double weight) {
      super(name, calories, color, weight);
  } // added constructor to call super Fruit

}