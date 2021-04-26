import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreenWorld extends SimulationWorld
{

    GreenfootSound music;


    /**
     * Constructor for objects of class EndScreenWorld.
     * 
     */
    public EndScreenWorld(double vscore)
    {
        super("",  800, 600, new Point2D(0.0, 0.0), 10);
        music = new GreenfootSound("endMenu.wav");
        setMusic(music);

        Score result = new Score();
        addObject(result, 381, 357);
        result.setImage(new GreenfootImage("You finished with a score of " + (int) vscore + ".", 40, Color.WHITE, Color.BLACK, Color.YELLOW));;

        Score feedback = new Score();
        addObject(feedback,400,407);
        String ranking = new String();
        if (vscore >= 300)
            ranking = " Professional player";
        else if (vscore >= 150)
            ranking = " Intermediate player";
        else
            ranking = " Novice player";
        feedback.setImage(new GreenfootImage("You are a" + ranking + ".", 40, Color.BLUE, Color.BLACK, Color.YELLOW));;
        

    }
    public void act()
    {

        if (Greenfoot.isKeyDown("space"))
        {
            transitionToWorld(new SpaceWorld()); 

        }


    
    }
}