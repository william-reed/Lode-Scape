package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
	static boolean inventoryVisible = false;
	final int row1y = 420;
	final int row2y = 800;
	
	void draw(SpriteBatch batch, BitmapFont font) {
		if (inventoryVisible) {
			batch.draw(Assets.inventory, 0, 0);
			//move somewhere else
			Player.ableToMove = false;
			Player.drawCharacter = false;
			
			//draw amounts
			font.draw(batch, Tree.amountOfWoodString, row1y, 388);
			font.draw(batch, Coal.amountOfCoalString, row1y, 356);
			font.draw(batch, Fishing.amountOfFishString, row1y, 330);
			font.draw(batch, Food.amountOfFoodString, row1y, 302);
			
			//row 2
			font.draw(batch, TradeShop.cashString, row2y, 135);
			font.draw(batch, String.valueOf(Food.foodLevel) + "%", row2y, 105);
			font.draw(batch, String.valueOf(Points.currentLevel), row2y, 76);
			
		}
	}

	void input() {
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Player.ableToMove = true;
			Player.drawCharacter = true;
			inventoryVisible = false;
		}
	}
}
