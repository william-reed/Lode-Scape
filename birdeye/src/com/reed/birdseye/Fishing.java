package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Fishing {

	// detects if you have the ability to fish
	boolean fishingPossible() {
		return Player.x > 700 && Player.x < 758 && Player.y > 1896
				&& Player.y < 2036 && TopMenu.currentTool == 1;
	}

	String caught = "You have caught a fish!";
	boolean fishCaught = false;
	Random r = new Random();
	static int amountOfFish = 0;
	static String amountOfFishString;

	void fishCaught() {
		if (fishingPossible() && Gdx.input.isKeyPressed(Keys.B) && timer > 	1) {
			if (r.nextInt(4) == 2) {
				fishCaught = true;
			}else
				timer = 0;
		}

		if (fishCaught) {
			Messages.messagesArray.add(new Message(caught, Messages.getSec()));
			amountOfFish += 1;
			Points.xp += 1;
			timer = 0;
			fishCaught = false;
		}

	}

	float timer;

	void update() {
		// update fish string
		amountOfFishString = Integer.toString(amountOfFish);
		if (Gdx.input.isKeyPressed(Keys.B)) {
			timer += Gdx.graphics.getDeltaTime();
		}
	}
}
