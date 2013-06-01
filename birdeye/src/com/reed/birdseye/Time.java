package com.reed.birdseye;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/** Everything related to time! */
public class Time {

	// 5 minute days
	// 1 minute transition
	// 3 minute nights
	// 1 minute transition
	static float colorAlpha = 0f;
	// set to .9 for proper light
	final static Color lightColor = new Color(255, 237, 138, colorAlpha);
	private static float timeOfDay = 305;
	// set to .2 for proper darkness
	private static float ambientLight = 1f;

	public static Array<PointLight> pointLights = new Array<PointLight>();

	/** Sets up new lights */
	public static void createLights(RayHandler rayHandler) {
		pointLights.add(newLight(rayHandler, 402, 406));
		pointLights.add(newLight(rayHandler, 563, 406));
		pointLights.add(newLight(rayHandler, 402, 200));
		pointLights.add(newLight(rayHandler, 402, -362));
		pointLights.add(newLight(rayHandler, 560, -362));
		pointLights.add(newLight(rayHandler, 402, -738));
		pointLights.add(newLight(rayHandler, 240, 318));
		pointLights.add(newLight(rayHandler, 738, 320));
		pointLights.add(newLight(rayHandler, 1104, 320));
		pointLights.add(newLight(rayHandler, 1522, 320));
		pointLights.add(newLight(rayHandler, 1938, 320));
		pointLights.add(newLight(rayHandler, 1938, 86));
		pointLights.add(newLight(rayHandler, 2098, 86));
		pointLights.add(newLight(rayHandler, 1938, -480));
		pointLights.add(newLight(rayHandler, 1938, -868));
		pointLights.add(newLight(rayHandler, 2098, -868));
		pointLights.add(newLight(rayHandler, 1710, -1200));
		pointLights.add(newLight(rayHandler, 1850, -1200));
		pointLights.add(newLight(rayHandler, 1115, -848));
		pointLights.add(newLight(rayHandler, 1255, -848));
		pointLights.add(newLight(rayHandler, 1236, -374));
		pointLights.add(newLight(rayHandler, 560, -862));
		pointLights.add(newLight(rayHandler, -224, -836));
		pointLights.add(newLight(rayHandler, -145, -1190));
	}

	/** Returns current time */
	public static float getTimeOfDay() {
		return timeOfDay;
	}

	/** Sets current time */
	public static void setTimeOfDay(float timeOfDay) {
		Time.timeOfDay = timeOfDay;
	}

	public static void update(RayHandler rayHandler) {
		// Constantly update time
		timeOfDay += Gdx.graphics.getDeltaTime();
		// set time back to 0 if reaches 10 minutes
		if (timeOfDay > 840)
			timeOfDay = 0;
		sunset();
		sunrise();
		rayHandler.setAmbientLight(getAmbientLight());
	}

	/** check if time is less then 5 minutes, if so it is day */
	public static boolean isDay() {
		return timeOfDay < 300;
	}

	/** detect if sunset */
	public static boolean isSunset() {
		return timeOfDay > 300 && timeOfDay < 420;
	}

	// appropriate sunset effects
	static void sunset() {
		if (isSunset()) {
			if (colorAlpha <= .9f) {
				colorAlpha += .0002f;
				lightColor.set(255, 237, 138, colorAlpha);
			}

			if (ambientLight >= .2f) {
				ambientLight -= .00015f;
			}

			for (int i = 0; i < pointLights.size; i++) {
				pointLights.get(i).setColor(lightColor);
			}
		}
	}

	/** detect if night */
	public static boolean isNight() {
		return timeOfDay > 420 && timeOfDay < 720;
	}

	/** detect if sunrise */
	public static boolean isSunrise() {
		return timeOfDay > 720;
	}

	// appropriate sunrise stuff
	static void sunrise() {
		if (isSunrise()) {
			if (colorAlpha >= 0f) {
				colorAlpha -= .0002f;
				lightColor.set(255, 237, 138, colorAlpha);
			}

			if (ambientLight <= 1f) {
				ambientLight += .00015f;
			}

			for (int i = 0; i < pointLights.size; i++) {
				pointLights.get(i).setColor(lightColor);
			}
		}
	}

	// create new light
	private static PointLight newLight(RayHandler rayHandler, int lightX,
			float lightY) {
		return new PointLight(rayHandler, 2500, lightColor, 175, lightX, lightY);

	}

	/** Returns ambient light value */
	public static float getAmbientLight() {
		return ambientLight;
	}

	/** Sets ambient light value */
	public static void setAmbientLight(float ambientLight) {
		Time.ambientLight = ambientLight;
	}
	
	//array list of spawn points
	private static Array<Vector2> spawnList = new Array<Vector2>();
	//defines spawn points
	static void addMobSpawns(){
		//finish latter
	}
}
