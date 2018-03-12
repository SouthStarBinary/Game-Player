
/* 
Classic NIM game created using the given interface and main.
*/

import java.util.*;
public class NIM implements InteractiveGame {
    private int pileSize;
    private boolean playSmart;
    private boolean playersTurn;
    private String gameRecord;
    
    
    //gets options if computer plays smart amd if player goes first
    public NIM (boolean playSmart, boolean playersTurn) { 
        Random r = new Random();
        this.pileSize = r.nextInt(91) + 10;
        this.gameRecord = "NIM Game The Starting Pile is " + this.pileSize;
        this.playSmart = playSmart;
        this.playersTurn = playersTurn;
    } 
    
    //if there is a winnter or not
    public boolean isCompleted() { 
        if (this.pileSize == 0){ 
            return true;
        } 
        
        return false;
    } 
    
    
    //if it is the players turn after the "computer"
    public boolean isPlayersTurn() { 
        return this.playersTurn;
    } 
    
    //checks to see if the move the player made is applicable
    public boolean isValidMove(String move) { 
        int currentPileSize = this.pileSize;
        int moveNum = Integer.parseInt(move);
        int halfPileSize = (currentPileSize / 2);
        
        if (this.pileSize == 1 && moveNum == 1) { 
            return true;
        }
        
        else if (moveNum > currentPileSize || moveNum > halfPileSize || moveNum <= 0) { 
            
            return false;
        } 
        return true;
    } 
    
    //gets move player wants to make and invokes the updateMethod
    public void makePlayersMove (String move) { 
        int playerMove = Integer.parseInt(move);
        
        updateGame("Player", playerMove);
    } 
    
    //logic for the computer to make its move. Also includes logic for if the computer
    //plays smart or not.
    public void makeComputersMove (){ 
        
        int computerMove = 0;
        
        if (this.playSmart == true){ 
            int power = 0;
            while (Math.pow(2,power) - 1 < this.pileSize) { 
                power++;
            } 
            power--;
            double powMove = Math.pow(2, power) - 1;
            int intMove = (int)powMove;
            intMove = this.pileSize - intMove;
            String checkMove = Integer.toString(intMove);
            if (isValidMove(checkMove) == false){ 
                Random r = new Random();
                int currentPileSize = this.pileSize;
                int halfPileSize = (currentPileSize / 2);
                if (halfPileSize == 0){ 
                halfPileSize++;
                }
                computerMove = r.nextInt(halfPileSize) + 1;
        
        
                updateGame("Computer", computerMove);
            } 
            else { 
                
                updateGame("Computer", intMove);
            }
        } 
        else { 
            Random r = new Random();
        int currentPileSize = this.pileSize;
        int halfPileSize = (currentPileSize / 2);
        if (halfPileSize == 0){ 
            halfPileSize++;
        }
        computerMove = r.nextInt(halfPileSize) + 1;
        
        
        updateGame("Computer", computerMove);
        }
        
    } 
    
    //updates the "game board" with either the computer or players move
    public void updateGame(String player, int move) { 
        
        this.pileSize = this.pileSize - move;
        
        this.gameRecord += "\n" + player + " took " + move + " Current Pile size is " + this.pileSize;
        
        if (this.pileSize > 0){
        this.playersTurn = !this.playersTurn;
        }
    } 
    
    //checks to see if the player has won every turn
    public boolean playerHasWon () { 
        
        if (this.pileSize == 0 && !this.playersTurn){ 
            return true;
        }
        
        return false;
    } 
    
    //prompts player to make their turn
    public String inputPrompt () { 
        return this.gameRecord + "\n Take how many from the pile ";
    } 
    
    public String toString () { 
        return this.gameRecord;
    }
}
