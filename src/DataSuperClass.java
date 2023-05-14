import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class DataSuperClass {

    public static class DataSaver {
        public static void main(String[] args) {
            try {
                PlayerInfoGetter playerInfoGetter = new PlayerInfoGetter();
                String playerName = playerInfoGetter.getName();

                Money money = new Money();
                int playerMoney = Money.getPlayerBalance();

                FileWriter writer = new FileWriter("player_info.txt", true);
                writer.write("Player Name: " + playerName + "\n");
                writer.write("Player Money: " + playerMoney + "\n");
                writer.close();
                System.out.println("Data added.");

                PlayerInfoSaver playerInfoSaver = new PlayerInfoSaver();
                String savedPlayerName = playerInfoSaver.getPlayerName();
                int savedPlayerMoney = playerInfoSaver.getPlayerMoney();
                System.out.println("Player name retrieved from player info file: " + savedPlayerName);
                System.out.println("Player money retrieved from player info file: " + savedPlayerMoney);

                startAutoSave(playerName, money);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static void startAutoSave(String playerName, Money money) {
            Thread autoSaveThread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(10000); // Sleep for 10 seconds change upgrade time
                        saveData(playerName, money);
                    } catch (InterruptedException e) {
                        System.out.println("AutoSave thread interrupted.");
                        e.printStackTrace();
                    }
                }
            });
            autoSaveThread.start();
        }

        public static void saveData(String playerName, Money money) {
            try {
                FileWriter writer = new FileWriter("player_info.txt", true);
                writer.write("Player Name: " + playerName + "\n");
                writer.write("Player Money: " + Money.getPlayerBalance() + "\n");
                writer.close();
                System.out.println("Data autosaved.");
            } catch (IOException e) {
                System.out.println("An error occurred while autosaving data.");
                e.printStackTrace();
            }
        }
    }

    public static class PlayerInfoGetter {
        public String getName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter player name:");
            String name = scanner.nextLine();
            scanner.close();
            return name; //gotta visualize this.
        }
    }

    public static class PlayerInfoSaver {
        public String getPlayerName() throws IOException {
            File file = new File("player_info.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Player Name: ")) {
                    return line.substring(13);
                }
            }
            reader.close();
            return null;
        }

        public int getPlayerMoney() throws IOException {
            File file = new File("player_info.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Player Money: ")) {
                    return Integer.parseInt(line.substring(14));
                }
            }
            reader.close();
            return 0;
        }
    }


    public static void main(String[] args) {
        DataSaver.main(args); // Run the DataSaver class
    }
}
