package entities;

import java.awt.image.BufferedImage;

import main.Handler;
import tiles.Tile;

public abstract class Mob extends Entity 
{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	protected int dir; //direction (up = 8, down = 2, left = 4, right = 6)
	protected boolean isSwimming;
	protected boolean onTallGrass;
	protected boolean isMoving;
	protected boolean noClipping;
	
	protected BufferedImage head;
	protected BufferedImage body;
	protected BufferedImage grassParticle;

	public Mob(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		this.xMove = 0;
		this.yMove = 0;
	}
	
	public void move()
	{
		if(xMove!=0 || yMove !=0)
			this.isMoving = true;
		if(xMove==0 && yMove==0)
			this.isMoving = false;
		this.moveY();
		this.moveX();
		//checks the current tile the mob is on and then sets if its swimming / on tall grass etc.
		this.checkCurrentTile();
		
		this.tileX = (int) ((this.x)/(Tile.TILEWIDTH));
		this.tileY = (int) ((this.y)/(Tile.TILEHEIGHT));
	}
	
	public void moveX()
	{
		if(noClipping)
		{
			this.x += xMove;
		}
		else
		if(xMove > 0)//Moving right
		{
			this.dir = 6;
			int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) &&
			   !collisionWithTile(tx, (int)(y + bounds.y + (bounds.height/2)) / Tile.TILEHEIGHT)&&
			   !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				this.x += xMove;
			}
			else
			{
				this.x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMove < 0)//Moving left
		{
			this.dir = 4;
			int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) &&
			   !collisionWithTile(tx, (int)(y + bounds.y + (bounds.height/2)) / Tile.TILEHEIGHT)&&
			   !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				this.x += xMove;
			}
			else
			{
				this.x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY()
	{
		if(noClipping)
		{
			this.y += yMove;
		}
		else
		if(yMove < 0)//Up
		{
			this.dir = 8;
			int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) &&
			   !collisionWithTile((int) (x + bounds.x + (bounds.width/2)) / Tile.TILEWIDTH, ty) &&
			   !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				this.y += yMove;
			}
			else
			{
				this.y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if(yMove > 0)//Down
		{
			this.dir = 2;
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) &&
			   !collisionWithTile((int) (x + bounds.x + (bounds.width/2)) / Tile.TILEWIDTH, ty) &&
			   !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				this.y += yMove;
			}
			else
			{
				this.y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y)
	{
		boolean collision = false;
		for(int layer = 0; layer < handler.getWorld().getLayers(); layer++)
		{
			if(handler.getWorld().getTile(x, y, layer).isSolid())//return it immediately for faster runtime.
				return true;
		}
		return collision;
	}
	
	protected void checkCurrentTile()
	{
		if(inWater())
			setSwimming(true);
		else
			setSwimming(false);
		
		if(onTallGrass())
			setOnTallGrass(true);
		else
			setOnTallGrass(false);
	}
	
	protected boolean onTallGrass()
	{
		if(noClipping)
			return false;
		return handler.getWorld().getTile((int)(this.x+(this.width/2))/Tile.TILEWIDTH, (int)(this.y+3+(this.height/2))/Tile.TILEHEIGHT, 1).isTallGrass();
	}
	
	protected boolean inWater() //Checking if the mobtype is in a tile that is water.
	{
		if(noClipping)
			return false;
		return handler.getWorld().getTile((int)(this.x+(this.width/2))/Tile.TILEWIDTH, (int)(this.y+(this.height/2))/Tile.TILEHEIGHT, 0).isWater();
	}
	
	//GETTERS SETTERS

	public float getxMove()
	{
		return this.xMove;
	}

	public void setxMove(float xMove)
	{
		this.xMove = xMove;
	}

	public float getyMove()
	{
		return this.yMove;
	}

	public void setyMove(float yMove)
	{
		this.yMove = yMove;
	}

	public int getHealth() 
	{
		return this.health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public float getSpeed() 
	{
		return this.speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}
	
	public boolean getSwimming()
	{
		return this.isSwimming;
	}
	
	public void setSwimming(boolean s)
	{
		this.isSwimming = s;
	}
	
	public boolean getOnTallGrass()
	{
		return this.onTallGrass;
	}
	
	public void setOnTallGrass(boolean t)
	{
		this.onTallGrass = t;
	}
	
}