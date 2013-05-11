package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	static float levelX = -500;
	static float levelY = -500;
	static float middleX = Gdx.graphics.getWidth() / 2 - 16;
	static float middleY = Gdx.graphics.getHeight() / 2 - 24;

	static int grassX = -64; // position for bottom left grass
	static int grassY = -64; // ^
	
	Sprite grassSprite = new Sprite(Assets.grass);
	
	void draw(SpriteBatch batch) {
		//draws grass image (64 , 64) everywhere
		for (int i = 0; i < Gdx.graphics.getWidth() + 128; i += 64) {
			for (int j = 0; j < Gdx.graphics.getHeight() + 128; j += 64) {
				if(i == 256 && j == 256){
					//grassSprite.flip(true, false);
				}
				
				batch.draw(grassSprite, grassX + i, grassY + j);
			}
		}
	}
	
	void update(){
		// sets map back to original position before white background becomes
				// visible
				if (grassY <= -128 || grassY >= 0) {
					grassY = -64;
				}
				if (grassX <= -128 || grassX >= 0) {
					grassX = -64;
				}
	}
}