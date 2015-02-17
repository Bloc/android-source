package com.bloc.singletons;

import java.util.Iterator;
import java.util.HashSet;

/*
 * This is a singleton class which maintains communication
 * between classes and Listeners
 */
public class Speakerphone extends Object {
	/*
	 * get
	 * @return the singleton instance of Speakerphone
	 */

// a set of listeners, stored as an HashSet
public static HashSet<Listener> listenerList = new HashSet<Listener>();

public static Speakerphone _speakerphone; // contains the global instance: adding _ is general practice for signaling a singleton

	public static Speakerphone get() {
		if (_speakerphone == null) {
			_speakerphone = new Speakerphone();
		}
		return _speakerphone;
	}

	/*
	 * addListener
	 * Add a listener to Speakerphone's list
	 * @param listener an instance of the Listener interface
	 */

public void addListener (Listener listener) {
	listenerList.add(listener);
}

	/*
	 * removeListener
	 * Remove a Listener from the Speakerphone's list
	 * @param listener the Listener to remove
	 */

public void removeListener (Listener listener) {
	listenerList.remove(listener);
}

	/*
	 * shoutMessage
	 * Sends the message to all of the Listeners tracked by Speakerphone
	 * @param talker a Talker whose message will be sent
	 */

public void shoutMessage(Talker talker) {
	Iterator<Listener> shoutIterator = listenerList.iterator();
	while (shoutIterator.hasNext()) {
		shoutIterator.next().onMessageReceived("a message");
	} // ends while
} // ends shoutMessage

// loop through the system and call the main method

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

public void shoutMessageTo(Talker talker, Class<?> cls) {
	Iterator<Listener> shoutIterator = listenerList.iterator();
	while (shoutIterator.hasNext()) {
		if (cls.isAssignableFrom(cls)) {
			shoutIterator.next().onMessageReceived("a message");
		} // ends if
	} // ends while
} // ends shoutMessageTo

// same as shout msg, but in loop if it's a class type, then shout message - otherwise, ignore it (class type is cls)

	/*
	 * removeAll
	 * Removes all Listeners from Speakerphone
	 */

public void removeAll (Listener listener) {
	listenerList.clear();
}

}