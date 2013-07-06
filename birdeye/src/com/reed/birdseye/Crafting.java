package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Crafting {
	boolean craftMenuVisible = false;
	boolean placeResource, editResource;
	boolean placeTree, editTree;
	boolean placeHouse, editHouse;
	float craftTimer = 0;

	void menuInput() {
		if (Gdx.input.isKeyPressed(Keys.Z)) {
			craftMenuVisible = true;
			Player.ableToMove = false;
			Player.drawCharacter = false;
		}
		if (craftMenuVisible) {
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				Player.ableToMove = true;
				Player.drawCharacter = true;
				craftMenuVisible = false;
			}
		}
		// System.out.println("X " + Gdx.input.getX() + " Y: " +
		// Gdx.input.getY());
	}

	void draw(SpriteBatch batch, BitmapFont font) {
		if (craftMenuVisible)
			batch.draw(Assets.craftmenu, 0, 0);
		if (placeResource || placeTree || placeHouse)
			font.draw(batch, "Click where you want to place your item.", 50, 50);
		if (editResource || editTree || editHouse)
			font.draw(
					batch,
					"Use WASD to edit the current Postion. Press ENTER when done.",
					50, 50);
	}

	void clicked() {
		if (craftMenuVisible) {
			// detect clicking for tree
			if (Gdx.input.getX() > 120 && Gdx.input.getX() < 330
					&& Gdx.input.getY() > 100 && Gdx.input.getY() < 215) {
				if (Gdx.input.isTouched()) {
					ArrayListsz.amountOfTrees++;
					placeTree = true;
					craftMenuVisible = false;
				}
			}
			// clicking for resource
			if (Gdx.input.getX() > 120 && Gdx.input.getX() < 330
					&& Gdx.input.getY() > 215 && Gdx.input.getY() < 290) {
				if (Gdx.input.isTouched()) {
					ArrayListsz.amountOfResources++;
					placeResource = true;
					craftMenuVisible = false;
				}
			}
			// check for house
			if (Gdx.input.getX() > 120 && Gdx.input.getX() < 330
					&& Gdx.input.getY() > 290 && Gdx.input.getY() < 400) {
				if (Gdx.input.isTouched()) {
					ArrayListsz.amountOfHouse++;
					placeHouse = true;
					craftMenuVisible = false;
				}
			}
		}
	}

	void placeResource() {
		if (placeResource) {
			craftTimer += Gdx.graphics.getDeltaTime();
			if (Gdx.input.isTouched() && craftTimer > 1) {
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).x = Gdx.input
						.getX() + (int) (-1 * Level.levelX);
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).y = (int) ((-1 * Level.levelY)
						- Gdx.input.getY() + 540);
				editResource = true;
				craftTimer = 0;
				placeResource = false;
			}
		}
		if (editResource) {
			if (Gdx.input.isKeyPressed(Keys.W))
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).y++;
			if (Gdx.input.isKeyPressed(Keys.A))
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).x--;
			if (Gdx.input.isKeyPressed(Keys.S))
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).y--;
			if (Gdx.input.isKeyPressed(Keys.D))
				ArrayListsz.resourceArray
						.get(ArrayListsz.amountOfResources - 1).x++;
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				editResource = false;
				Player.move = true;
			}

		}
	}

	void placeTree() {
		if (placeTree) {
			craftTimer += Gdx.graphics.getDeltaTime();
			if (Gdx.input.isTouched() && craftTimer > 1) {
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).x = Gdx.input
						.getX() + (int) (-1 * Level.levelX);
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).y = (int) ((-1 * Level.levelY)
						- Gdx.input.getY() + 540);// + (int) (Level.levelY);
				editTree = true;
				craftTimer = 0;
				placeTree = false;
			}
		}
		if (editTree) {
			if (Gdx.input.isKeyPressed(Keys.W))
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).y++;
			if (Gdx.input.isKeyPressed(Keys.A))
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).x--;
			if (Gdx.input.isKeyPressed(Keys.S))
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).y--;
			if (Gdx.input.isKeyPressed(Keys.D))
				ArrayListsz.treeArray.get(ArrayListsz.amountOfTrees - 1).x++;
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				editTree = false;
				Player.move = true;
			}

		}
	}

	void placeHouse() {
		if (placeHouse) {
			craftTimer += Gdx.graphics.getDeltaTime();
			if (Gdx.input.isTouched() && craftTimer > 1) {
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).x = Gdx.input
						.getX() + (int) (-1 * Level.levelX);
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).y = (int) ((-1 * Level.levelY)
						- Gdx.input.getY() + 540);
				editHouse = true;
				craftTimer = 0;
				placeHouse = false;
			}
		}
		if (editHouse) {
			if (Gdx.input.isKeyPressed(Keys.W))
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).y++;
			if (Gdx.input.isKeyPressed(Keys.A))
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).x--;
			if (Gdx.input.isKeyPressed(Keys.S))
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).y--;
			if (Gdx.input.isKeyPressed(Keys.D))
				ArrayListsz.houseArray.get(ArrayListsz.amountOfHouse - 1).x++;
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				editHouse = false;
				Player.move = true;
			}

		}
	}
}
