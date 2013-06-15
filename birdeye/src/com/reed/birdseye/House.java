package com.reed.birdseye;

import com.badlogic.gdx.Gdx;

public class House {

	static boolean isInRiverHouse = false;
	// booleans for a run once code strip
	boolean justEntered = true, justExited = false;

	void update() {
		// variable becomes true through the collision class
		if (isInRiverHouse) {
			if (justEntered) {
				GameScreen.mapRenderer.setMap(Assets.riverHouse);
				// set cordinates
				GameScreen.mapCamera.position.x = Gdx.graphics.getWidth() / 2;
				GameScreen.mapCamera.position.y = 300;
				// draw player in correct spot
				// get rid of grass
				// set to house collision (set up different types of collision <makes sense in the long run it seems....<)
				//finally set to false
				justEntered = false;
				
			}
			// check for collision
		} else {
			if (justExited) {
				GameScreen.mapRenderer.setMap(Assets.mainTiledMap);
				// redraw grass
				// do normal collision
			}
		}
	}

	void gettingOut() {
		//set cordinates for exit door
		if(){
			
		}
	}
}
