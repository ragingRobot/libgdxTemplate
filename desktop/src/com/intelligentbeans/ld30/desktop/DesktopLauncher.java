package com.intelligentbeans.ld30.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.intelligentbeans.ld30.LD30;

public class DesktopLauncher implements com.intelligentbeans.ld30.iAdController {
	private static DesktopLauncher application;
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		if (application == null) {
            application = new DesktopLauncher();
        }
		
		
		new LwjglApplication(new LD30(application), config);
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
