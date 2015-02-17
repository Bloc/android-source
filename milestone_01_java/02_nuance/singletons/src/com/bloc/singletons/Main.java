package com.bloc.singletons;

import java.util.HashSet;

import com.bloc.singletons.talkers.*;
import com.bloc.singletons.listeners.*;
import com.bloc.singletons.Speakerphone;
import com.bloc.singletons.Talker;
import com.bloc.singletons.Listener;

public class Main extends Object {

public static HashSet<Talker> performers = new HashSet<Talker>();
public static HashSet<Talker> household = new HashSet<Talker>();

	public static void main(String [] args) {

    // Instantiate some talkers and some listeners
    Singer whitneyHouston = new Singer();
    AudienceMember fanGirl = new AudienceMember();

    // Register listeners
    performers.add(whitneyHouston);

    Speakerphone microphone = Speakerphone.get(); // creates the instance - you have to call get at least once

    microphone.addListener(fanGirl);

    // Remove listeners

    // Send messages!
    fanGirl.onMessageReceived(whitneyHouston.getMessage());

        for (Talker person : performers) {
            microphone.shoutMessage(person);
        }

	}

}