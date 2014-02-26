package com.bloc.singletons.listeners;

import com.bloc.singletons.Listener;

public class AudienceMember extends Object implements Listener {

	@Override
	public void onMessageReceived(String message) {
		// Applause
		System.out.println("Applause at: " + message);
	}
	
}