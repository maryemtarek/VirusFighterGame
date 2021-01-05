package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.util.*;

public class PlayScreen implements Screen {

	fighter Fighter;
	ArrayList<Block> Blocks = new ArrayList<Block>();
	ArrayList<Health> health = new ArrayList<Health>();
	ArrayList<Spike> Spikes = new ArrayList<Spike>();
	private MyGdxGame VirusGame;
	Rectangle leftedge, rightedge;
	ArrayList<Virus> Viruses = new ArrayList<Virus>();
	Rectangle rightbox = new Rectangle(2200, 0, 1000, 850);
	Rectangle leftbox = new Rectangle(-500, 0, 1000, 850);
	Rectangle camerabox = new Rectangle(0, 0, 5, 850);
	Texture EndOfGameTexture = new Texture(Gdx.files.internal("ENDOFLEVEL.png"));
	Sprite EndOfGameSprite = new Sprite(EndOfGameTexture, 0, 0, 110, 110);
	Rectangle LevelEndRectangle ;
	ArrayList<Weapon> Weapons = new ArrayList<Weapon>();
	public static int c = 0,c2=0;
	int level;
	

	public PlayScreen(MyGdxGame VirusGame,String filename, int level) {
		this.VirusGame = VirusGame;
		this.level = level;
		VirusGame.Camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	    VirusGame.Camera.translate( VirusGame.Camera.viewportWidth/2, VirusGame.Camera.viewportHeight/2);
		if (Characters.choosenone.equals("Boy.png")) {
			Fighter = new BoyFighter(VirusGame);
		} else {
			Fighter = new GirlFighter(VirusGame);
		}
		Fighter.score = 0;
		Fighter.Score = "Score: " + Fighter.score;
		
		
		FileHandle file = Gdx.files.internal(filename);
		StringTokenizer token = new StringTokenizer(file.readString());
		
		// Reading Level From File
		while (token.hasMoreElements()) {
			String type = token.nextToken();
			if (type.equals("Block")) {
				Blocks.add(new Block(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
			} else if (type.equals("Virus1")) {
				Viruses.add(new virus1(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			} else if (type.equals("Virus2")) {
				Viruses.add(new virus2(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			} else if (type.equals("Virus3")) {
				Viruses.add(new virus3(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			}else if (type.equals("Health")) {
				health.add(new Health(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
			}else if (type.equals("EndOfGame")) {
				EndOfGameSprite = new Sprite(EndOfGameTexture, 0, 0, 110, 110);
			    LevelEndRectangle = new Rectangle(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()), 110, 110);
			}else if (type.equals("Spike")) {
				Spikes.add(new Spike(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
			} else if (type.equals("Virus4")) {
				Viruses.add(new virus4(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			}else if (type.equals("Virus5")) {
				Viruses.add(new virus5(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			}else if (type.equals("Virus6")) {
				Viruses.add(new virus6(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),level));
			}
		}
		
		
		
	}

	@Override
	public void show() {

		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Shooting Code
				if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {		
					if(Fighter instanceof GirlFighter) 				
					    Weapons.add(new Bullet(Fighter.FullRectangle));
					else
						Weapons.add(new Bomb(Fighter.FullRectangle));
				}
				ArrayList<Weapon> WeaponsToBeRemoved = new ArrayList<Weapon>();		
				ArrayList<Virus> VirusesTobeRemoved = new ArrayList<Virus>();
				      for (Weapon W : Weapons) {	
				    	  if(Fighter.isRight == false)
				    		  W.updateToLeft(delta);
				    	  else
				    		  W.updateToRight(delta);
					     for (Virus v : Viruses) {
						       if (W.Shooting(v.position)) {
						           	v.hits();
						         	if (v.killed)
							        	VirusesTobeRemoved.add(v);
					        	}
				        }
					  if (W.remove)
						  WeaponsToBeRemoved.add(W);
				}
				Weapons.removeAll(WeaponsToBeRemoved);
				Viruses.removeAll(VirusesTobeRemoved);
				//End of Shooting Code

		// VirusGame.Camera.position.set(Fighter.bottom.x,Fighter.bottom.y,0);
		VirusGame.Camera.update();

		VirusGame.batch.begin();
		
		VirusGame.batch.draw(VirusGame.Back, 0, 0);
		
		for (int i = 0; i < health.size(); ++i) {
			health.get(i).draw(VirusGame.batch);
		}

		
		// VirusGame.batch.draw(VirusGame.Back, 1548, 0);
		Fighter.draw();
		Fighter.update(Gdx.graphics.getDeltaTime());
		EndOfGameSprite.setPosition(LevelEndRectangle.x,  LevelEndRectangle.y);
		EndOfGameSprite.draw(VirusGame.batch);

		VirusGame.batch.setProjectionMatrix(VirusGame.Camera.combined);

		for (Block b : Blocks)
			b.draw(VirusGame.batch);
		
		
		for (Spike s : Spikes) {
			s.draw(VirusGame.batch);
		}
		
		
		
		
		//Draw Viruses
		for (Virus v : Viruses) {
			v.draw(VirusGame.batch);
			v.Update();
		}

		// hit block
		for (Block b : Blocks) {
			b.hits(Fighter);
		}
		
		for (Spike s : Spikes) {
			if (Fighter.bottom.overlaps(s.hitbox)) {
				Fighter.action(4,0,0);
				
				c2 ++;
 
			}
			}
		
		
		leftedge = new Rectangle(0, 0, 0, 800);
		rightedge = new Rectangle(2715, 0, 0, 800);

		if (Fighter.hits(leftedge) != -1) {
			Fighter.action(2, 0, 0);
		}
		if (Fighter.hits(rightedge) != -1) {
			Fighter.action(2, 2555, 0);
		}
		for (int i = 0; i < Viruses.size(); i++) {
			if (Fighter.FullRectangle.overlaps(Viruses.get(i).position)) {
				c++;
				Fighter.action(1, 0, 0);
			}
		}
		//Win
		if (Fighter.FullRectangle.overlaps(LevelEndRectangle)) {
			if (Fighter.score >= 100*level) {
				VirusGame.SetWinScreen();
			}
		}
		// controlls
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

			Fighter.moveleft(Gdx.graphics.getDeltaTime());
			if (!leftbox.overlaps(camerabox)) {
				VirusGame.Camera.translate(-1.3f, 0f);
			}
			camerabox.x = VirusGame.Camera.position.x;

		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

			Fighter.moveright(Gdx.graphics.getDeltaTime());

			if (!rightbox.overlaps(camerabox)) {

				VirusGame.Camera.translate(1.3f, 0f);
			}
			camerabox.x = VirusGame.Camera.position.x;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			if (Fighter.yaxismotion == 0)
				Fighter.jump();
		}

		for (int i = 0; i < health.size(); ++i) {
			if (health.get(i).hits(Fighter.bottom) == 1) {

				health.remove(i);
				Fighter.action(3, 0, 0);
				i--;
			}
		}
		/*
		 * for(Virus v: Viruses) {
		 * 
		 * v.hits(Fighter.bottom); if(v.killed) { Viruses.remove(v); break; } }
		 */

		// Draw Weapons
	    for (Weapon W : Weapons) {		
	       	W.render(VirusGame.batch);
     	}
	    
		Fighter.Hfont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		Fighter.Hfont.draw(VirusGame.batch, Fighter.htext, VirusGame.Camera.position.x + 115,
				VirusGame.Camera.position.y + 420);
		Fighter.Hfont.draw(VirusGame.batch, Fighter.Score, VirusGame.Camera.position.x - 500,
				VirusGame.Camera.position.y + 420);
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
