package com.reed.birdseye;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wolf {

	Mob wolf = new Mob();
	
	void draw(SpriteBatch batch, BitmapFont font){
		wolf.draw(batch, font, Assets.mainWolf);
	}
	
	void update(){
		wolf.movement();
		wolf.boundingArea(0, 0, 1000, 1000);
		Assets.mainWolf = wolf.setSprites(Assets.upWolf_STILL, Assets.upWolf_LEFT,
				Assets.upWolf_RIGHT, Assets.downWolf_STILL,
				Assets.downWolf_LEFT, Assets.downWolf_RIGHT,
				Assets.leftWolf_STILL, Assets.leftWolf_LEFT,
				Assets.leftWolf_RIGHT, Assets.rightWolf_STILL,
				Assets.rightWolf_LEFT, Assets.rightWolf_RIGHT);
		
	}
}
