package com.reed.birdseye;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;

public class Mob {
	// randomly moving "mob" (animal, monster, etc)
	final int distanceFromMob = 100;
	Random r = new Random();
	int x = 500;
	int y = 500; // set to random *in bounding area*
	int direction = r.nextInt(5) + 1; // 0 = up, 1 = down, 2 = left, 3 = right,
										// 4 = no movement
	float mobTime = r.nextInt(3) + 1;
	// defines time left for movement - set to random int below 3
	final int speed = 1;
	static int food = 0;

	void draw(SpriteBatch batch, BitmapFont font, TextureRegion mainMob) {
		if (isAlive()) {
			batch.draw(mainMob, x, y);
		}
	}

	void movement() {
		// constantly decrease the mobTime
		if (!attackedMovement && isAlive()) {
			mobTime -= Gdx.graphics.getDeltaTime();
			if (direction == 0 && mobTime > 0) {
				y += speed;
			} else if (direction == 1 && mobTime > 0) {
				y -= speed;
			} else if (direction == 2 && mobTime > 0) {
				x -= speed;
			} else if (direction == 3 && mobTime > 0) {
				x += speed;
			} else if (direction == 4 && mobTime > 0) {
				// 4 means no movement
			} else {
				mobTime = r.nextInt(3) + 1;
				direction = r.nextInt(5) + 1;
			}
		}
	}

	void boundingArea(int xCord, int yCord, int width, int height) {
		if (x > xCord + width)
			direction = 2;
		if (x < xCord)
			direction = 3;
		if (y > yCord + height)
			direction = 1;
		if (y < yCord)
			direction = 0;
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Level.middleX) * (x - Level.middleX)
				+ (y - Level.middleY) * (y - Level.middleY)) < distanceFromMob);
	}

	// health etc
	float health = 100;
	float attackTimer;

	// attacks player when close enough
	void attack() {
		if (closeEnough() && attackTimer > 5 && isAlive()) {
			Points.looseHealth(r.nextInt(10));
			attackTimer = 0;
		}
		attackTimer += Gdx.graphics.getDeltaTime();
	}

	// draws health bar above mob
	void healthBar(ShapeRenderer shapeRenderer, TextureRegion mainMob) {
		if (isAlive()) {
			shapeRenderer.begin(ShapeType.Filled);
			// set to green for full mob health
			shapeRenderer.setColor(0, 255, 0, 1);
			shapeRenderer
					.rect(x - 8, y + mainMob.getRegionHeight() + 15, 50, 5);
			// set to red for current mob health
			shapeRenderer.setColor(255, 0, 0, 1);
			shapeRenderer.rect(x - 8, y + mainMob.getRegionHeight() + 10,
					(health / 100) * 50, 5);
			shapeRenderer.end();
		}
	}

	float dyingTimer;

	// takes away health from mob
	void looseHealth() {
		if (closeEnough() && TopMenu.currentTool == 0 && Tools.isTooling
				&& dyingTimer > 1) {
			health -= r.nextInt(20) + 10;
			dyingTimer = 0;
		}

		dyingTimer += Gdx.graphics.getDeltaTime();
	}

	// ensures that mob is alive (for drawing purposes)
	boolean isAlive() {
		if (health <= 0) {
			onGround = true;
			return false;
		} else
			return true;
	}

	boolean attackedMovement;

	/*
	 * //how am i going to do this??? void movementWhenAttacked(){
	 * if(!closeEnough() && attackedMovement){ if (target is to the left of me):
	 * move(left); else move(right);
	 * 
	 * if (target is above me): move(up); else move(down); } //if further than
	 * 100 pixels away move back to bounding area.
	 * 
	 * }
	 */

	float timer = 0;

	TextureRegion setSprites(TextureRegion upMob_STILL,
			TextureRegion upMob_LEFT, TextureRegion upMob_RIGHT,
			TextureRegion downMob_STILL, TextureRegion downMob_LEFT,
			TextureRegion downMob_RIGHT, TextureRegion rightMob_STILL,
			TextureRegion rightMob_LEFT, TextureRegion rightMob_RIGHT,
			TextureRegion leftMob_STILL, TextureRegion leftMob_LEFT,
			TextureRegion leftMob_RIGHT) {
		if (timer < 4)
			timer += .1f;
		else
			timer = 0;

		// walking right animation
		if (direction == 3) {
			if (timer < 1) {
				return rightMob_STILL;
			} else if (timer > 1 && timer < 2) {
				return rightMob_LEFT;
			} else if (timer > 2 && timer < 3) {
				return rightMob_STILL;
			} else if (timer > 3) {
				return rightMob_RIGHT;
			}
		}

		// walking left animation
		if (direction == 2) {
			if (timer < 1) {
				return leftMob_STILL;
			} else if (timer > 1 && timer < 2) {
				return leftMob_LEFT;
			} else if (timer > 2 && timer < 3) {
				return leftMob_STILL;
			} else if (timer > 3) {
				return leftMob_RIGHT;
			}
		}

		// walking up animation
		if (direction == 0) {
			if (timer < 1) {
				return upMob_STILL;
			} else if (timer > 1 && timer < 2) {
				return upMob_LEFT;
			} else if (timer > 2 && timer < 3) {
				return upMob_STILL;
			} else if (timer > 3) {
				return upMob_RIGHT;
			}
		}

		// walking down animation
		if (direction == 1) {
			if (timer < 1) {
				return downMob_STILL;
			} else if (timer > 1 && timer < 2) {
				return downMob_LEFT;
			} else if (timer > 2 && timer < 3) {
				return downMob_STILL;
			} else if (timer > 3) {
				return downMob_RIGHT;
			}
		}
		return downMob_STILL;
	}

	// animal drops
	boolean onGround = false;

	void drawDrops(SpriteBatch batch, Texture itemDropped) {
		if (!isAlive() && onGround) {
			batch.draw(itemDropped, x, y);
		}
	}

	void drops() {
		if (!isAlive() && closeEnough() && onGround) {
			food += 1;
			onGround = false;
		}
	}
}