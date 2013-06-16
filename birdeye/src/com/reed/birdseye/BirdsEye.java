package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class BirdsEye extends Game {
	@Override
	public void create() {
		
		Assets.load();
		setScreen(new GameScreen(this));
		SaveAndLoad.load();
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		SaveAndLoad.save();
		super.dispose();
		Gdx.app.exit();
	}

	public void resize(int width, int height) {
	}

	public void pause() {
	}

	public void resume() {
	}
}