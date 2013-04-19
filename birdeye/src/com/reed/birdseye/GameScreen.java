package com.reed.birdseye;

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
	BitmapFont font = new BitmapFont();
	Farm farm;
	Level level;
	Player player;
	// TEMP use arrayList for random or static assigned rocks
	Resource resource;
	ArrayListsz arrays;
	Crafting craft = new Crafting();
	TopMenu topMenu;
	Mob mob;
	Iron iron;
	Inventory inv;
	Copper copper;
	Tree tree, tre;
	CollisionDetection collision;

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
		mob = new Mob();
		iron = new Iron();
		inv = new Inventory();
		copper = new Copper();
		tree = new Tree();
		tre = new Tree();
		collision = new CollisionDetection(400, 700, 20, 20);
		fps = new FPSLogger();
	}

	FPSLogger fps;

	public void update(float deltaTime) {
 		// farm.closeEnoughToFarm();
		player.setSprites();
		player.move();
		player.update();
		craft.menuInput();
		craft.clicked();
		craft.placeResource();
		craft.placeTree();
		mob.movement();
		mob.boundingArea(300, 300, 500, 400);
		mob.closeEnough();
		mob.gui();
		iron.closeEnough();
		iron.collect();
		topMenu.input();
		inv.input();
		copper.closeEnough();
		copper.collect();
		collision.collisionDetector();
	}

	public void draw(float deltaTime) {
		
		// float delta = Gdx.graphics.getDeltaTime() / 3;
		// time += delta;

		Gdx.gl.glClearColor(255f, 255f, 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		level.draw(batch);
		
		batch.draw(Assets.grass, 0 ,0);
		arrays.resourceArrayEstablisher(batch, font);
		arrays.treeArrayEstablisher(batch, font);
		arrays.houseArrayEstablisher(batch, font);
		iron.draw(batch, font);
		copper.draw(batch, font);
		mob.draw(batch, font);
		topMenu.draw(batch, font);
		craft.draw(batch, font);
		inv.draw(batch, font);
		player.draw(batch, font);
		// draws gui
		mob.robotDraw(batch, font);

		// animation.apply(skeleton, time, false);
		// skeleton.updateWorldTransform();
		// skeleton.draw(batch);
		batch.end();
		
		collision.draw(shapeRenderer);

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
