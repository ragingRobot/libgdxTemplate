package com.intelligentbeans.ld30;

import com.intelligentbeans.boilerplate.IntelligentGame;

public class LD30 extends  IntelligentGame {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//MAIN ENTRY POINT FOR OUR GAME
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public iAdController adController;
	public LD30(iAdController adController){
		this.adController = adController;
	}
	@Override
	public void create() {	
		
		//manager = new AssetManager();
		//manager.load("data/z/z-textures", TextureAtlas.class);
		//manager.finishLoading();
		//this loads the first game screen
		setScreen(new LDGameScreen("data/levels/level.json",this));
		
		
	}

}
