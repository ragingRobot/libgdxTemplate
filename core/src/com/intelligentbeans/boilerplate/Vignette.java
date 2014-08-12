package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Vignette extends Actor {
	private Texture texture;
	public Vignette(){
		setup("data/vignette.png");
    	
	}
	
	public Vignette(String image){
		setup(image);
    	
	}
	
	private void setup(String image){
		texture = new Texture(Gdx.files.internal(image));
	
		
		setWidth(Gdx.graphics.getWidth());
    	setHeight(Gdx.graphics.getHeight());
    	setX(0);
    	setY(0);
	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//GAME LOOP STUFF	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*************************************************************************************
	* This handles physics stuff
	*************************************************************************************/
    @Override
	public void act(float delta) {
		super.act(delta);		
		
	}
   
   
    /*************************************************************************************
	 * This renders stuff on the screen
	 *************************************************************************************/
    @Override
   	public void draw(Batch batch, float parentAlpha) {
    	final Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a * parentAlpha);
        
   		batch.draw(texture, getX(), getY(), getWidth() , getHeight());
   		super.draw(batch, parentAlpha);
   		
   }
    
}
