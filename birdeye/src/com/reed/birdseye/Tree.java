package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tree {

	public int x, y, width = 64, height = 58;
	boolean treeFall = false;
	boolean treeDone = false;
	static int amountOfWood = 0;
	static String amountOfWoodString;
	int distanceFromMaterial = 100;
	SkeletonRenderer renderer = new SkeletonRenderer();

	Skeleton treeSkel = new Skeleton(Assets.treeSkeletonData);
	Bone root = treeSkel.getRootBone();
	Skeleton leavesSkel = new Skeleton(Assets.leaveSkeletonData);
	Bone leaveRoot = leavesSkel.getRootBone();

	void draw(SpriteBatch batch, BitmapFont font) {
		root.setX(x);
		root.setY(y);
		leaveRoot.setX(x);
		leaveRoot.setY(y);
		renderer.draw(batch, leavesSkel);
		renderer.draw(batch, treeSkel);
		// batch.draw(Assets.tree, x, y);
		if (closeEnough() && Player.ableToMove && !treeDone)
			font.draw(batch, "Press B to Pick up the Tree", 50, 50);
		treeSkel.updateWorldTransform();
		leavesSkel.updateWorldTransform();
	}

	void drawTrunk(SpriteBatch batch) {
		batch.draw(Assets.treeAtlas.findRegion("treeBottom"), x - 50, y);
	}

	void collision() {
		if (Player.x > x - 45 && Player.x < x - 20 && Player.y < y + 40
				&& Player.y > y - 20)
			Player.isAbleToMoveRight = false;
		if (Player.x > x + 10 && Player.x < x + 30 && Player.y < y + 40
				&& Player.y > y - 20) {
			Player.isAbleToMoveLeft = false;
		}
		if (Player.x > x - 41 && Player.x < x + 26 && Player.y < y + 40
				&& Player.y > y + 20) {
			Player.isAbleToMoveDown = false;
		}
		if (Player.x > x - 41 && Player.x < x + 26 && Player.y < y
				&& Player.y > y - 24) {
			Player.isAbleToMoveUp = false;
		}
	}

	boolean closeEnough() {
		return (Math.sqrt((x - Player.x) * (x - Player.x) + (y - Player.y)
				* (y - Player.y)) < distanceFromMaterial);
	}

	float treeFallTime, leavesTime;

	void leavesFall() {
		if (closeEnough() && !treeFall) {
			leavesTime += Gdx.graphics.getDeltaTime();
			Assets.leaveAnim.apply(leavesSkel, leavesTime, false);
		}
	}

	float chopTimer;

	void collectingTree() {
		amountOfWoodString = Integer.toString(amountOfWood);// update string
		if (closeEnough() && !treeFall) {
			if (Gdx.input.isKeyPressed(Keys.B) && TopMenu.currentTool == 2
					&& Tutorial.step >= 5) {
				chopTimer += Gdx.graphics.getDeltaTime();
				if (chopTimer > 2) {
					Points.xp += 1;
					amountOfWood += 4;
					treeFall = true;
				}
			}else
				chopTimer = 0;
		}
		if (treeFall && !treeDone) {
			float delta = Gdx.graphics.getDeltaTime(); // 3;
			treeFallTime += delta;
			Assets.treeAnim.apply(treeSkel, treeFallTime, false);
			if (treeFallTime > .9) {
				treeDone = true;
			}
		}
		if(Tutorial.step == 5 && amountOfWood >= 8){
			Tutorial.step = 6;
		}
	}
}
