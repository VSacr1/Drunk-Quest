import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap; 

/**
 *  This is Drunk Simulator, a text based adventure game which gives you the 
 *  experience of being drunk on a night out with realistic consequences  
 *  from your actions. 
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  
 * @version 
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    public int amount;
    private Player player;
    public int setPrice;
    private Enemies enemies; 
    private CommandWord commandWord;
    private Random randomGenerator;
    private ArrayList<String> exits; 
    private HashMap<String,Room> taxiDestinations;
    public ArrayList<Room> roomList;
  
    /**
     * Create the game and initialise its internal map.
     * 
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        Random rand = new Random(); 
        player = new Player(); 
     
        //enemies = new Enemies("drunk", 100);
    }


    /**
     * Create all the rooms and link their exits together.
     *  @Rooms are created using the createRooms class. 
     *  @Enemies are created using the Enemies class which is connected to the room class. 
     *  @Price is created using the Room class(been thinking about setting up a different class called 
     *   price, similar to how I have created Enemies. 
     */
    public void createRooms()
    {
        Room pub,pubgarden, exhouse, yourhouse, taxirank, citycenter, shops, resturant, 
        resturantbathroom, field, forest, traintrack, farmhouse, tunnel, streets, 
        bridge, river, field2, forest2, kebabshop, barn, traintrack2, town, forest3,
        trainstation, bridge2, river2, campsite, shop2, pub2, resturant2, street2,
        exshouse, streets3, house, resturantbathroom2, trainstation2, road, club, 
        insidefarmhouse, insideexhouse, insidehouse, pub3, pub4, bar;
        
        // create the rooms
        pub = new Room("you are in a pub");
        yourhouse = new Room("you are in your house, you collapse with exhaustion");
        resturant = new Room("you are in a resturant"); 
        resturantbathroom = new Room("you are in the resturants bathroom");
        field = new Room("you are in a field"); 
        forest = new Room("you are in a forest");
        traintrack = new Room("you are by a train track");
        farmhouse = new Room("you are outside a farmhouse");
        yourhouse = new Room("you are outside your house");
        exhouse = new Room("You are outside a house"); 
        taxirank = new Room("You are by a taxi, destination: pub, trainstation, shops");
        citycenter = new Room("you are in the city centre");
        tunnel = new Room("you are in a dark tunnel");
        bridge = new Room("you are on a bridge");
        river = new Room("you fell into a river, you are cold and wet");
        pubgarden = new Room("You are in the pub garden");
        streets = new Room("you are in the streets");
        shops = new Room("you are outside the shops");
        field2 = new Room("you are in a field");
        forest2 = new Room("you are in a forest");
        kebabshop = new Room("you are in a Kebab Shop");
        barn = new Room("you are in the barn");
        traintrack2 = new Room ("you are on the train track");
        town = new Room ("you are in the town");
        forest3 = new Room("you are in the forest"); 
        trainstation = new Room("you are at brighton train station");
        bridge2 = new Room("you are on a bridge"); 
        river2 = new Room("you fell into a river, you are cold and wet");
        campsite = new Room("you are in a campsite"); 
        street2 = new Room("you are in the street"); 
        streets3 = new Room("you are in the street"); 
        resturant2 = new Room("you are in a chinese resturant");
        exhouse = new Room("you are outside a house"); 
        pub2 = new Room("you are in a pub"); 
        pub3 = new Room("you are in a pub");
        shop2 = new Room("you are outside the shops"); 
        house = new Room("you are outside a house"); 
        resturantbathroom2 = new Room("you are in a resturant bathroom"); 
        trainstation2 = new Room("you are at Hove trainstation"); 
        road = new Room("you are on the road"); 
        club = new Room("you in a club");
        insidefarmhouse = new Room("you broke into a farm house, minutes later you get arrested, you have failed"); 
        insideexhouse = new Room("you broke into your ex's house, minutes later you get arrested, you have failed");
        insidehouse = new Room("you are inside your house, you collapse on your bed. Congradulations you have completed your objective"); 
        pub4 = new Room("you are inside a pub"); 
        bar = new Room("you are in a bar"); 
        // initialise room exits
        
        //the pub exits
        pub.setExit("south", pubgarden);
        pub.setExit("north",streets); 
        
        pubgarden.setExit("north", pub);
        
        pub2.setExit("east", streets3);
        
        pub3.setExit("south", street2); 
        
        pub4.setExit("south", shops); 
        
        bar.setExit("south", taxirank); 
        
        //pub enemies
        pub.setEnemies("Drunk", 15, "the drunk fall down in shock and get very angry", 15); 
        
        pub2.setEnemies("Bouncer", 20, "He attempts to kick you out the pub", 10);
        
        //pub food
        pub.setFood("Burger", 5); 
        
        //pub drink
        pub.setDrink("alcohol", 4);
        
        pub2.setDrink("alochol", 3);
        
        pub3.setDrink("alcohol", 5); 
        
        pub4.setDrink("alcohol", 4); 
        
        bar.setDrink("shots", 2);
        //street exits 
        streets.setExit("pub", pub);
        streets.setExit("north", citycenter);
        streets.setExit("west", resturant);
        streets.setExit("east", kebabshop); 
        
        street2.setExit("east", town); 
        street2.setExit("south", resturant2);
        street2.setExit("west", exhouse); 
        street2.setExit("pub", pub3); 
        
        streets3.setExit("south", shop2); 
        streets3.setExit("pub", pub2); 
        streets3.setExit("north", house); 
        
        //street Enemies; 
        street2.setEnemies("Dog", 5, "dog gets angry and bites you", 3); 
        streets.setEnemies("cat", 5, "cat gets angry and scratches you", 1); 
        streets3.setEnemies("car", 30, "car alarm sounds", 0); 
        
        //kebab shop exit
        kebabshop.setExit("west", streets); 
        
        //kebab shop food
        
        kebabshop.setFood("kebab", 6); 
        
        //city center exits
        citycenter.setExit("south", streets); 
        citycenter.setExit("west", taxirank); 
        citycenter.setExit("east", shops); 
        citycenter.setExit("north", field);
       
        //shops 
        shops.setExit("west", citycenter); 
        shops.setExit("pub", pub4);
        
        shop2.setExit("north", club); 
        shop2.setExit("south", town); 
        shop2.setExit("east", exhouse); 
        shop2.setExit("west", streets3);
        
        shops.setEnemies("window", 20, "you hurt your fist when you punch it", 5); 
        
        //taxi rank to hail a cab
        taxirank.setExit("east", citycenter);
        taxirank.setExit("west", road); 
        taxirank.setExit("taxi", null); 
        taxirank.setExit("bar", bar); 

        //taxi object
        taxirank.setTransport("taxi", 20); 
        
        //club
        club.setExit("south", exhouse); 
        club.setExit("east", street2); 
        
        club.setDrink("Shots", 2); 
        

        
        //fields
        field.setExit("south", citycenter);
        field.setExit("north", bridge);
        field.setExit("east", forest);
        
        field2.setExit("south", bridge); 
        field2.setExit("west", farmhouse); 
        field2.setExit("east", forest2); 
        field2.setExit("north", traintrack);
        
        //field enemy
        field.setEnemies("sheep", 10, "Baaahhh", 1);
        field2.setEnemies("flower", 2, "flower is crushed", 0); 
        
        //forests
        forest.setExit("west", field); 
        
        forest2.setExit("west", field2);
        forest2.setExit("east", forest3); 
        
        forest3.setExit("west", forest2); 
        forest3.setExit("north", traintrack2); 
        forest3.setExit("south", bridge2); 
        
        //enemies for forest
        forest.setEnemies("Tree", 20, "you get smacked in the face", 10);
        forest.setEnemies("owl", 10, "Twit twoo, the owl digs its talons into you", 5);
        
        //resturant exits
        resturant.setExit("east", streets); 
        resturant.setExit("south", resturantbathroom); 
        
        resturantbathroom.setExit("north", resturant); 
        
        resturant2.setExit("north", street2); 
        resturant2.setExit("west", resturantbathroom2); 
        
        resturantbathroom2.setExit("east", resturant2); 
        
        resturant.setFood("chinese", 8);
        
        resturant2.setFood("thai", 13); 
        
        //rivers
        river.setExit("south", field);
        river.setExit("north", field2); 
        
        river2.setExit("north", forest3);
        river2.setExit("south", campsite); 
         
        river.setEnemies("fish", 8, "splish splash", 1); 
        
        //bridge
        bridge.setExit("south",field);
        bridge.setExit("east", river); 
        bridge.setExit("west", river); 
        bridge.setExit("north", field2); 
        
        bridge2.setExit("north", forest3); 
        bridge2.setExit("east", river2); 
        bridge2.setExit("west", river2); 
        bridge2.setExit("south", campsite); 
        
        bridge.setEnemies("troll", 5, "you just punched air", 0); 
        
        //train track
        traintrack.setExit("south", field2);
        traintrack.setExit("east", tunnel);
        
        tunnel.setExit("west", traintrack); 
        tunnel.setExit("east", traintrack2); 
        
        traintrack2.setExit("west", tunnel);
        traintrack2.setExit("north", town); 
        traintrack2.setExit("south", forest3); 
        traintrack2.setExit("east", trainstation2); 
        
        //enemies for train tracks; 
        traintrack.setEnemies("train", 20, "train horn", 100); 
        traintrack2.setEnemies("badger", 10, "growl", 5);
        
        //trainstation; 
        trainstation2.setExit("west", traintrack2);
        trainstation2.setExit("train", trainstation); 
        
        trainstation.setExit("south", road); 
        trainstation.setExit("train", trainstation2); 
        

        
        //train object
        trainstation.setTransport("train", 6); 
        trainstation2.setTransport("train", 6);
        
        //farm house property
        farmhouse.setExit("east", field2); 
        farmhouse.setExit("west", barn);
        farmhouse.setExit("south", insidefarmhouse); 
        
        insidefarmhouse.setLock(true); 
        
        barn.setExit("east", farmhouse);
        
        //farmhouse enemy
        farmhouse.setEnemies("Farmer", 20, "Get off my land!", 30); 
        
        
        //campsite
        campsite.setExit("north", bridge2); 
        
        
        //house
        house.setExit("south", streets3);
        house.setExit("north", insidehouse); 
        
        insidehouse.setLock(true); 
        
        //exs house
        exhouse.setExit("east", street2); 
        exhouse.setExit("club", club);
        exhouse.setExit("south", insideexhouse);
        insideexhouse.setLock(true); 
        
        //town
        town.setExit("north", shop2); 
        town.setExit("south", traintrack); 
        
        //roads
        road.setExit("north", trainstation); 
        road.setExit("east", taxirank); 
        
        //Taxi Destination;
        taxiDestinations = new HashMap<String,Room>();
        taxiDestinations.put("pub",pub2);
        taxiDestinations.put("trainstation", trainstation2); 
        taxiDestinations.put("shops", shop2); 
        
        //policeman Movement
        roomList = new ArrayList<Room>();
        //roomList.add(citycenter); roomList.add(taxirank); 
        roomList.add(shops); roomList.add(resturant); 
        roomList.add(field); roomList.add(forest); roomList.add(traintrack); roomList.add(farmhouse); 
        roomList.add(tunnel); roomList.add(streets); roomList.add(bridge); 
        roomList.add(field2); roomList.add(forest2); roomList.add(kebabshop); roomList.add(barn);
        roomList.add(traintrack2); roomList.add(town); roomList.add(forest3);
        roomList.add(trainstation); roomList.add(bridge2); roomList.add(river2); 
        roomList.add(campsite); roomList.add(shop2); roomList.add(pub2); roomList.add(resturant2); 
        roomList.add(street2); roomList.add(streets3); roomList.add(trainstation2); roomList.add(road); 
        roomList.add(club); roomList.add(pub3); 
       
        
           
        currentRoom = pub;  // start game in the pub.
        
    }
   
    /**
     * @param This places the police officer in a random location from the list above; 
     */
    public void movement()
    {
        randomGenerator = new Random(); 
        int movement;
        movement = randomGenerator.nextInt(roomList.size()); 
        
        //Characters effected by the random room movement. 
        roomList.get(movement).setPolice("police man", 70, "You get arrested and thrown in a prison cell");
        roomList.get(movement).setPolice("police women", 70, "You get arrested and thrown in a prison cell");
        roomList.get(movement).setPolice("copper", 70, "You get arrested and thrown in a prison cell"); 
        roomList.get(movement).setPolice("Police chief", 70, "You get arrested and thrown in a prison cell");
        return;
    }
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Drunk simulator!");
        System.out.println("You must find your way back home without any problems.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());

    }
   
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed. A list of the commands are 
     * HELP: gives the players guidence on what their controls are. 
     * GO: Allows players to travel through different rooms
     * QUIT: A command word to quit the game 
     * ATTACK: Attacks enemies in the room.
     * RUN: Command that runs away from enemies. 
     * LOOK: Looks for enemies in the room. 
     * BUY: Allows people to travel using public transport. 
     * DRINK: Players can continue to drink alcohol using this command, however the drunk meter will increase.. 
     * EAT: This command allows players to eat food to decrease their drunk meter
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
            movement();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }

        else if(commandWord == CommandWord.ATTACK) 
        {
             if(!command.hasSecondWord())
            {
               
                System.out.println("attack what?");
                return false;
               
           
            }
            
              if(currentRoom.getPolice() != null)
              {
                player.playerHealth = player.playerHealth - currentRoom.getPolice().getPoliceDamage();
                System.out.println(currentRoom.getPolice().getPoliceReaction());
                System.out.println("You have failed");

                wantToQuit = true;
              
            }
              
            else if(currentRoom.getEnemies() == null)
            {
                System.out.println("there is no enemies here");
                return false;
            } 
             
   
        
            
            else if(currentRoom.getEnemies().getenemiesDamage() == 0)
            {
                System.out.println(currentRoom.getEnemies().getReaction());  
                System.out.println("no damage dealt");
                
            }


            //need to improve and add an actual number to the players health meter as it seems
            //to one hit ko the player. 
            else {
               System.out.println(currentRoom.getEnemies().getReaction());  
               currentRoom.getEnemies().detractHealth(10);  
               player.playerHealth = player.playerHealth - currentRoom.getEnemies().getenemiesDamage();
               wantToQuit = player.healthScale(); 
               
            }
        

         }
              
        else if(commandWord == CommandWord.RUN) 
        {
            System.out.println("you have succesfully ran away"); 
            //command word to run away from enemies
        }

        else if(commandWord == CommandWord.LOOK) {

            
            
            if(currentRoom.getPolice() == null)
                {
                    System.out.println("There is no police"); 
                }
            else
            {
                    System.out.println(currentRoom.getPolice().getPoliceName()); 
                    
            }
            
            if(currentRoom.getEnemies() == null)
            {
                System.out.println("There are no enemies here"); 
            }
            else
            {
                System.out.println(currentRoom.getEnemies().getName());
            }
            //command word to look at the enemies in the current room to check if they are there;
        }
        
        else if(commandWord == CommandWord.TRAVEL) {
            //command word to pay for transport which will then take you to different locations;
            if(currentRoom.getTransport() == null)
            {
                System.out.println("there is no transport here"); 
                return false;
            }
        
            
            boolean canBuy = player.buyFunction(currentRoom.getTransportPrice()); 
            
            if(canBuy)
            {
                player.playerMoney = player.playerMoney - currentRoom.getTransportPrice(); 
                if (currentRoom.getTransport().getTransportName() == "train") {
                setCurrentRoom(currentRoom.getExit("train"));
            }   
            else {
                Room dest = taxiDestinations.get(command.getSecondWord());
                if (dest == null) {
                    player.buyFunction(currentRoom.getTransportPrice());
                    System.out.println("Invalid destination");
                    return false;
                }
                
                setCurrentRoom(dest); 
            }
                System.out.println(currentRoom.getLongDescription());
            }
        }   
    
        
        else if(commandWord == CommandWord.DRINK)
        {
            //command word to drink alcohol and it will take money out of your account. 
            if(currentRoom.getdrink() == null)
            {
                System.out.println("there is no drink here"); 
                return false;
            }
            
           boolean canBuy = player.buyFunction(currentRoom.getDrinkPrice());
           
           if(canBuy)
           {
               player.drunkMeter = player.drunkMeter + 10;
               player.playerHealth = player.playerHealth + 5; 
               wantToQuit = player.drunkScale();
           }
           
        }
        
        
        else if(commandWord == CommandWord.STAT)
        {
            //command word to have a look at you players stat
            player.stat();  
        }
        
        else if(commandWord == CommandWord.EAT)
        {
           //command word to eat food from certain resturants or pubs. 
            if(currentRoom.getFood() == null)
           {
               System.out.println("There is no food here");
               return false;
           }
           
           boolean canBuy = player.buyFunction(currentRoom.getFoodPrice());
           
           if(canBuy)
           {
           player.drunkMeter = player.drunkMeter - 5;
           System.out.println("drunk meter" + player.drunkMeter); 

          }
          
        }
        else if(commandWord == CommandWord.UNLOCK)
        {
            //Unlock doors in the game;
            if(!command.hasSecondWord()) {
                System.out.println("Unlock which door"); 
            }

            String direction = command.getSecondWord();     
            Room nextRoom = currentRoom.getExit(direction);
            System.out.println("Door is unlocked"); 
            nextRoom.setLock(false);
        }
    
       
       
        // else command not recogised.
        return wantToQuit;
     
    }
   
    // implementations of user commands:
  
    /**
     * This locks the room. 
     */
    public void setCurrentRoom(Room newRoom)
    {
        if(newRoom.getLock())
        {
            System.out.println("Room is locked"); 
            return;
         
        }
        
        currentRoom = newRoom; 
        
    }
   

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are drunk. You are alone. You bumble");
        System.out.println("around with no concept of reality.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            setCurrentRoom(nextRoom); 
            System.out.println(currentRoom.getLongDescription());
        }
        
    }

        
    

   
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
        
        //if statement explaining that if you go over the drunk Limit the game automatically quits; 
    
    }

    /**
     * param this should include a second word with the command attack with an if statement. 
     */
    
    private void attack(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("attack what?");
            return;
        }
        // wondering if this even works currently? 
        String enemeiesName = command.getSecondWord(); 
    }
}
    
    

    

    

