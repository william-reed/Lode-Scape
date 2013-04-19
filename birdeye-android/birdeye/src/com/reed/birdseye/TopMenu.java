package com.reed.birdseye;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TopMenu {
	void draw(SpriteBatch batch, BitmapFont font){
		batch.draw(Assets.itemSelector, 230, 465);
		batch.draw(Assets.material, 240, 470);
		batch.draw(Assets.tree, 330, 470, 50, 60);
		batch.draw(Assets.corn, 420, 470, 35, 60);
		batch.draw(Assets.bucket, 495, 470, 52, 56);
		
		font.draw(batch, Resource.amountOfStoneString, 240, 530);
		font.draw(batch, Water.amountOfWaterString, 488, 530);
		font.draw(batch, Tree.amountOfWoodString, 320, 530);
	}
}
