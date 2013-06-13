package com.reed.birdseye;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;

public class Assets {

	static Texture itemSelector, buttons, character, material, tree, hydration,
			bucket, corn, farm, houseIn, craftmenu, crop, creeper,
			robot, robotGUI, ironOre, inventory, copperOre, grass, dpad,
			dpadLEFT, dpadRIGHT, dpadUP, dpadDOWN, pointsBar, currentItem, pig,
			bacon, wolf, chatBox, inHouse;

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
			rightPig_STILL, rightPig_LEFT, rightPig_RIGHT, mainPig,
			upWolf_STILL, upWolf_LEFT, upWolf_RIGHT, downWolf_STILL,
			downWolf_LEFT, downWolf_RIGHT, leftWolf_STILL, leftWolf_LEFT,
			leftWolf_RIGHT, rightWolf_STILL, rightWolf_LEFT, rightWolf_RIGHT,
			mainWolf;

	static TextureRegion shopOwner, tradePerson;

	// Spine stuffz
	static TextureAtlas treeAtlas, leavesAtlas, toolsMasterAtlas;
	static Animation treeAnim, leaveAnim, toolsMasterAnim;
	static SkeletonData treeSkeletonData, leaveSkeletonData, toolsMasterData;

	static BitmapFont cgfFont;

	static TiledMap mainTiledMap;

	public static void load() {
		itemSelector = new Texture(Gdx.files.internal("data/itemselector.png"));
		crop = new Texture(Gdx.files.internal("data/crop.png"));
		// buttons = new Texture(Gdx.files.internal("buttons.png"));
		bucket = new Texture(Gdx.files.internal("data/bucket.png"));
		hydration = new Texture(Gdx.files.internal("data/hydration.png"));
		corn = new Texture(Gdx.files.internal("data/corn.png"));
		character = new Texture(Gdx.files.internal("data/characters.png"));
		material = new Texture(Gdx.files.internal("data/material.png"));
		houseIn = new Texture(Gdx.files.internal("data/inhouse.png"));
		farm = new Texture(Gdx.files.internal("data/lilfarm2.png"));
		craftmenu = new Texture(Gdx.files.internal("data/craftingMenu.png"));
		// depreceated due to texture atlas
		// tree = new Texture(Gdx.files.internal("tree.png"));
		robot = new Texture(Gdx.files.internal("data/robot.png"));
		robotGUI = new Texture(Gdx.files.internal("data/robotGui.png"));
		ironOre = new Texture(Gdx.files.internal("data/ironOre.png"));
		inventory = new Texture(Gdx.files.internal("data/inventory.png"));
		copperOre = new Texture(Gdx.files.internal("data/copper.png"));
		grass = new Texture(Gdx.files.internal("data/grass.png"));
		dpad = new Texture(Gdx.files.internal("data/dPad.png"));
		dpadLEFT = new Texture(Gdx.files.internal("data/dpad_left.png"));
		dpadRIGHT = new Texture(Gdx.files.internal("data/dpad_right.png"));
		dpadUP = new Texture(Gdx.files.internal("data/dpad_up.png"));
		dpadDOWN = new Texture(Gdx.files.internal("data/dpad_down.png"));
		buttons = new Texture(Gdx.files.internal("data/buttonsGray.png"));
		pointsBar = new Texture(Gdx.files.internal("data/pointBar.png"));
		currentItem = new Texture(Gdx.files.internal("data/currentItem.png"));
		creeper = new Texture(Gdx.files.internal("data/creeperSprite.png"));
		pig = new Texture(Gdx.files.internal("data/pig.png"));
		wolf = new Texture(Gdx.files.internal("data/wolf.png"));
		inHouse = new Texture(Gdx.files.internal("data/inhouse.png"));
		chatBox = new Texture(Gdx.files.internal("data/chat.png"));

		shopOwner = new TextureRegion(character, 128, 192, 32, 48);
		tradePerson = new TextureRegion(character, 224, 192, 32, 48);

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
		// wolf animation
		downWolf_STILL = new TextureRegion(wolf, 48, 0, 48, 48);
		downWolf_LEFT = new TextureRegion(wolf, 0, 0, 48, 48);
		downWolf_RIGHT = new TextureRegion(wolf, 96, 0, 48, 48);
		rightWolf_STILL = new TextureRegion(wolf, 48, 48, 48, 48);
		rightWolf_LEFT = new TextureRegion(wolf, 0, 48, 48, 48);
		rightWolf_RIGHT = new TextureRegion(wolf, 96, 48, 48, 48);
		leftWolf_STILL = new TextureRegion(wolf, 48, 96, 48, 48);
		leftWolf_LEFT = new TextureRegion(wolf, 0, 96, 48, 48);
		leftWolf_RIGHT = new TextureRegion(wolf, 96, 96, 48, 48);
		upWolf_STILL = new TextureRegion(wolf, 48, 144, 48, 48);
		upWolf_LEFT = new TextureRegion(wolf, 0, 144, 48, 48);
		upWolf_RIGHT = new TextureRegion(wolf, 96, 144, 48, 48);

		// set to defaults - no nulls (yarg)
		mainCreeper = downCreeper_STILL;
		mainPig = downPig_STILL;
		mainRobot = downRobot_STILL;
		mainChar = downChar_STILL;

		treeAtlas = new TextureAtlas(Gdx.files.internal("data/tree.atlas"));
		SkeletonJson treeJson = new SkeletonJson(treeAtlas);
		treeSkeletonData = treeJson.readSkeletonData(Gdx.files
				.internal("data/tree.json"));
		treeAnim = treeSkeletonData.findAnimation("tree fall");

		leavesAtlas = new TextureAtlas(Gdx.files.internal("data/leaves.atlas"));
		SkeletonJson leavesJson = new SkeletonJson(leavesAtlas);
		leaveSkeletonData = leavesJson.readSkeletonData(Gdx.files
				.internal("data/leavesSkel.json"));
		leaveAnim = leaveSkeletonData.findAnimation("animation");

		toolsMasterAtlas = new TextureAtlas(
				Gdx.files.internal("data/toolAtlas.atlas"));
		SkeletonJson toolsMasterJson = new SkeletonJson(toolsMasterAtlas);
		toolsMasterData = toolsMasterJson.readSkeletonData(Gdx.files
				.internal("data/toolsMaster.json"));
		toolsMasterAnim = toolsMasterData.findAnimation("animation");

		cgfFont = new BitmapFont(Gdx.files.internal("data/cgf.fnt"),
				Gdx.files.internal("data/cgf_0.png"), false);

		// maps
		mainTiledMap = new TmxMapLoader().load("data/maps/Map.tmx");
	}
}
