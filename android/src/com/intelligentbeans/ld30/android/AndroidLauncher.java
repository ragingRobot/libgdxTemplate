package com.intelligentbeans.ld30.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.intelligentbeans.ld30.iAdController;
import com.intelligentbeans.ld30.LD30;

public class AndroidLauncher extends AndroidApplication implements iAdController {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new LD30(this), config);
	}

	@Override
	public void showAd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideAd() {
		// TODO Auto-generated method stub
		
	}
}
