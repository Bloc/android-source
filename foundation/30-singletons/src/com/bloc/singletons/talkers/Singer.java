package com.bloc.singletons.talkers;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.singletons.Talker;

public class Singer extends Object implements Talker {

	@Override
	public String getMessage() {
		return "♫ And IIIIIII will always love youuuuuuu ♫";
	}
	
}