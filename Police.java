
/**
 * This is the police class that generates a new police officer for the game. 
 * These characters are NPC that will be used to hinder the players decision of attacking
 * something, whether it causes no damage or not. 
 * 
 * The characters movement shall be random. 
 *
 * @author VSacre1
 * @version 
 */
public class Police
{
    // instance variables - replace the example below with your own
    private String police;
    private int policeDamage;
    private String policeReaction;

    /**
     * Constructor for objects of class RandomPlayer
     */
    public Police(String police, int policeDamage, String policeReaction)
    {
        this.police = police; 
        this.policeDamage = policeDamage; 
        this.policeReaction = policeReaction; 
    
    }
    /**
     * @return the string for the policemand name
     */
    public String getPoliceName()
    {
        return police;
    }
    /**
     * @return This returns the int value for the polices damage. 
     */
    public int getPoliceDamage()
    {
        return policeDamage;
    }
    
    /**
     * @return Returns the String for the policeman reaction
     */
    
    public String getPoliceReaction()
    {
        return policeReaction; 
    }
    
    /**
     * @param sets up new string for the name;
     */
    public void setPolice(String newPolice)
    {
        police = newPolice;
    }
    /**
     * @param sets up a new int value for the damage
     */
    public void setPoliceDamage(int newpoliceDamage)
    {
        policeDamage = newpoliceDamage; 
    }
    
    /**
     * @param sets up new string for the reaction
     */
    public void setPoliceReaction(String newpoliceReaction)
    {
        policeReaction = newpoliceReaction; 
    }
    
    /**
     * @param Prints the value of all the objects specified above. 
     */
    public void printPolice()
    {
        System.out.println(police); 
        System.out.println(policeDamage); 
        System.out.println(policeReaction); 
    }

}
