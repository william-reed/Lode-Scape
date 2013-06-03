package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class BirdsEye extends Game {
	Preferences prefs;
	boolean firstRun;
	float version = 1.01f;

	@Override
	public void create() {
		prefs = Gdx.app.getPreferences("preferences.lodescape");
		Assets.load();
		setScreen(new GameScreen(this));
		// tests if it has been created before
		version = prefs.getFloat("version");
		
		if (version == 1.01f) {
			GameScreen.camera.position.x = prefs.getFloat("camera x");
			GameScreen.camera.position.y = prefs.getFloat("camera y");
			Player.x = prefs.getFloat("player x");
			Player.y = prefs.getFloat("player y");
			Tutorial.step = prefs.getInteger("Tutorial Level");
			Fishing.amountOfFish = prefs.getInteger("Fish");
			Resource.amountOfStone = prefs.getInteger("Stone");
			Tree.amountOfWood = prefs.getInteger("Wood");
			TradeShop.cash = prefs.getInteger("cash");
			Points.hp = prefs.getInteger("hp");
			Points.xp = prefs.getInteger("xp");
			
		} else
			prefs.clear();
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		prefs.putInteger("Tutorial Level", Tutorial.step);
		prefs.putInteger("Fish", Fishing.amountOfFish);
		prefs.putInteger("Stone", Resource.amountOfStone);
		prefs.putInteger("Wood", Tree.amountOfWood);
		prefs.putInteger("Cash", TradeShop.cash);
		prefs.putInteger("hp", Points.hp);
		prefs.putInteger("xp", Points.xp);
		prefs.putFloat("camera x", GameScreen.camera.position.x);
		prefs.putFloat("camera y", GameScreen.camera.position.y);
		prefs.putFloat("player x", Player.x);
		prefs.putFloat("player y", Player.y);
		
		//set to current version before saving
		version = 1.01f;
		prefs.putFloat("version", version);
		prefs.flush();
		super.dispose();
	}

	public void resize(int width, int height) {
	}

	public void pause() {
	}

	public void resume() {
	}
}