import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Asteroid extends SimulationActor
{

    private boolean destroyed;
    private int health = 3; 
    
    public Asteroid()
    {
        setRotation(Greenfoot.getRandomNumber(360));
        destroyed = false;

    }

    public void act() 
    {
        super.act();

        if (getY() > 630)
        {
            position.setY(position.getY() + 300.0);
        } 

        if (destroyed == false)
        {
            SimulationWorld world = (SimulationWorld) getWorld();
            List<Bullet> bullets = getWorld().getObjects(Bullet.class);
            
            for (int i=0; i < bullets.size(); i++)
            {
                Bullet bullet = bullets.get(i);
                
                Vector2D bulletToAstroid = new Vector2D(bullet.getX() - getX(), bullet.getY() - getY());
                double distance = bulletToAstroid.magnitude();
                
                double bulletRadius = bullet.getImage().getHeight() / 2;
                double astroidRadius = getImage().getHeight() / 2;
                
                if (distance < bulletRadius + astroidRadius)
                {
                    // remove the bullet
                    world.removeObject(bullet);
                    health = health - 1;
                    
                    if (health == 0)
                    {
                        getSimulationWorld().addObject(new Explosion(), getX(), getY());
                        world.removeObject(this);
                        
                        destroyed = true;
                        
                        return;
                        
                    }
                }
            }
        }
        
    }
}
    

                
            
            

        

       

