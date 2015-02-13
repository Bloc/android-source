package com.bloc.singletons;

import java.util.HashSet;

import com.bloc.singletons.talkers.*;
import com.bloc.singletons.listeners.*;
import com.bloc.singletons.Speakerphone;
import com.bloc.singletons.Talker;
import com.bloc.singletons.Listener;

public class Main extends Object {

Speakerphone _speakerphone = Speakerphone._speakerphone;

public static HashSet<Listener> audience = new HashSet<Listener>();
public static HashSet<Listener> household = new HashSet<Listener>();

	public static void main(String [] args) {

    // Instantiate some talkers and some listeners
    Singer whitneyHouston = new Singer();
    Parent mom = new Parent();
    AudienceMember fanGirl = new AudienceMember();
    Pet spot = new Pet();

    // Register listeners
    audience.add(fanGirl);
    household.add(spot);

    // Send messages! - INCOMPLETE
    whitneyHouston.getMessage();
    mom.getMessage();

    fanGirl.onMessageReceived();

    // audience.shoutMessage(Singer(whitneyHouston));

	}

}