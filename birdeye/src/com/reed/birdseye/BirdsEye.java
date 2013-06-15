package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class BirdsEye extends Game {
	Preferences prefs;
	String currentVersion = "1.1.1.0";
	String version;

	@Override
	public void create() {
		
		prefs = Gdx.app.getPreferences("preferences.lodescape");
		Assets.load();
		setScreen(new GameScreen(this));
		version = prefs.getString("version");
		/*
		if (version.equals(currentVersion)) {
			GameScreen.mapCamera.position.x = prefs.getFloat("camera x");
			GameScreen.mapCamera.position.y = prefs.getFloat("camera y");
			Player.x = prefs.getFloat("player x");
			Player.y = prefs.getFloat("player y");
			Tutorial.step = prefs.getInteger("Tutorial Level");
			Fishing.amountOfFish = prefs.getInteger("Fish");
			Resource.amountOfStone = prefs.getInteger("Stone");
			Tree.amountOfWood = prefs.getInteger("Wood");
			TradeShop.cash = prefs.getInteger("cash");
			Points.hp = prefs.getInteger("hp");
			Points.xp = prefs.getInteger("xp");
			Time.colorAlpha = prefs.getFloat("color alpha");
			Time.setTimeOfDay(prefs.getFloat("time"));
			Time.setAmbientLight(prefs.getFloat("ambient light"));
		} else
			prefs.clear();*/
	}

	public void render() {
		super.render();
	}

	public void dispose() {/*
		prefs.putInteger("Tutorial Level", Tutorial.step);
		prefs.putInteger("Fish", Fishing.amountOfFish);
		prefs.putInteger("Stone", Resource.amountOfStone);
		prefs.putInteger("Wood", Tree.amountOfWood);
		prefs.putInteger("Cash", TradeShop.cash);
		prefs.putInteger("hp", Points.hp);
		prefs.putInteger("xp", Points.xp);
		prefs.putFloat("camera x", GameScreen.mapCamera.position.x);
		prefs.putFloat("camera y", GameScreen.mapCamera.position.y);
		prefs.putFloat("player x", Player.x);
		prefs.putFloat("player y", Player.y);
		prefs.putFloat("color alpha", Time.colorAlpha);
		prefs.putFloat("time", Time.getTimeOfDay());
		prefs.putFloat("ambient light", Time.getAmbientLight());
		
		//set to current version before saving
		prefs.putString("version", currentVersion);
		prefs.flush();*/
		
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