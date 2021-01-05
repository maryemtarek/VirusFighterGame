package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
public abstract class fighter {
	SpriteBatch batch;
	TextureAtlas R_RuntextureAtlas,L_RuntextureAtlas;
	Sprite R_Runsprite,L_Runsprite,Jumpsprite,Standsprite,Shootsprite,L_Shootsprite;
	TextureRegion R_RuntextureRegion,L_RuntextureRegion;
	Texture R_Jumptexture,L_Jumptexture,R_Standtexture,L_Standtexture;
	int currentFrame = 1;
	boolean isRight=true;
	Rectangle bottom,FullRectangle;
	float yaxismotion;
	String htext;
	BitmapFont Hfont ;
	int health;
    public static int score = 0;
	static String Score ;
	Sound jumpSound = Gdx.audio.newSound(Gdx.files.internal("jumping.wav"));
	Sound collectHealth = Gdx.audio.newSound(Gdx.files.internal("Collect.mp3"));
	
	 MyGdxGame VirusGame;
		public fighter(String name,MyGdxGame VirusGame,int health) {
			  batch=VirusGame.batch;

		      R_RuntextureAtlas = new TextureAtlas(Gdx.files.internal(String.format("Fighter/%s_Run.txt",name)));
		      R_RuntextureRegion = R_RuntextureAtlas.findRegion("Run (1)");
		      R_Runsprite = new Sprite(R_RuntextureRegion);
		      
		      L_RuntextureAtlas = new TextureAtlas(Gdx.files.internal(String.format("Fighter/%s_LRun.txt",name)));
		      L_RuntextureRegion = L_RuntextureAtlas.findRegion("Run (1)");      
		      L_Runsprite = new Sprite(L_RuntextureRegion);
		     
		      R_Jumptexture=new Texture(String.format("Fighter/%s_Jump.png",name));
		      L_Jumptexture=new Texture(String.format("Fighter/%s_LJump.png",name));
		      Jumpsprite=new Sprite(R_Jumptexture);
		      
		      R_Standtexture=new Texture(String.format("Fighter/%s_Stand.png",name));
		      L_Standtexture=new Texture(String.format("Fighter/%s_LStand.png",name));
		      Standsprite=new Sprite(R_Standtexture);
		      
		      
		yaxismotion=0;
		Hfont = new BitmapFont(Gdx.files.internal("myfont.fnt"));
		this.health=health;
		this.VirusGame=VirusGame;
		htext="Health:"+health;
                          Score = "Score: " + score;
		}
		
		public int hits(Rectangle r) {
			if(bottom.overlaps(r)) {
				return 1;	
			}
			return -1;
		}
		
		public void jump() {
			jumpSound.play(1.0f);
			yaxismotion=15;
		}

