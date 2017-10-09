package worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import entities.Entity;
import main.Handler;
import tiles.Tile;
import util.Utils;

public class World 
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private ArrayList<Entity> entities;
	private ArrayList<int[][]> layers;
	private int[][] tilesLayer0;
	private int[][] tilesLayer1;
	private int[][] tilesLayer2;
	private int[][] tilesLayer3;
	
	private int highlightLayer = 0;
	private boolean highlight = false;
	private Color highlightColor = new Color(255,255,0,100);

	public World(Handler handler, String path)
	{
		this.handler = handler;
		loadWorld(path);
	}
	
	public Tile getTile(int x, int y, int layer)
	{
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[layers.get(layer)[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public void setTile(int x, int y, int layer, int id)
	{
		if(x < 0 || y < 0 || x >= width || y >= height)
			return;

		//gets specific layer and sets the tile.
		layers.get(layer)[x][y] = id;
	}
	
	public int getSpawnX()
	{
		return spawnX;
	}
	
	public int getSpawnY()
	{
		return spawnY;
	}
	
	public int[][] getTilesLayer0()
	{
		return this.tilesLayer0;
	}
	public int[][] getTilesLayer1()
	{
		return this.tilesLayer1;
	}
	public int[][] getTilesLayer2()
	{
		return this.tilesLayer2;
	}
	public int[][] getTilesLayer3()
	{
		return this.tilesLayer3;
	}
	
	public int getLayers()
	{
		return this.layers.size();
	}
	
	public boolean getHighlight()
	{
		return this.highlight;
	}
	public void setHighlight(boolean h)
	{
		this.highlight = h;
	}
	public int getHighlightLayer()
	{
		return this.highlightLayer;
	}
	public void setHighlightLayer(int h)
	{
		this.highlightLayer = h;
	}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tilesLayer0 = new int[width][height];
		tilesLayer1 = new int[width][height];
		tilesLayer2 = new int[width][height];
		tilesLayer3 = new int[width][height]; 
		layers = new ArrayList<int[][]>();
		layers.add(tilesLayer0);
		layers.add(tilesLayer1);
		layers.add(tilesLayer2);
		layers.add(tilesLayer3);
		
		int token = 4; //which number its reading in
		for(int l = 0; l < layers.size(); l++)
		{
			for(int y = 0; y < height; y++)
			{
				for(int x = 0; x < width; x++)
				{
					if(layers.get(l)[x][y]  == 0)
						layers.get(l)[x][y] = Utils.parseInt(tokens[token]);
					token++;
				}
			}
		}
	}
	
	public ArrayList<Entity> getEntities()
	{
		return this.entities;
	}
	
	public void setEntities(ArrayList<Entity> e)
	{
		this.entities = e;
	}
	
	public void tick()
	{

	}
	
	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);
		
		for(int layer = 0; layer < layers.size(); layer++)//rendering in all the layers.
		{
			for(int y = yStart; y < yEnd; y++)
			{
				for(int x = xStart; x < xEnd; x++)
				{
					if(!getTile(x,y,layer).isAir())//dont render in air tiles, saves a ton of fps.
						getTile(x, y, layer).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
					if(layer==highlightLayer)
					{
						if(highlight && !getTile(x,y,layer).isAir()) //if its highlighting and the tile isnt air.
						{
							g.setColor(highlightColor);
							g.fillRect((int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()), Tile.TILEWIDTH, Tile.TILEHEIGHT);
						}
					}
				}
			}
		}
	}
}
