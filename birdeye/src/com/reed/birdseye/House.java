package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
	float ambientLight = 1;

	/** SEPPERATE INTO INDIVIDUAL METHODS */
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
				Time.setAmbientLight(ambientLight);

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
				// you exit *looks around franticly* -- set up currentAmbient
				// light and outdoor ambient light variables.
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
		nearBed();
		sleep();
		exitBed();

	}

	// bed cordinates
	int x = 730, y = 386;
	final int distanceFromBed = 50;

	/**
	 * Returns boolean if you are close enough from the designated variable
	 * 
	 * @variable distanceFromBed
	 */
	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < distanceFromBed);
	}

	boolean justGotNearBed = false;
	boolean justGotInBed = false;
	boolean inBed = false;

	void nearBed() {
		if (closeEnough() && !inBed) {
			// justGotNearBed = true;
			if (justGotNearBed) {
				Messages.messagesArray.add(new Message(
						"Press 'B' to go to sleep", Messages.getSec()));
				justGotNearBed = false;
			}
			if (Gdx.input.isKeyPressed(Keys.B)) {
				inBed = true;
				justGotInBed = true;
			}
		} else
			justGotNearBed = false;
	}

	final float fadingRate = .05f;// adjust to fine tune changing rate
	boolean justExitedBed = false;

	void sleep() {
		if (inBed) {
			if (justGotInBed) {
				Player.ableToMove = false;
				// set player to bed position facing down
				Player.x = 730;
				Player.y = 386;
				System.out.println("in bed should be no movement");
				justGotInBed = false;
			}
			System.out.println("darkness levels should change");
			Time.setAmbientLight(ambientLight);
			if (ambientLight >= 0) {
				ambientLight -= fadingRate;
			}
			if (ambientLight <= 0) {
				Time.setTimeOfDay(0f);
			}
			if (ambientLight <= 1) {
				ambientLight += fadingRate;
			}
			if (ambientLight >= 1) {
				justExitedBed = true;
				// inBed = false;
			}
		}
	}

	void exitBed() {
		if (justExitedBed) {
			Player.ableToMove = true;
			// set player position
			// set move booleans back to true;
		}
	}
}
