/**
 * Money Class
 * This Class is storing and displaying player money
 *
 * @author Emily Wang
 * @version 1.0
 * @since 2023-04-17
 */

public class Money {
    // Retrieve the player's current balance
    static int playerMoney = 0;

    public static int getPlayerBalance(){
    // Add the specified amount to the player's balance
        return playerMoney;
    }

    public void addMoney(int amount){

        playerMoney += amount;
    }

    public boolean removeMoney(int amount){
        if (amount>playerMoney){
            return false; // Ensures player has enough money
        }
        else{
            playerMoney -=amount;
            return true; // Subtracts money from players account
        }
    }



}
