import java.util.ArrayList; 

/**
 * This is the food class.
 * This is where the list of food is created. The food will help the players drunk meter by making 
 * them more sober, however will cost the players money. 
 *
 *These items functions are a String which provides the food name and an int to produce the cost.
 * @author 
 * @version 
 */
public class Food
{
    // instance variables - replace the example below with your own
    private ArrayList <String> food;  
    
    private String fName;
    public int fPrice; 
  

    /**
     * Constructor for objects of class Food
     */
    public Food(String foodName, int foodPrice)
    {
        fName = foodName;
        fPrice = foodPrice;

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return String food name
     */
    public String getfName()
    {
        return fName;
    }
    
    /**
     * return int food price
     */
    public int getfPrice()
    {
        return fPrice; 
    }
    
    /**
     * @param This makes new foods and below it makes new prices. 
     */
    public void setfName(String newFood)
    {
        fName = newFood;
    }
    
    public void setfPrice(int foodPrice)
    {
        fPrice = foodPrice;
    }
    
    /**
     * @param this prints the results of the food name and prices
     */
    public void printFood()
    {
        System.out.println(fName); 
        System.out.println(fPrice); 
    }

}
