
/**
 * This is the Enemies class;
 * This is where the information about the enemies for this game is stored. These are NPC that 
 * you can attack and defeat using your attack command. They range from different animals to transport.
 * However they are all realistic creatures, the ones that are imaginary cause no damage. 
 *
 * @author 
 * @version 
 */
public class Enemies
{
    // instance variables - replace the example below with your own
    private CommandWord commandWord;
    public String name; 
    public int health; 
    private String reaction;
    public int damage; 
   
    /**
     * Constructor for objects of class Enemies
     */
    public Enemies(String enemiesName, int enemiesHealth, String enemiesreaction, int enemiesDamage)
    {
        this.name = enemiesName;
        this.health = enemiesHealth; 
        this.reaction = enemiesreaction; 
        this.damage = enemiesDamage; 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return String enemy name
     */
   
    public String getName()
    {
        return name; 
    }
    
    /**
     * return int enemy health
     */
    public int getHealth()
    {
        return health; 
    }
    
    public String getReaction()
    {
        return reaction; 
    }
    
    public int getenemiesDamage()
    {
        return damage; 
    }
    
    /**
     * param creates a new name for the enemies
     */
    public void setName(String newName)
    {
        name = newName; 
    }
    
    /**
     * param this int creates the health of the enemy.
     */
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }
    
    
    public void setReaction(String newReaction)
    {
        reaction = newReaction; 
    }
    
    public void setenemiesDamage(int newDamage)
    {
        damage = newDamage; 
    }
    
    /**
     * param prints out the informaton on the enemy. 
     */
    public void print()
    {
        System.out.println(name); 
        System.out.println(health);
        System.out.println(reaction);
        System.out.println(damage); 
    }
    
    public void enemiesAttack()
    {
        System.out.println(reaction); 
        System.out.println(damage); 
    }
    
    /**
     * param What happens when the enemy's health reaches below 0
     */
    public void detractHealth(int kill) //what happens when a player beat up an enemy
    {
        health = health - kill; 
        System.out.println("Enemies has " + health + " health"); 
        
        if(health <= 0)
        {
            System.out.println ("you have beat up a " + name ); 
        }
    }
    
    public boolean policeOfficer()
    {
        if(commandWord == CommandWord.ATTACK)
        {
            System.out.println("You have been arrested"); 
            return true;
        }
        else 
        {
            return false;
        }
    }

     
  }

    

