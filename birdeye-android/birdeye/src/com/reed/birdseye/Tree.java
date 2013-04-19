package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tree {

	public int x, y, width = 64, height = 58;
	public boolean drawResource = true;
	static int amountOfWood = 0;
	static String amountOfWoodString = Integer.toString(amountOfWood);
	int distanceFromMaterial = 100;

	void draw(SpriteBatch batch, BitmapFont font) {
		if (drawResource)
			batch.draw(Assets.tree, Level.levelX + x, Level.levelY + y);
		if (closeEnough())
			font.draw(batch, "Press B to Pick up the Tree", 50, 50);
	}

	boolean closeEnough() {
		return (Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.levelY)) < distanceFromMaterial);
	}

	void collectingTree() {
		if (closeEnough()) {
			if (Gdx.input.isKeyPressed(Keys.B)) {
				amountOfWood += 4;
				drawResource = false;
			}
		}
	}
}
