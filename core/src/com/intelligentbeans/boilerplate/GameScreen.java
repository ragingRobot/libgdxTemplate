package com.intelligentbeans.boilerplate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;


public class GameScreen implements Screen, ContactListener {

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// STATIC PROPERTIES
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final float WORLD_TO_BOX = 0.01f;
	public static final float BOX_TO_WORLD = 100f;

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PRIVATE/PROTECTED STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected World world;
	protected Stage background;
	protected Stage stage;
	protected Stage staticStage;
	protected Stage overlayStage;
	protected Box2DDebugRenderer debugRenderer;
	protected FPSLogger logger;
	protected String level;
	protected SpriteBatch batch;
	protected Array<JSONGameItem> items;
	protected IntelligentGame game;
	protected Camera camera;
	protected SpriteCache spriteCache;
	protected Color bgcolor;
	protected int spriteCacheEnvironmentId;
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// SETUP AND SCREEN RESIZE STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public GameScreen(String level,IntelligentGame game) {

		start(level, game, null, null);

	}

	public GameScreen(String level, IntelligentGame game, Float startX, Float startY) {

		start(level, game, startX, startY);

	}

	protected void start(String level, IntelligentGame game, Float startX, Float startY) {
		bgcolor = Helper.colorFromHex(0x5e413f);
		this.setLevel(level);
		this.game = game;
		batch = new SpriteBatch();
		background = new Stage();
		stage = new Stage();
		staticStage = new Stage();
		overlayStage = new Stage();
		logger = new FPSLogger();
		world = new World(new Vector2(0, -10f), true);
		debugRenderer = new Box2DDebugRenderer();
		
		
		spriteCache = new SpriteCache();
		
		
		Gdx.input.setInputProcessor(staticStage);
		world.setContactListener(this);

		
		camera = stage.getCamera();

		
	}

	/*************************************************************************************
	 * This handles when the window is resized
	 *************************************************************************************/
	@Override
	public void resize(int width, int height) {
	
		

	}

	@Override
	public void show() {
		loadLevel(level);
	}
	
	


	/*************************************************************************************
	 * This takes the name of a JSON file then creates the level based on that
	 * file
	 *************************************************************************************/
	@SuppressWarnings("unchecked")
	protected void loadLevel(String levelToLoad) {

		
		Json json = new Json();

		// this converts the json objects into java objects that we can read
		// easily
	
		items = json.fromJson(Array.class, JSONGameItem.class, Gdx.files.internal(levelToLoad));

		// loop through the contents of the level file and create the objects
		// spcified
		for (JSONGameItem item : items) {

			if (item.getItemType().equals("LevelDetail")) {

				/************************************************************************************************
				 * This sets the details of the level
				 * 
				 */
	
			} 
			
			itemCreationLoop(item);

		}
		
		loadComplete();
		spriteCache.beginCache();
		drawStatic();
	    spriteCacheEnvironmentId = spriteCache.endCache();

	}
	
	public void loadComplete(){
		
	}
	
	public void drawStatic(){
		
	}
	
	protected void itemCreationLoop(JSONGameItem item){
		
	}
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// GAME LOOP STUFF
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void backgroundRender(float delta) {
	
	}
	
	public void lightRender(float delta) {
		
	}
	
	
	/*************************************************************************************
	 * This renders stuff on the screen
	 *************************************************************************************/
	@Override
	public void render(float delta) {
	
		 
		if(stage != null){
				
				camera.update();
				spriteCache.setProjectionMatrix(camera.combined);
			
				
				// this clears the canvas so we can start drawing a clean frame
				Gdx.gl.glClearColor(bgcolor.r, bgcolor.g, bgcolor.b, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
				
				
				background.act(delta);
				background.draw();
			
				backgroundRender(delta);
				
				
				
				spriteCache.begin();
				spriteCache.draw(spriteCacheEnvironmentId);
				spriteCache.end();
				
				
	
			 	lightRender(delta);
				
				
				stage.act(delta);
			  	stage.draw();
			
			 
				
				// this animated then draws the layer with stationary controls on it
				staticStage.act(delta);
				staticStage.draw();

			
				// this renders the physics debugger.
				//debugRenderer.render(world, camera.combined.scale(100,100,100));
		
				
				overlayStage.act(delta);
				overlayStage.draw();
				
				
				// this steps the physics engine
				if(world != null){
					world.step(1 / 60f, 6, 2);
				}
		
				// this logs our FPS to the console. We can remove this in production
				logger.log();
		}
		
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
		
		
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		
		background.clear();
		background.dispose();
		stage.clear();
		stage.dispose();
		staticStage.clear();
		staticStage.dispose();
		debugRenderer.dispose();
		//world.dispose();
		//resetPhysicsWorld();
		


	}
	
	public void resetPhysicsWorld() {
		world.clearForces();
		Array<Body> b = new Array<Body>();
		Array<Joint> j = new Array<Joint>();
		world.getBodies(b);
		world.getJoints(j);
		
		 for (int i = 0; i < b.size;i++) {
             Body body = b.get(i);
             if(body!=null){
            	 body.setActive(false);
            	 //world.destroyBody(body);
             }
		 }
		 for (int k=0;k< j.size;k++) {
             Joint joint = j.get(k);
             if(joint!=null){
            	// world.destroyJoint(joint);
             }
		 }
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
