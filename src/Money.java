public class Money {
    static int playerMoney = 0;

    public static int getPlayerBalance(){

        return playerMoney;
    }

    public void addMoney(int amount){

        playerMoney += amount;
    }

    public boolean removeMoney(int amount){
        if (amount>playerMoney){
            return false;
        }
        else{
            playerMoney -=amount;
            return true;
        }
    }



}
