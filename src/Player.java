import java.io.IOException;
/**
 * Player class
 *
 *
 * @author Riley So,Edwin Fleming
 * @version 1.0
 * @since 2023-05-3
 */
public class Player {
    public static boolean money;
    private String playerName;
    private int playerMoney;

    public Player() {
        try {
            DataSuperClass.PlayerInfoSaver playerInfoSaver = new DataSuperClass.PlayerInfoSaver();
            playerName = playerInfoSaver.getPlayerName();

            Money money = new Money();
            playerMoney = Money.getPlayerBalance();
        } catch (IOException e) {
            System.out.println("An error occurred while initializing the player.");
            e.printStackTrace();
        }
    }


    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
}
