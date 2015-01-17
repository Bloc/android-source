package com.bloc.statics;

/************************************************
 *	YOU MAY NOT MODIFY THIS FILE
/************************************************/

import com.bloc.statics.appliances.*;

public class PowerSupply extends Object {
	private Appliance[] mAppliances;

	public PowerSupply() {
		this(new Appliance[0]);
	}

	public PowerSupply(Appliance[] appliances) {
		mAppliances = appliances;
	}

	public void plugAppliance(Appliance appliance) {
		Appliance[] temp = new Appliance[mAppliances.length + 1];
		for (int i = 0; i < mAppliances.length; i++) {
			temp[i] = mAppliances[i];
		}
		temp[mAppliances.length] = appliance;
		mAppliances = temp;
	}

	public void unplugAppliance(Appliance appliance) {
		for (int i = 0; i < mAppliances.length; i++) {
			if (mAppliances[i] == appliance) {
				mAppliances[i] = null;
			}
		}
	}

	public boolean hasAppliance(Appliance appliance) {
		for (int i = 0; i < mAppliances.length; i++) {
			if (mAppliances[i] == appliance) {
				return true;
			}
		}
		return false;
	}
}