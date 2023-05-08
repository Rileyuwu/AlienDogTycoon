import java.util.Scanner;
import java.lang.Math;

public class UpgradeSuperClass {

    //Constants for upgrade costs
    //TODO change pricing

    static final int MAX_GROOMING_MACHINE_TIER = 4;
    static final int MAX_FOOD_FACTORY_TIER = 4;
    static final int MAX_GROWTH_CHAMBER_TIER = 4;

    //Variables for player's money and upgrade status
    int playerMoney;
    int groomingMachineTier;
    int foodFactoryTier;
    int growthChamberTier;

    public UpgradeSuperClass() {

        playerMoney = 1000;
        groomingMachineTier = 1;
        foodFactoryTier = 1;
        growthChamberTier = 1;

    }

    /**
     * enum that contains dog rarity
     */
    enum Rarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY,
        MYTHIC
    }

    /**
     * this function handles the rarity of different rarities of dog for different growth chamber tiers
     *
     * @param tier the tier of growth chamber the player has unlocked
     * @return the rarity of the newly generated dog
     */
    public Rarity getNewDogRarity(int tier) {
        int random = (int) (Math.random() * 6);
        switch (tier) {
            case 1:
                if (random == 1 | random == 2 | random == 3) {
                    return Rarity.COMMON;
                } else if (random == 4 | random == 5) {
                    return Rarity.UNCOMMON;
                } else if (random == 6) {
                    return Rarity.RARE;
                }
                break;
            case 2:
                if (random == 1 | random == 2 | random == 3) {
                    return Rarity.UNCOMMON;
                } else if (random == 4 | random == 5) {
                    return Rarity.RARE;
                } else if (random == 6) {
                    return Rarity.EPIC;
                }
                break;
            case 3:
                if (random == 1 | random == 2 | random == 3) {
                    return Rarity.RARE;
                } else if (random == 4 | random == 5) {
                    return Rarity.EPIC;
                } else if (random == 6) {
                    return Rarity.LEGENDARY;
                }
                break;
            case 4:
                if (random == 1 | random == 2 | random == 3) {
                    return Rarity.EPIC;
                } else if (random == 4 | random == 5) {
                    return Rarity.LEGENDARY;
                } else if (random == 6) {
                    return Rarity.MYTHIC;
                }
                break;

        }
        return null;
    }

    enum Machine{
        GROWTH_CHAMBER,
        FOOD_FACTORY,
        GROOMING_MACHINE
    }

    /**
     * gets the tier of the given machine
     * @param machine the machine to get the tier of
     * @return the tier of the machine
     */
    private int getMachineTier(Machine machine){
        switch (machine){
            case GROOMING_MACHINE:
                return groomingMachineTier;
            case GROWTH_CHAMBER:
                return growthChamberTier;
            case FOOD_FACTORY:
                return foodFactoryTier;
        }
        return 0;
    }

    private int getUpgradeCost(Machine machine){
        switch (machine){
            case FOOD_FACTORY:
                int ffTier = foodFactoryTier;
                return (int) Math.pow(10, ffTier+2);
            case GROWTH_CHAMBER:
                int gcTier = growthChamberTier;
                return (int) Math.pow(10, gcTier+2);
            case GROOMING_MACHINE:
                int gmTier = groomingMachineTier;
                return (int) Math.pow(10, gmTier+2);
        }
        return 0;
    }


    public void upgradeMachine(Machine machine){
        if (getMachineTier(machine)<MAX_GROWTH_CHAMBER_TIER){
            if (playerMoney >= getUpgradeCost(machine)){
                playerMoney -= getUpgradeCost(machine);
            }
        }else{
            System.out.println("Uh... this shouldn't have happened. (Error with upgrading)");
            // this should never happen - the upgrade button shouldn't be able to be interacted with if it's already at the max tier
        }
    }

}
