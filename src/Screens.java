import JProcessingFX.ProcessingFX;
import javafx.scene.image.Image;
import java.util.Scanner;
public abstract class Screens extends ProcessingFX {
    boolean querying;
    protected String name = "";
    Image background = new Image("DogAssets/petDogBackground.png");
    public Screens(){

    }

    public void keyTyped(){
        while (querying){
            name+=key.key;


        }

    }
    /**
     * Food Factory
     * author: Emily
     * if clicked the food bag area will ask player whether to sell food or not
     */
     class FoodFactory {
        boolean isInside = checkIfInsideSquare(70, 7.7, 98, 15.4, 85, 11.5);

        boolean checkIfInsideSquare(int i, double v, int i1, double v1, int i2, double v2) {
            if (isInside){
                System.out.print("Do you want to sell food? (yes/no):");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes")){
                    sellFood();
                    //add code to check for upgrade status
                    //add code to check if meets the request from customer
                    System.out.println("One bag of pet food sold. You earned $100!");
                    System.out.println("Current income: $"+ Money.playerMoney);}
                    else{
                        System.out.println("No food sold. Current income: $"+ Money.playerMoney);
                    }

                }
            return true;


            }
        }

        private void sellFood() {
            Money.playerMoney+=100;
        }

    }
    /**
     * Grooming Machine
     * author: Emily
     * if clicked the food bag area will ask player whether to sell food or not
     */
     class GroomingMachine {
        boolean isInside = checkIfInsideSquare(70, 31, 98, 44, 85, 35);

        boolean checkIfInsideSquare(int i, int v, int i1, int v1, int i2, int v2) {
            if (isInside){
                System.out.print("Do you want to groom the dog? (yes/no):");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes")){
                    groomService();
                    //add code to check for upgrade status
                    //add code to check if meets the request from customer
                    System.out.println("One grooming service sold. You earned $150!");
                    System.out.println("Current income: $"+ Money.playerMoney);}

                else{
                    System.out.println("No grooming service sold. Current income: $"+ Money.playerMoney);
                }

            }
            return true;
        }

        private void groomService() {
            Money.playerMoney+=150;
        }



    }



class GrowthChamber {
    boolean isInside = checkIfInsideSquare(70, 53, 98, 67, 85, 60);

    boolean checkIfInsideSquare(int i, int v, int i1, int v1, int i2, int v2) {
        if (isInside) {
            System.out.print("Do you want to breed the dog? (yes/no):");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                breedDog();
                //add code to check for upgrade status
                //add code to check if meets the request from customer
                System.out.println("One grooming service sold. You earned $150!");
                System.out.println("Current income: $" + Money.playerMoney);
            } else {
                System.out.println("No no bred. Current income: $" + Money.playerMoney);
            }

        }
        return true;
    }

    private void breedDog() {
        Money.playerMoney += 200;
    }
}
