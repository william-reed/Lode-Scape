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
		root.setX(Level.levelX + x);
		root.setY(Level.levelY + y);
		leaveRoot.setX(Level.levelX + x);
		leaveRoot.setY(Level.levelY + y);
		renderer.draw(batch, leavesSkel);
		renderer.draw(batch, treeSkel);
		// batch.draw(Assets.tree, Level.levelX + x, Level.levelY + y);
		if (closeEnough() && Player.move && !treeDone)
			font.draw(batch, "Press B to Pick up the Tree", 50, 50);
		treeSkel.updateWorldTransform();
		leavesSkel.updateWorldTransform();

	}

	boolean closeEnough() {
		return (Math.sqrt((Level.levelX + x - Level.middleX)
				* (Level.levelX + x - Level.middleX)
				+ (Level.levelY + y - Level.middleY)
				* (Level.levelY + y - Level.middleY)) < distanceFromMaterial);
	}

	float treeFallTime, leavesTime;

	void leavesFall() {
		if (closeEnough() && !treeFall) {
			leavesTime += Gdx.graphics.getDeltaTime();
			Assets.leaveAnim.apply(leavesSkel, leavesTime, false);
		}
	}

	void collectingTree() {
		amountOfWoodString = Integer.toString(amountOfWood);// update string
		if (closeEnough() && !treeFall) {
			if (Gdx.input.isKeyPressed(Keys.B) &&  TopMenu.currentTool == 2) {
				Points.xp += 1;
				amountOfWood += 4;
				treeFall = true;
			}
		}
		if (treeFall && !treeDone) {
			float delta = Gdx.graphics.getDeltaTime(); // 3;
			treeFallTime += delta;
			Assets.treeAnim.apply(treeSkel, treeFallTime, false);
			if (treeFallTime > .9) {
				treeDone = true;
			}
		}
	}

	void collision(ShapeRenderer shapeRenderer) {
		CollisionDetection collision = new CollisionDetection(x, y, 20, 20);
		collision.draw(shapeRenderer);
	}
}
