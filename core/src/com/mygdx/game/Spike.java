package com.mygdx.game;
 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
 
public class Spike {
	Rectangle hitbox;
	Sprite sprite_Spikes;
	Texture texture_Spikes;
 
	public Spike (int x,int y)
	{
		hitbox =  new Rectangle (x,y,165,22);
		texture_Spikes = new Texture(Gdx.files.internal("Spikes.png"));
		sprite_Spikes = new Sprite (texture_Spikes,0,0,165,22);
 
		setPosition(x,y);
	}
 
	public void setPosition (int x,int y)
	{
		hitbox.x = x;
		hitbox.y=y;
		sprite_Spikes.setPosition(x, y);
	}
 
 
    void draw (SpriteBatch batch)
     {
    	sprite_Spikes.draw(batch);
     }
 
 
}