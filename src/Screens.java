import JProcessingFX.ProcessingFX;
import javafx.scene.image.Image;
import java.util.Scanner;
public abstract class Screens extends ProcessingFX {
    static boolean querying;
    static boolean upgradesScreenOpen = false;
    protected String name = "";
    Image background = new Image("DogAssets/petDogBackground.png");

    /**
     * @param x1 the x value of the top left corner of the rectangle
     * @param y1 the y value of the top left corner of the rectangle
     * @param x2 the x value of the bottom right corner of the rectangle
     * @param y2 the y value of the bottom right corner of the rectangle
     * @return whether the mouse is within the box supplied in parameters
     */
    public static boolean mouseInRect(double x1, double y1, double x2, double y2){
        if(x1 <= mouse.x && mouse.x <= x2 && y1 <= mouse.y && mouse.y <= y2){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author ned
     * TODO CHANGE VALUES FOR mouseInRect() TO THE VALUES FOR THE BUTTON TO OPEN THE UPGRADES SCREEN
     * checks if the player is clicking on the button to open the upgrades screen
     */
    public static void checkForOpeningUpgradesScreen(){
        if(!upgradesScreenOpen && mouseInRect(1, 1, 1, 1)){
            upgradesScreenOpen = true;
        }
    }
    /**
     * @author ned
     * TODO CHANGE VALUES FOR mouseInRect() TO THE VALUES FOR THE BUTTON TO OPEN THE UPGRADES SCREEN
     * checks if the player is clicking on the button to close the upgrades screen
     */
    public static void checkForClosingUpgradesScreen(){
        if(upgradesScreenOpen && mouseInRect(1, 1, 1, 1)){
            upgradesScreenOpen = false;
        }
    }

    /**
     * checks to see if the player is trying to click a button to upgrade a machine
     */
    public static void checkForUpgradeMachine(){
        //growth chamber
        if(upgradesScreenOpen && mouseInRect(1, 1, 1, 1) && UpgradeSuperClass.growthChamberUpgradable()){
            upgradesScreenOpen = false;
        //food factory
        } else if(upgradesScreenOpen && mouseInRect(2, 2, 2, 2) && UpgradeSuperClass.foodFactoryUpgradable()){
            upgradesScreenOpen = false;
        //grooming machine
        } else if(upgradesScreenOpen && mouseInRect(3, 3, 3, 3) && UpgradeSuperClass.groomingMachineUpgradable()){
            upgradesScreenOpen = false;
        }
    }
}
