package com.bloc.statics;

import com.bloc.statics.appliances.*;

public class PowerSupply extends Object {
	private Appliance[] mAppliances;

	public PowerSupply() {
		this(new Appliance[0]);
	}

	public PowerSupply(Appliance[] appliances) {
		mAppliances = appliances; // new array of appliances
	}

	public void plugAppliance(Appliance appliance) {
		Appliance[] temp = new Appliance[mAppliances.length + 1]; // new appliance called temp
		for (int i = 0; i < mAppliances.length; i++) {
			temp[i] = mAppliances[i]; // goes into the mAppliances array
		}
		temp[mAppliances.length] = appliance; // renamed as appliance
		mAppliances = temp; // array is renamed as temp
	}

	public void unplugAppliance(Appliance appliance) {
		for (int i = 0; i < mAppliances.length; i++) {
			if (mAppliances[i] == appliance) {
				mAppliances[i] = null; // resets to null
			}
		}
	}

	public boolean hasAppliance(Appliance appliance) {
		for (int i = 0; i < mAppliances.length; i++) {
			if (mAppliances[i] == appliance) {
				return true; // maintains as appliance
			}
		}
		return false;
	}
}