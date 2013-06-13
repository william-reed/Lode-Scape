package com.reed.birdseye;

public class CollisionDetection {

	void doCollision() {
		// left wall
		if (Player.x < 110) {
			Player.isAbleToMoveLeft = false;
		}// segment 1
		else if (Player.y < 3554 && Player.y > 2466 && Player.x > 1374
				&& Player.x < 1394) {
			Player.isAbleToMoveLeft = false;
		}// segment 3
		else if (Player.y < 3666 && Player.y > 3526 && Player.x > 1192
				&& Player.x < 1250) {
			Player.isAbleToMoveLeft = false;
		}// segment 7
		else if (Player.y < 3706 && Player.y > 3606 && Player.x > 1363
				&& Player.x < 1388) {
			Player.isAbleToMoveLeft = false;
		}// segment 10
		else if (Player.y < 3680 && Player.y > 3602 && Player.x > 1538
				&& Player.x < 1568) {
			Player.isAbleToMoveLeft = false;
		}// segment 15
		else if (Player.y < 3550 && Player.y > 2240 && Player.x > 3002
				&& Player.x < 3034) {
			Player.isAbleToMoveLeft = false;
		}// segment 17
		else if (Player.y < 2260 && Player.y > 2002 && Player.x > 2744
				&& Player.x < 2782) {
			Player.isAbleToMoveLeft = false;
		}// segment 21
		else if (Player.y < 2260 && Player.y > 1946 && Player.x > 2672
				&& Player.x < 2706) {
			Player.isAbleToMoveLeft = false;
		}// segment 23
		else if (Player.y < 2422 && Player.y > 2236 && Player.x > 1360
				&& Player.x < 1394) {
			Player.isAbleToMoveLeft = false;
		}// segment 25
		else if (Player.y < 2422 && Player.y > 1878 && Player.x > 886
				&& Player.x < 944) {
			Player.isAbleToMoveLeft = false;
		}// segment 27
		else if (Player.y < 2034 && Player.y > 1900 && Player.x > 706
				&& Player.x < 718) {
			Player.isAbleToMoveLeft = false;
		}// segment 29
		else if (Player.y < 2422 && Player.y > 2030 && Player.x > 812
				&& Player.x < 852) {
			Player.isAbleToMoveLeft = false;
		}// segment 31
		else if (Player.y < 2532 && Player.y > 2396 && Player.x > 730
				&& Player.x < 770) {
			Player.isAbleToMoveLeft = false;
		}// segment 33
		else if (Player.y < 2516 && Player.y > 2466 && Player.x > 810
				&& Player.x < 848) {
			Player.isAbleToMoveLeft = false;
		}// segment 36
		else if (Player.y < 3442 && Player.y > 2916 && Player.x > 2894
				&& Player.x < 2934) {
			Player.isAbleToMoveLeft = false;
		}// segment 38 HOUSE NEAR TOP RIGHT OF MAP
		else if (Player.y < 2930 && Player.y > 2856 && Player.x > 2856
				&& Player.x < 2866) {
			Player.isAbleToMoveLeft = false;
		}// segment 40
		else if (Player.y < 2868 && Player.y > 2336 && Player.x > 2894
				&& Player.x < 2934) {
			Player.isAbleToMoveLeft = false;
		}// segment 42
		else if (Player.y < 2820 && Player.y > 2338 && Player.x > 2068
				&& Player.x < 2114) {
			Player.isAbleToMoveLeft = false;
		}// segment 46
		else if (Player.y < 2884 && Player.y > 2338 && Player.x > 2150
				&& Player.x < 2190) {
			Player.isAbleToMoveLeft = false;
		}// segment 48
		else if (Player.y < 3108 && Player.y > 2866 && Player.x > 1464
				&& Player.x < 1498) {
			Player.isAbleToMoveLeft = false;
		}// segment 52
		else if (Player.y < 3434 && Player.y > 3154 && Player.x > 1464
				&& Player.x < 1500) {
			Player.isAbleToMoveLeft = false;
		}// segment 53
		else if (Player.y < 2258 && Player.y > 1878 && Player.x > 1466
				&& Player.x < 1502) {
			Player.isAbleToMoveLeft = false;
		}
		else
			Player.isAbleToMoveLeft = true;

		if (Player.x > 3788) {
			Player.isAbleToMoveRight = false;
		}// segment 1
		else if (Player.y < 3554 && Player.y > 2466 && Player.x > 1344
				&& Player.x < 1383) {
			Player.isAbleToMoveRight = false;
		}// segment 3
		else if (Player.y < 3666 && Player.y > 3526 && Player.x > 1202
				&& Player.x < 1240) {
			Player.isAbleToMoveRight = false;
		}// segment 5
		else if (Player.y < 3661 && Player.y > 3602 && Player.x > 1282
				&& Player.x < 1302) {
			Player.isAbleToMoveRight = false;
		}// segment 8
		else if (Player.y < 3706 && Player.y > 3606 && Player.x > 1458
				&& Player.x < 1488) {
			Player.isAbleToMoveRight = false;
		}// segment 12
		else if (Player.y < 3660 && Player.y > 3546 && Player.x > 1600
				&& Player.x < 1610) {
			Player.isAbleToMoveRight = false;
		}// segment 13
		else if (Player.y < 3558 && Player.y > 3522 && Player.x > 1458
				&& Player.x < 1488) {
			Player.isAbleToMoveRight = false;
		}// segment 15
		else if (Player.y < 3550 && Player.y > 2236 && Player.x > 2992
				&& Player.x < 3024) {
			Player.isAbleToMoveRight = false;
		}// segment 17
		else if (Player.y < 2260 && Player.y > 2002 && Player.x > 2732
				&& Player.x < 2766) {
			Player.isAbleToMoveRight = false;
		}// segment 19
		else if (Player.y < 2034 && Player.y > 1938 && Player.x > 3688
				&& Player.x < 3708) {
			Player.isAbleToMoveRight = false;
		}// segment 21
		else if (Player.y < 2260 && Player.y > 1930 && Player.x > 2658
				&& Player.x < 2696) {
			Player.isAbleToMoveRight = false;
		}// segment 23
		else if (Player.y < 2422 && Player.y > 2236 && Player.x > 1346
				&& Player.x < 1384) {
			Player.isAbleToMoveRight = false;
		}// segment 25
		else if (Player.y < 2422 && Player.y > 1878 && Player.x > 876
				&& Player.x < 914) {
			Player.isAbleToMoveRight = false;
		}// segment 29
		else if (Player.y < 2422 && Player.y > 2030 && Player.x > 802
				&& Player.x < 842) {
			Player.isAbleToMoveRight = false;
		}// segment 31
		else if (Player.y < 2532 && Player.y > 2396 && Player.x > 718
				&& Player.x < 760) {
			Player.isAbleToMoveRight = false;
		}// segment 33
		else if (Player.y < 2516 && Player.y > 2466 && Player.x > 800
				&& Player.x < 828) {
			Player.isAbleToMoveRight = false;
		}// segment 36
		else if (Player.y < 3442 && Player.y > 2916 && Player.x > 2884
				&& Player.x < 2924) {
			Player.isAbleToMoveRight = false;
		}// segment 40
		else if (Player.y < 2868 && Player.y > 2336 && Player.x > 2882
				&& Player.x < 2924) {
			Player.isAbleToMoveRight = false;
		}// segment 44
		else if (Player.y < 2820 && Player.y > 2334 && Player.x > 1454
				&& Player.x < 1498) {
			Player.isAbleToMoveRight = false;
		}// segment 46
		else if (Player.y < 2884 && Player.y > 2338 && Player.x > 2140
				&& Player.x < 2180) {
			Player.isAbleToMoveRight = false;
		}// segment 48
		else if (Player.y < 3108 && Player.y > 2866 && Player.x > 1454
				&& Player.x < 1488) {
			Player.isAbleToMoveRight = false;
		}// segment 50 ENTRANCE TO CENTRAL HOUSE
		else if (Player.y < 3178 && Player.y > 3090 && Player.x > 1486
				&& Player.x < 1496) {
			Player.isAbleToMoveRight = false;
		}// segment 52
		else if (Player.y < 3434 && Player.y > 3154 && Player.x > 1454
				&& Player.x < 1490) {
			Player.isAbleToMoveRight = false;
		}// segment 53
		else if (Player.y < 2258 && Player.y > 1878 && Player.x > 1456
				&& Player.x < 1492) {
			Player.isAbleToMoveRight = false;
		}
		else
			Player.isAbleToMoveRight = true;

		// bottom wall
		if (Player.y < 224) {
			Player.isAbleToMoveDown = false;
		}
		// segment 2
		else if (Player.y > 3526 && Player.y < 3558 && Player.x > 1206
				&& Player.x < 1390) {
			Player.isAbleToMoveDown = false;
		}// segment 14
		else if (Player.y > 3532 && Player.y < 3558 && Player.x > 1458
				&& Player.x < 3022) {
			Player.isAbleToMoveDown = false;
		}// segment 16
		else if (Player.y > 2240 && Player.y < 2264 && Player.x > 2738
				&& Player.x < 3028) {
			Player.isAbleToMoveDown = false;
		}// segment 18
		else if (Player.y > 2008 && Player.y < 2034 && Player.x > 2738
				&& Player.x < 2836) {
			Player.isAbleToMoveDown = false;
		}// segment 20
		else if (Player.y > 1932 && Player.y < 1960 && Player.x > 2662
				&& Player.x < 3836) {
			Player.isAbleToMoveDown = false;
		}// segment 22
		else if (Player.y > 2238 && Player.y < 2264 && Player.x > 1462
				&& Player.x < 2690) {
			Player.isAbleToMoveDown = false;
		}// segment 24
		else if (Player.y > 2400 && Player.y < 2426 && Player.x > 880
				&& Player.x < 1384) {
			Player.isAbleToMoveDown = false;
		}// segment 26
		else if (Player.y > 1888 && Player.y < 1910 && Player.x > 664
				&& Player.x < 1502) {
			Player.isAbleToMoveDown = false;
		}// segment 28
		else if (Player.y > 2032 && Player.y < 2048 && Player.x > 664
				&& Player.x < 848) {
			Player.isAbleToMoveDown = false;
		}// segment 30
		else if (Player.y > 2400 && Player.y < 2426 && Player.x > 722
				&& Player.x < 848) {
			Player.isAbleToMoveDown = false;
		}// segment 34
		else if (Player.y > 2470 && Player.y < 2500 && Player.x > 806
				&& Player.x < 1386) {
			Player.isAbleToMoveDown = false;
		}// segment 35
		else if (Player.y > 3418 && Player.y < 3448 && Player.x > 1458
				&& Player.x < 2928) {
			Player.isAbleToMoveDown = false;
		}// segment 37
		else if (Player.y > 2920 && Player.y < 2946 && Player.x > 2822
				&& Player.x < 2930) {
			Player.isAbleToMoveDown = false;
		}// segment 39
		else if (Player.y > 2848 && Player.y < 2872 && Player.x > 2822
				&& Player.x < 2930) {
			Player.isAbleToMoveDown = false;
		}// segment 41
		else if (Player.y > 2340 && Player.y < 2372 && Player.x > 2144
				&& Player.x < 2928) {
			Player.isAbleToMoveDown = false;
		}// segment 43
		else if (Player.y > 2790 && Player.y < 2824 && Player.x > 1458
				&& Player.x < 2114) {
			Player.isAbleToMoveDown = false;
		}// segment 47
		else if (Player.y > 2872 && Player.y < 2900 && Player.x > 1458
				&& Player.x < 2190) {
			Player.isAbleToMoveDown = false;
		}// segment 49
		else if (Player.y > 3090 && Player.y < 3112 && Player.x > 1458
				&& Player.x < 1528) {
			Player.isAbleToMoveDown = false;
		} else
			Player.isAbleToMoveDown = true;

		// top wall
		if (Player.y > 3690) {
			Player.isAbleToMoveUp = false;
		}
		// segment 2
		else if (Player.y > 3522 && Player.y < 3548 && Player.x > 1206
				&& Player.x < 1390) {
			Player.isAbleToMoveUp = false;
		}// segment 4
		else if (Player.y > 3654 && Player.y < 3664 && Player.x > 1245
				&& Player.x < 1288) {
			Player.isAbleToMoveUp = false;
		}// segment 6
		else if (Player.y > 3602 && Player.y < 3616 && Player.x > 1286
				&& Player.x < 1388) {
			Player.isAbleToMoveUp = false;
		}// segment 9
		else if (Player.y > 3602 && Player.y < 3636 && Player.x > 1464
				&& Player.x < 1564) {
			Player.isAbleToMoveUp = false;
		}// segment 11
		else if (Player.y > 3654 && Player.y < 3666 && Player.x > 1562
				&& Player.x < 1620) {
			Player.isAbleToMoveUp = false;
		}// segment 14
		else if (Player.y > 3522 && Player.y < 3548 && Player.x > 1458
				&& Player.x < 3022) {
			Player.isAbleToMoveUp = false;
		}// segment 16
		else if (Player.y > 2230 && Player.y < 2254 && Player.x > 2738
				&& Player.x < 3028) {
			Player.isAbleToMoveUp = false;
		}// segment 18
		else if (Player.y > 1998 && Player.y < 2024 && Player.x > 2738
				&& Player.x < 3836) {
			Player.isAbleToMoveUp = false;
		}// segment 20
		else if (Player.y > 1922 && Player.y < 1950 && Player.x > 2662
				&& Player.x < 3836) {
			Player.isAbleToMoveUp = false;
		}// segment 22
		else if (Player.y > 2228 && Player.y < 2254 && Player.x > 1462
				&& Player.x < 2698) {
			Player.isAbleToMoveUp = false;
		}// segment 24
		else if (Player.y > 2390 && Player.y < 2416 && Player.x > 880
				&& Player.x < 1384) {
			Player.isAbleToMoveUp = false;
		}// segment 26
		else if (Player.y > 1874 && Player.y < 1900 && Player.x > 664
				&& Player.x < 1502) {
			Player.isAbleToMoveUp = false;
		}// segment 28
		else if (Player.y > 2022 && Player.y < 2058 && Player.x > 664
				&& Player.x < 848) {
			Player.isAbleToMoveUp = false;
		}// segment 30
		else if (Player.y > 2390 && Player.y < 2416 && Player.x > 722
				&& Player.x < 848) {
			Player.isAbleToMoveUp = false;
		}// segment 32 DOOR WAY NEAR RIVER HOUSE
		else if (Player.y > 2500 && Player.y < 2516 && Player.x > 758
				&& Player.x < 832) {
			Player.isAbleToMoveUp = false;
			//House.isInRiverHouse = true;
		}// segment 34
		else if (Player.y > 2460 && Player.y < 2486 && Player.x > 806
				&& Player.x < 1386) {
			Player.isAbleToMoveUp = false;
		}// segment 35
		else if (Player.y > 3408 && Player.y < 3438 && Player.x > 1458
				&& Player.x < 2928) {
			Player.isAbleToMoveUp = false;
		}// segment 37
		else if (Player.y > 2910 && Player.y < 2932 && Player.x > 2822
				&& Player.x < 2930) {
			Player.isAbleToMoveUp = false;
		}// segment 39
		else if (Player.y > 2838 && Player.y < 2862 && Player.x > 2822
				&& Player.x < 2930) {
			Player.isAbleToMoveUp = false;
		}// segment 41
		else if (Player.y > 2334 && Player.y < 2354 && Player.x > 2144
				&& Player.x < 2930) {
			Player.isAbleToMoveUp = false;
		}// segment 45
		else if (Player.y > 2334 && Player.y < 2354 && Player.x > 1458
				&& Player.x < 2110) {
			Player.isAbleToMoveUp = false;
		}// segment 47
		else if (Player.y > 2862 && Player.y < 2886 && Player.x > 1458
				&& Player.x < 2190) {
			Player.isAbleToMoveUp = false;
		}// segment 51
		else if (Player.y > 3148 && Player.y < 3188 && Player.x > 1458
				&& Player.x < 1528) {
			Player.isAbleToMoveUp = false;
		}
		// segment 53
		else if (Player.y > 2230 && Player.y < 2240 && Player.x > 1354
					&& Player.x < 1386) {
				Player.isAbleToMoveUp = false;
		} else
			Player.isAbleToMoveUp = true;
	}
}
