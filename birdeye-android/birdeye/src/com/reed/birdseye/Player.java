package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	boolean move = true;
	boolean up = false, down = false, left = false, right = false;
	int playerSpeed = 2;
	static float x = Level.middleX;
	static float y = Level.middleY;
	
	void move(){
		if(!House.inHouse){
			if ((Gdx.input.isKeyPressed(Keys.W))) {
				Level.levelY -= playerSpeed;
				up = true;
			} else
				up = false;
			if ((Gdx.input.isKeyPressed(Keys.A))) {
				Level.levelX += playerSpeed;
				left = true;
			} else
				left = false;
			if ((Gdx.input.isKeyPressed(Keys.S))) {
				Level.levelY += playerSpeed;
				down = true;
			} else
				down = false;
			if ((Gdx.input.isKeyPressed(Keys.D))) {
				Level.levelX -= playerSpeed;
				right = true;
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
	
	void setSprites(){
		if (right)
			Assets.mainChar = Assets.rightChar;
		if (left)
			Assets.mainChar = Assets.leftChar;
		if (up)
			Assets.mainChar = Assets.upChar;
		if (down)
			Assets.mainChar = Assets.downChar;
	}
	
	//finish collision some time...
	boolean isAbleToMove(){
		return (x > 260 && y < 304 && y > 132 && x < 650);
	}
	
	void wallCollision(){
		if(!isAbleToMove()){
			
		}
	}
	
	void draw(SpriteBatch batch){
		System.out.println("X: "+ x +" Y: " + y);
		if(move)
		batch.draw(Assets.mainChar, x, y);
	}
}

