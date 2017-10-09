package states;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Entity;
import entities.Player;
import main.Handler;
import worlds.World;

public class GameState extends State 
{
	private Player player;
	private World world;
	private ArrayList<Entity> entitiesInWorld;
	
	public GameState(Handler handler)
	{
		super(handler);
		this.world = handler.getWorld();
		handler.setWorld(world);
		this.player = handler.getPlayer();
		this.entitiesInWorld = world.getEntities();
	}
	
	@Override
	public void tick()
	{
		world.tick();
		player.tick();

		if(world.getEntities() != null)
			for(int i = 0; i < world.getEntities().size(); i++)
				entitiesInWorld.get(i).tick();
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
		
		if(world.getEntities() != null)
			for(int i = 0; i < world.getEntities().size(); i++)
				if(entitiesInWorld.get(i).shouldRender())//so it only renders the entities in range of the player.
					entitiesInWorld.get(i).render(g);
	}

}