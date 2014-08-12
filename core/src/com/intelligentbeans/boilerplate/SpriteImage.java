package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;


public class SpriteImage extends Group {
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//PRIVATE/PROTECTED STUFF
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
    protected Sprite sprite;
    protected Texture texture;
    public TextureRegion region;
    public static TextureAtlas atlas;
    public Boolean dead = false;
    protected int frame = 0;
    private Color c;
    
    public SpriteImage(Vector2 position, String name, IntelligentGame game){

    	this(position, name, game,"data/z/z-textures");
    
    }
	public SpriteImage(Vector2 position, String name, IntelligentGame game, String sheet){
		//if(SpriteImage.atlas == null){
			if(game.manager.isLoaded(sheet)) {
				SpriteImage.atlas = game.manager.get(sheet, TextureAtlas.class);
			}else{
				SpriteImage.atlas = new TextureAtlas(Gdx.files.internal(sheet));
			}
		//}
		
		if(name != null){
			//atlas = new TextureAtlas(Gdx.files.internal(sheet));
			region = SpriteImage.atlas.findRegion(name);
			
		    sprite = new Sprite(region);
		   
		    setWidth(region.getRegionWidth());
			setHeight(region.getRegionHeight());
		}
		setX( position.x);
		setY( position.y);
	 
	 		
	}
	
	
	public SpriteImage(Vector2 position, float width, float height, String name, Boolean repeat){
		
		
			texture = new Texture(Gdx.files.internal(name));
			sprite = new Sprite(texture);
			if(repeat){
				texture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
			}
		   
		
		setWidth(width);
		setHeight(height);
		setX( position.x);
		setY( position.y);
	 
	
	}
	public SpriteImage(){
		
		
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
	public void draw(Batch batch, float parentAlpha){
			c = getColor();
	        batch.setColor(c.r, c.g, c.b, c.a * parentAlpha);
	        	if(sprite != null && texture != null){
	        		//batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
	        		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	        	}else if(region != null){
	        		//batch.draw(region, getX() , getY(), getWidth(), getHeight());
	        		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	        	}	
	   
	        
	        
			super.draw(batch, parentAlpha);
			
	}


}
