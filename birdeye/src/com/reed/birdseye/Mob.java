package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mob {
	// randomly moving "mob" (animal, monster, etc)
	final int distanceFromMob = 100;
	Random r = new Random();
	int x = 500;
	int y = 500; // set to random
	int direction = r.nextInt(5) + 1; // 0 = up, 1 = down, 2 = left, 3 = right,
										// 4 = no movement
	float mobTime = r.nextInt(3) + 1;
	// defines time left for movement - set to random int below 3
	final int speed = 1;

	// some mob test texture here

	boolean menuOpen = false;

	void draw(SpriteBatch batch, BitmapFont font) {
		batch.draw(Assets.robot, Level.levelX + x, Level.levelY + y);
		if (closeEnough())
			font.draw(batch, "Press 'L' to open GUI", 50, 100);
	}

	void movement() {
		// constantly decrease the mobTime
		mobTime -= Gdx.graphics.getDeltaTime();
		if (direction == 0 && mobTime > 0) {
			y += speed;
		} else if (direction == 1 && mobTime > 0) {
			y -= speed;
		} else if (direction == 2 && mobTime > 0) {
			x -= speed;
		} else if (direction == 3 && mobTime > 0) {
			x += speed;
		} else if (direction == 4 && mobTime > 0) {
			// 4 means no movement
		} else {
			mobTime = r.nextInt(3) + 1;
			direction = r.nextInt(5) + 1;
		}
	}

	void boundingArea(int xCord, int yCord, int width, int height) {
		if (x > xCord + width)
			direction = 2;
		if (x < xCord)
			direction = 3;
		if (y > yCord + height)
			direction = 1;
		if (y < yCord)
			direction = 0;
	}

	boolean closeEnough() {
		return (Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.middleY)) < distanceFromMob);
	}

	// robot stuff
	int robotResources = 0;
	String amountOfStoneString;
	float robotTimer = 0;

	void gui() {
		robotTimer += Gdx.graphics.getDeltaTime();
		if(robotTimer > 60){
			robotResources += 1;
			robotTimer = 0;
		}
		amountOfStoneString = Integer.toString(robotResources);
		if (closeEnough() && Gdx.input.isKeyPressed(Keys.L)) {
			menuOpen = true;
		}
		if (menuOpen) {
			Player.move = false;
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				Player.move = true;
				menuOpen = false;
			}
			//detect if claim is clicked
			if (Gdx.input.getX() > 406 && Gdx.input.getX() < 559
					&& Gdx.input.getY() > 406 && Gdx.input.getY() < 478) {
				if (Gdx.input.isTouched()) {
					Resource.amountOfStone += robotResources;
					robotResources = 0;
				}
			}
		}
	}

	void robotDraw(SpriteBatch batch, BitmapFont font) {
		if (menuOpen){
			batch.draw(Assets.robotGUI, 0, 0);
			font.draw(batch, amountOfStoneString, 250, 400);
		}
	}
}