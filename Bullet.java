import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SimulationActor
{
    private Point2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    
    private static final double GRAVITY = 9.8 * -200; // 200 pixels is 1 meter

    
    public Bullet()
    {
        position = null;
        velocity = new Vector2D(0.0, 0.0);
        acceleration = new Vector2D(0.0, GRAVITY);
    }

        
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        // Initial position
        if (position == null)
        {
            position = new Point2D(getX(), getY());
        }
        
        // Get time step duration
        SimulationWorld simuworld = (SimulationWorld) getWorld();
        double dt = simuworld.getTimeStepDuration();
        
        // Update velocity
        Vector2D velocityVariation = Vector2D.multiply(acceleration, dt);
        velocity = Vector2D.add(velocity, velocityVariation);

        // Update position
        Vector2D positionVariation = Vector2D.multiply(velocity, dt);
        position.add(positionVariation);
        
        // Set new actor position
        setLocation((int) position.getX(), (int) position.getY());
        
        
    }    
}
