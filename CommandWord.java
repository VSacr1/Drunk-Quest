    import java.util.HashMap;

    public enum CommandWord
    {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), ATTACK("attack"), 
    RUN("run"), DRINK("drink"), EAT("eat"), STAT("stat"), LOOK("look"), 
    TRAVEL("travel"), UNLOCK("unlock");
    
    // The command string.
        private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
 }
