package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
	static boolean inventoryVisible = false;

	void draw(SpriteBatch batch, BitmapFont font) {
		if (inventoryVisible) {
			batch.draw(Assets.inventory, 0, 0);
			//move somewhere else
			Player.ableToMove = false;
			
			//draw amounts
			//font.draw(batch, Resource.amountOfStoneString, 275, 405);
			//font.draw(batch, Iron.amountOfIronString, 275, 377);
			//font.draw(batch, Copper.amountOfCopperString, 275, 322);
			font.draw(batch, Tree.amountOfWoodString, 350, 290);
			font.draw(batch, Fishing.amountOfFishString, 350, 225);
		}
	}

	void input() {
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Player.ableToMove = true;
			inventoryVisible = false;
		}
	}
}
