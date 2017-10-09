package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;

public abstract class Entity 
{
	protected Handler handler;
	protected float x, y;
	protected int tileX, tileY;
	protected int width, height;
	protected Rectangle bounds;
	protected int renderRangeX = 350;
	protected int renderRangeY = 225;

	protected int tickCount = 0;
	
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean shouldRender()
	{		
		if((Math.abs(handler.getPlayer().x - this.x) < this.renderRangeX) && (Math.abs(handler.getPlayer().y - this.y) < this.renderRangeY))
			return true;
		else
			return false;
	}

	public float getX()
	{
		return this.x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY() 
	{
		return this.y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	public int getTileX()
	{
		return this.tileX;
	}

	public void setTileX(int tX)
	{
		this.tileX = tX;
	}

	public int getTileY() 
	{
		return this.tileY;
	}

	public void setTileY(int tY)
	{
		this.tileY = tY;
	}

	public int getWidth()
	{
		return this.width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
}