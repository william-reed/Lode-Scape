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
				CollisionDetection.setCollisionType(1);
				// temporary delete after proper collision is set up
				Player.isAbleToMoveUp = true;
				Player.isAbleToMoveRight = true;
				Player.isAbleToMoveDown = true;
				Player.isAbleToMoveLeft = true;
				GameScreen.mapRenderer.setMap(Assets.riverHouse);
				// set cordinates
				GameScreen.mapCamera.position.x = Gdx.graphics.getWidth() / 2;
				GameScreen.mapCamera.position.y = 300;
				// draw player in correct spot
				Player.x = Gdx.graphics.getWidth() / 2;
				Player.y = 400;// adjust a little
				// get rid of grass (set to what? blackness)

				// get rid of darkness. (how to set back to normal levels when
				//  you exit *looks around franticly* -- set up currentAmbient
				//  light and outdoor ambient light variables.
				// finally set to false
				justEntered = false;

			}
			// check for collision (will be done in gamescreen class thanks to a
			// switch statment)
			// check for bed (prob add its own method) must be close enough (add
			// close enough method)
			// stove / oven method stuff
			// allow for exit of house ability set justExited to true
		} else {
			if (justExited) {
				GameScreen.mapRenderer.setMap(Assets.mainTiledMap);
				// redraw grass
				// do normal collision
				CollisionDetection.setCollisionType(0);
				justExited = false;
			}
		}
	}

	void gettingOut() {
		//set cordinates for exit door
		if(){
			
		}
	}
}
