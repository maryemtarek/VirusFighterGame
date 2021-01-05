package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
 abstract class Virus {
    int Score;
	Rectangle position;
	float velocity,initialPositionX,initialPositionY;
	Sprite sprite;
	Texture texture;
	boolean direction,killed=false;
	
	Virus(float x,float y)
	{
		initialPositionX =x;
		initialPositionY=y;
		direction=false;
		
	}
	// decreasing virus score 
	void hits()
	{
		Score-=1;
		if(Score==0)
		{
			killed=true;
		}
			
	}
	 
    void draw (SpriteBatch batch)
     {
		sprite.draw(batch);
     }
    
	void setPosition(float x, float y)
	{
	  position.x  = x;
	  position.y = y;
	  sprite.setPosition(x, y);
	}
	
	abstract void Update();	// Allow virus to move in a Specific area
}


class virus1 extends Virus  {
	
	virus1(float x,float y,int level)
	{
		super(x,y);
		Score = level;
		texture = new Texture (Gdx.files.internal("virus1.png"));
		position = new Rectangle(x,y,26,33);
		sprite = new Sprite(texture,0,0,26,33);
		velocity = 1;
		setPosition(x,y+22);
		
	}
	
	@Override
	
	void Update (){
		if(direction) {
			
			position.x+=velocity; // move right
			setPosition(position.x,position.y);
			 }
			else
			{
				position.x-=velocity; // move left
				setPosition(position.x,position.y);
			}
		
			if(position.x==initialPositionX) // Change direction when reaching the initial position
			{
				direction=false;
			}
			if(position.x==initialPositionX-105) // Change the direction when reaching the end of the block
			{
				direction =true;
				
			} 
	}
	
	
}

class virus2 extends Virus  {
	
	virus2(float x,float y,int level)
	{
		super(x,y);
		Score = level;
		texture = new Texture (Gdx.files.internal("virus2.png"));
		position = new Rectangle(x,y+20,43,31);
		sprite = new Sprite(texture,0,0,43,31);
		velocity = 2;
		setPosition(x,y+22);
		
	}

	@Override
	void Update() {
		// TODO Auto-generated method stub
		
		if(direction) {
			
			position.x+=velocity; // move right
			setPosition(position.x,position.y);
			 }
			else
			{
				position.x-=velocity;// move left
				setPosition(position.x,position.y);
			}
		
			if(position.x==initialPositionX) // Change direction when reaching the initial position
			{
				direction=false;
			}
			if(position.x==initialPositionX-110) // Change the direction when reaching the end of the block
			{
				direction=true;
				
			} 
	}
	
	
}



class virus3 extends Virus  {
	
	virus3(float x,float y,int level)
	{
		super(x,y);
		Score = level+1;
		texture = new Texture (Gdx.files.internal("virus3.png"));
		sprite = new Sprite(texture,0,0,68,28);
		position = new Rectangle(x,y,68,28);
		velocity = 2;
		setPosition(x,y);
		
	}

	@Override
	void Update() {
		// TODO Auto-generated method stub
      if(direction) {
			
			position.y+=velocity; // Move Up
			setPosition(position.x,position.y);
			 }
			else
			{
				position.y-=velocity; //Move down
				setPosition(position.x,position.y);
			}
			if(position.y==initialPositionY) // Change the direction when reaching the initial position
			{
				direction=false;
			}
			if(position.y==initialPositionY-110) // Change the direction when reaching the last position
			{
				direction=true;
				
			} 
		
	}
	
	
}
class virus4 extends Virus  {
	
	virus4(float x,float y,int level)
	{
		super(x,y);
		Score = level;
		texture = new Texture (Gdx.files.internal("virus4.png"));
		position = new Rectangle(x,y+20,50,71);
		sprite = new Sprite(texture,0,0,50,71);
		velocity = 2;
		setPosition(x,y+22);
		
	}

	@Override
	void Update() {
		// TODO Auto-generated method stub
		
		if(direction) {
			
			position.x+=velocity; // move right
			setPosition(position.x,position.y);
			 }
			else
			{
				position.x-=velocity;// move left
				setPosition(position.x,position.y);
			}
		
			if(position.x==initialPositionX) // Change direction when reaching the initial position
			{
				direction=false;
			}
			if(position.x==initialPositionX-110) // Change the direction when reaching the end of the block
			{
				direction=true;
				
			} 
	}
	
	
}

class virus5 extends Virus  {
	
	virus5(float x,float y,int level)
	{
		super(x,y);
		Score = level;
		texture = new Texture (Gdx.files.internal("virus5.png"));
		position = new Rectangle(x,y+20,50,46);
		sprite = new Sprite(texture,0,0,50,46);
		velocity = 3;
		setPosition(x,y+22);
		
	}

	@Override
	void Update() {
		// TODO Auto-generated method stub
		
		if(direction) {
			
			position.x+=velocity; // move right
			setPosition(position.x,position.y);
			 }
			else
			{
				position.x-=velocity;// move left
				setPosition(position.x,position.y);
			}
		
			if(position.x>=initialPositionX) // Change direction when reaching the initial position
			{
				direction=false;
			}
			if(position.x<=initialPositionX-110) // Change the direction when reaching the end of the block
			{
				direction=true;
				
			} 
	}
}

class virus6 extends Virus  {
	
	virus6(float x,float y,int level)
	{
		super(x,y);
		Score = level+1;
		texture = new Texture (Gdx.files.internal("virus6.png"));
		sprite = new Sprite(texture,0,0,50,49);
		position = new Rectangle(x,y,50,49);
		velocity = 2;
		setPosition(x,y);
		
	}

	@Override
	void Update() {
		// TODO Auto-generated method stub
      if(direction) {
			
			position.y+=velocity; // Move Up
			setPosition(position.x,position.y);
			 }
			else
			{
				position.y-=velocity; //Move down
				setPosition(position.x,position.y);
			}
			if(position.y==initialPositionY) // Change the direction when reaching the initial position
			{
				direction=false;
			}
			if(position.y==initialPositionY-110) // Change the direction when reaching the last position
			{
				direction=true;
				
			} 
		
	}
	
	
}
