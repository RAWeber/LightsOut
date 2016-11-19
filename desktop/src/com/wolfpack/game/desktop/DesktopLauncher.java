package com.wolfpack.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wolfpack.game.GameApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    config.title = "Lights Out";
	    config.width = 1280;
	    config.height = 720;
		new LwjglApplication(new GameApp(), config);
	}
}
