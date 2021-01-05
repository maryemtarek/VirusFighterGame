package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game implements ApplicationListener, InputProcessor{
	//our used screens 
	private Screen MainMenu;
    private Screen Characters;
    private Screen PlayScreen;
    private Screen GameOverScreen;
    private Screen WinScreen;
    private Screen Instructions;
    private Screen Levels;
    static OrthographicCamera  Camera;
    public static int width,heigth;
    public Sprite Back;
    public Music backgroundMusic;
	public SpriteBatch batch;	
	
	public void  setMainMenu()
    {
        MainMenu=new MainMenu(this);
        setScreen(MainMenu);
    }
	public void  setCharacters()
    {
		Characters=new Characters(this);
        setScreen(Characters);
    }
	public void  setPlayScreen(String filename, int level)
    {
       PlayScreen=new PlayScreen(this,filename,level);
        setScreen(PlayScreen);
        
    }
	public void  setInstructions()
    {
        Instructions=new Instructions(this);
        setScreen(Instructions);
    }
	public void  setGameOverScreen()
    {
		GameOverScreen=new GameOverScreen(this);
		
	        setScreen(GameOverScreen);
    }
	public void  SetWinScreen()
    {
       WinScreen = new WinScreen(this);
       setScreen(WinScreen);
    }
	public void  SetLevels()
    {
       Levels = new Levels(this);
       setScreen(Levels);
    }
	@Override
	public void create () {
		
		 //Back=new Sprite(new Texture("Back2.jpeg"));
		
		float aspectRatio=(float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
		
		
		//Camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	  
	//    Camera.translate(Camera.viewportWidth/2,Camera.viewportHeight/2);
	    
		Gdx.input.setInputProcessor(this);
		
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
		batch = new SpriteBatch();
		setScreen(new MainMenu(this));
 
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		
		
		return false;
		//return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
