import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class DataSuperClass {

    public static class DataSaver {
        public static void main(String[] args) {
            try {

                PlayerInfoGetter playerInfoGetter = new PlayerInfoGetter();
                String playerName = playerInfoGetter.getName();

                FileWriter writer = new FileWriter("player info.txt", true);
                writer.write("Player Name: " + playerName + "\n");
                writer.close();
                System.out.println("Player name added to player info file.");

                PlayerInfoSaver playerInfoSaver = new PlayerInfoSaver();
                String savedPlayerName = playerInfoSaver.getPlayerName();
                System.out.println("Player name retrieved from player info file: " + savedPlayerName);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }



    public static class PlayerInfoGetter {  //Will change to grab from the actual class where we get info later
        public String getName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter player name:");
            String name = scanner.nextLine();
            scanner.close();
            return name;
        }
    }

    public static class PlayerInfoSaver {
        public String getPlayerName() throws IOException {
            File file = new File("player info.txt");
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
    }


}
