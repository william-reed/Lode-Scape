package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	static Texture itemSelector, buttons, character, material, level, floor,
			tree, hydration, bucket, corn, lake, farm, house, houseIn,
			craftmenu, crop;
	static TextureRegion upChar, downChar, leftChar, rightChar, mainChar, grass;
	
	public static void load(){
		level = new Texture(Gdx.files.internal("map1test.png"));
		itemSelector = new Texture(Gdx.files.internal("itemselector.png"));
		crop = new Texture(Gdx.files.internal("crop.png"));
		// floor = new Texture(Gdx.files.internal("floor.png"));
		lake = new Texture(Gdx.files.internal("lake.png"));
		buttons = new Texture(Gdx.files.internal("buttons.png"));
		bucket = new Texture(Gdx.files.internal("bucket.png"));
		hydration = new Texture(Gdx.files.internal("hydration.png"));
		corn = new Texture(Gdx.files.internal("corn.png"));
		character = new Texture(Gdx.files.internal("characters.png"));
		material = new Texture(Gdx.files.internal("material.png"));
		house = new Texture(Gdx.files.internal("hosue.png"));
		houseIn = new Texture(Gdx.files.internal("inhouse.png"));
		farm = new Texture(Gdx.files.internal("lilfarm2.png"));
		craftmenu = new Texture(Gdx.files.internal("craftscreen.png"));
		tree = new Texture(Gdx.files.internal("tree.png"));
		// grass = new TextureRegion(floor, 0,0, 64, 64);
		downChar = new TextureRegion(character, 32, 0, 32, 48);
		leftChar = new TextureRegion(character, 32, 48, 32, 48);
		rightChar = new TextureRegion(character, 32, 96, 32, 48);
		upChar = new TextureRegion(character, 32, 144, 32, 48);
		mainChar = downChar;
	}
}