		public void setposition(float x, float y) {
			  R_Runsprite.setPosition(x,y);
		      L_Runsprite.setPosition(x,y);
		      Standsprite.setPosition(x,y);
		      Jumpsprite.setPosition(x, y);
		      Shootsprite.setPosition(x, y);
		      
		      bottom.setPosition(x, y);
		      FullRectangle.setPosition(x, y);
		}
		public void update(float time) {
			   yaxismotion-=(30*time);
			   bottom.y+=yaxismotion;
			   FullRectangle.y+=yaxismotion;
			   setposition(FullRectangle.x,FullRectangle.y);
		}
		public void draw() {
			 if(!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE)&&
					 !Gdx.input.isKeyPressed(Input.Keys.LEFT)&&!Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			       Standsprite.draw(batch);
			   
			  if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
				   Jumpsprite.draw(batch);   
			   
			   if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
			   {
				   shoot();
			   }
			   
		}
		public abstract void moveright(float time);
		public abstract void moveleft(float time);
		public abstract void action(int type, float x, float y) ;
		public abstract void shoot();
		

		
	}
	class BoyFighter extends fighter{
		
	int speed=110;
	
	TextureAtlas R_ShoottextureAtlas,L_ShoottextureAtlas;
	TextureRegion R_ShoottextureRegion,L_ShoottextureRegion;
	
	
		public BoyFighter(MyGdxGame VirusGame) {
			super("Boy", VirusGame,100);
			  bottom=new Rectangle(0.0f,0.0f,95,10);
		      FullRectangle=new Rectangle(0.0f,0.0f,150,129);
		     
		      R_ShoottextureAtlas=new TextureAtlas(Gdx.files.internal("Fighter/Boy_Throw.txt"));
		      L_ShoottextureAtlas=new TextureAtlas(Gdx.files.internal("Fighter/Boy_LThrow.txt")); 
		      
		      R_ShoottextureRegion=R_ShoottextureAtlas.findRegion("Throw (1)");
		      L_ShoottextureRegion=L_ShoottextureAtlas.findRegion("Throw (1)");
		      Shootsprite=new Sprite(R_ShoottextureRegion);
		      
		      setposition(0,22);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void action(int type, float x, float y) {
			
			 if(type==1) {
				 if(PlayScreen.c==1 ||PlayScreen.c%15==0) {
				             health-=15;
				}
				if(health<=0) {
					htext = "Health :" + 0;
					VirusGame.setGameOverScreen();
				}
				else {
				htext = "Health :" + health;}
			}
			//hits left or right
			else if(type==2) {
				setposition(x,bottom.y);
			}//hits the health box
			 else if(type==3) {
				 collectHealth.play(1.0f);
				 if(health<100) {
				health+=10;
				htext = "Health :" + health;}
			}
			 else if(type==4) {
				 htext = "Health :" + 0;
			VirusGame.setGameOverScreen();
			 }
			 }
		
		@Override
		public void moveright(float time) {
			isRight=true;
			
			FullRectangle.x+=(speed*time);
	        bottom.x+=(speed*time); 
	    	L_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);

	    	 if(!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
			   {
		      R_Runsprite.draw(batch);
			   }
	    	  Jumpsprite.setTexture(R_Jumptexture);
		      Jumpsprite.setPosition(FullRectangle.x,FullRectangle.y);
		      if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
				   Jumpsprite.draw(batch);
			     currentFrame++;
		         if(currentFrame > 10)
		            currentFrame = 1;
		         R_Runsprite.setRegion(R_RuntextureAtlas.findRegion(String.format("Run (%d)",currentFrame)));
		         R_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
		       
		         Standsprite = new Sprite(R_Standtexture);
		         Standsprite.setPosition(FullRectangle.x,FullRectangle.y); 	      
		}
		@Override
		public void moveleft(float time) {
			isRight=false;
			 FullRectangle.x-=(speed*time);
	         bottom.x-=(speed*time);	
			 R_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
			   
			   if(!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
			   {
		      L_Runsprite.draw(batch);
			   }
			      Jumpsprite.setTexture(L_Jumptexture);
			      Jumpsprite.setPosition(FullRectangle.x,FullRectangle.y);
			      if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))  
					   Jumpsprite.draw(batch);
			     
			      currentFrame++;
		         if(currentFrame > 10)
		            currentFrame = 1;
		         L_Runsprite.setRegion(L_RuntextureAtlas.findRegion(String.format("Run (%d)",currentFrame)));
		         L_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
		         
		         Standsprite = new Sprite(L_Standtexture);
		         Standsprite.setPosition(FullRectangle.x,FullRectangle.y);
		}	
		
		
		public void shoot()
		{
			if(isRight) {
				Shootsprite.draw(batch);
			 currentFrame++;
	         if(currentFrame > 10)
	            currentFrame = 1;
	         Shootsprite.setRegion(R_ShoottextureAtlas.findRegion(String.format("Throw (%d)",currentFrame)));
	         setposition(FullRectangle.x,FullRectangle.y);
		  }
			if(isRight==false)
			{
				Shootsprite.draw(batch);
				 currentFrame++;
		         if(currentFrame > 10)
		            currentFrame = 1;
		         Shootsprite.setRegion(L_ShoottextureAtlas.findRegion(String.format("Throw (%d)",currentFrame)));
		         setposition(FullRectangle.x,FullRectangle.y);
			}
		}
		
		
	}
	class GirlFighter extends fighter{
	
		int speed=100;
	
	Texture R_shoottexture,L_shoottexture;
	
	
		public GirlFighter(MyGdxGame VirusGame) {
			super("Girl", VirusGame,120);
			 bottom=new Rectangle(0.0f,10.0f,73,10);
		      FullRectangle=new Rectangle(0.0f,0.0f,150,118);
		     R_shoottexture=new Texture("Fighter/Girl_Shoot.png");
		     L_shoottexture=new Texture("Fighter/Girl_LShoot.png");
		      Shootsprite=new Sprite(R_shoottexture);
		      
		      setposition(0,22);
		}
		@Override
		public void action(int type, float x, float y) {
			
			if(health<=0) {
				htext = "Health :" + 0;
				VirusGame.setGameOverScreen();
			}			
			 if(type==1) {
				if(PlayScreen.c==1 ||PlayScreen.c%15==0) {
					health-=15;
				}
				setposition(bottom.x,bottom.y);
				if(health<=0) {
					htext = "Health :" + 0;
					VirusGame.setGameOverScreen();
				}else {
				htext = "Health :" + health;}
			 }//hits left or right edges
			else if(type==2) {
				setposition(x,bottom.y);
			}//hits the health box
			 else if(type==3) {
				 collectHealth.play(1.0f);
				 if(health<120) {
				health+=10;
				htext = "Health :" + health;}
				}else if(type==4) {
					
				 
				htext = "Health :" + 0;
				VirusGame.setGameOverScreen();
			
				 }
			 
		}
		
		
		@Override
		public void moveright(float time) {
			isRight=true;
			
			FullRectangle.x+=(speed*time);
	        bottom.x+=(speed*time); 
	    	L_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);

	    	 if(!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
			   {
		      R_Runsprite.draw(batch);
			   }
	    	  Jumpsprite.setTexture(R_Jumptexture);
		      Jumpsprite.setPosition(FullRectangle.x,FullRectangle.y);
		      if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
				   Jumpsprite.draw(batch);
	    	 
			     currentFrame++;
		         if(currentFrame > 8)
		            currentFrame = 1;
		         R_Runsprite.setRegion(R_RuntextureAtlas.findRegion(String.format("Run (%d)",currentFrame)));
		         R_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
		       
		         Standsprite = new Sprite(R_Standtexture);
		         Standsprite.setPosition(FullRectangle.x,FullRectangle.y);
		}
		@Override
		public void moveleft(float time) {
            isRight=false;
		
			 FullRectangle.x-=(speed*time);
	           bottom.x-=(speed*time);	
			   R_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
			   
			   if(!Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))
			   {
		      L_Runsprite.draw(batch);
			   }
			   Jumpsprite.setTexture(L_Jumptexture);
			      Jumpsprite.setPosition(FullRectangle.x,FullRectangle.y);
			      if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!Gdx.input.isKeyPressed(Input.Keys.SPACE))  
					   Jumpsprite.draw(batch);
			   
			      currentFrame++;
		         if(currentFrame > 8)
		            currentFrame = 1;
		         L_Runsprite.setRegion(L_RuntextureAtlas.findRegion(String.format("Run (%d)",currentFrame)));
		         L_Runsprite.setPosition(FullRectangle.x,FullRectangle.y);
		         
		         Standsprite = new Sprite(L_Standtexture);
		         Standsprite.setPosition(FullRectangle.x,FullRectangle.y);
		}	
		
		
		public void shoot()
		{
			if(isRight)
			{
				Shootsprite.setTexture(R_shoottexture);
			}
			if(!isRight)
			{
				Shootsprite.setTexture(L_shoottexture);
			}
			
			Shootsprite.draw(batch);
		}
		
}