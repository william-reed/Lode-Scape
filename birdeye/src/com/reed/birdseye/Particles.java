package com.reed.birdseye;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Particles {
	
	void smokeUpdateAndDraw(SpriteBatch batch, float deltaTime){
		Assets.chimneySmoke.start();
		Assets.chimneySmoke.draw(batch);
		Assets.chimneySmoke.setPosition(1695, 3369);
		Assets.chimneySmoke.update(deltaTime);
	}
}
