package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Farm {
	int growing = 0;
	float time = 0;
	int growthRate = 5;
	boolean hydrated = false;
	float sizeAlpha, sizeBeta;
	int x, y;
	boolean closeEnough;
	ArrayListsz mainGame = new ArrayListsz();
	static int cornCount = 0;
	static String cornCountString = Integer.toString(cornCount);
	final int distanceFromMaterial = 100;
	
	public void draw(SpriteBatch batch, BitmapFont font) {
		// if (hydrated)
		// batch.draw(Assets.hydration, mainGame.levelX + x - 52,
		// mainGame.levelY + y - 8);
		// standard crop field
		batch.draw(Assets.farm, Level.levelX + x, Level.levelY + y);

		sizeAlpha = ((float) growing / 100);
		sizeBeta = sizeAlpha * 14;
		// actual crops
		for (int i = 510; i <= 570; i += 20)
			batch.draw(Assets.crop, Level.levelX + i, Level.levelY + 410,
					sizeBeta, sizeBeta);
		for (int i = 510; i <= 570; i += 20)
			batch.draw(Assets.crop, Level.levelX + i, Level.levelY + 428,
					sizeBeta, sizeBeta);
		for (int i = 510; i <= 570; i += 20)
			batch.draw(Assets.crop, Level.levelX + i, Level.levelY + 446,
					sizeBeta, sizeBeta);
		for (int i = 510; i <= 570; i += 20)
			batch.draw(Assets.crop, Level.levelX + i, Level.levelY + 464,
					sizeBeta, sizeBeta);
		// draw text
		if (closeEnough)
			font.draw(batch, "Crops are " + growing + "% grown!", 50,
					50);
		if (growing == 100)
			font.draw(batch, "Press B to obtain crops.", 50, 100);
	}

	public void closeEnoughToFarm() {

		if ((Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.middleY)) < distanceFromMaterial)) {
			closeEnough = true;
			if (growing == 100) {
				if (Gdx.input.isKeyPressed(Keys.B)) {
					cornCount++;
					growing = 0;
				}
			}
			/*
			 * if (amountOfWater >= 8 && !hydrated) { font.draw(batch,
			 * "Press R to Hydrate crops.", 50, 100); if
			 * (Gdx.input.isKeyPressed(Keys.R)) { hydrated = true; growthRate =
			 * 1; } }
			 */
		}
	}

	public void farmTimer() {
		if (growing < 100)
			time += Gdx.graphics.getDeltaTime();
		if (time >= growthRate) {
			growing += 1;
			time = 0;
		}
	}
}
