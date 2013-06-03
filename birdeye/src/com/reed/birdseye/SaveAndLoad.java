package com.reed.birdseye;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.badlogic.gdx.Gdx;

public class SaveAndLoad {
	
	public final static String file = ".lodescape";
	
	public static void save () {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(Gdx.files.local("lodescape.txt").write(false)));
			out.write(Integer.toString(Tutorial.step));
			out.newLine();
			out.write(Float.toString(Time.getTimeOfDay()));

		} catch (Throwable e) {
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) {
			}
		}
	}
	
}
