package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class WinScreen implements Screen {
	private MyGdxGame VirusGame;
	Texture texture;
	String Yes = "YES";
	String No = "NO";
	private BitmapFont GameOverfont;
	private Music music_win;
	
	public WinScreen(MyGdxGame VirusGame) {
		this.VirusGame = VirusGame;	
		VirusGame.batch.getProjectionMatrix().setToOrtho2D(0, 0, 1000, 850);
		texture = new Texture("WIN.jpg");		
		GameOverfont = new BitmapFont(Gdx.files.internal("myfont3.fnt"));	
		music_win = Gdx.audio.newMusic(Gdx.files.internal("Victory sound.mp3")) ;
		music_win.setVolume(0.5f);
		VirusGame.backgroundMusic.dispose();
		music_win.play();
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
		VirusGame.batch.begin();
		//music_win.setVolume(0.5f);
		//music_win.play();
		//music_win.pause();
		//music_win.setLooping(true); 
		VirusGame.batch.draw(texture, 0, 0);	
		GameOverfont.draw(VirusGame.batch, Yes, 360, 190);
		GameOverfont.draw(VirusGame.batch, No, 605, 190);
		
		
		
		if(Gdx.input.getX() > 380 && Gdx.input.getX() < 550 && Gdx.input.getY() > 470 && Gdx.input.getY() < 670) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				 VirusGame.setMainMenu();
			}
		}else if(Gdx.input.getX() > 550 && Gdx.input.getX() < 700 && Gdx.input.getY() > 500 && Gdx.input.getY() < 670) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				Gdx.app.exit();
			}
		}
		//music_win.stop(); 
		
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
		music_win.dispose();
		 
	}
	 
}
