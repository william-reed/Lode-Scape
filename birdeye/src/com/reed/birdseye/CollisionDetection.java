package com.reed.birdseye;

public class CollisionDetection {

	void doCollision() {
		// left wall
		if (Player.x < -844) {
			Player.isAbleToMoveLeft = false;
		}// segment 1
		else if (Player.y < 238 && Player.y > -850 && Player.x > 416
				&& Player.x < 436) {
			Player.isAbleToMoveLeft = false;
		}// segment 3
		else if (Player.y < 350 && Player.y > 210 && Player.x > 234
				&& Player.x < 292) {
			Player.isAbleToMoveLeft = false;
		}// segment 7
		else if (Player.y < 390 && Player.y > 290 && Player.x > 405
				&& Player.x < 430) {
			Player.isAbleToMoveLeft = false;
		}// segment 10
		else if (Player.y < 364 && Player.y > 286 && Player.x > 580
				&& Player.x < 610) {
			Player.isAbleToMoveLeft = false;
		}// segment 15
		else if (Player.y < 234 && Player.y > -1076 && Player.x > 2044
				&& Player.x < 2076) {
			Player.isAbleToMoveLeft = false;
		}// segment 17
		else if (Player.y < -1056 && Player.y > -1314 && Player.x > 1786
				&& Player.x < 1824) {
			Player.isAbleToMoveLeft = false;
		}// segment 21
		else if (Player.y < -1056 && Player.y > -1370 && Player.x > 1714
				&& Player.x < 1748) {
			Player.isAbleToMoveLeft = false;
		}// segment 23
		else if (Player.y < -894 && Player.y > -1080 && Player.x > 402
				&& Player.x < 436) {
			Player.isAbleToMoveLeft = false;
		}// segment 25
		else if (Player.y < -894 && Player.y > -1438 && Player.x > -72
				&& Player.x < -14) {
			Player.isAbleToMoveLeft = false;
		}// segment 27
		else if (Player.y < -1282 && Player.y > -1416 && Player.x > -252
				&& Player.x < -240) {
			Player.isAbleToMoveLeft = false;
		}// segment 29
		else if (Player.y < -894 && Player.y > -1286 && Player.x > -146
				&& Player.x < -106) {
			Player.isAbleToMoveLeft = false;
		}// segment 31
		else if (Player.y < -784 && Player.y > -920 && Player.x > -228
				&& Player.x < -188) {
			Player.isAbleToMoveLeft = false;
		}// segment 33
		else if (Player.y < -800 && Player.y > -850 && Player.x > -148
				&& Player.x < -110) {
			Player.isAbleToMoveLeft = false;
		}// segment 36
		else if (Player.y < 126 && Player.y > -400 && Player.x > 1936
				&& Player.x < 1976) {
			Player.isAbleToMoveLeft = false;
		}// segment 38 HOUSE NEAR TOP RIGHT OF MAP
		else if (Player.y < -386 && Player.y > -460 && Player.x > 1898
				&& Player.x < 1908) {
			Player.isAbleToMoveLeft = false;
		}// segment 40
		else if (Player.y < -448 && Player.y > -980 && Player.x > 1936
				&& Player.x < 1976) {
			Player.isAbleToMoveLeft = false;
		}// segment 42
		else if (Player.y < -496 && Player.y > -978 && Player.x > 1110
				&& Player.x < 1156) {
			Player.isAbleToMoveLeft = false;
		}// segment 46
		else if (Player.y < -432 && Player.y > -978 && Player.x > 1192
				&& Player.x < 1232) {
			Player.isAbleToMoveLeft = false;
		}// segment 48
		else if (Player.y < -208 && Player.y > -450 && Player.x > 506
				&& Player.x < 540) {
			Player.isAbleToMoveLeft = false;
		}// segment 52
		else if (Player.y < 118 && Player.y > -162 && Player.x > 506
				&& Player.x < 542) {
			Player.isAbleToMoveLeft = false;
		} else
			Player.isAbleToMoveLeft = true;

		if (Player.x > 2830) {
			Player.isAbleToMoveRight = false;
		}// segment 1
		else if (Player.y < 238 && Player.y > -850 && Player.x > 386
				&& Player.x < 425) {
			Player.isAbleToMoveRight = false;
		}// segment 3
		else if (Player.y < 350 && Player.y > 210 && Player.x > 244
				&& Player.x < 282) {
			Player.isAbleToMoveRight = false;
		}// segment 5
		else if (Player.y < 345 && Player.y > 286 && Player.x > 324
				&& Player.x < 344) {
			Player.isAbleToMoveRight = false;
		}// segment 8
		else if (Player.y < 390 && Player.y > 290 && Player.x > 500
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 12
		else if (Player.y < 344 && Player.y > 230 && Player.x > 642
				&& Player.x < 652) {
			Player.isAbleToMoveRight = false;
		}// segment 13
		else if (Player.y < 242 && Player.y > 206 && Player.x > 500
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 15
		else if (Player.y < 234 && Player.y > -1080 && Player.x > 2034
				&& Player.x < 2066) {
			Player.isAbleToMoveRight = false;
		}// segment 17
		else if (Player.y < -1056 && Player.y > -1314 && Player.x > 1774
				&& Player.x < 1808) {
			Player.isAbleToMoveRight = false;
		}// segment 19
		else if (Player.y < -1282 && Player.y > -1378 && Player.x > 2730
				&& Player.x < 2750) {
			Player.isAbleToMoveRight = false;
		}// segment 21
		else if (Player.y < -1056 && Player.y > -1386 && Player.x > 1700
				&& Player.x < 1738) {
			Player.isAbleToMoveRight = false;
		}// segment 23
		else if (Player.y < -894 && Player.y > -1080 && Player.x > 388
				&& Player.x < 426) {
			Player.isAbleToMoveRight = false;
		}// segment 25
		else if (Player.y < -894 && Player.y > -1438 && Player.x > -82
				&& Player.x < -44) {
			Player.isAbleToMoveRight = false;
		}// segment 29
		else if (Player.y < -894 && Player.y > -1286 && Player.x > -156
				&& Player.x < -116) {
			Player.isAbleToMoveRight = false;
		}// segment 31
		else if (Player.y < -784 && Player.y > -920 && Player.x > -240
				&& Player.x < -198) {
			Player.isAbleToMoveRight = false;
		}// segment 33
		else if (Player.y < -800 && Player.y > -850 && Player.x > -158
				&& Player.x < -130) {
			Player.isAbleToMoveRight = false;
		}// segment 36
		else if (Player.y < 126 && Player.y > -400 && Player.x > 1926
				&& Player.x < 1966) {
			Player.isAbleToMoveRight = false;
		}// segment 40
		else if (Player.y < -448 && Player.y > -980 && Player.x > 1924
				&& Player.x < 1966) {
			Player.isAbleToMoveRight = false;
		}// segment 44
		else if (Player.y < -496 && Player.y > -982 && Player.x > 496
				&& Player.x < 540) {
			Player.isAbleToMoveRight = false;
		}// segment 46
		else if (Player.y < -432 && Player.y > -978 && Player.x > 1182
				&& Player.x < 1222) {
			Player.isAbleToMoveRight = false;
		}// segment 48
		else if (Player.y < -208 && Player.y > -450 && Player.x > 496
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 50 ENTRANCE TO CENTRAL HOUSE
		else if (Player.y < -138 && Player.y > -226 && Player.x > 528
				&& Player.x < 538) {
			Player.isAbleToMoveRight = false;
		}// segment 52
		else if (Player.y < 118 && Player.y > -162 && Player.x > 496
				&& Player.x < 532) {
			Player.isAbleToMoveRight = false;
		} else
			Player.isAbleToMoveRight = true;

		// bottom wall
		if (Player.y < -3092) {
			Player.isAbleToMoveDown = false;
		}
		// segment 2
		else if (Player.y > 210 && Player.y < 242 && Player.x > 248
				&& Player.x < 432) {
			Player.isAbleToMoveDown = false;
		}// segment 14
		else if (Player.y > 216 && Player.y < 242 && Player.x > 500
				&& Player.x < 2064) {
			Player.isAbleToMoveDown = false;
		}// segment 16
		else if (Player.y > -1076 && Player.y < -1052 && Player.x > 1780
				&& Player.x < 2070) {
			Player.isAbleToMoveDown = false;
		}// segment 18
		else if (Player.y > -1308 && Player.y < -1282 && Player.x > 1780
				&& Player.x < 2878) {
			Player.isAbleToMoveDown = false;
		}// segment 20
		else if (Player.y > -1384 && Player.y < -1356 && Player.x > 1704
				&& Player.x < 2878) {
			Player.isAbleToMoveDown = false;
		}// segment 22
		else if (Player.y > -1078 && Player.y < -1052 && Player.x > 392
				&& Player.x < 1740) {
			Player.isAbleToMoveDown = false;
		}// segment 24
		else if (Player.y > -916 && Player.y < -890 && Player.x > -78
				&& Player.x < 426) {
			Player.isAbleToMoveDown = false;
		}// segment 26
		else if (Player.y > -1428 && Player.y < -1406 && Player.x > -294
				&& Player.x < -18) {
			Player.isAbleToMoveDown = false;
		}// segment 28
		else if (Player.y > -1284 && Player.y < -1268 && Player.x > -294
				&& Player.x < -110) {
			Player.isAbleToMoveDown = false;
		}// segment 30
		else if (Player.y > -916 && Player.y < -890 && Player.x > -236
				&& Player.x < -110) {
			Player.isAbleToMoveDown = false;
		}// segment 34
		else if (Player.y > -846 && Player.y < -816 && Player.x > -152
				&& Player.x < 428) {
			Player.isAbleToMoveDown = false;
		}// segment 35
		else if (Player.y > 102 && Player.y < 132 && Player.x > 500
				&& Player.x < 1970) {
			Player.isAbleToMoveDown = false;
		}// segment 37
		else if (Player.y > -396 && Player.y < -370 && Player.x > 1864
				&& Player.x < 1972) {
			Player.isAbleToMoveDown = false;
		}// segment 39
		else if (Player.y > -468 && Player.y < -444 && Player.x > 1864
				&& Player.x < 1972) {
			Player.isAbleToMoveDown = false;
		}// segment 41
		else if (Player.y > -976 && Player.y < -944 && Player.x > 1186
				&& Player.x < 1970) {
			Player.isAbleToMoveDown = false;
		}// segment 43
		else if (Player.y > -526 && Player.y < -492 && Player.x > 500
				&& Player.x < 1156) {
			Player.isAbleToMoveDown = false;
		}// segment 47
		else if (Player.y > -444 && Player.y < -416 && Player.x > 500
				&& Player.x < 1232) {
			Player.isAbleToMoveDown = false;
		}// segment 49
		else if (Player.y > -226 && Player.y < -204 && Player.x > 500
				&& Player.x < 570) {
			Player.isAbleToMoveDown = false;
		} else
			Player.isAbleToMoveDown = true;

		// top wall
		if (Player.y > 374) {
			Player.isAbleToMoveUp = false;
		}
		// segment 2
		else if (Player.y > 206 && Player.y < 232 && Player.x > 248
				&& Player.x < 432) {
			Player.isAbleToMoveUp = false;
		}// segment 4
		else if (Player.y > 338 && Player.y < 348 && Player.x > 287
				&& Player.x < 330) {
			Player.isAbleToMoveUp = false;
		}// segment 6
		else if (Player.y > 286 && Player.y < 300 && Player.x > 328
				&& Player.x < 430) {
			Player.isAbleToMoveUp = false;
		}// segment 9
		else if (Player.y > 286 && Player.y < 320 && Player.x > 506
				&& Player.x < 606) {
			Player.isAbleToMoveUp = false;
		}// segment 11
		else if (Player.y > 338 && Player.y < 350 && Player.x > 604
				&& Player.x < 662) {
			Player.isAbleToMoveUp = false;
		}// segment 14
		else if (Player.y > 206 && Player.y < 232 && Player.x > 500
				&& Player.x < 2064) {
			Player.isAbleToMoveUp = false;
		}// segment 16
		else if (Player.y > -1086 && Player.y < -1062 && Player.x > 1780
				&& Player.x < 2070) {
			Player.isAbleToMoveUp = false;
		}// segment 18
		else if (Player.y > -1318 && Player.y < -1292 && Player.x > 1780
				&& Player.x < 2878) {
			Player.isAbleToMoveUp = false;
		}// segment 20
		else if (Player.y > -1394 && Player.y < -1366 && Player.x > 1704
				&& Player.x < 2878) {
			Player.isAbleToMoveUp = false;
		}// segment 22
		else if (Player.y > -1088 && Player.y < -1062 && Player.x > 392
				&& Player.x < 1740) {
			Player.isAbleToMoveUp = false;
		}// segment 24
		else if (Player.y > -926 && Player.y < -900 && Player.x > -78
				&& Player.x < 426) {
			Player.isAbleToMoveUp = false;
		}// segment 26
		else if (Player.y > -1442 && Player.y < -1416 && Player.x > -294
				&& Player.x < -18) {
			Player.isAbleToMoveUp = false;
		}// segment 28
		else if (Player.y > -1294 && Player.y < -1258 && Player.x > -294
				&& Player.x < -110) {
			Player.isAbleToMoveUp = false;
		}// segment 30
		else if (Player.y > -926 && Player.y < -900 && Player.x > -236
				&& Player.x < -110) {
			Player.isAbleToMoveUp = false;
		}// segment 32 DOOR WAY NEAR RIVER HOUSE
		else if (Player.y > -816 && Player.y < -800 && Player.x > -200
				&& Player.x < -126) {
			Player.isAbleToMoveUp = false;
		}// segment 34
		else if (Player.y > -856 && Player.y < -830 && Player.x > -152
				&& Player.x < 428) {
			Player.isAbleToMoveUp = false;
		}// segment 35
		else if (Player.y > 92 && Player.y < 122 && Player.x > 500
				&& Player.x < 1970) {
			Player.isAbleToMoveUp = false;
		}// segment 37
		else if (Player.y > -406 && Player.y < -384 && Player.x > 1864
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 39
		else if (Player.y > -478 && Player.y < -454 && Player.x > 1864
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 41
		else if (Player.y > -982 && Player.y < -962 && Player.x > 1186
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 45
		else if (Player.y > -982 && Player.y < -962 && Player.x > 500
				&& Player.x < 1152) {
			Player.isAbleToMoveUp = false;
		}// segment 47
		else if (Player.y > -454 && Player.y < -430 && Player.x > 500
				&& Player.x < 1232) {
			Player.isAbleToMoveUp = false;
		}// segment 51
		else if (Player.y > -168 && Player.y < -138 && Player.x > 500
				&& Player.x < 570) {
			Player.isAbleToMoveUp = false;
		} else
			Player.isAbleToMoveUp = true;
	}
}
