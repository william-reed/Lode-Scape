package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Iron {

	public int x = 300, y = 100;;
	int width = 64;
	int height = 58;
	float ironTimer = 0;
	int distanceFromMaterial = 100;
	static int amountOfIron = 0;
	static String amountOfIronString;
	boolean drawResource = true;
	float miningRate = 1f;
	
	boolean closeEnough() {
		return (Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.middleY)) < distanceFromMaterial);
	}

	void draw(SpriteBatch batch, BitmapFont font) {
		if (drawResource) {
			batch.draw(Assets.ironOre, Level.levelX + x, Level.levelY + y,
					width, height);

			if (closeEnough() && Player.move) {
				font.draw(batch, "Hold B to Pick up the Iron", 50, 50);
			}
		}
	}

	void collect() {
		amountOfIronString = Integer.toString(amountOfIron);//update string
		// starts making the image of the "resource" smaller as b is
		// held down
		if (closeEnough()) {
			if (Gdx.input.isKeyPressed(Keys.B)) {
				ironTimer += Gdx.graphics.getDeltaTime() * miningRate;
				if (ironTimer > 1 && ironTimer < 2) {
					width = (int) (64 * .8);
					height = (int) (58 * .8);
				}
				if (ironTimer > 2 && ironTimer < 3) {
					width = (int) (64 * .6);
					height = (int) (58 * .6);
				}
				if (ironTimer > 3 && ironTimer < 4) {
					width = (int) (64 * .4);
					height = (int) (58 * .4);
				}
				if (ironTimer > 4 && ironTimer < 5) {
					width = (int) (64 * .2);
					height = (int) (58 * .2);
				}
				if (ironTimer > 5) {
					amountOfIron += 1;
					ironTimer = 0;
					drawResource = false;
				}

			} else {
				ironTimer = 0;
				width = 64;
				height = 58;
			}
		}
	}
}
