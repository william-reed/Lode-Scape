package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Crafting {
	boolean craftMenuVisible = false;
	boolean selectingImageSpot = false;
	boolean editImageSpot = false;
	GameMain mainGame = new GameMain();
/*
	void menuInput() {
		if (Gdx.input.isKeyPressed(Keys.Z)) {
			craftMenuVisible = true;
			mainGame.move = false;
		}
		if (craftMenuVisible) {
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				mainGame.move = true;
				craftMenuVisible = false;
			}
		}
	}

	public void rollOver(SpriteBatch apples, int x, int y, int width,
			int height, String derp, int stringX, int stringY) {
		if (Gdx.input.getX() > x && Gdx.input.getX() < x + width
				&& Gdx.input.getY() > y && Gdx.input.getY() < y + height) {
			mainGame.font.setColor(190, 190, 190, 1);
			mainGame.font.draw(apples, derp, stringX, stringY);
			mainGame.font.setColor(1, 1, 1, 1);
			if (Gdx.input.isTouched()) {
				craftMenuVisible = false;
				selectingImageSpot = true;
			}
		}
	}

	/*
	 * public boolean rollOver(SpriteBatch apples, int x, int y, int width, int
	 * height, String derp, int stringX, int stringY) { if (Gdx.input.getX() > x
	 * && Gdx.input.getX() < x + width && Gdx.input.getY() > y &&
	 * Gdx.input.getY() < y + height) { return true; /*
	 * mainGame.font.setColor(190, 190, 190, 1); mainGame.font.draw(apples,
	 * derp, stringX, stringY); mainGame.font.setColor(1, 1, 1, 1); if
	 * (Gdx.input.isTouched()) { //craftMenuVisible = false;*
	 * //selectingImageSpot = true; } } return false;}
	 */

	int x, y;
/*
	void placeImage() {
		if (selectingImageSpot) {
			if (Gdx.input.isTouched()) {
				System.out.println("X pos: " + Gdx.input.getX() + " Y Pos: "
						+ Gdx.input.getY());
				System.out.println("Level X: " + mainGame.getLevelX() + " LevelY "
						+ mainGame.getLevelY());
				x = Gdx.input.getX() + (int) (-1 * mainGame.getLevelX());
				y = Gdx.input.getY() + (int) (-1 * mainGame.getLevelY());
				mainGame.treeArray.get(mainGame.currentTree).x = x;
				mainGame.treeArray.get(mainGame.currentTree).y = y;
				mainGame.currentTree++;
				mainGame.amountOfTrees++;
				editImageSpot = true;
				selectingImageSpot = false;
			}
		}
	}

	void editImageSpot(Texture someTexture) {
		if (!mainGame.move && editImageSpot) {
			if (Gdx.input.isKeyPressed(Keys.W))
				mainGame.treeArray.get(mainGame.currentTree).y++;
			if (Gdx.input.isKeyPressed(Keys.A))
				mainGame.treeArray.get(mainGame.currentTree).x--;
			if (Gdx.input.isKeyPressed(Keys.S))
				mainGame.treeArray.get(mainGame.currentTree).y--;
			if (Gdx.input.isKeyPressed(Keys.D))
				mainGame.treeArray.get(mainGame.currentTree).x++;
		}
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			mainGame.move = true;
			editImageSpot = false;
		}
		// drawPlacedObject(x, y, someTexture);
	}

	void drawMenu(SpriteBatch batch) {
		if (craftMenuVisible) {
			batch.draw(Assets.craftmenu, 0, 0);
			mainGame.font.setColor(0, 0, 0, 1);
			mainGame.font.draw(batch, "Tree", 200, 400);
			mainGame.font.setColor(1, 1, 1, 1);
			rollOver(batch, 135, 130, 680, 30, "Tree", 200, 400);
		}
		if (selectingImageSpot) {
			mainGame.font.draw(batch,
					"Press where you want the object", 50, 50);
		}
		if (editImageSpot) {
			mainGame.font.draw(batch,
					"Use WASD to move the object", 50, 50);
		}
	}

	void drawPlacedObject(int x, int y, Texture texture, SpriteBatch batch) {
		batch.draw(texture, mainGame.getLevelX() + x, mainGame.getLevelY()
				+ y);
	}
	*/
}
