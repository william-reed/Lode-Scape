package com.reed.birdseye;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {
	Game game;
	OrthographicCamera camera;
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont currentFont;
	Farm farm;
	Level level;
	Player player;
	// TEMP use arrayList for random or static assigned rocks
	Resource resource;
	ArrayListsz arrays;
	Crafting craft = new Crafting();
	TopMenu topMenu;
	Iron iron;
	Inventory inv;
	Copper copper;
	Tree tree, tre;
	CollisionDetection collision;
	Android android;
	Points points;

	Mob creeper;

	public GameScreen(Game game) {
		this.game = game;

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		level = new Level();
		player = new Player();
		resource = new Resource();
		arrays = new ArrayListsz();
		topMenu = new TopMenu();
		iron = new Iron();
		inv = new Inventory();
		copper = new Copper();
		tree = new Tree();
		tre = new Tree();
		// collision detection problem?
		collision = new CollisionDetection(400, 700, 20, 20);
		fps = new FPSLogger();
		android = new Android();
		points = new Points();

		creeper = new Mob(Assets.mainCreeper, Assets.upCreeper_STILL, Assets.upCreeper_LEFT,
				Assets.upCreeper_RIGHT, Assets.downCreeper_STILL,
				Assets.downCreeper_LEFT, Assets.downCreeper_RIGHT,
				Assets.leftCreeper_STILL, Assets.leftCreeper_LEFT,
				Assets.leftCreeper_RIGHT, Assets.rightCreeper_STILL,
				Assets.rightCreeper_LEFT, Assets.rightCreeper_RIGHT);

		if (Gdx.app.getType() == ApplicationType.Android) {
			currentFont = Assets.cgfFont;
		} else
			currentFont = new BitmapFont();
	}

	FPSLogger fps;

	public void update(float deltaTime) {
		// farm.closeEnoughToFarm();
		player.setSprites();
		player.move();
		player.input();
		craft.menuInput();
		craft.clicked();
		craft.placeResource();
		craft.placeTree();
		// iron.closeEnough();
		// iron.collect();
		topMenu.input();
		inv.input();
		// copper.closeEnough();
		// copper.collect();
		// collision.collisionDetector();
		points.updateLevel();
		level.update();
		creeper.boundingArea(0, 0, 300, 300);
		creeper.movement();
		creeper.attack();
		creeper.looseHealth();
		creeper.setSprites();

	}

	public void draw(float deltaTime) {

		// float delta = Gdx.graphics.getDeltaTime() / 3;
		// time += delta;

		Gdx.gl.glClearColor(255f, 255f, 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		level.draw(batch);

		arrays.resourceArrayEstablisher(batch, currentFont);
		arrays.treeArrayEstablisher(batch, currentFont);
		arrays.houseArrayEstablisher(batch, currentFont);
		// iron.draw(batch, currentFont);
		// copper.draw(batch, currentFont);
		topMenu.draw(batch, currentFont);
		craft.draw(batch, currentFont);
		inv.draw(batch, currentFont);
		creeper.draw(batch, currentFont);

		player.draw(batch, currentFont);
		// draws gui
		points.draw(batch);

		currentFont.draw(batch, "FPS : +" + Gdx.graphics.getFramesPerSecond(),
				800, 50);

		if (Gdx.app.getType() == ApplicationType.Android) {
			android.input();
			android.draw(batch);
		}

		batch.end();

		points.drawBars(shapeRenderer);
		creeper.healthBar(shapeRenderer);
		// arrays.treeArrayShapes(shapeRenderer);
	}

	@Override
	public void render(float delta) {
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
