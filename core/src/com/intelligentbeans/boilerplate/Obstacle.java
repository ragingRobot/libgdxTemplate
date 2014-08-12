package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Obstacle extends PhysicalImage {

	public Obstacle(Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game) {
		super(position, name, world, staticbody,sensor,friction,game);
		
	}
	public Obstacle(Vector2 position, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game, float width, float height) {
		super(position, name, world, staticbody,sensor,friction,game, width, height);
		
	}
	
	public Obstacle(Vector2 position,float width,float height, String name, World world, boolean staticbody, boolean sensor, float friction, IntelligentGame game) {
		super(position, width,height,name, world, staticbody,sensor,friction,game);
		
	}
	
	
	  public void die(){
	    	
	    }
	    

}
