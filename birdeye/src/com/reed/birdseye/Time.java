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
	private static float timeOfDay = 300;
	// set to .2 for proper darkness
	private static float ambientLight = 1f;

	public static Array<PointLight> pointLights = new Array<PointLight>();

	/** Sets up new lights */
	public static void createLights(RayHandler rayHandler) {
		pointLights.add(newLight(rayHandler, 1360, 3722));
		pointLights.add(newLight(rayHandler, 1521, 3722));
		pointLights.add(newLight(rayHandler, 1360, 3516));
		pointLights.add(newLight(rayHandler, 1360, 2954));
		pointLights.add(newLight(rayHandler, 1518, 2954));
		pointLights.add(newLight(rayHandler, 1360, 2578));
		pointLights.add(newLight(rayHandler, 1198, 3634));
		pointLights.add(newLight(rayHandler, 1696, 3636));
		pointLights.add(newLight(rayHandler, 2062, 3636));
		pointLights.add(newLight(rayHandler, 2480, 3636));
		pointLights.add(newLight(rayHandler, 2896, 3636));
		pointLights.add(newLight(rayHandler, 2896, 3402));//
		pointLights.add(newLight(rayHandler, 3056, 3402));//
		pointLights.add(newLight(rayHandler, 2896, 2836));//
		pointLights.add(newLight(rayHandler, 2896, 2448));//
		pointLights.add(newLight(rayHandler, 3056, 2448));//
		pointLights.add(newLight(rayHandler, 2668, 2116));//
		pointLights.add(newLight(rayHandler, 2808, 2116));
		pointLights.add(newLight(rayHandler, 2073, 2468));
		pointLights.add(newLight(rayHandler, 2213, 2468));
		pointLights.add(newLight(rayHandler, 2194, 2942));
		pointLights.add(newLight(rayHandler, 1518, 2454));
		pointLights.add(newLight(rayHandler, 734, 2480));
		pointLights.add(newLight(rayHandler, 813, 2126));
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
