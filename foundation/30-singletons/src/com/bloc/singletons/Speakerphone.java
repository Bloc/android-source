package com.bloc.singletons;

/************************************************
 *	ASSIGNMENT:
 *	Populate this class with the defined methods.
 *
 *	This is a singleton class which maintains communication
 *	between Talker and Listener interface objects.
/************************************************/
private static Speakerphone speakerphone;
private HashSet<Listener> mListener;
private HashSet<Talker> mTalker;

public class Speakerphone extends Object {
	private Speakerphone(){
		mListener = new HashSet<Lister>();
		mTalker = new HashSet<Talker>();
	}
	/*
	 * get
	 *
	 * @return the singleton instance of Speakerphone (Speakerphone)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the get method
	/************************************************/
	public static Speakerphone get(){
		if (speakerphone == null) {
			speakerphone = new Speakerphone();
		}
		
		return speakerphone;
	}
	/*
	 * addListener
	 *
	 * Add a listener to Speakerphone's list
	 *
	 * @param listener an instance of the Listener interface (Listener)
	 * @return nothing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the addListener method
	/************************************************/
	public static void addListener(Listener listerner){
		mListener.add(listener);
	}
	
	/*
	 * removeListener
	 *
	 * Remove a Listener from the Speakerphone's list
	 *
	 * @param listener the Listener to remove (Listener)
	 * @return nothing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the removeListener method
	/************************************************/
	private void removeListener(Listener listener){
		if(!mListener.remove(listener)){
			System.out.println("Sorry, listener " + listener.toString() + " is not in the speakerphone.");
		}
	}
	/*
	 * removeAll
	 *
	 * Removes all Listeners from Speakerphone
	 *
	 * @return nothing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the removeAll method
	/************************************************/
	private void removeAll(){
		mListener.clear();
	}
	/*
	 * contains
	 *
	 * Checks whether a Listener is found in the Speakerphone's
	 * collection.
	 *
	 * @param listener
	 * @return `true` if the Listener has already been added to
	 *		   the Speakerphone, `false` otherwise (boolean)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the contains method
	/************************************************/	
	private boolean contains(Listener listener){
		return mListener.contains(listener);
	}
	/*
	 * shoutMessage
	 *
	 * Sends the message to all of the Listeners tracked by Speakerphone
	 *
	 * @param talker a Talker whose message will be sent (Talker)
	 * @return nothing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the shoutMessage method
	/************************************************/
	private void shoutMessage(Talker talker){
		String message = talker.getMessage();
		Iterator<Listener> it = mListener.iterator();
		
		while(it.hasNext()){
			it.next().onMessageReceived(message);
		}
	}
	/*
	 * shoutMessage
	 *
	 * Sends the message to all of the Listeners which are instances of
	 * the cls parameter
	 *
	 * @param talker a Talker whose message will be sent (Talker)
	 * @param cls a Class object representing the type which the Listener
	 *			  should extend from in order to receive the message (Class)
	 * @return nothing
	 *
	 * HINT: see Class.isAssignableFrom()
	 *		 http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#isAssignableFrom(java.lang.Class)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Implement the shoutMessage method
	/************************************************/
	private void shoutMessage(Talker talker,Class cls){
	
	}
}