package com.reed.birdseye;

public class Packet {
	public static class Packet0LoginRequest {
	}

	public static class Packet1LoginAnswer {
		boolean accepted = false;
	}

	public static class Packet2xPos {
		int xPos;
	}
	
	public static class Packet3yPos {
		int yPos;
	}
}
