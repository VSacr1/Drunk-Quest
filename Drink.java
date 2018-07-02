
/**
 * This is the drink class
 * This is where the list of Drinks for the game are created. These drinks will mainly be
 * alcohol to hinder the players drunk Meter. These items will also cost the players money.
 * 
 * I have used int values for the prices and a String for the name of the drinks. 
 *
 * @author 
 * @version 
 */

//going to need to seperate object water and alcohol so that it comes up wih two different responses.

public class Drink
{
    // instance variables - replace the example below with your own
    private String Drink;
    public int dPrice; 
    /**
     * Constructor for objects of class Drink
     */
    public Drink(String drinkName, int drinkPrice)
    {
        Drink = drinkName; 
        dPrice = drinkPrice;
    }

    /**
     * An example of a method - replace this comment with your own
     * @return Drink name
     */
    public String getDrink()
    {
        return Drink;
    }
    
    /**
     * @return drink price
     */
    public int getdPrice()
    {
       return dPrice; 
    }
    
    /**
     * param this create a new drink. 
     */
    public void setDrink(String newDrink)
    {
        Drink = newDrink;
    }
    
    
    public void setdPrice(int drinkPrice)
    {
        dPrice = drinkPrice;
    }
    
    /**
     * @param this prints out the information from the Drink class
     */
    public void printDrink()
    {
        System.out.print(Drink); 
        System.out.print(dPrice); 
    }
    
}
