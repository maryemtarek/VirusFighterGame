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

public class MainMenu implements Screen {
	private MyGdxGame VirusGame;
	Texture texture;
	Texture texture2;
	String Title = "Virus Fighter Game";
	String Start = "Start";
	String Instructions = "How To Play?";
	private BitmapFont font, font1;
	
	public MainMenu(MyGdxGame VirusGame) {
		this.VirusGame = VirusGame;
		texture = new Texture("Viruss.jpg");
		texture2 = new Texture("buttons_PNG5.png");
		font = new BitmapFont(Gdx.files.internal("myfont5.fnt"));
		font1 = new BitmapFont(Gdx.files.internal("font.fnt"));
		VirusGame.backgroundMusic.play();
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
		if(Gdx.input.getX() > 400 && Gdx.input.getX() < 600 && Gdx.input.getY() > 350 && Gdx.input.getY() < 450) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			         VirusGame.setCharacters();
			 }
		}
		
		if(Gdx.input.getX() > 450 && Gdx.input.getX() < 600 && Gdx.input.getY() > 550 && Gdx.input.getY() < 750) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			        VirusGame.setInstructions();
			 }
		}	
		
		VirusGame.batch.begin();		
		VirusGame.batch.draw(texture, 0, 0);	
		font1.draw(VirusGame.batch, Title, 50, 755);
		VirusGame.batch.draw(texture2, 340, 390);
		font.draw(VirusGame.batch, Start, 460, 445);		
		VirusGame.batch.draw(texture2, 340, 150);
		font.draw(VirusGame.batch, Instructions, 390, 205);
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
