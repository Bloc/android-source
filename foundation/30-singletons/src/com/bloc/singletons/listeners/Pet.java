package com.bloc.singletons.listeners;

import com.bloc.singletons.Listener;

public class Pet extends Object implements Listener {

	@Override
	public void onMessageReceived(String message) {
		// I'm a parrot, repeat message
		System.out.println(message);
	}
	
}