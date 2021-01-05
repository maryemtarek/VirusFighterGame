package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Characters implements Screen{
	MyGdxGame game;
	BitmapFont font;
	BitmapFont font2;
	Texture texture;
	Texture texture2;
	Texture texture3;
	public static String choosenone;
	String Text = "Choose a Character: ";
	String char1Health="Health: 120";
	String char1Speed ="Speed: 100 ";
	String char2Health="Health: 100";
	String char2Speed ="Speed: 110 ";
	public Characters(MyGdxGame game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		texture = new Texture("background.jpg");
		texture2 = new Texture("Fighter/Girl_Stand.png");
		texture3 = new Texture("Fighter/Boy_Stand.png");
		font = new BitmapFont(Gdx.files.internal("myfont.fnt"));	
		font2 = new BitmapFont(Gdx.files.internal("myfont2.fnt"));			
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();		
		game.batch.draw(texture, 0, 0);
		game.batch.draw(texture3, 550, 300);	
		game.batch.draw(texture2, 250, 300);
		font.draw(game.batch, Text, 170, 600);
		font2.draw(game.batch, char1Health, 250, 295);
		font2.draw(game.batch, char1Speed, 250, 270);
		font2.draw(game.batch, char2Health, 550, 295);
		font2.draw(game.batch, char2Speed, 550, 270);
		if(Gdx.input.getX() > 250 && Gdx.input.getX() < 450 && Gdx.input.getY() > 300 && Gdx.input.getY() < 500 ) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			choosenone="Girl.png";
		    game.SetLevels();}
		}
		 if(Gdx.input.getX() > 550 && Gdx.input.getX() < 750 && Gdx.input.getY() > 300 && Gdx.input.getY() < 500 ) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			choosenone="Boy.png";
		    game.SetLevels();}
		}
		game.batch.end();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		game.batch.dispose();
		
	}}

