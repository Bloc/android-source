package com.bloc.singletons;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

public interface Listener {
	/*
	 * onMessageReceived
	 * New messages will arrive in this method
	 * @param message The message sent
	 */
	public void onMessageReceived(String message);
}