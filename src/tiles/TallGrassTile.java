package tiles;

import java.awt.image.BufferedImage;

public class TallGrassTile extends Tile
{
	public TallGrassTile(BufferedImage texture, int id)
	{
		super(texture, id);
	}
	
	@Override
	public boolean isTallGrass()
	{
		return true;
	}

}
