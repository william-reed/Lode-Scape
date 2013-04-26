package com.reed.birdseye;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class CollisionDetection {

	final int shape1X = (int) (Level.middleX + 5);
	final int shape1Y = (int) (Level.middleY + 1);
	final int shape1Width = 23;
	final int shape1Height = 10;
	int shape2X, shape2Y, shape2Width, shape2Height;

	public CollisionDetection(int shape2X, int shape2Y, int shape2Width,
			int shape2Height) {
		this.shape2X = shape2X;
		this.shape2Y = shape2Y;
		this.shape2Width = shape2Width;
		this.shape2Height = shape2Height;
	}

	boolean collisionDetector() {
		
		if(((shape1Y + shape1Height) > (Level.levelY + shape2Y)) && 
			((Level.levelX + shape2X) < (shape1X + shape1Width) &&
			(shape1X + shape1Width) < ((Level.levelX + shape2X) + shape2Width + shape1Width))){
			
			System.out.println("Collision!");
			Player.move = false;
			return true;
	}else{
		
		return false;
		
		}
	}
	
	void draw(ShapeRenderer shapeRenderer) {
		// draw the rectangles
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(0, 0, 0, 1);
		//shape 1 is player
		shapeRenderer.rect(shape1X, shape1Y, shape1Width, shape1Height);
		shapeRenderer.rect(Level.levelX + shape2X, Level.levelY + shape2Y, shape2Width, shape2Height);
		shapeRenderer.end();
	}
}
