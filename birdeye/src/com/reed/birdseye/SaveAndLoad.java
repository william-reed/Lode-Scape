package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class SaveAndLoad {
	static Preferences prefs;
	static String currentVersion = "1.1.3";
	static String version;

	public static void load() {
		prefs = Gdx.app.getPreferences("preferences.lodescape");
		version = prefs.getString("version");

		// checks if up to date also checks if game has been played before :)
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
			// LOAD PIG X AND Y POSITIONS HERE
			// must establish pigs before setting their values
			for (int i = 0; i < ArrayListsz.amountOfPigs; i++) {
				ArrayListsz.pigArray.add(new Pig());
			}
			for (int i = 0; i < ArrayListsz.pigArray.size; i++) {
				ArrayListsz.pigArray.get(i).pig.x = prefs.getInteger("pigPosX"
						+ i);
				ArrayListsz.pigArray.get(i).pig.y = prefs.getInteger("pigPosY"
						+ i);
				ArrayListsz.pigArray.get(i).pig.health = prefs
						.getFloat("pigHealth" + i);
			}
			// establish before setting values
			for (int i = 0; i < ArrayListsz.amountOfMobs; i++) {
				ArrayListsz.creeperArray.add(new Mob(1562, 1264, 1000, 918));
			}
			for (int i = 0; i < ArrayListsz.creeperArray.size; i++) {
				ArrayListsz.creeperArray.get(i).x = prefs
						.getInteger("creeperPosX" + i);
				ArrayListsz.creeperArray.get(i).y = prefs
						.getInteger("creeperPosY" + i);
				ArrayListsz.creeperArray.get(i).health = prefs
						.getFloat("creeperHealth" + i);
			}
			// establish before setting values
			ArrayListsz.coalArray.add(new Coal(2290, 1798));
			ArrayListsz.coalArray.add(new Coal(1618, 2022));
			ArrayListsz.coalArray.add(new Coal(1844, 1652));
			for (int i = 0; i < ArrayListsz.coalArray.size; i++) {
				ArrayListsz.coalArray.get(i).drawResource = prefs
						.getBoolean("drawCoal" + i);
				ArrayListsz.coalArray.get(i).timer = prefs
						.getFloat("coalRegenTimer" + i);
			}
			Food.amountOfFood = prefs.getInteger("foodAmount");
			Points.currentLevel = prefs.getInteger("level");
			
			Time.createLights(GameScreen.rayHandler);
		} else {
			// still gotta load lights even if the versions dont match up
			Time.createLights(GameScreen.rayHandler);
			// same with pigs...
			for (int i = 0; i < ArrayListsz.amountOfPigs; i++) {
				ArrayListsz.pigArray.add(new Pig());
			}//same fore creepers
			for (int i = 0; i < ArrayListsz.amountOfMobs; i++) {
				ArrayListsz.creeperArray.add(new Mob(1562, 1264, 1000, 918));
			}
			//same for coal
			ArrayListsz.coalArray.add(new Coal(2290, 1798));
			ArrayListsz.coalArray.add(new Coal(1618, 2022));
			ArrayListsz.coalArray.add(new Coal(1844, 1652));
			prefs.clear();
		}

	}

	public static void save() {
		House.exitGame();

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
		for (int i = 0; i < ArrayListsz.pigArray.size; i++) {
			prefs.putInteger("pigPosX" + i + "",
					ArrayListsz.pigArray.get(i).pig.x);
			prefs.putInteger("pigPosY" + i + "",
					ArrayListsz.pigArray.get(i).pig.y);
			prefs.putFloat("pigHealth" + i,
					ArrayListsz.pigArray.get(i).pig.health);
		}
		for (int i = 0; i < ArrayListsz.creeperArray.size; i++) {
			prefs.putInteger("creeperPosX" + i + "",
					ArrayListsz.creeperArray.get(i).x);
			prefs.putInteger("creeperPosY" + i + "",
					ArrayListsz.creeperArray.get(i).y);
			prefs.putFloat("creeperHealth" + i,
					ArrayListsz.creeperArray.get(i).health);
		}
		for (int i = 0; i < ArrayListsz.coalArray.size; i++) {
			prefs.putBoolean("drawCoal" + i,
					ArrayListsz.coalArray.get(i).drawResource);
			prefs.putFloat("coalRegenTimer" + i,
					ArrayListsz.coalArray.get(i).timer);
		}
		prefs.putInteger("foodAmount", Food.amountOfFood);
		prefs.putInteger("level", Points.currentLevel);
		
		// set to current version before saving
		prefs.putString("version", currentVersion);
		prefs.flush();
	}
}
