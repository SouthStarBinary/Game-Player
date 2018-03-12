
//Interface Headers
//The main will be able to run any game created that uses these methods

interface InteractiveGame {
    
    public boolean isCompleted();
    
    public boolean isPlayersTurn();
    
    public boolean isValidMove(String move);
    
    public void makePlayersMove(String move);
    
    public void makeComputersMove();
    
    public boolean playerHasWon();
    
    public String inputPrompt();
    
    
    
    
    
}
