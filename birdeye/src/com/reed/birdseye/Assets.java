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

	static Texture itemSelector, buttons, character, material, floor,
			tree, hydration, bucket, corn, lake, farm, house, houseIn,
			craftmenu, crop, creeper, robot, robotGUI, ironOre, inventory,
			copperOre, grass, dpad, dpadLEFT, dpadRIGHT, dpadUP, dpadDOWN,
			pointsBar, currentItem, pig, bacon, map;

	static TextureRegion upChar_STILL, upChar_LEFT, upChar_RIGHT,
			downChar_STILL, downChar_LEFT, downChar_RIGHT, leftChar_STILL,
			leftChar_LEFT, leftChar_RIGHT, rightChar_STILL, rightChar_LEFT,
			rightChar_RIGHT, mainChar, upCreeper_STILL, upCreeper_LEFT,
			upCreeper_RIGHT, downCreeper_STILL, downCreeper_LEFT,
			downCreeper_RIGHT, leftCreeper_STILL, leftCreeper_LEFT,
			leftCreeper_RIGHT, rightCreeper_STILL, rightCreeper_LEFT,
			rightCreeper_RIGHT, mainCreeper, upRobot_STILL, upRobot_LEFT,
			upRobot_RIGHT, downRobot_STILL, downRobot_LEFT, downRobot_RIGHT,
			leftRobot_STILL, leftRobot_LEFT, leftRobot_RIGHT, rightRobot_STILL,
			rightRobot_LEFT, rightRobot_RIGHT, mainRobot, upPig_STILL,
			upPig_LEFT, upPig_RIGHT, downPig_STILL, downPig_LEFT,
			downPig_RIGHT, leftPig_STILL, leftPig_LEFT, leftPig_RIGHT,
			rightPig_STILL, rightPig_LEFT, rightPig_RIGHT, mainPig;
	
	static TextureRegion shopOwner;

	// Spine stuffz
	static TextureAtlas treeAtlas, leavesAtlas, toolsMasterAtlas;
	static Animation treeAnim, leaveAnim, toolsMasterAnim;
	static SkeletonData treeSkeletonData, leaveSkeletonData, toolsMasterData;

	static BitmapFont cgfFont;

	public static void load() {
		map = new Texture(Gdx.files.internal("Map.png"));
		itemSelector = new Texture(Gdx.files.internal("itemselector.png"));
		crop = new Texture(Gdx.files.internal("crop.png"));
		// floor = new Texture(Gdx.files.internal("floor.png"));
		lake = new Texture(Gdx.files.internal("lake.png"));
		// buttons = new Texture(Gdx.files.internal("buttons.png"));
		bucket = new Texture(Gdx.files.internal("bucket.png"));
		hydration = new Texture(Gdx.files.internal("hydration.png"));
		corn = new Texture(Gdx.files.internal("corn.png"));
		character = new Texture(Gdx.files.internal("characters.png"));
		material = new Texture(Gdx.files.internal("material.png"));
		house = new Texture(Gdx.files.internal("hosue.png"));
		houseIn = new Texture(Gdx.files.internal("inhouse.png"));
		farm = new Texture(Gdx.files.internal("lilfarm2.png"));
		craftmenu = new Texture(Gdx.files.internal("craftingMenu.png"));
		// depreceated due to texture atlas
		// tree = new Texture(Gdx.files.internal("tree.png"));
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
		currentItem = new Texture(Gdx.files.internal("currentItem.png"));
		creeper = new Texture(Gdx.files.internal("creeperSprite.png"));
		pig = new Texture(Gdx.files.internal("pig.png"));
		bacon = new Texture(Gdx.files.internal("Bacon.png"));
		
		shopOwner = new TextureRegion(character, 128, 192, 32, 48);
		
		// character animations
		downChar_STILL = new TextureRegion(character, 32, 0, 32, 48);
		downChar_LEFT = new TextureRegion(character, 0, 0, 32, 48);
		downChar_RIGHT = new TextureRegion(character, 64, 0, 32, 48);
		leftChar_STILL = new TextureRegion(character, 32, 48, 32, 48);
		leftChar_LEFT = new TextureRegion(character, 0, 48, 32, 48);
		leftChar_RIGHT = new TextureRegion(character, 64, 48, 32, 48);
		rightChar_STILL = new TextureRegion(character, 32, 96, 32, 48);
		rightChar_LEFT = new TextureRegion(character, 0, 96, 32, 48);
		rightChar_RIGHT = new TextureRegion(character, 64, 96, 32, 48);
		upChar_STILL = new TextureRegion(character, 32, 144, 32, 48);
		upChar_LEFT = new TextureRegion(character, 0, 144, 32, 48);
		upChar_RIGHT = new TextureRegion(character, 64, 144, 32, 48);
		// creeper animations
		downCreeper_STILL = new TextureRegion(creeper, 32, 0, 32, 48);
		downCreeper_LEFT = new TextureRegion(creeper, 0, 0, 32, 48);
		downCreeper_RIGHT = new TextureRegion(creeper, 64, 0, 32, 48);
		leftCreeper_STILL = new TextureRegion(creeper, 32, 48, 32, 48);
		leftCreeper_LEFT = new TextureRegion(creeper, 0, 48, 32, 48);
		leftCreeper_RIGHT = new TextureRegion(creeper, 64, 48, 32, 48);
		rightCreeper_STILL = new TextureRegion(creeper, 32, 96, 32, 48);
		rightCreeper_LEFT = new TextureRegion(creeper, 0, 96, 32, 48);
		rightCreeper_RIGHT = new TextureRegion(creeper, 64, 96, 32, 48);
		upCreeper_STILL = new TextureRegion(creeper, 32, 144, 32, 48);
		upCreeper_LEFT = new TextureRegion(creeper, 0, 144, 32, 48);
		upCreeper_RIGHT = new TextureRegion(creeper, 64, 144, 32, 48);
		// robot animations
		downRobot_STILL = new TextureRegion(robot, 32, 0, 32, 48);
		downRobot_LEFT = new TextureRegion(robot, 0, 0, 32, 48);
		downRobot_RIGHT = new TextureRegion(robot, 64, 0, 32, 48);
		leftRobot_STILL = new TextureRegion(robot, 32, 48, 32, 48);
		leftRobot_LEFT = new TextureRegion(robot, 0, 48, 32, 48);
		leftRobot_RIGHT = new TextureRegion(robot, 64, 48, 32, 48);
		rightRobot_STILL = new TextureRegion(robot, 32, 96, 32, 48);
		rightRobot_LEFT = new TextureRegion(robot, 0, 96, 32, 48);
		rightRobot_RIGHT = new TextureRegion(robot, 64, 96, 32, 48);
		upRobot_STILL = new TextureRegion(robot, 32, 144, 32, 48);
		upRobot_LEFT = new TextureRegion(robot, 0, 144, 32, 48);
		upRobot_RIGHT = new TextureRegion(robot, 64, 144, 32, 48);
		// pig animations
		downPig_STILL = new TextureRegion(pig, 32, 0, 32, 48);
		downPig_LEFT = new TextureRegion(pig, 0, 0, 32, 48);
		downPig_RIGHT = new TextureRegion(pig, 64, 0, 32, 48);
		leftPig_STILL = new TextureRegion(pig, 32, 48, 32, 48);
		leftPig_LEFT = new TextureRegion(pig, 0, 48, 32, 48);
		leftPig_RIGHT = new TextureRegion(pig, 64, 48, 32, 48);
		rightPig_STILL = new TextureRegion(pig, 32, 96, 32, 48);
		rightPig_LEFT = new TextureRegion(pig, 0, 96, 32, 48);
		rightPig_RIGHT = new TextureRegion(pig, 64, 96, 32, 48);
		upPig_STILL = new TextureRegion(pig, 32, 144, 32, 48);
		upPig_LEFT = new TextureRegion(pig, 0, 144, 32, 48);
		upPig_RIGHT = new TextureRegion(pig, 64, 144, 32, 48);
		
		//set to defaults - no nulls (yarg)
		mainCreeper = downCreeper_STILL;
		mainPig = downPig_STILL;
		mainRobot = downRobot_STILL;
		mainChar = downChar_STILL;

		treeAtlas = new TextureAtlas(Gdx.files.internal("tree.atlas"));
		SkeletonJson treeJson = new SkeletonJson(treeAtlas);
		treeSkeletonData = treeJson.readSkeletonData(Gdx.files
				.internal("tree.json"));
		treeAnim = treeSkeletonData.findAnimation("tree fall");

		leavesAtlas = new TextureAtlas(Gdx.files.internal("leaves.atlas"));
		SkeletonJson leavesJson = new SkeletonJson(leavesAtlas);
		leaveSkeletonData = leavesJson.readSkeletonData(Gdx.files
				.internal("leavesSkel.json"));
		leaveAnim = leaveSkeletonData.findAnimation("animation");

		toolsMasterAtlas = new TextureAtlas(
				Gdx.files.internal("toolAtlas.atlas"));
		SkeletonJson toolsMasterJson = new SkeletonJson(toolsMasterAtlas);
		toolsMasterData = toolsMasterJson.readSkeletonData(Gdx.files
				.internal("toolsMaster.json"));
		toolsMasterAnim = toolsMasterData.findAnimation("animation");

		cgfFont = new BitmapFont(Gdx.files.internal("cgf.fnt"),
				Gdx.files.internal("cgf_0.png"), false);
	}
}
