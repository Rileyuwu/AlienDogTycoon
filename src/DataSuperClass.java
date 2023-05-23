import java.io.*;
import java.util.Scanner;
/**
 * DataSuper class
 *
 *
 * @author Riley So
 * @version 1.0
 * @since 2023-05-15
 */
public class DataSuperClass {

    public static class DataSaver {
        public static void main(String[] args) {
            try {
                // Get player name from user
                PlayerInfoGetter playerInfoGetter = new PlayerInfoGetter();
                String playerName = playerInfoGetter.getName();

                // Get player money
                Money money = new Money();
                int playerMoney = Money.getPlayerBalance();

                // Player info to file
                FileWriter writer = new FileWriter("player_info.txt", true);
                writer.write("Player Name: " + playerName + "\n");
                writer.write("Player Money: " + playerMoney + "\n");
                writer.close();
                System.out.println("Data added.");

                // Retrieve player info from file
                PlayerInfoSaver playerInfoSaver = new PlayerInfoSaver();
                String savedPlayerName = playerInfoSaver.getPlayerName();
                int savedPlayerMoney = playerInfoSaver.getPlayerMoney();
                System.out.println("Player name retrieved from player info file: " + savedPlayerName);
                System.out.println("Player money retrieved from player info file: " + savedPlayerMoney);

                // Start auto-save thread
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
                // Read the contents of the file
                File file = new File("player_info.txt");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Player Name: ")) {
                        line = "Player Name: " + playerName;
                    } else if (line.startsWith("Player Money: ")) {
                        line = "Player Money: " + Money.getPlayerBalance();
                    }
                    content.append(line).append("\n");
                }
                reader.close();

                // Write the modified contents back to the file
                FileWriter writer = new FileWriter(file);
                writer.write(content.toString());
                writer.close();
                System.out.println("Data saved.");
            } catch (IOException e) {
                System.out.println("An error occurred while saving data.");
                e.printStackTrace();
            }
        }
    }

    public static class PlayerInfoGetter {
        public String getName() {
            // Get player name from user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter player name:");
            String name = scanner.nextLine();
            scanner.close();
            return name;
        }
    }

    public static class PlayerInfoSaver {
        public String getPlayerName() throws IOException {
            // Retrieve player name from file
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
            // Retrieve player money from file
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
