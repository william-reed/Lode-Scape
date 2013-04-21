package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Android {
	// sets size of image to 20 percent of the width
	float size = (float) (Gdx.graphics.getWidth() * .2);

	void draw(SpriteBatch batch) {
		// draw d pad and a / b buttons for android here using:
		// Gdx.app.getType()
		batch.draw(Assets.dpad, Gdx.graphics.getWidth() - size, 0, size, size);
		if (Player.up) {
			batch.draw(Assets.dpadUP, Gdx.graphics.getWidth() - size, 0, size,
					size);
		}
		if (Player.down) {
			batch.draw(Assets.dpadDOWN, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}
		if (Player.left) {
			batch.draw(Assets.dpadLEFT, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}
		if (Player.right) {
			batch.draw(Assets.dpadRIGHT, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}
	}

	void input() {
		// done in percents to account for size change as accoutned for above
		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .833
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .9583
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .2142
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .3571
				&& Gdx.input.isTouched()) {
			Player.up = true;
		} else {
			// Player.up = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .833
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .9583
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1425
				&& Gdx.input.isTouched()) {
			Player.down = true;
		} else {
			// Player.down = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .7916
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .875
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1071
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .25
				&& Gdx.input.isTouched()) {
			Player.left = true;
		} else {
			// Player.left = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .9166
				&& Gdx.input.getX() < Gdx.graphics.getWidth()
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1071
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .25
				&& Gdx.input.isTouched()) {
			Player.right = true;
		} else {
			// Player.up = false;
		}
	}
}
