import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import java.util.Random;

public class Screens extends ProcessingFX {
    private Random random;

    protected String name = "";
    //import background image

    //private Optional<String> breedResult;

    Image background = new Image("DogAssets/DogTycoonBackground.png");
    //import the player image
    Image player = new Image("DogAssets/playerHalfBody.png");
    //import upgrade button image
    Image upgradeButton = new Image("DogAssets/upgradeButton.png");

    Image commonDogImage = new Image("DogAssets/dogCommon.png");

    Image orderButton = new Image ("DogAssets/orderButton.png");

    //Image randomCommonImage; // Variable to hold the random common image


    public Screens() {

        random = new Random();
    }

    /**
     * @param x1 the x value of the top left corner of the rectangle
     * @param y1 the y value of the top left corner of the rectangle
     * @param x2 the x value of the bottom right corner of the rectangle
     * @param y2 the y value of the bottom right corner of the rectangle
     * @return whether the mouse is within the box supplied in parameters
     */
    public boolean mouseInRect(double x1, double y1, double x2, double y2) {
        if (x1 <= mouse.x && mouse.x <= x2 && y1 <= mouse.y && mouse.y <= y2) {
            return true;
        } else {
            return false;
        }
    }


    public void mouseClicked() {

        if(mouseInRect(50,50,330,160)){
            Customer customer = new Customer();
            String name = customer.getName();
            String dialogue= "";

            if (customer.wantsGrooming()) {
                dialogue = "I want to buy dog food.(yes/no)";
            } else if (customer.wantsDogFood()) {
                dialogue = "I want to groom my dog.(yes/no)";
            } else if (customer.wantsDogType()) {
                dialogue = "I want to breed a new dog.(yes/no)";
            }

            System.out.println(name + ": " + dialogue);
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText(name + ": " + dialogue );
            Optional<String> result = dialog.showAndWait();

            if (result.isPresent() && result.get().equalsIgnoreCase("yes")) {
                System.out.println("New Order received. Please complete the order.");

        }else{
                System.out.println("No order recieved");
            }}


        //buttons for food factory and grooming machine, if clicked dialogs pop up asking whether selling food/grooming service
        if (mouseInRect(400, 50, 590, 165)) {
            TextInputDialog foodDialog = new TextInputDialog();
            foodDialog.setHeaderText("Do you want to sell food? (yes/no)");
            Optional<String> foodResult = foodDialog.showAndWait();
            if (foodResult.isPresent() && foodResult.get().equalsIgnoreCase("yes")) {

                Money.playerMoney += 100.0;
                System.out.println("One bag of pet food sold. Earned $100.");
                System.out.println("Current income: $" + Money.playerMoney);
            } else {
                System.out.println("No food sold.");
            }
        } else if (mouseInRect(400, 200, 590, 250)) {
            TextInputDialog foodDialog = new TextInputDialog();
            foodDialog.setHeaderText("Do you want to sell grooming service? (yes/no)");
            Optional<String> foodResult = foodDialog.showAndWait();
            if (foodResult.isPresent() && foodResult.get().equalsIgnoreCase("yes")) {
                Money.playerMoney += 150.0;
                System.out.println("One grooming service sold. Earned $150.");
                System.out.println("Current income: $" + Money.playerMoney);

            } else {
                System.out.println("No grooming service sold.");
            }
        }
        //button for growth chamber. If clicked dialogs pop up asking whether grow a new dog
        if (mouseInRect(400, 300, 550, 375)) {
            TextInputDialog breedDialog = new TextInputDialog();
            breedDialog.setHeaderText("Do you want to breed new dogs? (yes/no)");
            //breedResult = breedDialog.showAndWait();
            Optional<String> breedResult = breedDialog.showAndWait();
            if (breedResult.isPresent() && breedResult.get().equalsIgnoreCase("yes")) {
                Money.playerMoney += 300.0;
                System.out.println("One new dog bred. Earned $300.");
                //Display commonDogImage


                System.out.println("Current income: $" + Money.playerMoney);

            } else {
                System.out.println("No dog grown.");
            }


        }
        //button for upgrade system. if clicked dialogs pop up asking whether upgrade the system.
        if (mouseInRect(60, 185, 160, 250)) {
            TextInputDialog upgradeDialog = new TextInputDialog();
            upgradeDialog.setHeaderText("Which machine do you want to upgrade? \n (1) Food Factory \n (2) Grooming Machine \n (3) Growth Chamber");
            Optional<String> upgradeResult = upgradeDialog.showAndWait();
            if (upgradeResult.isPresent() && upgradeResult.get().equalsIgnoreCase("1")) {
                if (UpgradeSuperClass.foodFactoryUpgradable()) {
                    UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.FOOD_FACTORY);
                } else {
                    System.out.println("Not enough money!");
                }
                System.out.println("Current balance: $" + Money.playerMoney);
            } else if (upgradeResult.isPresent() && upgradeResult.get().equalsIgnoreCase("2")) {
                if (UpgradeSuperClass.groomingMachineUpgradable()) {
                    UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.GROOMING_MACHINE);
                } else {
                    System.out.println("Not enough money!");
                }
                System.out.println("Current balance: $" + Money.playerMoney);
            } else if (upgradeResult.isPresent() && upgradeResult.get().equalsIgnoreCase("3")) {
                if (UpgradeSuperClass.growthChamberUpgradable()) {
                    UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.GROWTH_CHAMBER);
                } else {
                    System.out.println("Not enough money!");
                }
                System.out.println("Current balance: $" + Money.playerMoney);
            } else {
                System.out.println("Nothing upgraded.");
            }
        }
    }

    public void keyTyped() {
        // Handle key typing logic if needed
    }

    @Override
    protected void setup(GraphicsContext pen) {
        // Add any setup logic if needed
    }

    @Override
    protected void draw(GraphicsContext pen) {
        double canvasWidth = pen.getCanvas().getWidth();
        double canvasHeight = pen.getCanvas().getHeight();

        // Clear the canvas
        pen.clearRect(0, 0, canvasWidth, canvasHeight);

        // Calculate the position to center the image
        double imageX = (canvasWidth - 600) / 2;
        double imageY = (canvasHeight - 600) / 2;

        // Draw the background image
        pen.drawImage(background, imageX, imageY, 600, 600);

        pen.drawImage(player, imageX, imageY, 600, 600);

        pen.drawImage(upgradeButton, imageX, imageY, 600, 600);

        pen.drawImage(orderButton, imageX, imageY, 600, 600);





        //if (breedResult.isPresent() && breedResult.get().equalsIgnoreCase("yes")) {
            //pen.drawImage(commonDogImage, imageX, imageY, 600, 600);
        }
    }


