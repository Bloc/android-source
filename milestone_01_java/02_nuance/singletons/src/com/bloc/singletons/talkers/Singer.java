package com.bloc.singletons.talkers;

import com.bloc.singletons.Talker;

public class Singer extends Object implements Talker {

	@Override
	public String getMessage() {
		return "♫ And IIIIIII will always love youuuuuuu ♫";
	}
	
}