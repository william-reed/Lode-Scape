package com.reed.birdseye;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class ArrayListsz {

	static Array<Coal> coalArray = new Array<Coal>();

	void coalArrayEstablisher() {
		coalArray.add(new Coal(2290, 1798));
		coalArray.add(new Coal(1618, 2022));
		coalArray.add(new Coal(1844, 1652));
	}

	void updateCoal() {
		for (int i = 0; i < coalArray.size; i++) {
			coalArray.get(i).collect();
			coalArray.get(i).regeneration();
			coalArray.get(i).playerCollision();
		}

	}

	void drawCoal(SpriteBatch batch) {
		for (int i = 0; i < coalArray.size; i++)
			coalArray.get(i).draw(batch);
	}

	static Array<Tree> treeArray = new Array<Tree>();
	final int amountOfTrees = 2;

	void treeArrayEstablisher() {
		for (int i = 0; i < amountOfTrees; i++)
			treeArray.add(new Tree());

		treeArray.get(0).x = 1258;
		treeArray.get(0).y = 2236;
		treeArray.get(1).x = 1158;
		treeArray.get(1).y = 2016;
	}

	void drawBrush(SpriteBatch batch, BitmapFont font) {
		for (int i = 0; i < treeArray.size; i++) {
			treeArray.get(i).draw(batch, font);
			treeArray.get(i).closeEnough();
			treeArray.get(i).collectingTree();
			treeArray.get(i).leavesFall();
			treeArray.get(i).collision();
		}
	}

	void drawTreeTrunk(SpriteBatch batch) {
		for (int i = 0; i < treeArray.size; i++) {
			treeArray.get(i).drawTrunk(batch);
		}
	}

	// All the pig stuff
	static Array<Pig> pigArray = new Array<Pig>();
	static int amountOfPigs = 4;

	void pigArrayEstablisher() {
		for (int i = 0; i < amountOfPigs; i++)
			pigArray.add(new Pig());
	}

	void pigUpdateAndDraw(SpriteBatch batch) {
		for (int i = 0; i < pigArray.size; i++) {
			pigArray.get(i).drops(batch);
			pigArray.get(i).pig.draw(batch, pigArray.get(i).theRealPig);
			pigArray.get(i).update();
			pigArray.get(i).regeneration();
			for (int j = 0; j < coalArray.size; j++) {
				coalArray.get(j).mobCollision(pigArray.get(i).pig);
			}
		}
	}

	void pigHealthBars(ShapeRenderer shapeRenderer) {
		for (int i = 0; i < pigArray.size; i++) {
			pigArray.get(i).pig.healthBar(shapeRenderer,
					pigArray.get(i).theRealPig);
		}
	}

	// all creeper stuff
	static Array<Mob> creeperArray = new Array<Mob>();
	static int amountOfMobs = 2;

	void mobArrayEstablisher() {
		for (int i = 0; i < amountOfMobs; i++)
			creeperArray.add(new Mob(1562, 1264, 1000, 918));
	}

	void mobUpdate() {
		for (int i = 0; i < creeperArray.size; i++) {

			creeperArray.get(i).realMob = creeperArray.get(i).setSprites(
					Assets.upCreeper_STILL, Assets.upCreeper_LEFT,
					Assets.upCreeper_RIGHT, Assets.downCreeper_STILL,
					Assets.downCreeper_LEFT, Assets.downCreeper_RIGHT,
					Assets.leftCreeper_STILL, Assets.leftCreeper_LEFT,
					Assets.leftCreeper_RIGHT, Assets.rightCreeper_STILL,
					Assets.rightCreeper_LEFT, Assets.rightCreeper_RIGHT);
			creeperArray.get(i).movement();
			creeperArray.get(i).attack();
			creeperArray.get(i).looseHealth();
			creeperArray.get(i).boundingArea();
			creeperArray.get(i).follow();
			creeperArray.get(i).detectIfUnderAttack();
			creeperArray.get(i).regeneration();

			for (int j = 0; j < coalArray.size; j++) {
				// if not under attack
				if (!creeperArray.get(i).underAttack) {
					coalArray.get(j).mobCollision(creeperArray.get(i));
				} else { // assume that it is under attack then
					coalArray.get(j).mobUnderAttackCollision(
							creeperArray.get(i));
				}
			}

		}
	}

	void mobDraw(SpriteBatch batch) {
		for (int i = 0; i < creeperArray.size; i++) {
			creeperArray.get(i).draw(batch, creeperArray.get(i).realMob);
		}
	}

	void mobHealthBars(ShapeRenderer shapeRenderer) {
		for (int i = 0; i < creeperArray.size; i++) {
			creeperArray.get(i).healthBar(shapeRenderer,
					creeperArray.get(i).realMob);
		}
	}
}
