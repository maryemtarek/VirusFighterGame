package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Instructions implements Screen {
	MyGdxGame VirusGame;
	Texture texture;
	Texture texture2;
	Texture texture3;
	private BitmapFont font, font2;
	String Text = " ";
	String Text2 = "Back";
	public Instructions(MyGdxGame VirusGame) {
		this.VirusGame = VirusGame;
		Text = "1- You must reach to the heart with \n"
				+ "score of 100 points in Level 1 or \n"
				+ "score of 200 points in Level 2 or\n"
				+ " more.\n"
		
				+ "2- If Your health reaches zero \n"
				+ "before reaching to the heart \n or you fall on a spike\n"
				+ " you will lose.\n"
				+ "3- walking by left and right arrows on keyboard\n"
				+ " and jumping by up arrow,\n"
				+ " to shot a bullet or throw a bomb press space";
		texture = new Texture("Viros.jpg");
		texture2 = new Texture("Heart2.png");
		texture3 = new Texture("buttons_PNG5.png");
		font = new BitmapFont(Gdx.files.internal("text.fnt"));
		font2 = new BitmapFont(Gdx.files.internal("myfont5.fnt"));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		VirusGame.batch.begin();		
		if(Gdx.input.getX() > 400 && Gdx.input.getX() < 550 && Gdx.input.getY() > 760 && Gdx.input.getY() < 800) {
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			         VirusGame.setMainMenu();
			 }
		}
		VirusGame.batch.draw(texture, 0, 0);	
		VirusGame.batch.draw(texture2, 270, 490);	
		font.draw(VirusGame.batch, Text, 100, 700);		
		VirusGame.batch.draw(texture3, 350, 20);	
		font2.draw(VirusGame.batch, Text2, 465, 75);
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
		
	}
}
