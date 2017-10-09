package gfx;

import entities.Entity;
import main.Game;
import worlds.World;

public class GameCamera 
{
	private Game game;
	private World world;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, World world, float xOffset, float yOffset)
	{
		this.world = world;
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e)
	{
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() /2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() /2; //+ 24;
		
		//At the corners of the world, camera un-centers player.
		if(xOffset <= 0)
			xOffset = 0;
		if(yOffset <= 0)
			yOffset = 0;
		if(xOffset >= (world.getTilesLayer0().length)*16 - game.getWidth())
			xOffset = (world.getTilesLayer0().length)*16 - game.getWidth();
		if(yOffset >= (world.getTilesLayer0()[0].length)*16 - game.getHeight())
			yOffset = (world.getTilesLayer0()[0].length)*16 - game.getHeight();

	}
	
	public void move(float xAmt, float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() 
	{
		return xOffset;
	}

	public void setxOffset(float xOffset) 
	{
		this.xOffset = xOffset;
	}

	public float getyOffset()
	{
		return yOffset;
	}

	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
}
