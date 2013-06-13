package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonRenderer;

public class Tools {

	// pick stuff
	Skeleton toolSkel = new Skeleton(Assets.toolsMasterData);
	Bone root = toolSkel.getRootBone();

	final int toolY = 65;// draws at 65 from top of screen as shown below
	int toolX = 12;// draws at appropriate x coordinate
	final int startOfTopBar = Gdx.graphics.getWidth() / 2
			- (Assets.itemSelector.getWidth() / 2);
	final int width = 50, height = 50;
	final int boxWidth = 80;
	SkeletonRenderer renderer = new SkeletonRenderer();
	static boolean isTooling = false; // great name :)

	void draw(SpriteBatch batch) {
		// draw sword
		if (Tutorial.step >= 7) {
			batch.draw(Assets.toolsMasterAtlas.findRegion("w_shortsword_0"),
					(startOfTopBar + (3 * boxWidth)) + toolX,
					Gdx.graphics.getHeight() - toolY, 70, 70);
		}
		// draw pick axe
		batch.draw(Assets.toolsMasterAtlas.findRegion("pick"),
				(startOfTopBar + (0 * boxWidth)) + toolX,
				Gdx.graphics.getHeight() - toolY, 50, 50);
		if (Tutorial.step >= 5) {
			// draw hatchet
			batch.draw(Assets.toolsMasterAtlas.findRegion("gear_swords"),
					(startOfTopBar + (2 * boxWidth)) + toolX,
					Gdx.graphics.getHeight() - toolY, 50, 50);
		}
		if (Tutorial.step >= 2) {
			// draw fishing rod
			batch.draw(Assets.toolsMasterAtlas.findRegion("fishingrod"),
					(startOfTopBar + (1 * boxWidth)) + toolX,
					Gdx.graphics.getHeight() - toolY, 80, 80);
		}
	}

	void drawCurrentTool(SpriteBatch batch) {
		if ((Player.currentDirection == 2 || Player.currentDirection == 3)
				&& !(TopMenu.currentTool == 5) && !(TopMenu.currentTool == 4)) {
			if (Gdx.input.isKeyPressed(Keys.B)) {
				isTooling = true;
				renderer.draw(batch, toolSkel);
			} else {
				isTooling = false;
			}
		}
	}

	void changeTool() {
		if (TopMenu.currentTool == 0) {
			toolSkel.setSkin("pick");
			toolSkel.setSlotsToBindPose();
			toolSkel.updateWorldTransform();
		}
		if (TopMenu.currentTool == 1 && Tutorial.step >= 2) {
			toolSkel.setSkin("fishingRod");
			toolSkel.setSlotsToBindPose();
			toolSkel.updateWorldTransform();
		}
		if (TopMenu.currentTool == 2 && Tutorial.step >= 5) {
			toolSkel.setSkin("hatchet");
			toolSkel.setSlotsToBindPose();
			toolSkel.updateWorldTransform();
		}
		if (TopMenu.currentTool == 3 && Tutorial.step >= 7) {
			toolSkel.setSkin("sword");
			toolSkel.setSlotsToBindPose();
			toolSkel.updateWorldTransform();
		}
	}

	void direction() {
		if (Player.right) {
			root.setX(Level.middleX + 11);
			root.setY(Level.middleY - 11);
			toolSkel.setFlipX(false);
		}
		if (Player.left) {
			root.setX(Level.middleX + 20);
			root.setY(Level.middleY - 11);
			toolSkel.setFlipX(true);
		}
	}

	float timer;

	void update() {
		timer += Gdx.graphics.getDeltaTime() / 2;
		toolSkel.setSkin("sword");
		Assets.toolsMasterAnim.apply(toolSkel, timer, true);
		toolSkel.updateWorldTransform();
	}
	// FIX INVENTORY BOX clicking coordinates
}
