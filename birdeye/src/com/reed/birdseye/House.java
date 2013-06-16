package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.lights.Lights;
import com.badlogic.gdx.math.Vector2;

public class House {

	private static boolean isInRiverHouse = false;
	// booleans for a run once code strip
	private static boolean justEntered = false, justExited = false;

	public static boolean isJustEntered() {
		return justEntered;
	}

	public static void setJustEntered(boolean justEntered) {
		House.justEntered = justEntered;
	}

	public static boolean isJustExited() {
		return justExited;
	}

	public static void setJustExited(boolean justExited) {
		House.justExited = justExited;
	}
	
	public static boolean isInRiverHouse() {
		return isInRiverHouse;
	}

	public static void setInRiverHouse(boolean isInRiverHouse) {
		House.isInRiverHouse = isInRiverHouse;
	}
	
	static Vector2 preCameraPos = new Vector2();
	static Vector2 prePlayerPos = new Vector2();
	static float preAmbientLight;
	/** SEPPERATE INTO INDIVIDUAL METHODS*/
	void update() {
		// variable becomes true through the collision class
		if (isInRiverHouse) {
			if (justEntered) {
				prePlayerPos.x = Player.x;
				prePlayerPos.y = Player.y;
				preCameraPos.x = GameScreen.mapCamera.position.x;
				preCameraPos.y = GameScreen.mapCamera.position.y;
				preAmbientLight = Time.getAmbientLight();
				Time.setOutdoors(false);
				Time.setAmbientLight(1f);
				
				CollisionDetection.setCollisionType(1);
				Level.setCurrentMap(1);
				// set cordinates
				GameScreen.mapCamera.position.x = Gdx.graphics.getWidth() / 2;
				GameScreen.mapCamera.position.y = 300;
				// draw player in correct spot
				Player.x = Gdx.graphics.getWidth() / 2;
				Player.y = Gdx.graphics.getHeight() / 2 - 50;
				// get rid of grass (set to what? blackness)

				// get rid of darkness. (how to set back to normal levels when
				//  you exit *looks around franticly* -- set up currentAmbient
				//  light and outdoor ambient light variables.
				// finally set to false
				justEntered = false;

			}
			// check for collision (will be done in gamescreen class thanks to a
			// switch statment)
			// check for bed (prob add its own method) must be close enough (add
			// close enough method)
			// stove / oven method stuff
			// allow for exit of house ability set justExited to true
		} else {
			if (justExited) {
				Level.setCurrentMap(0);
				Player.x = prePlayerPos.x;
				Player.y = prePlayerPos.y;
				GameScreen.mapCamera.position.x = preCameraPos.x;
				GameScreen.mapCamera.position.y = preCameraPos.y;
				CollisionDetection.setCollisionType(0);
				Time.setAmbientLight(preAmbientLight);
				Time.setOutdoors(true);
				justExited = false;
			}
		}
	}
}
