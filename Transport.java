
/**
 * This is the transport class
 * This allows me to create new transport for the game. These are going to be public transport
 * which travels suitable to the time period specified,like a train or a taxi. These will cost money
 * and will take the players to specific or chosen locations. However due to their intoxication levels
 * I have designed it so it only gives them the choice to use one word to describe their destination. 
 *
 *This relied on a String which provides the name and an int which provides the cost of the public
 *transport. 
 * @author 
 * @version 
 */
public class Transport
{
    // instance variables - replace the example below with your own
    private String publicTransport; 
    public int cost;

    /**
     * Constructor for objects of class transport
     */
    public Transport(String transportName, int transportPrice)
    {
        publicTransport = transportName; 
        cost = transportPrice;
    }

    /**
     * @return transport name
     */
    public String getTransportName()
    {
        return publicTransport; 
    }
    
    /**
     * @return transport price
     */
    public int getTransportPrice()
    {
        return cost; 
    }
    
    /**
     * @param creates new String for transport name
     */
    public void setTransport(String newTransport)
    {
        publicTransport = newTransport;
    }
    
    public void setPrice(int newPrice)
    {
        cost = newPrice;
    }
    
    /**
     * @param prints transport information. 
     */
    public void printTransport()
    {
        System.out.println(publicTransport); 
        System.out.println(cost); 
    }
}
