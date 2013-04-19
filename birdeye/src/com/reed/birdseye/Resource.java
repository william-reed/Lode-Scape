package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

public class Resource {

	public int x, y;
	int width = 64;
	int height = 58;
	float resourceTimer = 0;
	int distanceFromMaterial = 100;
	static int amountOfStone = 0;
	static String amountOfStoneString;
	static boolean mining = false;
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
			batch.draw(Assets.material, Level.levelX + x, Level.levelY + y,
					width, height);
			if (closeEnough() && Player.move) {
				font.draw(batch, "Hold B to Pick up the Stone", 50, 50);
			}
		}
	}


	void collect() {
		amountOfStoneString = Integer.toString(amountOfStone);// update string
		// starts making the image of the "resource" smaller as b is
		// held down
		if (closeEnough() && drawResource) {
			if (Gdx.input.isKeyPressed(Keys.B)) {
				mining = true;
				resourceTimer += Gdx.graphics.getDeltaTime() * miningRate;
				if (resourceTimer > 1 && resourceTimer < 2) {
					width = (int) (64 * .8);
					height = (int) (58 * .8);
				}
				if (resourceTimer > 2 && resourceTimer < 3) {
					width = (int) (64 * .6);
					height = (int) (58 * .6);
				}
				if (resourceTimer > 3 && resourceTimer < 4) {
					width = (int) (64 * .4);
					height = (int) (58 * .4);
				}
				if (resourceTimer > 4 && resourceTimer < 5) {
					width = (int) (64 * .2);
					height = (int) (58 * .2);
				}
				if (resourceTimer > 5) {
					amountOfStone += 1;
					resourceTimer = 0;
					mining = false;
					drawResource = false;
				}

			} else {
				resourceTimer = 0;
				width = 64;
				height = 58;
				mining = false;
			}
		}
	}
}
