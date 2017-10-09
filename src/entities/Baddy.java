package entities;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Animation;
import gfx.Assets;
import main.Handler;

public class Baddy extends Mob
{
	protected boolean isHostile;
	
	//animations
	private Animation walkUp = new Animation(Assets.baddyWalkingUp, false, 10);
	private Animation walkLeft = new Animation(Assets.baddyWalkingLeft, false, 10);
	private Animation walkDown = new Animation(Assets.baddyWalkingDown, false, 10);
	private Animation walkRight = new Animation(Assets.baddyWalkingRight, false, 10);
	
	protected int randDir; //random direction for the AI
	protected int aggroRange = 150;

	public Baddy(Handler handler, float x, float y)
	{
		super(handler, x, y, Mob.DEFAULT_CREATURE_WIDTH, Mob.DEFAULT_CREATURE_HEIGHT);
		this.setSpeed(2);
		
		//default position is facing down.
		this.head = Assets.baddyHeadDirections[2];
		this.body = Assets.baddyStanding[2];
		this.randDir = handler.randomWithRange(1, 8);
		
		this.bounds.x = 2;
		this.bounds.y = 2;
		this.bounds.width = 28;
		this.bounds.height = 30;
	}
	
	private void movementAI()
	{
		//random movement
		boolean getNewDir = false;
		if(handler.randomWithRange(1,100) == 100)
			getNewDir = true;
		else
			getNewDir = false;
		if(getNewDir)
			randDir = handler.randomWithRange(1, 9);

		if(this.nearPlayer())
		{
			if((handler.getPlayer().getY() < this.y))//UP
	        {
				if((handler.getPlayer().getY() - this.y > 5 || handler.getPlayer().getY() - this.y < -5))
					this.yMove = -this.speed;
				else
					this.yMove = 0;
	        }
	        if((handler.getPlayer().getY() > this.y))//DOWN
	        {
	        	if((handler.getPlayer().getY() - this.y > 5 || handler.getPlayer().getY() - this.y < -5))
	        		this.yMove = this.speed;
				else
					this.yMove = 0;
	        }   
	        if((handler.getPlayer().getX() < this.x))//LEFT
	        {
	        	if((handler.getPlayer().getX() - this.x > 5 || handler.getPlayer().getX() - this.x < -5))
	        		this.xMove = -this.speed;
				else
					this.xMove = 0;
	        }       
	        if((handler.getPlayer().getX() > this.x))//RIGHT
	        {
	        	if((handler.getPlayer().getX() - this.x > 5 || handler.getPlayer().getX() - this.x < -5))
	        		this.xMove = this.speed;
				else
					this.xMove = 0;
	        }
		}
		else
		{
			switch(randDir)
			{
			case 1:
				this.xMove = -this.speed;
				this.yMove = 0;
				break;
			case 2:
				this.xMove = this.speed;
				this.yMove = 0;
				break;
			case 3:
				this.xMove = 0;
				this.yMove = -this.speed;
				break;
			case 4:
				this.xMove = 0;
				this.yMove = this.speed;
				break;
			case 5:
				this.xMove = -this.speed;
				this.yMove = -this.speed;
				break;
			case 6:			
				this.xMove = this.speed;
				this.yMove = this.speed;
				break;
			case 7:							
				this.xMove = -this.speed;
				this.yMove = this.speed;
				break;
			case 8:
				this.xMove = this.speed;
				this.yMove = -this.speed;
				break;
			case 9:		
				this.xMove = 0;
				this.yMove = 0;
				break;
			}
		}
	}
	
	private boolean nearPlayer() //if the baddy is in range of the player.
	{
		boolean isNearPlayer = false;
		
		if(handler.distform(handler.getPlayer().getX(),handler.getPlayer().getY(),this.x,this.y) < this.aggroRange)
			isNearPlayer = true;
		
		return isNearPlayer;
	}

	@Override
	public void tick()
	{
		this.movementAI();
		this.move();
		this.updateAnimations();
		this.tickCount++;
	}
	

	@Override
	public void render(Graphics g)
	{
		int drawX = (int) (x - handler.getGameCamera().getxOffset());
		int drawY = (int) (y - handler.getGameCamera().getyOffset());
		boolean shouldDrawBody = true;

		if(getSwimming())
		{
			//drawing the water around the player
			g.drawImage(Assets.displacedWaterParticle, drawX, drawY+18, 32, 16, null);
			drawY+=16;
			shouldDrawBody = false;
		}
		
		//rendering the player
		if(shouldDrawBody)
			g.drawImage(this.body, drawX, drawY+2, width, height, null);
		g.drawImage(this.head, drawX, drawY-16, width, height, null);
		
		if(getOnTallGrass())
		{
			g.drawImage(Assets.grassParticle, drawX, drawY+18, 32, 16, null);
		}
		//drawing a green line connecting the player and the baddy if it's in range.
		if(handler.getGame().debugMode == true)		
		{
			if(this.nearPlayer())
			{
				g.setColor(Color.GREEN);
	        	g.drawLine((int)(x + bounds.x - handler.getGameCamera().getxOffset())+bounds.width/2, (int)(y + bounds.y - handler.getGameCamera().getyOffset())+bounds.height/2, (int)((handler.getPlayer().getX() - handler.getGameCamera().getxOffset()))+handler.getPlayer().bounds.width/2, (int)((handler.getPlayer().getY() - handler.getGameCamera().getyOffset()))+handler.getPlayer().bounds.height/2);
			}
			//drawing aggro range
			g.setColor(Color.CYAN);
			g.drawOval(drawX-aggroRange+bounds.width/2, drawY-aggroRange+bounds.height/2, aggroRange*2, aggroRange*2);
		
			//drawing hitbox.
			g.setColor(Color.RED);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
	private void updateAnimations()
	{
		if(this.dir == 8)//up
		{
			if(this.isMoving)
			{
				this.walkUp.start();
				this.walkUp.update();
				this.body = walkUp.getSprite();
			}
			else
				this.body = Assets.baddyStanding[0];
			
			this.head = Assets.baddyHeadDirections[0];
		}
		if(this.dir == 4)//left
		{
			if(this.isMoving)
			{
				this.walkLeft.start();
				this.walkLeft.update();
				this.body = walkLeft.getSprite();
			}
			else
				this.body = Assets.baddyStanding[1];
			
			this.head = Assets.baddyHeadDirections[1];
		}
		if(this.dir == 2)//down
		{
			if(this.isMoving)
			{
				this.walkDown.start();
				this.walkDown.update();
				this.body = walkDown.getSprite();
			}
			else
				this.body = Assets.baddyStanding[2];
			
			this.head = Assets.baddyHeadDirections[2];
		}
		if(this.dir == 6)//right
		{
			if(this.isMoving)
			{
				this.walkRight.start();
				this.walkRight.update();
				this.body = walkRight.getSprite();
			}
			else
				this.body = Assets.baddyStanding[3];
			
			this.head = Assets.baddyHeadDirections[3];
		}
	}
}
