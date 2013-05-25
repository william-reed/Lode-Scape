package com.reed.birdseye;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class ArrayListsz {
	static int amountOfResources = 5;
	static Array<Resource> resourceArray = new Array<Resource>();

	void resourceArrayEstablisher(SpriteBatch batch, BitmapFont font) {
		for (int i = 0; i < amountOfResources; i++) {
			resourceArray.add(new Resource());
		}

		resourceArray.get(0).x = 800;
		resourceArray.get(0).y = 800;
		resourceArray.get(1).x = 1200;
		resourceArray.get(1).y = 1200;
		resourceArray.get(2).x = 800;
		resourceArray.get(2).y = 1200;
		resourceArray.get(3).x = 1200;
		resourceArray.get(3).y = 800;
		resourceArray.get(4).x = 500;
		resourceArray.get(4).y = 1000;

		for (int i = 0; i < amountOfResources; i++) {
			resourceArray.get(i).draw(batch, font); // problem <--
			resourceArray.get(i).closeEnough();
			resourceArray.get(i).collect();
		}

	}

	static Array<Tree> treeArray = new Array<Tree>();
	static int amountOfTrees = 2;

	void treeArrayEstablisher(SpriteBatch batch, BitmapFont font) {
		for (int i = 0; i < amountOfTrees; i++)
			treeArray.add(new Tree());

		treeArray.get(0).x = 400;
		treeArray.get(0).y = 700;
		treeArray.get(1).x = 300;
		treeArray.get(1).y = 300;

		for (int i = 0; i < amountOfTrees; i++) {
			treeArray.get(i).draw(batch, font);
			treeArray.get(i).closeEnough();
			treeArray.get(i).collectingTree();
			treeArray.get(i).leavesFall();
		}
	}

	static Array<House> houseArray = new Array<House>();
	static int amountOfHouse = 1;

	void houseArrayEstablisher(SpriteBatch batch, BitmapFont font) {
		for (int i = 0; i < amountOfHouse; i++)
			houseArray.add(new House());

		houseArray.get(0).x = 800;
		houseArray.get(0).y = 900;
		
		for (int i = 0; i < amountOfHouse; i++) {
			//ERROR HERE...
			houseArray.get(i).draw(batch, font);
			houseArray.get(i).closeEnough();
			houseArray.get(i).gettingInandOut();
		}
	}
}
