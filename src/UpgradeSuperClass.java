import java.util.Scanner;
public class UpgradeSuperClass {

    //Constants for upgrade costs
    static final int GROOMING_MACHINE_COST = 1000;
    static final int FOOD_FACTORY_COST = 2000;
    static final int AUTO_BREED_COST = 3000;

    //Variables for player's money and upgrade status
    int playerMoney;
    boolean groomingMachineUpgraded;
    boolean foodFactoryUpgraded;
    boolean autoBreedUpgraded;

    public UpgradeSuperClass() {

        playerMoney = 1000;
        groomingMachineUpgraded = false;
        foodFactoryUpgraded = false;
        autoBreedUpgraded = false;

    }

    public void startUpgrade(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display options and player's status
            System.out.println("Welcome to the upgrade menu!");
            System.out.println("You currently have $" + playerMoney);
            System.out.println("Grooming Machine: " + (groomingMachineUpgraded ? "Upgraded" : "Not Upgraded"));
            System.out.println("Food Factory: " + (foodFactoryUpgraded ? "Upgraded" : "Not Upgraded"));
            System.out.println("Breeding System: " + (autoBreedUpgraded ? "Upgraded" : "Not Upgraded"));
            System.out.println("What would you like to do?");
            System.out.println("1. Upgrade Grooming Machine ($" + GROOMING_MACHINE_COST + ")");
            System.out.println("2. Upgrade Food Factory ($" + FOOD_FACTORY_COST + ")");
            System.out.println("3. Upgrade Breeding System ($" + AUTO_BREED_COST + ")");
            System.out.println("4. Exit");



    }

         void upgradeGroomingMachine() {
            if (playerMoney >= GROOMING_MACHINE_COST && !groomingMachineUpgraded) {
                playerMoney -= GROOMING_MACHINE_COST;
                groomingMachineUpgraded = true;
                System.out.println("Grooming Machine upgraded!");
                System.out.println("New grooming machine functions unlocked.");
            } else if (groomingMachineUpgraded) {
                System.out.println("Your grooming machine is already upgraded!");
            } else {
                System.out.println("You don't have enough money to upgrade your grooming machine!");
            }
        }


}
    }
