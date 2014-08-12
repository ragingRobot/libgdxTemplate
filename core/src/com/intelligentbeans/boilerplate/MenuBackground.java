package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MenuBackground extends Actor {
	private Texture texture;
	private float offset = 0;
	private Color c;
	public MenuBackground(){
		//texture = new Texture(Gdx.files.internal("data/background.jpg"));
		//texture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		
		texture = new Texture(Gdx.files.internal("data/menu.png"));
    	texture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
    	
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
    	offset -= .001;
		super.act(delta);		
	}
   
    /*************************************************************************************
	 * This renders stuff on the screen
	 *************************************************************************************/
    @Override
   	public void draw(Batch batch, float parentAlpha) {
    	c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a * parentAlpha);
        
   		batch.draw(texture, getX(), getY(), getWidth() * GameScreen.BOX_TO_WORLD, getHeight() * GameScreen.BOX_TO_WORLD,-offset, offset, texture.getWidth()/4 ,texture.getHeight()/4);
   		super.draw(batch, parentAlpha);
   		
   }
    
}
