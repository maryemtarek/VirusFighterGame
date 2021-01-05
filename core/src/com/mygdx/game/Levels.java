package com.mygdx.game;

import org.w3c.dom.events.MouseEvent;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Levels implements Screen {
	private MyGdxGame VirusGame;
	Texture texture;
	Texture texture2;
	String Level1 = "Easy";
	String Level2 = "Hard";
	private BitmapFont font;
	
	public Levels(MyGdxGame VirusGame) {
		this.VirusGame = VirusGame;
		texture = new Texture("Viruss.jpg");
		texture2 = new Texture("buttons_PNG5.png");
		font = new BitmapFont(Gdx.files.internal("myfont5.fnt"));		
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
		if(Gdx.input.getX() > 400 && Gdx.input.getX() < 500 && Gdx.input.getY() > 250 && Gdx.input.getY() < 350) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			         VirusGame.setPlayScreen("Level1.txt",1);
			         VirusGame.Back = new Sprite(new Texture("Back2.jpeg"));
			 }
		}
		
		if(Gdx.input.getX() > 350 && Gdx.input.getX() < 600 && Gdx.input.getY() > 550 && Gdx.input.getY() < 650) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				 VirusGame.setPlayScreen("Level2.txt",2);
				 VirusGame.Back = new Sprite(new Texture("blackBack.jpeg"));
			 }
		}	
		
		VirusGame.batch.begin();		
		VirusGame.batch.draw(texture, 0, 0);		
		VirusGame.batch.draw(texture2, 340, 470);
		font.draw(VirusGame.batch, Level1, 460, 525);		
		VirusGame.batch.draw(texture2, 340, 250);
		font.draw(VirusGame.batch, Level2, 460, 305);
		VirusGame.batch.end();
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
		// TODO Auto-generated method stub
		VirusGame.batch.dispose();
	}
	 
}
