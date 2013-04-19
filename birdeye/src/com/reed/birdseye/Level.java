package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	static float levelX = -500;
	static float levelY = -500;	
	static float middleX = Gdx.graphics.getWidth() / 2 - 16; 
	static float middleY = Gdx.graphics.getHeight() / 2 - 24;
	
	void draw(SpriteBatch batch){
		batch.draw(Assets.level, levelX, levelY);
	}
}
