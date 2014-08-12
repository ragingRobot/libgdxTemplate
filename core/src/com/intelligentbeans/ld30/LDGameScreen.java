package com.intelligentbeans.ld30;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.intelligentbeans.boilerplate.GameScreen;
import com.intelligentbeans.boilerplate.IntelligentGame;
import com.intelligentbeans.boilerplate.JSONGameItem;

public class LDGameScreen extends GameScreen implements ContactListener {

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// STATIC PROPERTIES
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PRIVATE/PROTECTED STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// SETUP AND SCREEN RESIZE STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public LDGameScreen(String level, IntelligentGame game) {
	
			super(level, game);
			
	}

	
	@Override
	protected void start(String level, IntelligentGame game, Float startX, Float startY) {

		super.start(level, game, startX, startY);
		
		
	
	}


	/*************************************************************************************
	 * This takes the name of a JSON file then creates the level based on that
	 * file
	 *************************************************************************************/
	protected void itemCreationLoop(JSONGameItem item){

		

			if (item.getItemType().equals("LevelDetail")) {

				/************************************************************************************************
				 * This sets the details of the level
				 * 
				 */
			

			} 
		
	}
	
	
	
	
	
	public void loadComplete(){
		
	
		addInterface();
		
		
	}

	/*************************************************************************************
	 * This adds the user interface needed based on the type of device
	 *************************************************************************************/
	protected void addInterface() {

		
	}
	

	
	
	
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// GAME LOOP STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*************************************************************************************
	 * This renders stuff on the screen
	 *************************************************************************************/

	@Override
	public void render(float delta) {
		super.render(delta);
		camera = stage.getCamera();

	}


	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// INTERFACE IMPLEMENTATION GRAVEYARD
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
		
	}

	
}
