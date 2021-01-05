package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
 
public class GameOverScreen implements Screen {
	private MyGdxGame VirusGame;
	Texture texture;	
	String Yes = "YES";
	String No = "NO";
	private BitmapFont GameOverfont;
	private Music music_gameover;
	public GameOverScreen(MyGdxGame VirusGame) {
		this.VirusGame = VirusGame;
		VirusGame.batch.getProjectionMatrix().setToOrtho2D(0, 0, 1000, 850);
		texture = new Texture("Game Over 1.jpeg");		
		GameOverfont = new BitmapFont(Gdx.files.internal("myfont4.fnt"));
		music_gameover = Gdx.audio.newMusic(Gdx.files.internal("Game Over.mp3")) ;
		music_gameover.setVolume(0.5f);
		VirusGame.backgroundMusic.dispose();
	    music_gameover.play();
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
		//music_gameover.setVolume(0.5f);
		//music_gameover.play();
		
		VirusGame.batch.draw(texture, 0, 0);		
		GameOverfont.draw(VirusGame.batch, Yes, 300, 190);
		GameOverfont.draw(VirusGame.batch, No, 650, 190);			
		if(Gdx.input.getX() > 300 && Gdx.input.getX() < 550 && Gdx.input.getY() > 530 && Gdx.input.getY() < 670) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				 VirusGame.setMainMenu();
			}
		}else if(Gdx.input.getX() > 550 && Gdx.input.getX() < 700 && Gdx.input.getY() > 530 && Gdx.input.getY() < 670) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				Gdx.app.exit();
			}
		}				
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
		music_gameover.dispose();
	}
 
}