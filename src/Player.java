import java.io.IOException;

public class Player {
    private final String playerName;
    private final int playerMoney;

    public Player() throws IOException {
        DataSuperClass.PlayerInfoSaver playerInfoSaver = new DataSuperClass.PlayerInfoSaver();
        playerName = playerInfoSaver.getPlayerName();

        Money money = new Money();
        playerMoney = Money.getPlayerBalance();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
}
