package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mob {
	// randomly moving "mob" (animal, monster, etc)
	
	Random r = new Random();
	int x, y; //set to random
	int direction = r.nextInt(4) + 1; // 0 = up, 1 = down, 2 = left, 3 = right
	float mobTime;
	// defies time left for movement - set to random int below 10
	final int speed = 1;
	// some mob test texture here
	

	void draw(SpriteBatch batch) {
		// batch.draw(texture, x, y);
	}

	void movement() {
		//constantly decrease the mobTime
		mobTime -= Gdx.graphics.getDeltaTime();
		if (direction == 0 && mobTime > 0) {

		} else {
			// sets new time "limit" to anything from 1 - 10 seconds
			mobTime = r.nextInt(10) + 1;
			direction = r.nextInt(4) + 1;
		}
		if (direction == 1 && mobTime > 0) {

		} else {
			mobTime = r.nextInt(10) + 1;
			direction = r.nextInt(4) + 1;
		}
		if (direction == 2 && mobTime > 0) {
			x -= speed;
		} else {
			mobTime = r.nextInt(10) + 1;
			direction = r.nextInt(4) + 1;
		}
		if (direction == 3 && mobTime > 0) {
			x += speed;
		} else {
			mobTime = r.nextInt(10) + 1;
			direction = r.nextInt(4) + 1;
		}
	}
}