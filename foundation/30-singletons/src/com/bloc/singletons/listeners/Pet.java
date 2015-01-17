package com.bloc.singletons.listeners;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.singletons.Listener;

public class Pet extends Object implements Listener {

	@Override
	public void onMessageReceived(String message) {
		// I'm a parrot, repeat message
		System.out.println(message);
	}
	
}