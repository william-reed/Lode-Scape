package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Robot {

	Mob bot = new Mob();
	
	// robot stuff
	int robotResources = 0;
	String amountOfStoneString;
	float robotTimer = 0;
	boolean menuOpen = false;
	
	void gui() {
		robotTimer += Gdx.graphics.getDeltaTime();
		if (robotTimer > 60) {
			robotResources += 1;
			robotTimer = 0;
		}
		amountOfStoneString = Integer.toString(robotResources);
		if (bot.closeEnough() && Gdx.input.isKeyPressed(Keys.L)) {
			menuOpen = true;
		}
		if (menuOpen) {
			Player.ableToMove = false;
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				Player.ableToMove = true;
				menuOpen = false;
			}
			// detect if claim is clicked
			if (Gdx.input.getX() > 406 && Gdx.input.getX() < 559
					&& Gdx.input.getY() > 406 && Gdx.input.getY() < 478) {
				if (Gdx.input.isTouched()) {
					Resource.amountOfStone += robotResources;
					robotResources = 0;
				}
			}
		}
	}

	void guiDraw(SpriteBatch batch, BitmapFont font) {
		if (menuOpen) {
			batch.draw(Assets.robotGUI, 0, 0);
			font.draw(batch, amountOfStoneString, 250, 400);
		}
	}
	
	void draw(SpriteBatch batch, BitmapFont font){
		bot.draw(batch, font, Assets.mainRobot);
		if (bot.closeEnough())
			font.draw(batch, "Press 'L' to open GUI", 50, 100);
	}
	
	void update(){
		bot.movement();
		bot.boundingArea(0, 0, 1000, 1000);
		Assets.mainRobot = bot.setSprites(Assets.upRobot_STILL, Assets.upRobot_LEFT,
				Assets.upRobot_RIGHT, Assets.downRobot_STILL,
				Assets.downRobot_LEFT, Assets.downRobot_RIGHT,
				Assets.leftRobot_STILL, Assets.leftRobot_LEFT,
				Assets.leftRobot_RIGHT, Assets.rightRobot_STILL,
				Assets.rightRobot_LEFT, Assets.rightRobot_RIGHT);
		
	}
}
