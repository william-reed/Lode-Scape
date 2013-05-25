package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Copper {

	public int x = 100, y = 300;;
	int width = 64;
	int height = 58;
	float copperTimer = 0;
	int distanceFromMaterial = 100;
	static int amountOfCopper = 0;
	static String amountOfCopperString;
	boolean drawResource = true;
	float miningRate = 1f;

	boolean closeEnough() {
		return (Math.sqrt((Level.middleX) * (x - Level.middleX)
				+ (y - Level.middleY) * (y - Level.middleY)) < distanceFromMaterial);
	}

	void draw(SpriteBatch batch, BitmapFont font) {
		if (drawResource) {
			batch.draw(Assets.copperOre, x, y, width, height);

			if (closeEnough() && Player.move) {
				font.draw(batch, "Hold B to Pick up the Copper", 50, 50);
			}
		}
	}

	void collect() {
		amountOfCopperString = Integer.toString(amountOfCopper);// update string
		// starts making the image of the "resource" smaller as b is
		// held down
		if (closeEnough()) {
			if (Gdx.input.isKeyPressed(Keys.B)) {
				copperTimer += Gdx.graphics.getDeltaTime() * miningRate;
				if (copperTimer > 1 && copperTimer < 2) {
					width = (int) (64 * .8);
					height = (int) (58 * .8);
				}
				if (copperTimer > 2 && copperTimer < 3) {
					width = (int) (64 * .6);
					height = (int) (58 * .6);
				}
				if (copperTimer > 3 && copperTimer < 4) {
					width = (int) (64 * .4);
					height = (int) (58 * .4);
				}
				if (copperTimer > 4 && copperTimer < 5) {
					width = (int) (64 * .2);
					height = (int) (58 * .2);
				}
				if (copperTimer > 5) {
					amountOfCopper += 1;
					copperTimer = 0;
					drawResource = false;
				}

			} else {
				copperTimer = 0;
				width = 64;
				height = 58;
			}
		}
	}
}
