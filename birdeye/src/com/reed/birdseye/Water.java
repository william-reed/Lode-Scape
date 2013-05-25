package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Water {
	float waterTimer;
	boolean closeEnough;
	int x, y;
	static int amountOfWater = 0;
	static String amountOfWaterString = Integer.toString(amountOfWater);
	int distanceFromMaterial = 100;
	
	public void draw(SpriteBatch batch, BitmapFont font) {
		batch.draw(Assets.lake, x, y);
		if (closeEnough)
			font.draw(batch, "Hold B to get some water", 50, 50);
	}

	public void closeEnough() {
		if ((Math.sqrt((x - Level.middleX)
				* (x - Level.middleX)
				+ (y - Level.middleY)
				* (y - Level.middleY)) < distanceFromMaterial)) {
			closeEnough = true;
		}
	}

	public void waterTimer() {
		if (Gdx.input.isKeyPressed(Keys.B)) {
			waterTimer += Gdx.graphics.getDeltaTime();
			if (waterTimer > 1 && amountOfWater < 16) {
				amountOfWater++;
				waterTimer = 0;
			}
		}
	}
}
