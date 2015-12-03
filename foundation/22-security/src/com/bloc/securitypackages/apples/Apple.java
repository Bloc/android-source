package com.bloc.securitypackages.apples;
import com.bloc.securitypackages.Fruit;
/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public abstract class Apple extends Fruit {

	public Apple(String name, int calories, Color color, double weight) {
        super(name, calories, color, weight);
    }

   	abstract void bite();

}