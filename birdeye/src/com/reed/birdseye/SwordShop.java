package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SwordShop {
	int x = 2473, y = 2392;
	final int DISTANCE_FROM_SHOP = 100;

	void draw(SpriteBatch batch) {
		batch.draw(Assets.shopOwner, x, y);
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < DISTANCE_FROM_SHOP);
	}

	String hello = "[Sword Shop] Hello there!";
	String purchase = "[Sword Shop] Would you like to buy a sword?";
	String derp = "[Sword Shop] What a nice game this is.";
	String myJob = "[Sword Shop] I love my job.";

	Random r = new Random();

	void textSetter() {
		String sender = "";

		if (ableToSend()) {
			if (Tutorial.step == 100)
				// random text when done with tutorial
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
			if (Tutorial.step < 100)
				// diferent text for tutorial stage
				switch (Tutorial.step) {
				case 1:
					sender = purchase;
					break;
				case 2:
					sender = "[Sword Shop] Have you obtained any fish yet?";
					break;
				case 3:
					sender = "[Sword Shop] Have you traded the fish for money yet?";
					break;
				case 4:
					sender = "[Sword Shop] You got the money! Oh no... it seems I have ran out of wood.";
					Messages.messagesArray.add(new Message("[Sword Shop] Take this hatchet and go chop some trees for me!", Messages.sec));
					break;
				case 5:
					sender = "[Sword Shop] Have you gotten that wood yet?";
					break;
				case 6:
					sender = "[Sword Shop] Thank you for getting that wood! Here is a sword!";
					break;
				case 7:
					sender = "More of this quest will be added soon! Stay tuned! :D";
					break;
				default:
					sender = "blank message...";
					break;
				}
			Messages.messagesArray.add(new Message(sender, Messages.sec));
		}

	}

	float timer = 15;
	int timerMax = 15;

	void update() {
		timer += Gdx.graphics.getDeltaTime();
		//System.out
			//	.println("X: " + Gdx.input.getX() + " Y: " + Gdx.input.getY());
		if(Tutorial.step == 4 && closeEnough()){
			timer = 0;
			TradeShop.cash -= 50;
			Tutorial.step = 5;
		}
		if(Tutorial.step == 6 && closeEnough()){
			timer = 0;
			Tutorial.step = 7;
		}
	}

	boolean ableToSend() {
		if (closeEnough() && timer >= timerMax) {
			timer = 0;
			return true;
		} else
			return false;
	}

	void drawInputText(SpriteBatch batch, BitmapFont font) {
		if (Tutorial.step == 1 && closeEnough()) {
			font.draw(batch, "Yes                    No", 800, 50);
		}
	}

	void handleInput() {
		if (Tutorial.step == 1 && closeEnough()) {
			if (Gdx.input.getX() > 785 && Gdx.input.getX() < 836
					&& Gdx.input.getY() > 470 && Gdx.input.getY() < 515 && Gdx.input.isTouched()) {
				Messages.messagesArray.add(new Message("[Sword Shop] Here is a fishing rod. Go catch some fish and trade it for cash to pay me.", Messages.sec));
				Messages.messagesArray.add(new Message("[Sword Shop] It looks like you don't have any money...", Messages.sec));
				Tutorial.step += 1;
			}
		}
	}
}