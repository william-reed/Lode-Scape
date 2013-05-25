package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TopMenu {
	static int currentTool = 5; // 0 is first cell, etc, 5 means null conluding
								// that it is not drawn

	void draw(SpriteBatch batch, BitmapFont font) {

		batch.draw(Assets.itemSelector, Gdx.graphics.getWidth() / 2 - 250,
				Gdx.graphics.getHeight() - 75);

		// decides where the currentTool white box is drawn - please excuse these *random* numbers
		switch (currentTool) {
		case 0:
			batch.draw(Assets.currentItem, 230, 465);
			break;
		case 1:
			batch.draw(Assets.currentItem, 230 + Assets.currentItem.getWidth()
					* 1 - 7 * 1, 465);
			break;
		case 2:
			batch.draw(Assets.currentItem, 230 + Assets.currentItem.getWidth()
					* 2 - 7 * 2, 465);
			break;
		case 3:
			batch.draw(Assets.currentItem, 230 + Assets.currentItem.getWidth()
					* 3 - 7 * 3, 465);
			break;
		case 4:
			batch.draw(Assets.currentItem, 230 + Assets.currentItem.getWidth()
					* 4 - 7 * 4, 465);
			break;
		}
	}

	void input() {
		if (Gdx.input.getX() > 649 && Gdx.input.getX() < 723
				&& Gdx.input.getY() > 6 && Gdx.input.getY() < 68
				&& Gdx.input.isTouched()) {
			Inventory.inventoryVisible = true;
		}
		
		// sets currentTool based off of input
		if (Gdx.input.getY() < 74 && Gdx.input.getY() > 0
				&& Gdx.input.getX() > 230 && Gdx.input.getX() < 310
				&& Gdx.input.isTouched()) {
			currentTool = 0;
		}
		if (Gdx.input.getY() < 74 && Gdx.input.getY() > 0
				&& Gdx.input.getX() > 310 && Gdx.input.getX() < 390
				&& Gdx.input.isTouched()) {
			currentTool = 1;
		}
		if (Gdx.input.getY() < 74 && Gdx.input.getY() > 0
				&& Gdx.input.getX() > 390 && Gdx.input.getX() < 470
				&& Gdx.input.isTouched()) {
			currentTool = 2;
		}
		if (Gdx.input.getY() < 74 && Gdx.input.getY() > 0
				&& Gdx.input.getX() > 470 && Gdx.input.getX() < 550
				&& Gdx.input.isTouched()) {
			currentTool = 3;
		}
		if (Gdx.input.getY() < 74 && Gdx.input.getY() > 0
				&& Gdx.input.getX() > 550 && Gdx.input.getX() < 630
				&& Gdx.input.isTouched()) {
			currentTool = 4;
		}
	}
}
