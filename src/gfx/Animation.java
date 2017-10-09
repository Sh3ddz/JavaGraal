package gfx;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation
{
    private int frameCount;                 // Counts ticks for change
    private int frameDelay;                 // frame delay 1-12 (You will have to play around with this)
    private int currentFrame;               // animations current frame
    private int animationDirection;         // animation direction (i.e counting forward or backward)
    private int totalFrames;                // total amount of frames for your animation

    private boolean stopped;                // has animations stopped
    private boolean loop; 					//if it loops or goes back and forth

    private List<Frame> frames = new ArrayList<Frame>();    // Arraylist of frames 

    public Animation(BufferedImage[] frames, boolean loop, int frameDelay)
    {
        this.frameDelay = frameDelay;
        this.stopped = true;

        for (int i = 0; i < frames.length; i++) 
        {
            addFrame(frames[i], frameDelay);
        }

        this.frameCount = 0;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.animationDirection = 1;
        this.totalFrames = this.frames.size();

    }

    public void start()
    {
        if (!stopped) 
        {
            return;
        }

        if (frames.size() == 0) 
        {
            return;
        }

        stopped = false;
    }

    public void stop()
    {
        if (frames.size() == 0)
        {
            return;
        }

        stopped = true;
    }

    public void restart()
    {
        if (frames.size() == 0) 
        {
            return;
        }

        stopped = false;
        currentFrame = 0;
    }

    public void reset()
    {
        this.stopped = true;
        this.animationDirection = 1;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    private void addFrame(BufferedImage frame, int duration)
    {
        if (duration <= 0) 
        {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }

        frames.add(new Frame(frame, duration));
        currentFrame = 0;
    }

    public BufferedImage getSprite()
    {
    	return frames.get(currentFrame).getFrame();
    }
    
    public int getCurrentFrame()
    {
    	return this.currentFrame;
    }

    public void update()
    {
        if (!stopped)
        {
            frameCount++;

            if (frameCount > frameDelay)
            {
                frameCount = 0;
                currentFrame += animationDirection;
                
                if(!loop)
                {
                    if (currentFrame >= totalFrames - 1)
                    {
                        animationDirection = -1;
                    }
                    else if (currentFrame <= 0)
                    {
                        animationDirection = 1;
                    }
                }
                else
                {
                    if (currentFrame > totalFrames - 1)
                    {
                        currentFrame = 0;
                    }
                    else if (currentFrame < 0)
                    {
                        currentFrame = totalFrames - 1;
                    }
                }
            }
        }
    }
}
