package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.Animation;
import gfx.Assets;
import gfx.Sound;
import main.Handler;
import states.State;
import tiles.Tile;

public class Player extends Mob
{	
	//things for attacking
	private BufferedImage sword;
	private Rectangle swordBounds;
	private float swordX;
	private float swordY;
	private float headX;
	private float headY;
	private float bodyX;
	private float bodyY;
	
	
	private boolean attacking;
	private boolean attackSoundPlaying;
	private boolean walkSoundPlaying;
	private int walkCount;
	private int attackCount;
	private int attackDelay = 15;//amount of time (ticks) each attack takes.(default is 18)
	//animations
	private Animation walkUp = new Animation(Assets.playerWalkingUp, false, 5);
	private Animation walkLeft = new Animation(Assets.playerWalkingLeft, false, 5);
	private Animation walkDown = new Animation(Assets.playerWalkingDown, false, 5);
	private Animation walkRight = new Animation(Assets.playerWalkingRight, false, 5);
	private Animation attackUp = new Animation(Assets.playerAttackingUp, true, attackDelay/7);
	private Animation attackLeft = new Animation(Assets.playerAttackingLeft, true, attackDelay/7);
	private Animation attackDown = new Animation(Assets.playerAttackingDown, true, attackDelay/7);
	private Animation attackRight = new Animation(Assets.playerAttackingRight, true, attackDelay/7);	
	private Animation swordUp = new Animation(Assets.playerSwordUp, true, attackDelay/5);
	private Animation swordLeft = new Animation(Assets.playerSwordLeft, true, attackDelay/5);
	private Animation swordDown = new Animation(Assets.playerSwordDown, true, attackDelay/5);
	private Animation swordRight = new Animation(Assets.playerSwordRight, true, attackDelay/5);

	
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Mob.DEFAULT_CREATURE_WIDTH, Mob.DEFAULT_CREATURE_HEIGHT);
		this.setSpeed(3);
		
		//default position is facing down.
		this.head = Assets.playerHeadDirections[2];
		this.body = Assets.playerStanding[2];
		this.sword = Assets.air;
		this.grassParticle = Assets.grassParticle;
		this.walkCount = 0;
		this.attackCount = 0;
		
		//hitboxes
		this.bounds.x = 2;
		this.bounds.y = 2;
		this.bounds.width = 28;
		this.bounds.height = 30;
		
		this.swordBounds = new Rectangle(2, 2, 14, 14);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().shift)
		{
			setSpeed(10);
			this.noClipping = true;
		}
		else
		{
			setSpeed(3);
			this.noClipping = false;
		}

		if(handler.getKeyManager().up && !handler.getKeyManager().down)
			yMove = -speed;
		if(handler.getKeyManager().down && !handler.getKeyManager().up)
			yMove = speed;
		if(handler.getKeyManager().left && !handler.getKeyManager().right)
			xMove = -speed;
		if(handler.getKeyManager().right && !handler.getKeyManager().left)
			xMove = speed;
		
		//walking sound timing
		if(this.isMoving)
		{
			if(walkSoundPlaying)
			{
				walkCount++;
			}
			if(walkCount > 10)
			{
				walkCount = 0;
				walkSoundPlaying = false;
			}
			if(!walkSoundPlaying && !this.inWater())
			{
				Sound.playSfx("steps.wav");
				walkSoundPlaying = true;
			}
		}
		//attacking
		if(this.attacking)
		{
			attack();
		}
		if(handler.getKeyManager().spaceBar && !this.attacking)
		{
			attacking = true;
			attack();
		}
		if(this.attackCount>this.attackDelay+2) //resetting the attack after after it passes the time needed (attack delay)
		{
			attacking = false;
			attackSoundPlaying = false;
			this.swordX = -100;
			this.swordY = -100;
			attackCount = 0;
		}
		
		//Toggleable buttons
		if(handler.getKeyManager().debugMode)
		{
			if(handler.getGame().debugMode == false)
			{
				handler.getGame().debugMode = true;
				handler.getKeyManager().debugMode = false;
			}
			else
			{
				handler.getGame().debugMode = false;
				handler.getKeyManager().debugMode = false;
			}
		}
		if(handler.getKeyManager().escape)
		{
			if(State.getState() == handler.getGame().gameState)
			{
				State.setState(handler.getGame().menuState);
				handler.getKeyManager().escape = false;
			}
			else if(State.getState() == handler.getGame().menuState)
			{
				State.setState(handler.getGame().gameState);
				handler.getKeyManager().escape = false;
			}
		}
	}
	
	private void attack()
	{
		//stops movement while attacking.
		yMove = 0;
		xMove = 0;
		if(!attackSoundPlaying)
		{
			Sound.playSfx("swordSlash.wav");
			attackSoundPlaying = true;
		}
		checkSwordCollision(); //checking if the sword hit anything
		attackCount++;
	}
	
	@Override
	public void tick() 
	{
		getInput();
		this.move();
		this.handler.getGameCamera().centerOnEntity(this);
		this.updateAnimations();
		this.tickCount++;
	}

	@Override
	public void render(Graphics g)
	{
		int headOffsetX = 0;
		int headOffsetY = 0;
		int drawSwordX = (int) (swordX - handler.getGameCamera().getxOffset());
		int drawSwordY = (int) (swordY - handler.getGameCamera().getyOffset());
		boolean shouldDrawBody = true;
		
		if(getSwimming())
		{
			//drawing the water around the player
			g.drawImage(Assets.displacedWaterParticle, (int)headX, (int)headY+34, 32, 16, null);
			headOffsetY=16;
			shouldDrawBody = false;
		}
		
		//rendering the player
		if(shouldDrawBody)
			g.drawImage(this.body, (int)bodyX, (int)bodyY, width, height, null);
		if(attacking)
			g.drawImage(this.sword, drawSwordX, drawSwordY, width, height, null);
		g.drawImage(this.head, (int)headX+headOffsetX, (int)headY+headOffsetY, width, height, null);
		
		if(getOnTallGrass())
		{
			g.drawImage(this.grassParticle, (int)headX, (int)headY+34, 32, 16, null);
		}
		if(handler.getGame().debugMode == true)
		{
			g.setColor(Color.RED);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
			g.drawRect((int)(swordX + swordBounds.x - handler.getGameCamera().getxOffset()), (int)(swordY + swordBounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
	private void checkSwordCollision()
	{
		int swordTileX = (int)swordX / 16;
		int swordTileY = (int)swordY / 16;
		for(int layer = 0; layer < handler.getWorld().getLayers(); layer++)
			if(handler.getWorld().getTile(swordTileX, swordTileY, layer).equals(Tile.bush1Tile) || handler.getWorld().getTile(swordTileX+swordBounds.width/Tile.TILEWIDTH, swordTileY+swordBounds.height/Tile.TILEHEIGHT, layer).equals(Tile.bush1Tile) ||
			   handler.getWorld().getTile(swordTileX, swordTileY, layer).equals(Tile.bush2Tile) || handler.getWorld().getTile(swordTileX+swordBounds.width/Tile.TILEWIDTH, swordTileY+swordBounds.height/Tile.TILEHEIGHT, layer).equals(Tile.bush2Tile) ||
			   handler.getWorld().getTile(swordTileX, swordTileY, layer).equals(Tile.bush3Tile) || handler.getWorld().getTile(swordTileX+swordBounds.width/Tile.TILEWIDTH, swordTileY+swordBounds.height/Tile.TILEHEIGHT, layer).equals(Tile.bush3Tile) ||
			   handler.getWorld().getTile(swordTileX, swordTileY, layer).equals(Tile.bush4Tile) || handler.getWorld().getTile(swordTileX+swordBounds.width/Tile.TILEWIDTH, swordTileY+swordBounds.height/Tile.TILEHEIGHT, layer).equals(Tile.bush4Tile))
			{
				handler.getWorld().setTile(swordTileX, swordTileY, layer, 0);
			}
	}
	
	private void updateAnimations()
	{
		headX = (int) (x - handler.getGameCamera().getxOffset());
		headY = (int) (y - handler.getGameCamera().getyOffset()-16);
		bodyX = (int) (x - handler.getGameCamera().getxOffset());
		bodyY = (int) (y - handler.getGameCamera().getyOffset()+2);
		
		if(this.dir == 8)//up
		{
			if(this.isMoving)
			{
				this.walkUp.start();
				this.walkUp.update();
				this.body = walkUp.getSprite();
				
				if(!this.inWater())
				{
					if(tickCount%8<=2)//headbobbing
						headY += 1;
					if(tickCount%8>2 && tickCount%5<=4)
						headY += 0;
					if(tickCount%8>4 && tickCount%5<=6)
						headY -= 1;
					if(tickCount%8>6)
						headY += 0;
				}

			}
			else
			{
				this.walkUp.reset();
				this.body = Assets.playerStanding[0];
			}
			
			if(this.attacking)//setting attack animation and sword position.
			{
				this.attackUp.start();
				this.attackUp.update();
				this.body = attackUp.getSprite();
				this.swordUp.start();
				this.swordUp.update();
				this.sword = swordUp.getSprite();
				if(this.swordUp.getCurrentFrame() == 0)
				{
					swordX = this.x+20;
					swordY = this.y-15;
					headY -= 2;
					bodyY -= 1;
				}
				if(this.swordUp.getCurrentFrame() == 1)
				{
					swordX = this.x+10;
					swordY = this.y-30;
					headY -= 4;
					bodyY -= 2;
				}
				if(this.swordUp.getCurrentFrame() == 2)
				{
					swordX = this.x;
					swordY = this.y-30;
					headY -= 6;
					bodyY -= 3;
				}
				if(this.swordUp.getCurrentFrame() == 3)
				{
					swordX = this.x-10;
					swordY = this.y-30;
					headY -= 4;
					bodyY -= 2;
				}
				if(this.swordUp.getCurrentFrame() == 4)
				{
					swordX = this.x-20;
					swordY = this.y-15;
					headY -= 2;
					bodyY -= 1;
				}
			}
			else
			{
				this.attackUp.reset();
				this.swordUp.reset();
			}
			
			this.head = Assets.playerHeadDirections[0];
		}
		if(this.dir == 4)//left
		{
			if(this.isMoving)
			{
				this.walkLeft.start();
				this.walkLeft.update();
				this.body = walkLeft.getSprite();
				
				if(!this.inWater())
				{
					if(tickCount%8<=2)//headbobbing
					{
						headY += 1;
						headX -= 1;
					}
					if(tickCount%8>2 && tickCount%5<=4)
					{
						headY += 0;
						headX -= 1;
					}				
					if(tickCount%8>4 && tickCount%5<=6)
					{
						headY -= 1;
						headX += 1;
					}
					if(tickCount%8>6)
					{
						headY += 0;
						headX += 1;
					}	
				}
			}
			else
			{
				this.walkLeft.reset();
				this.body = Assets.playerStanding[1];
			}
			
			if(this.attacking)//setting attack animation and sword position.
			{
				this.attackLeft.start();
				this.attackLeft.update();
				this.body = attackLeft.getSprite();
				this.swordLeft.start();
				this.swordLeft.update();
				this.sword = swordLeft.getSprite();
				if(this.swordLeft.getCurrentFrame() == 0)
				{
					swordX = this.x-15;
					swordY = this.y-20;
					headX -= 2;
					bodyX -= 1;
				}
				if(this.swordLeft.getCurrentFrame() == 1)
				{
					swordX = this.x-30;
					swordY = this.y-10;
					headX -= 4;
					bodyX -= 2;
				}
				if(this.swordLeft.getCurrentFrame() == 2)
				{
					swordX = this.x-30;
					swordY = this.y;
					headX -= 6;
					bodyX -= 3;
				}
				if(this.swordLeft.getCurrentFrame() == 3)
				{
					swordX = this.x-30;
					swordY = this.y+10;
					headX -= 4;
					bodyX -= 2;
				}
				if(this.swordLeft.getCurrentFrame() == 4)
				{
					swordX = this.x-15;
					swordY = this.y+20;
					headX -= 2;
					bodyX -= 1;
				}
			}
			else
			{
				this.attackLeft.reset();
				this.swordLeft.reset();
			}
			
			this.head = Assets.playerHeadDirections[1];
		}
		if(this.dir == 2)//down
		{
			if(this.isMoving)
			{
				this.walkDown.start();
				this.walkDown.update();
				this.body = walkDown.getSprite();
				
				if(!this.inWater())
				{
					if(tickCount%8<=2)//headbobbing
						headY += 1;
					if(tickCount%8>2 && tickCount%5<=4)
						headY += 0;
					if(tickCount%8>4 && tickCount%5<=6)
						headY -= 1;
					if(tickCount%8>6)
						headY += 0;
				}

			}
			else
			{
				this.walkDown.reset();
				this.body = Assets.playerStanding[2];
			}
			
			if(this.attacking)//setting attack animation and sword position.
			{
				this.attackDown.start();
				this.attackDown.update();
				this.body = attackDown.getSprite();
				this.swordDown.start();
				this.swordDown.update();
				this.sword = swordDown.getSprite();
				if(this.swordDown.getCurrentFrame() == 0)
				{
					swordX = this.x-20;
					swordY = this.y+15;
					headY += 2;
					bodyY += 1;
				}
				if(this.swordDown.getCurrentFrame() == 1)
				{
					swordX = this.x-10;
					swordY = this.y+30;
					headY += 4;
					bodyY += 2;
				}
				if(this.swordDown.getCurrentFrame() == 2)
				{
					swordX = this.x;
					swordY = this.y+30;
					headY += 6;
					bodyY += 3;
				}
				if(this.swordDown.getCurrentFrame() == 3)
				{
					swordX = this.x+10;
					swordY = this.y+30;
					headY += 4;
					bodyY += 2;
				}
				if(this.swordDown.getCurrentFrame() == 4)
				{
					swordX = this.x+20;
					swordY = this.y+15;
					headY += 2;
					bodyY += 1;

				}
			}
			else
			{
				this.attackDown.reset();
				this.swordDown.reset();
			}
			
			this.head = Assets.playerHeadDirections[2];
		}
		if(this.dir == 6)//right
		{
			if(this.isMoving)
			{
				this.walkRight.start();
				this.walkRight.update();
				this.body = walkRight.getSprite();
				
				if(!this.inWater())
				{
					if(tickCount%8<=2)//headbobbing
					{
						headY += 1;
						headX += 1;
					}
					if(tickCount%8>2 && tickCount%5<=4)
					{
						headY += 0;
						headX += 1;
					}				
					if(tickCount%8>4 && tickCount%5<=6)
					{
						headY -= 1;
						headX -= 1;
					}
					if(tickCount%8>6)
					{
						headY += 0;
						headX -= 1;
					}		
				}
			}
			else
			{
				this.walkRight.reset();
				this.body = Assets.playerStanding[3];
			}
			
			if(this.attacking)//setting attack animation and sword position.
			{
				this.attackRight.start();
				this.attackRight.update();
				this.body = attackRight.getSprite();
				this.swordRight.start();
				this.swordRight.update();
				this.sword = swordRight.getSprite();
				if(this.swordRight.getCurrentFrame() == 0)
				{
					swordX = this.x+15;
					swordY = this.y-20;
					headX += 2;
					bodyX += 1;
				}
				if(this.swordRight.getCurrentFrame() == 1)
				{
					swordX = this.x+30;
					swordY = this.y-10;
					headX += 4;
					bodyX += 2;
				}
				if(this.swordRight.getCurrentFrame() == 2)
				{
					swordX = this.x+30;
					swordY = this.y;
					headX += 6;
					bodyX += 3;
				}
				if(this.swordRight.getCurrentFrame() == 3)
				{
					swordX = this.x+30;
					swordY = this.y+10;
					headX += 4;
					bodyX += 2;
				}
				if(this.swordRight.getCurrentFrame() == 4)
				{
					swordX = this.x+15;
					swordY = this.y+20;
					headX += 2;
					bodyX += 1;
				}
			}
			else
			{
				this.attackRight.reset();
				this.swordRight.reset();
			}
			
			this.head = Assets.playerHeadDirections[3];
		}
		
		//for grass animations
		if(this.isMoving && this.onTallGrass())
		{
			if(tickCount%12>6)
				this.grassParticle = Assets.grassParticleAnimations[0];
				else if(tickCount%12<6)
					this.grassParticle = Assets.grassParticleAnimations[1];
		}
	}
}