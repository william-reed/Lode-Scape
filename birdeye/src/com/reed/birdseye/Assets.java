package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;

public class Assets {

	static Texture itemSelector, buttons, character, material, level, floor,
			tree, hydration, bucket, corn, lake, farm, house, houseIn,
			craftmenu, crop, creeper, robot, robotGUI, ironOre, inventory, copperOre, grass,
			dpad, dpadLEFT, dpadRIGHT, dpadUP, dpadDOWN, pointsBar;
	static TextureRegion upChar, downChar, leftChar, rightChar, mainChar;
	
	//Spine stuffz
	static TextureAtlas treeAtlas, pickAtlas, leavesAtlas;
	static Animation treeAnim, pickRightAnim, leaveAnim;
	static SkeletonData treeSkeletonData, pickRightSkeletonData, leaveSkeletonData;
	
	static BitmapFont cgfFont;
	
	public static void load(){
		level = new Texture(Gdx.files.internal("map1test.png"));
		itemSelector = new Texture(Gdx.files.internal("itemselector.png"));
		crop = new Texture(Gdx.files.internal("crop.png"));
		// floor = new Texture(Gdx.files.internal("floor.png"));
		lake = new Texture(Gdx.files.internal("lake.png"));
		//buttons = new Texture(Gdx.files.internal("buttons.png"));
		bucket = new Texture(Gdx.files.internal("bucket.png"));
		hydration = new Texture(Gdx.files.internal("hydration.png"));
		corn = new Texture(Gdx.files.internal("corn.png"));
		character = new Texture(Gdx.files.internal("characters.png"));
		material = new Texture(Gdx.files.internal("material.png"));
		house = new Texture(Gdx.files.internal("hosue.png"));
		houseIn = new Texture(Gdx.files.internal("inhouse.png"));
		farm = new Texture(Gdx.files.internal("lilfarm2.png"));
		craftmenu = new Texture(Gdx.files.internal("craftingMenu.png"));
		//depreceated due to texture atlas
		//tree = new Texture(Gdx.files.internal("tree.png"));
		creeper = new Texture(Gdx.files.internal("creeper.png"));
		robot = new Texture(Gdx.files.internal("robot.png"));
		robotGUI = new Texture(Gdx.files.internal("robotGui.png"));
		ironOre = new Texture(Gdx.files.internal("ironOre.png"));
		inventory = new Texture(Gdx.files.internal("inventory.png"));
		copperOre = new Texture(Gdx.files.internal("copper.png"));
		grass = new Texture(Gdx.files.internal("grass.png"));
		dpad = new Texture(Gdx.files.internal("dPad.png"));
		dpadLEFT = new Texture(Gdx.files.internal("dpad_left.png"));
		dpadRIGHT = new Texture(Gdx.files.internal("dpad_right.png"));
		dpadUP = new Texture(Gdx.files.internal("dpad_up.png"));
		dpadDOWN = new Texture(Gdx.files.internal("dpad_down.png"));
		buttons = new Texture(Gdx.files.internal("buttonsGray.png"));
		pointsBar = new Texture(Gdx.files.internal("pointBar.png"));
		
		downChar = new TextureRegion(character, 32, 0, 32, 48);
		leftChar = new TextureRegion(character, 32, 48, 32, 48);
		rightChar = new TextureRegion(character, 32, 96, 32, 48);
		upChar = new TextureRegion(character, 32, 144, 32, 48);
		mainChar = downChar;
		
		treeAtlas = new TextureAtlas(Gdx.files.internal("tree.atlas"));
		SkeletonJson treeJson = new SkeletonJson(treeAtlas);
		treeSkeletonData = treeJson.readSkeletonData(Gdx.files.internal("tree.json"));
		treeAnim = treeSkeletonData.findAnimation("tree fall");
	
		pickAtlas = new TextureAtlas(Gdx.files.internal("pickaxe.atlas"));
		SkeletonJson pickRightJson = new SkeletonJson(pickAtlas);
		pickRightSkeletonData = pickRightJson.readSkeletonData(Gdx.files.internal("pick.json"));
		pickRightAnim = pickRightSkeletonData.findAnimation("animation");
		
		leavesAtlas = new TextureAtlas(Gdx.files.internal("leaves.atlas"));
		SkeletonJson leavesJson = new SkeletonJson(leavesAtlas);
		leaveSkeletonData = leavesJson.readSkeletonData(Gdx.files.internal("leavesSkel.json"));
		leaveAnim = leaveSkeletonData.findAnimation("animation");
		
		cgfFont = new BitmapFont(Gdx.files.internal("cgf.fnt"), Gdx.files.internal("cgf_0.png"), false);
	}
}
