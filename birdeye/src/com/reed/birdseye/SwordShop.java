package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SwordShop {
	int x = 1515, y = -924;
	final int DISTANCE_FROM_SHOP = 100;

	void draw(SpriteBatch batch) {
		batch.draw(Assets.shopOwner, x, y);
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < DISTANCE_FROM_SHOP);
	}

	String hello = "Sword Shop: Hello there!";
	String purchase = "Sword Shop: Would you like to buy a sword?";
	String derp = "Sword Shop: What a nice game this is.";
	String myJob = "Sword Shop: I love my job.";

	Random r = new Random();

	void textSetter() {
		String sender;

		if (ableToSend()) {
			switch (r.nextInt(4)) {
			case 0:
				sender = hello;
				break;
			case 1:
				sender = purchase;
				break;
			case 2:
				sender = derp;
				break;
			case 3:
				sender = myJob;
				break;
			default:
				sender = "blank message";
				break;
			}

			Messages.messagesArray.add(new Message(sender, Messages.sec));
		}

	}

	float timer = 5;

	void update() {
		timer += Gdx.graphics.getDeltaTime();
	}

	boolean ableToSend() {
		if (closeEnough() && timer >= 5) {
			timer = 0;
			return true;
		} else
			return false;
	}
}