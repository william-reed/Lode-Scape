package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tools {

	Texture toolImage;// image for drawing the tool in top bar area
	int boxNumber; // box number to draw at

	public Tools(Texture toolImage, int boxNumber) {
		this.toolImage = toolImage;
		this.boxNumber = boxNumber;
	}

	final int toolY = 65;//draws at 65 from top of screen as shown below
	int toolX = 12;//draws at appropriate x coordinate
	final int startOfTopBar = Gdx.graphics.getWidth() / 2 - (Assets.itemSelector.getWidth() / 2);
	final int width = 50, height = 50;
	final int boxWidth = 80;
	
	void draw(SpriteBatch batch) {
		batch.draw(toolImage, (startOfTopBar + (boxNumber * boxWidth)) + toolX, Gdx.graphics.getHeight() - toolY, 50, 50);
	}
	
	
	//FIX INVENTORY BOX
}
