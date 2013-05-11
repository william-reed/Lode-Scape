package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Points {
	// health points and experience points
	static int hp = 100;
	static int xp = 0;

	static int currentLevel = 0;
	// The amount of xp points required to obtain that level. 2^(level)
	final int levels[] = { 2, 4, 6, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 };

	void draw(SpriteBatch batch) {
		// draws at a percentage to account for different screen sizes
		batch.draw(Assets.pointsBar, Gdx.graphics.getWidth() * .80f,
				Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * .1011f);
	}

	// define positions to draw bars for each of these
	final float hpX = Gdx.graphics.getWidth() * .80f + 4;
	final float hpY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight()
			* .1011f + 25;
	final float xpX = Gdx.graphics.getWidth() * .80f + 4;
	final float xpY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight()
			* .1011f + 5;

	final int barWidth = 126;
	final int barHeight = 13;
	float hpWidth;
	float xpWidth;

	// done in seperate method since it requires shapeRender - it makes things
	// easier this way
	void drawBars(ShapeRenderer shapeRenderer) {
		// update these booleans
		hpWidth = (hp * barWidth) / 100;
		xpWidth = (xp * barWidth) / levels[currentLevel];
		shapeRenderer.begin(ShapeType.Filled);
		// draw hp in orange
		shapeRenderer.setColor(255, 179, 0, .02f);
		shapeRenderer.rect(hpX, hpY, hpWidth, barHeight);
		// draw xp in blue
		shapeRenderer.setColor(0, 65, 162, 0);
		shapeRenderer.rect(xpX, xpY, xpWidth, barHeight);
		shapeRenderer.end();
	}

	static void gainHealth(int amount) {
		if (hp <= 100)
			hp += amount;
	}

	static void looseHealth(int amount) {
		if (hp >= 0)
			hp -= amount;
	}

	static void gainExperience(int amount) {
		xp += amount;
	}

	static void looseExperience(int amount) {
		xp -= amount;
	}

	void updateLevel() {
		// changes level if xp exceeds current level
		if (xp > levels[currentLevel]) {
			currentLevel++;
			// sets xp back to 1 for next level
			xp = 1;
		}
	}

	void regeneration() {
		// regenerate health over time here
	}
}
