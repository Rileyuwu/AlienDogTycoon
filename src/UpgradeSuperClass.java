import java.util.Scanner;
import java.lang.Math;
public class UpgradeSuperClass {

    //Constants for upgrade costs
    static final int GROOMING_MACHINE_COST = 1000;
    static final int FOOD_FACTORY_COST = 2000;
    static final int GROWTH_CHAMBER_COST = 3000;

    //Variables for player's money and upgrade status
    int playerMoney;
    boolean groomingMachineUpgraded;
    boolean foodFactoryUpgraded;
    boolean growthChamberUpgraded;

    int groomingMachineLevel;
    int growthChamberLevel;
    int foodFactoryLevel;

    public UpgradeSuperClass() {

        playerMoney = 1000;
        groomingMachineUpgraded = false;
        foodFactoryUpgraded = false;
        growthChamberUpgraded = false;

    }


    enum Rarity{
        /**
         * Enum that defines each of the rarities
         */
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY,
        MYTHIC
    }
    public Rarity getNewDogRarity(int tier){
        /** @param tier the upgrade tier of the growth chamber
         *  @author Edwin Fleming
         *  @version 4-26-2023
         *  determines the rarity of newly grown dogs based on growth chamber tier
         */
        int random = (int) (Math.random()*6);
        switch (tier) {
            case 1:
                if (random == 1|random == 2|random == 3){
                    return Rarity.COMMON;
                } else if (random == 4|random == 5){
                    return Rarity.UNCOMMON;
                } else if (random == 6) {
                    return Rarity.RARE;
                }
                break;
            case 2:
                if (random == 1|random == 2|random == 3){
                    return Rarity.UNCOMMON;
                } else if (random == 4|random == 5){
                    return Rarity.RARE;
                } else if (random == 6) {
                    return Rarity.EPIC;
                }
                break;
            case 3:
                if (random == 1|random == 2|random == 3){
                    return Rarity.RARE;
                } else if (random == 4|random == 5){
                    return Rarity.EPIC;
                } else if (random == 6) {
                    return Rarity.LEGENDARY;
                }
                break;
            case 4:
                if (random == 1|random == 2|random == 3){
                    return Rarity.EPIC;
                } else if (random == 4|random == 5){
                    return Rarity.LEGENDARY;
                } else if (random == 6) {
                    return Rarity.MYTHIC;
                }
                break;

        }
    }

    public void startUpgrade(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display options and player's status
            System.out.println("Welcome to the upgrade menu!");
            System.out.println("You currently have $" + playerMoney);
            System.out.println("Grooming Machine: " + (groomingMachineUpgraded ? "Upgraded" : "Not Upgraded"));
            System.out.println("Food Factory: " + (foodFactoryUpgraded ? "Upgraded" : "Not Upgraded"));
            System.out.println("Breeding System: " + (growthChamber ? "Upgraded" : "Not Upgraded"));
            System.out.println("What would you like to do?");
            System.out.println("1. Upgrade Grooming Machine ($" + GROOMING_MACHINE_COST + ")");
            System.out.println("2. Upgrade Food Factory ($" + FOOD_FACTORY_COST + ")");
            System.out.println("3. Upgrade Breeding System ($" + GROWTH_CHAMBER_COST + ")");
            System.out.println("4. Exit");

    }

        void upgradeGroomingMachine () {
            if (groomingMachineLevel == 3) {
                System.out.println("Cannot be upgraded!");
            } else if (playerMoney >= GROOMING_MACHINE_COST && !groomingMachineUpgraded) {
                playerMoney -= GROOMING_MACHINE_COST;
                groomingMachineUpgraded = true;
                groomingMachineLevel++;
                System.out.println("Grooming Machine upgraded!");
                System.out.println("New grooming machine functions unlocked.");
            } else {
                System.out.println("You don't have enough money to upgrade your grooming machine!");
            }
        }
    }

    void upgradeFoodFactory() {
        if (foodFactoryLevel == 3) {
            System.out.println("Cannot be upgraded!");
        } else if (playerMoney >= FOOD_FACTORY_COST && !foodFactoryUpgraded) {
            playerMoney -= FOOD_FACTORY_COST;
            foodFactoryUpgraded = true;
            foodFactoryLevel++;
            System.out.println("Food Factory upgraded!");
            System.out.println("New food functions unlocked.");
        } else {
            System.out.println("You don't have enough money to upgrade your food factory!");
        }
    }

    void upgradeGrowthChamber() {
        if (growthChamberLevel == 3) {
            System.out.println("Cannot be upgraded!");
        } else if (playerMoney >= AUTO_BREED_COST && !autoBreedUpgraded) {
            playerMoney -= AUTO_BREED_COST;
            autoBreedUpgraded = true;
            growthChamberLevel++;
            System.out.println("Growth Chamber upgraded!");
            System.out.println("New growth functions unlocked.");
        } else {
            System.out.println("You don't have enough money to upgrade your growth chamber!");
        }

    }
}
