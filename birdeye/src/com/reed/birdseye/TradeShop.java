package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TradeShop {
	int x = 880, y = -410;
	final int DISTANCE_FROM_SHOP = 100;

	void draw(SpriteBatch batch) {
		batch.draw(Assets.tradePerson, x, y);
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < DISTANCE_FROM_SHOP);
	}
	
	String hello = "Trade Shop: Hello there stranger!";
	String purchase = "Trade Shop: Anything you want to trade with me?";
	String derp = "Trade Shop: What a nice game this is.";

	Random r = new Random();

	void textSetter() {
		String sender;

		if (ableToSend()) {
			switch (r.nextInt(3)) {
			case 0:
				sender = hello;
				break;
			case 1:
				sender = purchase;
				break;
			case 2:
				sender = derp;
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
