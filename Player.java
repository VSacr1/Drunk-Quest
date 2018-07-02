/**
 * This is the player class
 * It shows the stats of your player and the limits of how drunk they can be 
 * and how much damage they can take.
 * 
 * There is also a NPC player program here which has been created to hinder
 * the players decisions throughout the game. 
 *
 * @author VSacre1
 * @version 
 */
public class Player
{
    // instance variables - replace the example below with your own
    
    
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        drunkMeter = 60;
        playerMoney = 30;
        playerHealth = 50; 
        playerDamage = 10;
        
    
    }
    //include a drunk meter % wise.
    //Include player currency in this class; 
    public int drunkMeter;
    public int playerMoney; 
    public int addDrunk;
    private int drunkScale;
    private int minimumValue; 
    private int maximumValue; 
    private int minimumMoney; 
    public int playerHealth;
    public int playerDamage; 
    private int healthScale;
    private String police; 
    private int policeHealth;
    private String policeReaction; 
    
    /**
     * @param Drunk Meter to monitor how drunk you are and how drunk you could get;
     * 
     */
    
    public void DrunkMeter()
    {
        drunkMeter = 60; 
        System.out.println(drunkMeter);
        
    }
    
    /**
     * @buy function to determine whether you can buy something due to the amount of money you have. 
     */
    public boolean buyFunction(int cost)
    {
        if(cost > playerMoney)
        {
            cost = 0; 
            System.out.println ("You are out of money");
            return false;
        }

        else {
            playerMoney -= cost;
            System.out.println ("Amount of money " + playerMoney); 
            return true;
        }

    }
    
   
    /**
     * @param to the drunk scale to determin how drunk you are; 
     */
    public boolean drunkScale()
    {
        if(drunkMeter == 100)
        {
            System.out.println("you blackout and end up in hopsital");
            System.out.println("you have failed."); 
            return true; 
        }
        else {
                System.out.println("drunk meter " + drunkMeter); 
             }
        
        if(drunkMeter <= 10)
        {
            System.out.println("you are almost sober"); 
        } 
        return false;
    }
    
    /**
     * @param the health scale to see how damaged you are.
     */
    public boolean healthScale()
    {
        if(playerHealth <= 0)
        {
            System.out.println("you blackout and end up in hospital");
            System.out.println("you have failed.");
            return true;
        
        }
            else
            {
                System.out.println("health meter" + playerHealth); 
            }
        
        return false;
    }
    
   
    /**
     * @return the drunk value as an int
     */

    public int getDrunk()
    {
        return drunkMeter;
    }
    
    public int getHealth()
    {
        return playerHealth; 
    }
    
    public void setHealth()
    {
        System.out.println(playerHealth); 
    }
    
    /**
     * @param Players Money amount;
     */
    public void Money()
    {
        playerMoney = 30;
        System.out.println(playerMoney); 
    }
    
    /**
     * @param minimum Spending limit. 
     *
    
    /**
     * @return Money amount; 
     */
    public int getMoney()
    {
        return minimumMoney;
    }
    
    public void playerDetractHealth(int death)
    {
        playerHealth = playerHealth - death; 
    }
  
    
   /**
     * @param this shows the general condition of the player;
     */

    public void stat()
    {
        System.out.println("Amount of money" + playerMoney);
        System.out.println("drunk meter" + getDrunk());
        System.out.println("health meter" + getHealth()); 
    }

   
    /**
     * @param Police officer will be another player that will walk around similar to your player
     * however it will be completely random movement. 
     */
  
    
        //public void policeOfficer()
    //{
       // System.out.println("there is a police officer in the room");
        //if(commandWord == CommandWord.ATTACK)
        //{
         //   System.out.println ("You get arrested. Game over"); 
        //}


}


    




