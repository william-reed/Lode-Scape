package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
	static float ambientLight = 1;

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
				GameScreen.mapCamera.position.x = Gdx.graphics.getWidth() / 2 + 10;
				GameScreen.mapCamera.position.y = Gdx.graphics.getHeight() / 2 - 140;
				// draw player in correct spot
				Player.x = Level.middleX + 10;
				Player.y = Level.middleY - 140;
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
		remCycles();
		// Time.setTimeOfDay(300);
	}

	// bed cordinates
	int x = 730, y = 386;
	final int distanceFromBed = 50;
	/**
	 * Current step in sleep <br>
	 * <u><b>What each step means:</b></u> <br>
	 * <b>1</b> means just got in bed <br>
	 * <b>2</b> means lights are diming <br>
	 * <b>3</b> means lights are brightening <br>
	 * <b>4</b> means just got out of bed <br>
	 * <b>0</b> means doing nothing (deafult)
	 */
	static int sleepStep = 0;

	/**
	 * Returns boolean if you are close enough from the designated variable
	 * 
	 * @variable distanceFromBed
	 */
	boolean closeEnoughToBed() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < distanceFromBed);
	}

	boolean justGotNearBed = false;
	boolean canSendNightMessage = true, canSendDayMessage = true;

	void nearBed() {
		if (closeEnoughToBed() && !(justGotNearBed)) {
			Messages.messagesArray.add(new Message("Press B to sleep", Messages
					.getSec()));
			justGotNearBed = true;
		}

		if (!closeEnoughToBed()) {
			justGotNearBed = false;
			canSendNightMessage = true;
		}
		if (justGotNearBed && Gdx.input.isKeyPressed(Keys.B)) {
			if (preAmbientLight <= .2f && canSendDayMessage) {
				canSendDayMessage = false;
				sleepStep = 1;
				canSendNightMessage = false;
			} else if (canSendNightMessage) {
				Messages.messagesArray.add(new Message(
						"You can only sleep at night!", Messages.getSec()));
				canSendNightMessage = false;
			}
		}
	}

	float lightCycleSpeed = .005f;
	static Vector2 preSleepPlayerPos = new Vector2();

	// sleep cycles
	void remCycles() {
		if (sleepStep == 1) {
			preSleepPlayerPos.x = Player.x;
			preSleepPlayerPos.y = Player.y;
			Player.x = 735;
			Player.y = 380;
			Player.ableToMove = false;
			Assets.mainChar = Assets.downChar_STILL;
			// set sprite to look down (should be a static sprite)
			sleepStep = 2;
		}
		if (ambientLight >= 0 && sleepStep == 2) {
			Time.setAmbientLight(ambientLight);
			ambientLight -= lightCycleSpeed;
			if (ambientLight <= 0)
				sleepStep = 3;
		}
		if (ambientLight <= 1 && sleepStep == 3) {
			Time.setAmbientLight(ambientLight);
			ambientLight += lightCycleSpeed;
			if (ambientLight >= 1) {
				sleepStep = 4;
			}
		}
		if (sleepStep == 4) {
			Player.ableToMove = true;
			canSendDayMessage = true;
			Player.x = preSleepPlayerPos.x;
			Player.y = preSleepPlayerPos.y;
			Time.colorAlpha = 0;
			preAmbientLight = 1;
			Time.setTimeOfDay(0);
			sleepStep = 0;
		}
	}

	static void exitGame() {
		if (sleepStep > 0) {
			Player.x = preSleepPlayerPos.x;
			Player.y = preSleepPlayerPos.y;
			Time.setAmbientLight(1);
		}
	}

	final int furnaceX = 512, furnaceY = 418;
	final int distanceFromFurnace = 50;

	// started but never finished need to add ores for fuel first
	// furnace / stove stuff
	boolean nearFurnace() {
		return (Math.sqrt((furnaceX - Player.x) * (furnaceX - Player.x)
				+ (furnaceY - Player.y) * (furnaceY - Player.y)) < distanceFromFurnace);
	}

	boolean canSendFurnaceMessage = true;
	boolean furnaceOpen = false;

	void furnace() {
		if (nearFurnace() && canSendFurnaceMessage) {
			Messages.messagesArray.add(new Message("Press B to open Furnace",
					Messages.getSec()));
			canSendFurnaceMessage = false;
		}
		if (!nearFurnace()) {
			canSendFurnaceMessage = true;
		}
		if (nearFurnace() && Gdx.input.isKeyPressed(Keys.B)) {
			System.out.println("furnace");
			furnaceOpen = true;
		}
	}

	Particles fire = new Particles();

	void furnaceGUIdraw(SpriteBatch batch, float deltaTime, BitmapFont font,
			ShapeRenderer shapeRenderer) {
		if (furnaceOpen) {
			Player.ableToMove = false;
			Player.drawCharacter = false;
			batch.draw(Assets.furnaceGUI, 0, 0);
			fire.fireUpdateAndDraw(batch, deltaTime);
			//draw fonts
			font.draw(batch, String.valueOf(coalInFurnace), 420, 234);
			font.draw(batch, String.valueOf(rawFoodInFurnace), 420, 376);
			font.draw(batch, String.valueOf(cookedFoodInFurnace), 760, 376);
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				Player.ableToMove = true;
				Player.drawCharacter = true;
				furnaceOpen = false;
			}
		}
	}

	int coalInFurnace = 0;
	int rawFoodInFurnace = 0;
	int cookedFoodInFurnace = 0;

	void addCoalandFood() {
		if (Gdx.input.getX() > 73 && Gdx.input.getX() < 374
				&& Gdx.input.getY() > 380 && Gdx.input.getY() < 430  && Gdx.input.justTouched() && Food.amountOfFood > 0) {
			rawFoodInFurnace += 1;
			Food.amountOfFood -= 1;
		}
		
		if (Gdx.input.getX() > 73 && Gdx.input.getX() < 374
				&& Gdx.input.getY() > 430 && Gdx.input.getY() < 475 && Gdx.input.justTouched() && Coal.amountOfCoal > 0) {
			coalInFurnace += 1;
			Coal.amountOfCoal -= 1;
		}
	}
	
	void cookFood(){
		//change coal amounts and stuff and cook food
	}
}
