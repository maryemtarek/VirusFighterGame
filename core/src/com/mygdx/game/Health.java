package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Health {

	Rectangle bottom;
	Texture texture;
	Sprite sprite;
	
	public Health(float x,float y)
	{
		bottom=new Rectangle(0.0f,0.0f,35,64);
		texture=new Texture(Gdx.files.internal("Health.png"));
		sprite=new Sprite(texture,0,0,35,64);
		this.setposition(x, y);
	}
	
	public int hits (Rectangle r)
	{
		if(bottom.overlaps(r))
		{
			return 1;
		}
		return -1;
	}
	
	public void draw(SpriteBatch batch)
	{
		sprite.draw(batch);
	}
	
	public void setposition(float x,float y)
	{
		bottom.x=x;
		bottom.y=y;
		sprite.setPosition(x, y);
	}
	
}
