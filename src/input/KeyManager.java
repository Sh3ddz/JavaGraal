package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class KeyManager implements KeyListener, MouseListener, MouseMotionListener
{
	private boolean[] keys;
	public boolean up, down, left, right, shift, upArrow, downArrow, leftArrow, rightArrow, spaceBar, escape, debugMode;
	public int mX,mY,cX,cY,dX,dY;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		shift = keys[KeyEvent.VK_SHIFT];
		upArrow = keys[KeyEvent.VK_UP];
		downArrow = keys[KeyEvent.VK_DOWN];
		leftArrow = keys[KeyEvent.VK_LEFT];
		rightArrow = keys[KeyEvent.VK_RIGHT];
		spaceBar = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
		if(e.getKeyCode() == KeyEvent.VK_F3)
			debugMode = true;
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			escape = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
	      dY=e.getY();
	      dX=e.getX();
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
	      mY=e.getY();
	      mX=e.getX();		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
	      cY=e.getY();
	      cX=e.getX();
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

}