package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Coal {

	public int x = 300, y = 100;;
	int width = 64;
	int height = 58;
	float coalTimer = 0;
	int distanceFromMaterial = 100;
	static int amountOfCoal = 0;
	static String amountOfCoalString;
	boolean drawResource = true;
	float miningRate = 1f;
	boolean readyForRegen = false;

	public Coal(int x, int y) {
		this.x = x;
		this.y = y;
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < distanceFromMaterial);
	}

	void draw(SpriteBatch batch) {
		if (drawResource) {
			batch.draw(Assets.coalOre, x, y, width, height);
		}
	}

	void collect() {
		amountOfCoalString = Integer.toString(amountOfCoal);// update string
		// starts making the image of the "resource" smaller as b is
		// held down
		if (closeEnough()) {
			if (TopMenu.currentTool == 0 && Tools.isTooling) {
				coalTimer += Gdx.graphics.getDeltaTime() * miningRate;
				if (coalTimer > 1 && coalTimer < 2) {
					width = (int) (64 * .8);
					height = (int) (58 * .8);
				}
				if (coalTimer > 2 && coalTimer < 3) {
					width = (int) (64 * .6);
					height = (int) (58 * .6);
				}
				if (coalTimer > 3 && coalTimer < 4) {
					width = (int) (64 * .4);
					height = (int) (58 * .4);
				}
				if (coalTimer > 4 && coalTimer < 5) {
					width = (int) (64 * .2);
					height = (int) (58 * .2);
				}
				if (coalTimer > 5) {
					amountOfCoal += 1;
					coalTimer = 0;
					drawResource = false;
					readyForRegen = true;
					Points.gainExperience(1);
				}

			} else {
				coalTimer = 0;
				width = 64;
				height = 58;
			}
		}
	}

	/** Distance between coal ore and Player */
	float distanceBetweenCoalAndPlayer() {
		return (float) Math.sqrt((x - Player.x) * (x - Player.x)
				+ (y - Player.y) * (y - Player.y));
	}

	float timer;

	void regeneration() {
		//just so I can save one less boolean * amount of coal
		if(!drawResource){
			readyForRegen = true;
		}
		// add time to timer to keep track when regen is possible
		if (readyForRegen && timer < 130)
			timer += Gdx.graphics.getDeltaTime();

		// if timer is greater than 120 seconds (2m) it can regen
		if (timer > 120 && distanceBetweenCoalAndPlayer() > 560) {
			readyForRegen = false;
			timer = 0;
			coalTimer = 0;
			width = 64;
			height = 58;
			drawResource = true;
		}
	}

	final int charWidth = Assets.mainChar.getRegionWidth();

	void playerCollision() {
		if (!readyForRegen) {
			if (Player.x + charWidth > x - 4 && Player.x < x + 20
					&& Player.y < y + 58 && Player.y > y) {
				Player.isAbleToMoveRight = false;
			}
			if (Player.x + charWidth > x + 54 && Player.x < x + 68
					&& Player.y < y + 58 && Player.y > y) {
				Player.isAbleToMoveLeft = false;
			}
			if (Player.x + charWidth > x && Player.x < x + 64
					&& Player.y > y - 14 && Player.y < y + 10) {
				Player.isAbleToMoveUp = false;
			}
			if (Player.x + charWidth > x && Player.x < x + 64
					&& Player.y > y + 48 && Player.y < y + 62) {
				Player.isAbleToMoveDown = false;
			}
		}
	}

	// use for pig and mob (use on mob when not under attack)
	void mobCollision(Mob mob) {
		if (!readyForRegen) {
			if (mob.x + charWidth > x - 4 && mob.x < x + 20 && mob.y < y + 58
					&& mob.y > y) {
				mob.direction = 2;
			}
			if (mob.x + charWidth > x + 54 && mob.x < x + 68 && mob.y < y + 58
					&& mob.y > y) {
				mob.direction = 3;
			}
			if (mob.x + charWidth > x && mob.x < x + 64 && mob.y > y - 14
					&& mob.y < y + 10) {
				mob.direction = 1;
			}
			if (mob.x + charWidth > x && mob.x < x + 64 && mob.y > y + 48
					&& mob.y < y + 62) {
				mob.direction = 0;
			}
		}
	}

	void mobUnderAttackCollision(Mob mob) {
		// if it goes into a rock under attack becomes false... not sure if I
		// should keep this or what
		if (!readyForRegen) {
			if (mob.x + mob.realMob.getRegionWidth() > x - 4 && mob.x < x + 20
					&& mob.y < y + 58 && mob.y > y) {
				mob.underAttack = false;
			}

			if (mob.x + mob.realMob.getRegionWidth() > x + 54 && mob.x < x + 68
					&& mob.y < y + 58 && mob.y > y) {
				mob.underAttack = false;
			}

			if (mob.x + mob.realMob.getRegionWidth() > x && mob.x < x + 64
					&& mob.y > y - 14 && mob.y < y + 10) {
				mob.underAttack = false;
			}

			if (mob.x + mob.realMob.getRegionWidth() > x && mob.x < x + 64
					&& mob.y > y + 48 && mob.y < y + 62) {
				mob.underAttack = false;
			}
		}
	}

	// save if it is being drawn or not*
}
