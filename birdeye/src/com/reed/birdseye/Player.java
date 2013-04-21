package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

public class Player {
	static boolean move = true;
	static boolean up = false, down = false, left = false, right = false;
	int currentDirection = 0; //0 is down, 1 is up, 2 is left, 3 is right
	int playerSpeed = 2;
	static float x = Level.middleX;
	static float y = Level.middleY;
	static final int playerWidth = 32;
	static final int playerHeight = 48;

	// pick stuff
	Skeleton pickSkel = new Skeleton(Assets.pickRightSkeletonData);
	Bone root = pickSkel.getRootBone();

	void input() {
		if (move) {
			if (!House.inHouse) {

				if ((Gdx.input.isKeyPressed(Keys.W))) {
					up = true;
					currentDirection = 1;
				} else
					up = false;
				if ((Gdx.input.isKeyPressed(Keys.A))) {
					left = true;
					currentDirection = 2;
				} else
					left = false;
				if ((Gdx.input.isKeyPressed(Keys.S))) {
					currentDirection = 0;
					down = true;
				} else
					down = false;
				if ((Gdx.input.isKeyPressed(Keys.D))) {
					right = true;
					currentDirection = 3;
				} else
					right = false;
			} else {
				if ((Gdx.input.isKeyPressed(Keys.W))) {
					y += playerSpeed;
					up = true;
				} else
					up = false;
				if ((Gdx.input.isKeyPressed(Keys.A))) {
					x -= playerSpeed;
					left = true;
				} else
					left = false;
				if ((Gdx.input.isKeyPressed(Keys.S))) {
					y -= playerSpeed;
					down = true;
				} else
					down = false;
				if ((Gdx.input.isKeyPressed(Keys.D))) {
					x += playerSpeed;
					right = true;
				} else
					right = false;
			}
		}
	}
	
	void move(){
		if(up)
			Level.levelY -= playerSpeed;
		if(down)
			Level.levelY += playerSpeed;
		if(left)
			Level.levelX += playerSpeed;
		if(right)
			Level.levelX -= playerSpeed;
	}

	void setSprites() {
		if (right)
			Assets.mainChar = Assets.rightChar;
		if (left)
			Assets.mainChar = Assets.leftChar;
		if (up)
			Assets.mainChar = Assets.upChar;
		if (down)
			Assets.mainChar = Assets.downChar;
	}

	void draw(SpriteBatch batch, BitmapFont font) {
		font.draw(batch, "X:  " + Level.levelX, 850, 520);
		font.draw(batch, "Y:  " + Level.levelY, 850, 500);
		if (currentDirection == 3 && Resource.mining)
			pickSkel.draw(batch);
		if (move)
			batch.draw(Assets.mainChar, x, y);
	}

	float time;

	void update() {
		root.setX(475);
		root.setY(235);

		time += Gdx.graphics.getDeltaTime() * 1.2;
		Assets.pickRightAnim.apply(pickSkel, time, true);
		pickSkel.updateWorldTransform();
	}
}
