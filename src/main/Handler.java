package main;

import entities.Player;
import gfx.GameCamera;
import input.KeyManager;
import worlds.World;

public class Handler 
{
	private Game game;
	private World world;
	private Player player;
	
	public Handler(Game game)
	{
		this.game = game;
	}
	
	public GameCamera getGameCamera()
	{
		return this.game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return this.game.getKeyManager();
	}
	
	public int getWidth()
	{
		return this.game.getWidth();
	}
	
	public int getHeight()
	{
		return this.game.getHeight();
	}
	
	public Game getGame() 
	{
		return this.game;
	}

	public void setGame(Game game) 
	{
		this.game = game;
	}

	public World getWorld()
	{
		return this.world;
	}

	public void setWorld(World world) 
	{
		this.world = world;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public void setPlayer(Player p)
	{
		this.player = p;
	}
	
	//some helper methods.
	public int randomWithRange(int min, int max)
	{ 
		int range = (max - min) + 1; 
		return (int)(Math.random() * range) + min; 
	}
	
	public int distform(int x, int y, int x1, int y1)
	{
	   return ((int) Math.sqrt((Math.pow((x1-x),2))+(Math.pow((y1-y),2))));
	}
	
	public float distform(float x, float y, float x1, float y1)
	{
	   return ((float) Math.sqrt((Math.pow((x1-x),2))+(Math.pow((y1-y),2))));
	}
}
