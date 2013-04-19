package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.reed.birdseye.GameScreen;

public class BirdsEye extends Game {
	
	@Override
	public void create () {
		Assets.load();
		setScreen(new GameScreen(this));
	}
	

	public void render() {
		super.render();
	}

	public void dispose () {
		super.dispose();
	}


	public void resize(int width, int height) {
	}

	public void pause() {	
	}

	public void resume() {	
	}
}