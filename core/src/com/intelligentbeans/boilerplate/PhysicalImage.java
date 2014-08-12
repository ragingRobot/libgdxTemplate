package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.intelligentbeans.boilerplate.BodyFactory;

public class PhysicalImage extends SpriteImage {
	public Body body;
	public IntelligentGame game;
	
	public PhysicalImage (Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, float density, IntelligentGame game, float width, float height,boolean isCircle){
		super(position, name, game);
		BodyType type = BodyType.DynamicBody;
		if(staticbody){
			type = BodyType.StaticBody;
		}
		
		if(!isCircle){
			if(width < 0){
				body = BodyFactory.CreateSquareBody(world,type ,position.x + (region.getRegionWidth()/2), position.y + (region.getRegionHeight()/2), region.getRegionWidth(), region.getRegionHeight(), sensor, density, 0f, friction );
			
			}else{
				body = BodyFactory.CreateSquareBody(world,type ,position.x + (region.getRegionWidth()/2), position.y + (region.getRegionHeight()/2), width, height, sensor, density, 0f, friction );
					
			}
		}else{
			body = BodyFactory.CreateCircleBody(world, type, position.x + (region.getRegionWidth()/2), position.y + (region.getRegionHeight()/2), region.getRegionWidth()/2, sensor);
		}
		body.setUserData(this);
    	body.setSleepingAllowed(staticbody);
    	
    	this.game = game;
    
	}
	
	public PhysicalImage(Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game){
		this(position, name,world, staticbody,sensor, friction, .005f, game, -1, -1,false);

	}
	
	public PhysicalImage(Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game, boolean isCircle){
		this(position, name,world, staticbody,sensor, friction, .005f, game, -1, -1,isCircle);

	}
	
	public PhysicalImage(Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game, float width, float height){
		this(position, name,world, staticbody,sensor, friction, .005f, game, width, height,false);

	}
	
	
	public PhysicalImage (Vector2 position, float width, float height, String name, World world, boolean staticbody, boolean sensor, float friction,  IntelligentGame game){
		//this one uses a sprite instead of a region
		super(position, width, height, name, true);
		BodyType type = BodyType.DynamicBody;
		if(staticbody){
			type = BodyType.StaticBody;
		}
		body = BodyFactory.CreateSquareBody(world,type ,position.x + (width/2), position.y + (height/2), width, height, sensor, .005f, 0f, friction );
    	body.setUserData(this);
    	body.setSleepingAllowed(staticbody);
    	
    	this.game = game;
    
	}
	
	
	
	public void updateX(float newX){
		body.setTransform(newX * GameScreen.WORLD_TO_BOX, getY() * GameScreen.WORLD_TO_BOX, body.getAngle());
		
	}
	
	public void updateY(float newY){
		body.setTransform(getX() * GameScreen.WORLD_TO_BOX, newY * GameScreen.WORLD_TO_BOX, body.getAngle());
		
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
		
		setX(Math.round((body.getPosition().x * GameScreen.BOX_TO_WORLD) - (getWidth())/2));
		setY(Math.round((body.getPosition().y* GameScreen.BOX_TO_WORLD) - (getHeight())/2));
		setOrigin(getWidth()/2, getHeight()/2f);
		setRotation(body.getAngle() * MathUtils.radiansToDegrees);
	
	}
   
	/*************************************************************************************
	 * This renders stuff on the screen
	 *************************************************************************************/
    @Override
   	public void draw(Batch batch, float parentAlpha) {
   		super.draw(batch, parentAlpha);
   }
}
