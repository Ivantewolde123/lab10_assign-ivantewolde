import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Asteroid extends SimulationActor
{

    private boolean destroyed;
 
    
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
            

        }

    }    
}
