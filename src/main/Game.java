package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import display.Display;
import entities.Baddy;
import entities.Entity;
import entities.Player;
import gfx.Assets;
import gfx.GameCamera;
import gfx.Sound;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;
import worlds.World;

public class Game implements Runnable
{

   private Display display;
   private int width, height;
   public String title;
	
   private boolean running = false;
   private Thread thread;
	
   private BufferStrategy bs;
   private Graphics g;
	
	//States
   public State gameState;
   public State menuState;
	
	//Input
   private KeyManager keyManager;
	
	//Entities
   private Player player;
   private ArrayList<Entity> entities;
	
	//Camera
   private GameCamera gameCamera;
	
	//Handler
   private Handler handler;
	
	//config
   private int TPS = 0;
   private int FPS = 0;
   private int seconds = 0;
   private int minutes = 0;
   private int hours = 0;
   public boolean debugMode = false;
	
	//custom colors
   private Color bg = new Color(0, 0, 0, 100);
   private static Font DEV_GUI_FONT = new Font("Arial", Font.PLAIN, 12);

   public Game(String title, int width, int height)
   {
      this.width = width;
      this.height = height;
      this.title = title;
      keyManager = new KeyManager();
   }
	
   private void init()
   {
      this.display = new Display(title, width, height);
      display.getFrame().addKeyListener(keyManager);
      display.getFrame().addMouseListener(keyManager);
      display.getFrame().addMouseMotionListener(keyManager);
      display.getCanvas().addMouseListener(keyManager);
      display.getCanvas().addMouseMotionListener(keyManager);
   	
      Assets.init();
  	  Sound.init();
	
  	  Sound.playMusic(Sound.songs[0]);

  	  Sound.setMusicVolume(-25.0f);
  	  Sound.setSfxVolume(-30.0f);
  		
      this.handler = new Handler(this);
      this.player = new Player(handler, 5761, 5329);
      handler.setPlayer(player);
      handler.setWorld(new World(handler, "src/resources/worlds/Graal.txt"));
      entities = new ArrayList<Entity>();
   	//initializing entities
      for(int i = 0; i < 50; i++)
      {
         float spawnX =(float)handler.randomWithRange(5000, 6000);
         float spawnY =(float)handler.randomWithRange(4500, 5500);
         Baddy b = new Baddy(handler, spawnX, spawnY);
         entities.add(b);
      }
   	
      handler.getWorld().setEntities(entities);
   	
      this.gameState = new GameState(handler);
      this.menuState = new MenuState(handler);
      State.setState(gameState);
   
      this.gameCamera = new GameCamera(this, handler.getWorld(), 300, 400);
   }
	
   private void tick()
   {
      keyManager.tick();
   	
      if(State.getState() != null)
         State.getState().tick();
   }
	
   private void render()
   {
      bs = display.getCanvas().getBufferStrategy();
      if(bs == null)
      {
         display.getCanvas().createBufferStrategy(3); //original is 3
         return;
      }
      g = bs.getDrawGraphics();
   	//Clear Screen
      g.clearRect(0, 0, width, height);
   	//Draw Here!
   	
      if(State.getState() != null)
         State.getState().render(g);
   	
      if(debugMode)
         devGUI(g);
   	
   	//End Drawing!
      bs.show();
      g.dispose();
   }
	
   public void devGUI(Graphics g)
   {
      String temp = "";
   	  g.setFont(DEV_GUI_FONT);
      temp = "DEV GUI";
      g.setColor(bg);
      g.fillRect(0, 0, (int)(temp.length()*7.5), 12);
      g.setColor(Color.YELLOW);
      g.drawString(temp, 0, 10);
      String secondsS = Integer.toString(seconds);
      String minutesS = Integer.toString(minutes);
      String hoursS = Integer.toString(hours);
      if(seconds<10)
      {
         secondsS = "0"+secondsS;
      }
      if(minutes<10)
      {
         minutesS = "0"+minutesS;
      }
      if(hours<10)
      {
         hoursS = "0"+hoursS;
      }
      temp = hoursS+":"+minutesS+":"+secondsS;
      g.setColor(bg);
      g.fillRect(0, 12, (int)(temp.length()*6.5), 12);
      g.setColor(Color.YELLOW);
      g.drawString(temp, 0, 22);
      temp = "FPS:"+this.FPS+", TPS:"+this.TPS;
      g.setColor(bg);
      g.fillRect(0, 24, (int)(temp.length()*6.5), 12);
      g.setColor(Color.YELLOW);
      g.drawString(temp, 0, 34);
      temp = "x: "+handler.getPlayer().getX()+", y:"+handler.getPlayer().getY();
      g.setColor(bg);
      g.fillRect(0, 36, (int)(temp.length()*5.5), 12);
      g.setColor(Color.YELLOW);
      g.drawString(temp, 0, 46);
      temp = "tileX:"+handler.getPlayer().getTileX()+", tileY:"+handler.getPlayer().getTileY();
      g.setColor(bg);
      g.fillRect(0, 48, (int)(temp.length()*5), 12);
      g.setColor(Color.YELLOW);
      g.drawString(temp, 0, 58);
   }
	
   public void run()
   {
   	
      init();
   	
      int tps = 60; //60 ticks per second.
      int fps = Integer.MAX_VALUE; //unlimited frames per second.
      double timePerTick = 1000000000 / tps;
      double timePerRender = 1000000000 / fps;
      double delta = 0;
      double delta2 = 0;
      long now;
      long lastTime = System.nanoTime();
      long timer = 0;
      int ticks = 0;
      int frames = 0;
   	
      while(running)
      {
         now = System.nanoTime();
         delta += (now - lastTime) / timePerTick;
         delta2 += (now - lastTime) / timePerRender;
         timer += now - lastTime;
         lastTime = now;
      	
         if(delta >= 1)//ticking
         {
            tick();
            ticks++;
            delta--;
         }
      	
         if(delta2 >= 1)//rendering
         {
            render();
            frames++;
            delta2--;
         }
      	
         if(timer >= 1000000000)
         {
            seconds++;
            if(seconds == 60)
            {
               seconds = 0;
               minutes++;
            }
            if(minutes == 60)
            {
               minutes = 0;
               hours++;
            }
            System.out.println("Ticks: " + ticks);
            System.out.println("Frames: " + frames);
            this.TPS = ticks;
            this.FPS = frames;
            ticks = 0;
            frames = 0;
            timer = 0;
         }
      }
   	
      stop();
   	
   }
	
   public KeyManager getKeyManager()
   {
      return keyManager;
   }
	
   public GameCamera getGameCamera()
   {
      return gameCamera;
   }
	
   public int getWidth()
   {
      return width;
   }
	
   public int getHeight()
   {
      return height;
   }
	
   public synchronized void start()
   {
      if(running)
         return;
      running = true;
      thread = new Thread(this);
      thread.start();
   }
	
   public synchronized void stop()
   {
      if(!running)
         return;
      running = false;
      try 
      {
         thread.join();
      } 
      catch (InterruptedException e) 
      {
         e.printStackTrace();
      }
   }
	
}