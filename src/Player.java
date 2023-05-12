
public class Player {
    public String name;
    public static int money;

    public Player(){
        this.name = "";
        this.money = 0;
    }

    /**
     * sets the player's name to the chosen one
     * @param newName the player's input for their name
     */
    public void setName(String newName){
        this.name = newName;
    }

}
