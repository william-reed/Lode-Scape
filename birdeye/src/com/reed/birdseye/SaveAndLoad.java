package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class SaveAndLoad {
	static Preferences prefs;
	static String currentVersion = "1.1.2.0";
	static String version;

	public static void load() {
		prefs = Gdx.app.getPreferences("preferences.lodescape");
		version = prefs.getString("version");

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
			House.preCameraPos.x = prefs.getFloat("pre camera x");
			House.preCameraPos.y = prefs.getFloat("pre camera y");
			House.prePlayerPos.x = prefs.getFloat("pre player x");
			House.prePlayerPos.y = prefs.getFloat("pre player y");
			CollisionDetection.setCollisionType(prefs
					.getInteger("collision type"));
			Level.setCurrentMap(prefs.getInteger("current map"));
			Time.setOutdoors(prefs.getBoolean("is outside"));
			House.preAmbientLight = prefs.getFloat("pre ambient light");

			Time.createLights(GameScreen.rayHandler);
		} else {
			Time.createLights(GameScreen.rayHandler);
			prefs.clear();
		}

	}

	public static void save() {
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
		prefs.putFloat("pre camera x", House.preCameraPos.x);
		prefs.putFloat("pre camera y", House.preCameraPos.y);
		prefs.putFloat("pre player x", House.prePlayerPos.x);
		prefs.putFloat("pre player y", House.prePlayerPos.y);
		prefs.putInteger("collision type",
				CollisionDetection.getCollisionType());
		prefs.putInteger("current map", Level.getCurrentMap());
		prefs.putBoolean("is outside", Time.isOutdoors());
		prefs.putFloat("pre ambient light", House.preAmbientLight);

		// set to current version before saving
		prefs.putString("version", currentVersion);
		prefs.flush();
	}
}
