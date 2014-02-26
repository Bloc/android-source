package com.bloc.singletons;

/*
 * This is a singleton class which maintains communication
 * between classes and Listeners
 */
public class Speakerphone extends Object {
	/*
	 * get
	 * @return the singleton instance of Speakerphone
	 */

	/*
	 * addListener
	 * Add a listener to Speakerphone's list
	 * @param listener an instance of the Listener interface
	 */

	/*
	 * removeListener
	 * Remove a Listener from the Speakerphone's list
	 * @param listener the Listener to remove
	 */

	/*
	 * shoutMessage
	 * Sends the message to all of the Listeners tracked by Speakerphone
	 * @param talker a Talker whose message will be sent
	 */

	/*
	 * shoutMessage
	 * Sends the message to all of the Listeners which are instances of
	 * the class parameter
	 * @param talker a Talker whose message will be sent
	 * @param cls a Class object representing the type which the Listener
	 *			  should extend from in order to receive the message
	 *
	 * HINT: see Class.isAssignableFrom()
	 *		 http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#isAssignableFrom(java.lang.Class)
	 */

	/*
	 * removeAll
	 * Removes all Listeners from Speakerphone
	 */

}