package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Virus Fighter Game";
		config.useGL30 = true;
		config.forceExit = true ; 
		config.width = 1000;
		config.height = 850;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
