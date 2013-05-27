package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TradeShop {
	int x = 880, y = -410;
	final int DISTANCE_FROM_SHOP = 100;
	public static int cash = 0;

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
		String sender = "";
		if (ableToSend()) {
			if (Tutorial.step == 100) {
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
			}
			if (Tutorial.step < 100)
				// diferent text for tutorial stage
				switch (Tutorial.step) {
				case 1:
					sender = "Trade Shop: Hello stranger! You look new.";
					break;
				case 2:
					sender = "Trade Shop: If you get some fish with that fishing pole I'll trade with you.";
					break;
				case 3:
					sender = "Trade Shop: Do you want to trade your 5 fish for $50?";
					break;
				case 4:
					sender = "Trade Shop: Hello there friend.";
				}
			Messages.messagesArray.add(new Message(sender, Messages.sec));
		}

	}

	float timer = 5;

	void update() {
		timer += Gdx.graphics.getDeltaTime();

		if (Fishing.amountOfFish >= 5 && Tutorial.step == 2) {
			Tutorial.step = 3;
		}
		if (cash >= 50 && Tutorial.step == 3) {
			Tutorial.step = 4;
		}
	}

	boolean ableToSend() {
		if (closeEnough() && timer >= 5) {
			timer = 0;
			return true;
		} else
			return false;
	}

	void drawInputText(SpriteBatch batch, BitmapFont font) {
		if (Tutorial.step == 3 && closeEnough()) {
			font.draw(batch, "Yes                    No", 800, 50);
		}
	}

	void handleInput() {
		if (Tutorial.step == 3 && closeEnough()) {
			if (Gdx.input.getX() > 785 && Gdx.input.getX() < 836
					&& Gdx.input.getY() > 470 && Gdx.input.getY() < 515
					&& Gdx.input.isTouched()) {
				Messages.messagesArray.add(new Message(
						"Trade Shop: Here is your money, thanks for the business!",
						Messages.sec));
				timer = 0;
				Tutorial.step += 1;
			}
		}
	}
}
