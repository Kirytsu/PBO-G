/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // Create the forest rooms
        Room deepForest, riverbank, ancientTree, mountainBase, waterfall, hiddenCave, 
            forestEdge, glade, huntingCabin, lookoutPoint, marshland, abandonedCamp;

        // Create the location in forest
        deepForest = new Room("in the heart of a dense forest, where towering trees block most of the sunlight");
        riverbank = new Room("beside a gentle river, its waters glistening in the soft light");
        ancientTree = new Room("at the base of an enormous, ancient tree, with carvings etched into its bark");
        mountainBase = new Room("at the base of a towering mountain, with steep cliffs rising ahead");
        waterfall = new Room("by a beautiful waterfall, the sound of rushing water filling the air");
        hiddenCave = new Room("inside a dark, hidden cave, with mysterious symbols on the walls");
        forestEdge = new Room("at the edge of the forest, where the trees start to thin and the open plains are visible");
        glade = new Room("in a peaceful glade, where wildflowers bloom and birds chirp merrily");
        huntingCabin = new Room("outside an old, abandoned hunting cabin, its door creaking in the wind");
        lookoutPoint = new Room("at a lookout point atop a cliff, offering a view of the entire forest");
        marshland = new Room("in the marshlands, where the ground is soft and the air is thick with moisture");
        abandonedCamp = new Room("at an abandoned campsite, with remnants of a campfire and scattered belongings");

        // initialize room exits (representing paths through the forest)
        deepForest.setExits(mountainBase, riverbank, ancientTree, glade);  
        riverbank.setExits(null, null, null, deepForest);                 
        ancientTree.setExits(deepForest, waterfall, abandonedCamp, null); 
        mountainBase.setExits(null, lookoutPoint, deepForest, hiddenCave); 
        waterfall.setExits(null, null, null, ancientTree);                
        hiddenCave.setExits(null, mountainBase, null, null);             
        forestEdge.setExits(null, null, glade, null);                     
        glade.setExits(deepForest, forestEdge, null, marshland);          
        huntingCabin.setExits(null, marshland, null, null);              
        lookoutPoint.setExits(null, null, mountainBase, null);            
        marshland.setExits(glade, null, null, huntingCabin);              
        abandonedCamp.setExits(null, ancientTree, null, null);            

        currentRoom = deepForest;  // start the game in the Deep Forest
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
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.print("You are lost. You are alone. You wander");
        System.out.println(" around in a deep forest.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
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
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
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
    }
}