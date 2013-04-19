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
		batch.draw(Assets.lake, Level.levelX + x, Level.levelY + y);
		if (closeEnough)
			font.draw(batch, "Hold B to get some water", 50, 50);
	}

	public void closeEnough() {
		if ((Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.middleY)) < distanceFromMaterial)) {
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
