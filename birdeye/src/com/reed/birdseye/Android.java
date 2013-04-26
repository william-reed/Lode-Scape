package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Android {
	// sets size of image to 20 percent of the width
	static float size = (float) (Gdx.graphics.getWidth() * .2);
	//dpad
	static boolean up = false, down = false, left = false, right = false; 
	// buttons
	static boolean a = false, b = false;

	void draw(SpriteBatch batch) {
		// draw d pad and a / b buttons for android here using:
		// Gdx.app.getType()
		batch.draw(Assets.dpad, Gdx.graphics.getWidth() - size, 0, size, size);
		if (up) {
			batch.draw(Assets.dpadUP, Gdx.graphics.getWidth() - size, 0, size,
					size);
		}
		if (down) {
			batch.draw(Assets.dpadDOWN, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}
		if (left) {
			batch.draw(Assets.dpadLEFT, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}
		if (right) {
			batch.draw(Assets.dpadRIGHT, Gdx.graphics.getWidth() - size, 0,
					size, size);
		}

		batch.draw(Assets.buttons, 0, 0, size, size / 2);
	}

	void input() {
		// done in percents to account for size change as accoutned for above
		// dpad input
		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .833
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .9583
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .2142
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .3571
				&& Gdx.input.isTouched()) {
			up = true;
		} else {
			up = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .833
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .9583
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1425
				&& Gdx.input.isTouched()) {
			down = true;
		} else {
			down = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .7916
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .875
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1071
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .25
				&& Gdx.input.isTouched()) {
			left = true;
		} else {
			left = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .9166
				&& Gdx.input.getX() < Gdx.graphics.getWidth()
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .1071
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .25
				&& Gdx.input.isTouched()) {
			right = true;
		} else {
			right = false;
		}

		// button input
		if (Gdx.input.getX() > 0
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .0958
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * 0
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .2142
				&& Gdx.input.isTouched()) {
			a = true;
		} else {
			a = false;
		}

		if (Gdx.input.getX() > Gdx.graphics.getWidth() * .1041
				&& Gdx.input.getX() < Gdx.graphics.getWidth() * .2083
				&& Gdx.input.getY() < Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * 0
				&& Gdx.input.getY() > Gdx.graphics.getHeight()
						- Gdx.graphics.getHeight() * .2142
				&& Gdx.input.isTouched()) {
			b  = true;
		} else {
			b = false;
		}
	}
}
