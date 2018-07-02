import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game. 
 *
 * A "Room" represents one location in the scenery of the game and also holds items which is 
 * provided by the other classes. It is connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  VSacre1
 * @version 
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; 
    private Player player;
    public int Price;
    public int newPrice;
    private Enemies enemies;
    private Transport transport; 
    private Food food; 
    private Drink drink; 
    private boolean hasEnemies; 
    private CommandWord commandWord;
    public boolean isLocked;
    public boolean isUnlocked; 
    private HashMap<String, Room> Locks;
    private Police policeofficer;
    // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.isLocked = false; 
        this.isUnlocked = true;
        
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * @Set room Lock; 
     */
    public void setLock(boolean isLocked)
    {
        this.isLocked = isLocked; 
    }
    
    /**
     * @returns the isLooked boolean; 
     */
    public boolean getLock()
    {
        return isLocked; 
    }
    
    public void unlockLock(boolean isUnlocked)
    {
        this.isUnlocked = isUnlocked;
    }
    
    public boolean getUnlock()
    {
        return isUnlocked;
    }
    
    public boolean isUnlocked() 
    {
        if(commandWord == CommandWord.UNLOCK)
        {
            this.isLocked = false; 
            System.out.println("Room is unlocked");
            return true;
            
        }
        
        return false; 
    }
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    //room state method 
    //if room doesnt have enemy = null
    //
  
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room,
     * A long description of the enemies in the room,
     * A long description of the food in the room,
     * A long description of the drink in the room, 
     * A long description of the transport in the room.
     */
    public String getLongDescription()
        {
        String newDescription = new String(); 
        newDescription = "" + description + ".\n" +  getExitString();
        
        //Long description for enemies in rooms
        if(enemies !=null)
        {
             newDescription = newDescription +".\n" + "There is a " + getEnemies().getName() + " picking a fight" ; 
        }
        
        //Long description for food in rooms. 
        if(food !=null)
        {
            newDescription = newDescription +".\n" + "do you want to eat a " + getFood().getfName(); 
        }
        
        //Long description for drinks in room. 
        if(drink !=null)
        {
            newDescription = newDescription +".\n" + "do you want to drink " + getdrink().getDrink(); 
        }
        
        //long decription for transport in rooms. 
        if(transport !=null)
        {
            newDescription = newDescription +".\n" + "Do you want to buy a " + getTransport().getTransportName() + " ride?"; 
        }
        
        return newDescription;
    }
    
   
  
   
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * @param set up prices for the locations using int; 
     */
    public void setPrice(int price)
    {
       Price = price;    
    }
    
    /**
     * @param prints out price. 
     */
    public void printPrice()
    {
        System.out.println(Price); 
    }
    
    //Enemies
    /**
     * @param add enemies via a String and int system;
     * @param Information collected from the Enemies class; 
     */
        
    public void setEnemies(String name, int health, String reaction, int damage)
    {
        enemies = new Enemies(name, health, reaction, damage); 
    }
    
    /** 
     * @Return Enemies name. 
     */
    public Enemies getEnemies() //HAS to be a single enemy or this fails
    {
        return enemies;
    }
    
    public void printEnemies()
    {
        System.out.println(enemies); 
    }
    
   
    //police
    public void setPolice(String police, int policedamage, String policereaction)
    {
        policeofficer = new Police(police, policedamage, policereaction);
    }
    
    public Police getPolice()
    {   
        return policeofficer; 
    }
    
    public void printPolice()
    {
            System.out.println(policeofficer); 
    }

    
    //Transport
    /**
     * @param added Transport via and int and String system gotten from the
     * Tranport Class;
     */
    public void setTransport(String publicTransport, int cost)
    {
        transport = new Transport(publicTransport, cost); 
    }
    
    /**
     * @return Transport String name and cost. 
     */
    
    public Transport getTransport()
    {
        return transport;
    }
    
    /**
     * @return Transport price
     */
    public int getTransportPrice()
    {
        return transport.cost;
    }
    
    /**
     * @param Print transport list; 
     */
    
    public void printTransport()
    {
        System.out.println(transport); 
    }

    //Food
    /**
     * 
     * @param Food for the resturant rooms using String and int gotten from the 
     * Food class; 
     */
    public void setFood(String foodName, int foodPrice)
    {
        food = new Food(foodName, foodPrice);
    }
    
    /**
     * @return the string name and cost of food. 
     */
    public Food getFood()
    {
        return food;
    }
    
    /**
     * @returns good price as an int
     */
    public int getFoodPrice()
    {
        return food.fPrice; 
    }
    
    /**
     * @param this prints the information about the food items. 
     */
    public void printFood()
    {
        System.out.println(food); 
    }
    
    //Drink
    /**
     * @param String is the name of the object drink
     * @param int for the price of the object.
     */
    public void setDrink(String drinkName, int drinkPrice)
    {
        drink = new Drink(drinkName, drinkPrice); 
    }
    
    /** 
     * return drink name; 
     */
    public Drink getdrink()
    {
        return drink; 
    }
    
    /**
     * return drink price
     */
    public int getDrinkPrice()
    {
        return drink.dPrice; 
    }
    
    public void printDrink()
    {
        System.out.println(drink); 
    }
    
 
} 

    
    

    


    

