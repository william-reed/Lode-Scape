package com.reed.birdseye;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	Game game;
	OrthographicCamera camera;
	SpriteBatch batch;
	BitmapFont font = new BitmapFont();
	Farm farm;
	House house;
	Level level;
	Player player;
	//TEMP use arrayList for random or static assigned rocks
	Resource resource;
	
	public GameScreen(Game game) {
		this.game = game;

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		//farm = new Farm();
		house = new House();
		house.x= 1000;
		house.y= 950;
		level = new Level();
		player = new Player();
		resource = new Resource();
	}
	
	public void update(float deltaTime) {
		//farm.closeEnoughToFarm();
		//farm.farmTimer();
		house.closeEnough();
		house.gettingInandOut();
		player.move();
		player.setSprites();
	}

	public void draw(float deltaTime) {
		Gdx.gl.glClearColor(255f, 255f, 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		level.draw(batch);
		//farm.draw(batch, font);
		house.draw(batch, font);
		player.draw(batch);
		
		batch.end();
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
