package com.mygdx.game;

import javax.swing.text.Position;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import java.util.ArrayList;

//Weapons
public abstract class Weapon {
	public static final int speed = 450;
	public Boolean remove = false;
	public Boolean Killed = false;
    Music music;
	Rectangle position;
	int initialPosition;
	
	public Weapon(Rectangle pos) {
		this.position = pos;			
		initialPosition = (int) this.position.x;
	}

	public abstract void updateToRight(float deltaTime);
	public abstract void updateToLeft(float deltaTime);
	public abstract void render(SpriteBatch batch);
	
	public Boolean Shooting(Rectangle virus) {
		if (position.overlaps(virus)) {
			music.setVolume(0.5f);
			music.play();
			fighter.score += 15;
			fighter.Score = "Score: " + fighter.score;
			remove = true;
			return true;
		}
		return false;
	}
}

class Bullet extends Weapon{
	private static Texture textureBullet;
	public Bullet(Rectangle position) {
		super(new Rectangle(position.x + 40, position.y + 10, 29, 19));
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			textureBullet = new Texture("bullet2.png");
		else
		    textureBullet = new Texture("bullet.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Shot.mp3"));
	}

	@Override
	public void updateToRight(float deltaTime) {
		position.x += speed * deltaTime;
		position.y += 50 * deltaTime;
		if (position.x > (initialPosition + 300))
			remove = true;
	}

	@Override
	public void updateToLeft(float deltaTime) {
		// TODO Auto-generated method stub
		position.x -= speed * deltaTime;
		position.y += 50 * deltaTime;
		if (position.x < (initialPosition - 400))
			remove = true;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(textureBullet, position.x, position.y);
	}
	
	
}

class Bomb extends Weapon{
	Body Bomb;
	private static Texture textureBomb;	
	
	public Bomb(Rectangle position) {
		super(new Rectangle(position.x + 20, position.y + 20, 50, 50));
		textureBomb = new Texture("bomb.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Blast.mp3"));
	}

	@Override
	public void updateToRight(float deltaTime) {
		// TODO Auto-generated method stub
		position.x += speed * deltaTime;
		position.y -= 80 * deltaTime;
		if (position.x > (initialPosition + 300))
			remove = true;
	}
	
	@Override
	public void updateToLeft(float deltaTime) {
		// TODO Auto-generated method stub
		position.x -= speed * deltaTime;		
		position.y -= 90 * deltaTime;
		if (position.x < (initialPosition - 400))
			remove = true;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(textureBomb, position.x, position.y);
	}
}