package com.bloc.singletons.listeners;

import com.bloc.singletons.Listener;

public class Child extends Object implements Listener {

	@Override
	public void onMessageReceived(String message) {
		// Ignore
		System.out.println("I can't hear yooouuuu");
	}
	
}