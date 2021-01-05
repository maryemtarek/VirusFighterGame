package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block {
	Rectangle box;
	Sprite sprite;
	Texture texture;
	
	public Block (int x,int y)
	{
		box =  new Rectangle (x,y,140,22);
		texture = new Texture(Gdx.files.internal("block.png"));
		sprite = new Sprite (texture,0,0,165,22);
				
		setPosition(x,y);
	}
	
	public void setPosition (int x,int y)
	{
		box.x = x;
		box.y=y;
		sprite.setPosition(x, y);
	}
	
	 
    void draw (SpriteBatch batch)
     {
		sprite.draw(batch);
     }
    
    void hits(fighter  Fighter)
    {
    	if (Fighter.bottom.overlaps(box))
    	{
    		
    		Fighter.yaxismotion=0;
    		Fighter.setposition(Fighter.bottom.x, box.y+22);//Update Fighter Position
    	}
    }
}
