import java.io.IOException;

public class Player {
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
