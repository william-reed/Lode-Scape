package com.reed.birdseye;

public class CollisionDetection {

	void doCollision() {
		// left wall
		if (Player.x < -844) {
			Player.isAbleToMoveLeft = false;
		}// segment 1
		else if (Player.y < 3554 && Player.y > 2466 && Player.x > 416//
				&& Player.x < 436) {
			Player.isAbleToMoveLeft = false;
		}// segment 3
		else if (Player.y < 3666 && Player.y > 3526 && Player.x > 234//
				&& Player.x < 292) {
			Player.isAbleToMoveLeft = false;
		}// segment 7
		else if (Player.y < 3706 && Player.y > 3606 && Player.x > 405//
				&& Player.x < 430) {
			Player.isAbleToMoveLeft = false;
		}// segment 10
		else if (Player.y < 3680 && Player.y > 3602 && Player.x > 580//
				&& Player.x < 610) {
			Player.isAbleToMoveLeft = false;
		}// segment 15
		else if (Player.y < 3550 && Player.y > 2240 && Player.x > 2044//
				&& Player.x < 2076) {
			Player.isAbleToMoveLeft = false;
		}// segment 17
		else if (Player.y < 2260 && Player.y > 2002 && Player.x > 1786//
				&& Player.x < 1824) {
			Player.isAbleToMoveLeft = false;
		}// segment 21
		else if (Player.y < 2260 && Player.y > 1946 && Player.x > 1714//
				&& Player.x < 1748) {
			Player.isAbleToMoveLeft = false;
		}// segment 23
		else if (Player.y < 2422 && Player.y > 2236 && Player.x > 402//
				&& Player.x < 436) {
			Player.isAbleToMoveLeft = false;
		}// segment 25
		else if (Player.y < 2422 && Player.y > 1878 && Player.x > -72//
				&& Player.x < -14) {
			Player.isAbleToMoveLeft = false;
		}// segment 27
		else if (Player.y < 2034 && Player.y > 1900 && Player.x > -252//
				&& Player.x < -240) {
			Player.isAbleToMoveLeft = false;
		}// segment 29
		else if (Player.y < 2422 && Player.y > 2030 && Player.x > -146//
				&& Player.x < -106) {
			Player.isAbleToMoveLeft = false;
		}// segment 31
		else if (Player.y < 2532 && Player.y > 2396 && Player.x > -228//
				&& Player.x < -188) {
			Player.isAbleToMoveLeft = false;
		}// segment 33
		else if (Player.y < 2516 && Player.y > 2466 && Player.x > -148//
				&& Player.x < -110) {
			Player.isAbleToMoveLeft = false;
		}// segment 36
		else if (Player.y < 3442 && Player.y > 2916 && Player.x > 1936//
				&& Player.x < 1976) {
			Player.isAbleToMoveLeft = false;
		}// segment 38 HOUSE NEAR TOP RIGHT OF MAP
		else if (Player.y < 2930 && Player.y > 2856 && Player.x > 1898//
				&& Player.x < 1908) {
			Player.isAbleToMoveLeft = false;
		}// segment 40
		else if (Player.y < 2868 && Player.y > 2336 && Player.x > 1936//
				&& Player.x < 1976) {
			Player.isAbleToMoveLeft = false;
		}// segment 42
		else if (Player.y < 2820 && Player.y > 2338 && Player.x > 1110//
				&& Player.x < 1156) {
			Player.isAbleToMoveLeft = false;
		}// segment 46
		else if (Player.y < 2884 && Player.y > 2338 && Player.x > 1192//
				&& Player.x < 1232) {
			Player.isAbleToMoveLeft = false;
		}// segment 48
		else if (Player.y < 3108 && Player.y > 2866 && Player.x > 506//
				&& Player.x < 540) {
			Player.isAbleToMoveLeft = false;
		}// segment 52
		else if (Player.y < 3434 && Player.y > 3154 && Player.x > 506//
				&& Player.x < 542) {
			Player.isAbleToMoveLeft = false;
		}// segment 53
		else if (Player.y < 2258 && Player.y > 1878 && Player.x > 508//
				&& Player.x < 544) {
			Player.isAbleToMoveLeft = false;
		}
		else
			Player.isAbleToMoveLeft = true;

		if (Player.x > 2830) {
			Player.isAbleToMoveRight = false;
		}// segment 1
		else if (Player.y < 3554 && Player.y > 2466 && Player.x > 386//
				&& Player.x < 425) {
			Player.isAbleToMoveRight = false;
		}// segment 3
		else if (Player.y < 3666 && Player.y > 3526 && Player.x > 244//
				&& Player.x < 282) {
			Player.isAbleToMoveRight = false;
		}// segment 5
		else if (Player.y < 3661 && Player.y > 3602 && Player.x > 324//
				&& Player.x < 344) {
			Player.isAbleToMoveRight = false;
		}// segment 8
		else if (Player.y < 3706 && Player.y > 3606 && Player.x > 500//
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 12
		else if (Player.y < 3660 && Player.y > 3546 && Player.x > 642//
				&& Player.x < 652) {
			Player.isAbleToMoveRight = false;
		}// segment 13
		else if (Player.y < 3558 && Player.y > 3522 && Player.x > 500//
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 15
		else if (Player.y < 3550 && Player.y > 2236 && Player.x > 2034//
				&& Player.x < 2066) {
			Player.isAbleToMoveRight = false;
		}// segment 17
		else if (Player.y < 2260 && Player.y > 2002 && Player.x > 1774//
				&& Player.x < 1808) {
			Player.isAbleToMoveRight = false;
		}// segment 19
		else if (Player.y < 2034 && Player.y > 1938 && Player.x > 2730//
				&& Player.x < 2750) {
			Player.isAbleToMoveRight = false;
		}// segment 21
		else if (Player.y < 2260 && Player.y > 1930 && Player.x > 1700//
				&& Player.x < 1738) {
			Player.isAbleToMoveRight = false;
		}// segment 23
		else if (Player.y < 2422 && Player.y > 2236 && Player.x > 388//
				&& Player.x < 426) {
			Player.isAbleToMoveRight = false;
		}// segment 25
		else if (Player.y < 2422 && Player.y > 1878 && Player.x > -82//
				&& Player.x < -44) {
			Player.isAbleToMoveRight = false;
		}// segment 29
		else if (Player.y < 2422 && Player.y > 2030 && Player.x > -156//
				&& Player.x < -116) {
			Player.isAbleToMoveRight = false;
		}// segment 31
		else if (Player.y < 2532 && Player.y > 2396 && Player.x > -240//
				&& Player.x < -198) {
			Player.isAbleToMoveRight = false;
		}// segment 33
		else if (Player.y < 2516 && Player.y > 2466 && Player.x > -158//
				&& Player.x < -130) {
			Player.isAbleToMoveRight = false;
		}// segment 36
		else if (Player.y < 3442 && Player.y > 2916 && Player.x > 1926//
				&& Player.x < 1966) {
			Player.isAbleToMoveRight = false;
		}// segment 40
		else if (Player.y < 2868 && Player.y > 2336 && Player.x > 1924//
				&& Player.x < 1966) {
			Player.isAbleToMoveRight = false;
		}// segment 44
		else if (Player.y < 2820 && Player.y > 2334 && Player.x > 496//
				&& Player.x < 540) {
			Player.isAbleToMoveRight = false;
		}// segment 46
		else if (Player.y < 2884 && Player.y > 2338 && Player.x > 1182//
				&& Player.x < 1222) {
			Player.isAbleToMoveRight = false;
		}// segment 48
		else if (Player.y < 3108 && Player.y > 2866 && Player.x > 496//
				&& Player.x < 530) {
			Player.isAbleToMoveRight = false;
		}// segment 50 ENTRANCE TO CENTRAL HOUSE
		else if (Player.y < 3178 && Player.y > 3090 && Player.x > 528//
				&& Player.x < 538) {
			Player.isAbleToMoveRight = false;
		}// segment 52
		else if (Player.y < 3434 && Player.y > 3154 && Player.x > 496//
				&& Player.x < 532) {
			Player.isAbleToMoveRight = false;
		}// segment 53
		else if (Player.y < 2258 && Player.y > 1878 && Player.x > 498//
				&& Player.x < 534) {
			Player.isAbleToMoveRight = false;
		}
		else
			Player.isAbleToMoveRight = true;

		// bottom wall
		if (Player.y < -3092) {
			Player.isAbleToMoveDown = false;
		}
		// segment 2
		else if (Player.y > 3526 && Player.y < 3558 && Player.x > 248//
				&& Player.x < 432) {
			Player.isAbleToMoveDown = false;
		}// segment 14
		else if (Player.y > 6848 && Player.y < 6874 && Player.x > 500//
				&& Player.x < 2064) {
			Player.isAbleToMoveDown = false;
		}// segment 16
		else if (Player.y > 2240 && Player.y < 2264 && Player.x > 1780//
				&& Player.x < 2070) {
			Player.isAbleToMoveDown = false;
		}// segment 18
		else if (Player.y > 2008 && Player.y < 2034 && Player.x > 1780//
				&& Player.x < 2878) {
			Player.isAbleToMoveDown = false;
		}// segment 20
		else if (Player.y > 1932 && Player.y < 1960 && Player.x > 1704//
				&& Player.x < 2878) {
			Player.isAbleToMoveDown = false;
		}// segment 22
		else if (Player.y > 2238 && Player.y < 2264 && Player.x > 504//
				&& Player.x < 1740) {
			Player.isAbleToMoveDown = false;
		}// segment 24
		else if (Player.y > 2400 && Player.y < 2426 && Player.x > -78//
				&& Player.x < 426) {
			Player.isAbleToMoveDown = false;
		}// segment 26
		else if (Player.y > 1888 && Player.y < 1910 && Player.x > -294//
				&& Player.x < 544) {
			Player.isAbleToMoveDown = false;
		}// segment 28
		else if (Player.y > 2032 && Player.y < 2048 && Player.x > -294//
				&& Player.x < -110) {
			Player.isAbleToMoveDown = false;
		}// segment 30
		else if (Player.y > 2400 && Player.y < 2426 && Player.x > -236//
				&& Player.x < -110) {
			Player.isAbleToMoveDown = false;
		}// segment 34
		else if (Player.y > 2470 && Player.y < 2500 && Player.x > -152//
				&& Player.x < 428) {
			Player.isAbleToMoveDown = false;
		}// segment 35
		else if (Player.y > 3418 && Player.y < 3448 && Player.x > 500//
				&& Player.x < 1970) {
			Player.isAbleToMoveDown = false;
		}// segment 37
		else if (Player.y > 2920 && Player.y < 2946 && Player.x > 1864//
				&& Player.x < 1972) {
			Player.isAbleToMoveDown = false;
		}// segment 39
		else if (Player.y > 2848 && Player.y < 2872 && Player.x > 1864//
				&& Player.x < 1972) {
			Player.isAbleToMoveDown = false;
		}// segment 41
		else if (Player.y > 2340 && Player.y < 2372 && Player.x > 1186//
				&& Player.x < 1970) {
			Player.isAbleToMoveDown = false;
		}// segment 43
		else if (Player.y > 2790 && Player.y < 2824 && Player.x > 500//
				&& Player.x < 1156) {
			Player.isAbleToMoveDown = false;
		}// segment 47
		else if (Player.y > 2872 && Player.y < 2900 && Player.x > 500//
				&& Player.x < 1232) {
			Player.isAbleToMoveDown = false;
		}// segment 49
		else if (Player.y > 3090 && Player.y < 3112 && Player.x > 500//
				&& Player.x < 570) {
			Player.isAbleToMoveDown = false;
		} else
			Player.isAbleToMoveDown = true;

		// top wall
		if (Player.y > 374) {
			Player.isAbleToMoveUp = false;
		}
		// segment 2
		else if (Player.y > 3522 && Player.y < 3548 && Player.x > 248//
				&& Player.x < 432) {
			Player.isAbleToMoveUp = false;
		}// segment 4
		else if (Player.y > 3654 && Player.y < 3664 && Player.x > 287//
				&& Player.x < 330) {
			Player.isAbleToMoveUp = false;
		}// segment 6
		else if (Player.y > 3602 && Player.y < 3616 && Player.x > 328//
				&& Player.x < 430) {
			Player.isAbleToMoveUp = false;
		}// segment 9
		else if (Player.y > 3602 && Player.y < 3636 && Player.x > 506//
				&& Player.x < 606) {
			Player.isAbleToMoveUp = false;
		}// segment 11
		else if (Player.y > 3654 && Player.y < 3666 && Player.x > 604//
				&& Player.x < 662) {
			Player.isAbleToMoveUp = false;
		}// segment 14
		else if (Player.y > 3522 && Player.y < 3548 && Player.x > 500//
				&& Player.x < 2064) {
			Player.isAbleToMoveUp = false;
		}// segment 16
		else if (Player.y > 2230 && Player.y < 2254 && Player.x > 1780//
				&& Player.x < 2070) {
			Player.isAbleToMoveUp = false;
		}// segment 18
		else if (Player.y > 1998 && Player.y < 2024 && Player.x > 1780//
				&& Player.x < 2878) {
			Player.isAbleToMoveUp = false;
		}// segment 20
		else if (Player.y > 1922 && Player.y < 1950 && Player.x > 1704//
				&& Player.x < 2878) {
			Player.isAbleToMoveUp = false;
		}// segment 22
		else if (Player.y > 2228 && Player.y < 2254 && Player.x > 504//
				&& Player.x < 1740) {
			Player.isAbleToMoveUp = false;
		}// segment 24
		else if (Player.y > 2390 && Player.y < 2416 && Player.x > -78//
				&& Player.x < 426) {
			Player.isAbleToMoveUp = false;
		}// segment 26
		else if (Player.y > 1874 && Player.y < 1900 && Player.x > -294//
				&& Player.x < 544) {
			Player.isAbleToMoveUp = false;
		}// segment 28
		else if (Player.y > 2022 && Player.y < 2058 && Player.x > -294//
				&& Player.x < -110) {
			Player.isAbleToMoveUp = false;
		}// segment 30
		else if (Player.y > 2390 && Player.y < 2416 && Player.x > -236//
				&& Player.x < -110) {
			Player.isAbleToMoveUp = false;
		}// segment 32 DOOR WAY NEAR RIVER HOUSE
		else if (Player.y > 2500 && Player.y < 2516 && Player.x > -200//
				&& Player.x < -126) {
			Player.isAbleToMoveUp = false;
			//House.isInRiverHouse = true;
		}// segment 34
		else if (Player.y > 2460 && Player.y < 2486 && Player.x > -152//
				&& Player.x < 428) {
			Player.isAbleToMoveUp = false;
		}// segment 35
		else if (Player.y > 3408 && Player.y < 3438 && Player.x > 500//
				&& Player.x < 1970) {
			Player.isAbleToMoveUp = false;
		}// segment 37
		else if (Player.y > 2910 && Player.y < 2932 && Player.x > 1864//
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 39
		else if (Player.y > 2838 && Player.y < 2862 && Player.x > 1864//
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 41
		else if (Player.y > 2334 && Player.y < 2354 && Player.x > 1186//
				&& Player.x < 1972) {
			Player.isAbleToMoveUp = false;
		}// segment 45
		else if (Player.y > 2334 && Player.y < 2354 && Player.x > 500//
				&& Player.x < 1152) {
			Player.isAbleToMoveUp = false;
		}// segment 47
		else if (Player.y > 2862 && Player.y < 2886 && Player.x > 500//
				&& Player.x < 1232) {
			Player.isAbleToMoveUp = false;
		}// segment 51
		else if (Player.y > 3148 && Player.y < 3188 && Player.x > 500//
				&& Player.x < 570) {
			Player.isAbleToMoveUp = false;
		} else
			Player.isAbleToMoveUp = true;
	}
}
