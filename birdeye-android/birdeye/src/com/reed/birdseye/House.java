package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class House {
	int distanceFromMaterial = 100;
	public static boolean inHouse = false;
	int x, y;

	boolean closeEnough(){
		return (Math.sqrt((Level.levelX + x - Level.middleX) * (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY) * (Level.levelY + y - Level.middleY)) < distanceFromMaterial);
	}
	
	void draw(SpriteBatch batch, BitmapFont font){
		batch.draw(Assets.house, Level.levelX + x, Level.levelY + y);
		if(closeEnough())
			font.draw(batch, "Press B to Enter...", 50, 50);
		if(inHouse){
			batch.draw(Assets.houseIn, 0, 0);
			font.draw(batch, "Press ESCAPE to Exit", 50, 50);
		}
		
	}
	
	void gettingInandOut(){
		if(!inHouse){
		if (Gdx.input.isKeyPressed(Keys.B))
			inHouse = true;
		}else{
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				Player.x = Level.middleX;
				Player.y = Level.middleY;
				inHouse = false;
			}
		}
	}
	
	
}
