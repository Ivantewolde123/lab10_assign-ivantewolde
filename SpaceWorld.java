import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class SpaceWorld extends SimulationWorld
{
    GreenfootSound music = new GreenfootSound("gameplay.wav");

    public SpaceWorld()
    {    
        super("", 800, 600, new Point2D(0.0, 0.0), 20);

        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();       
        prepare();
        setMusic(music);
    }

    public void act()
    {
        super.act();

        List<SpaceShip> list = getObjects(SpaceShip.class);
        if (list.size() > 0)
        {
            SpaceShip player = list.get(0);
            cameraCenter.setY(player.getPosition().getY() + 6.0);
        }

        
    }

    private void prepare()
    {
        SpaceShip spaceShip = new SpaceShip();
        addObject(spaceShip,400,500);
        spaceShip.setLocation(400,540);

        // Generate asteroids for 20 screens
        for (int i = 0; i < 12000; i+=60)
        {
            int xPos = 40 + 60*Greenfoot.getRandomNumber(13);
            addObject(new Asteroid(), xPos, -i);
        }

        Score score = new Score();
        addObject(score,725,36);
    }
}
