import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import java.util.Random;
/**
 * Screens Class
 * This Class is for showing main graphics for players
 * including customer request, food factory, grooming and breeding chamber
 *
 * @author Emily Wang,Edwin Fleming,Riley So
 * @version 1.0
 * @since 2023-04-17
 */

public class Screens extends ProcessingFX {
    private Random random;
    protected String name = "";
    private long startTime = 0;  // Track the start time of image display
    private int displayDuration = 5000;  // Display duration in milliseconds

    Image background = new Image("DogAssets/DogTycoonBackground.png");
    Image player = new Image("DogAssets/playerHalfBody.png");
    Image upgradeButton = new Image("DogAssets/upgradeButton.png");
    Image orderButton = new Image("DogAssets/orderButton.png");
    Image dogImage;

    private Dog dog;//Instance of Dog class

    public Screens() {
        dog = new Dog();// Instantiate the Dog class
        random = new Random();
    }

    public boolean mouseInRect(double x1, double y1, double x2, double y2) {
        if (x1 <= mouse.x && mouse.x <= x2 && y1 <= mouse.y && mouse.y <= y2) {
            return true;
        } else {
            return false;
        }
    }

    public void mouseClicked() {
        if (mouseInRect(50, 50, 330, 160)) {
            Customer customer = new Customer();
            String name = customer.getName();
            String dialogue = "";

            if (customer.wantsGrooming()) {
                dialogue = "I want to buy dog food. (yes/no)";
            } else if (customer.wantsDogFood()) {
                dialogue = "I want to groom my dog. (yes/no)";
            } else if (customer.wantsDogType()) {
                dialogue = "I want to breed a new dog. (yes/no)";
            }

            System.out.println(name + ": " + dialogue);
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText(name + ": " + dialogue);
            Optional<String> result = dialog.showAndWait();

            if (result.isPresent() && result.get().equalsIgnoreCase("yes")) {
                System.out.println("New Order received. Please complete the order.");
            } else {
                System.out.println("No order received");
            }
        }

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

        if (mouseInRect(400, 300, 550, 375)) {
            TextInputDialog breedDialog = new TextInputDialog();
            breedDialog.setHeaderText("Do you want to breed new dogs? (yes/no)");
            Optional<String> breedResult = breedDialog.showAndWait();
            if (breedResult.isPresent() && breedResult.get().equalsIgnoreCase("yes")) {
                Money.playerMoney += 300.0;
                System.out.println("One new dog bred. Earned $300.");
                //dogImage = new Image("DogAssets/" + dog.getRandomImage(UpgradeSuperClass.Rarity.COMMON));
                System.out.println("Current income: $" + Money.playerMoney);
            } else {
                System.out.println("No dog grown.");
            }
        }

        if (mouseInRect(60, 185, 160, 250)) {
            TextInputDialog upgradeDialog = new TextInputDialog();
            upgradeDialog.setHeaderText("Which machine do you want to upgrade?\n(1) Food Factory\n(2) Grooming Machine\n(3) Growth Chamber");
            Optional<String> upgradeResult = upgradeDialog.showAndWait();
            if (upgradeResult.isPresent()) {
                String choice = upgradeResult.get();
                if (choice.equals("1")) {
                    if (UpgradeSuperClass.foodFactoryUpgradable()) {
                        UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.FOOD_FACTORY);
                        System.out.println("Food Factory upgraded.");
                    } else {
                        System.out.println("Not enough money!");
                    }
                } else if (choice.equals("2")) {
                    if (UpgradeSuperClass.groomingMachineUpgradable()) {
                        UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.GROOMING_MACHINE);
                        System.out.println("Grooming Machine upgraded.");
                    } else {
                        System.out.println("Not enough money!");
                    }
                } else if (choice.equals("3")) {
                    if (UpgradeSuperClass.growthChamberUpgradable()) {
                        UpgradeSuperClass.upgradeMachine(UpgradeSuperClass.Machine.GROWTH_CHAMBER);
                        System.out.println("Growth Chamber upgraded.");
                    } else {
                        System.out.println("Not enough money!");
                    }
                } else {
                    System.out.println("Invalid choice.");
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

        // Check if it's time to display a new image
        if (System.currentTimeMillis() - startTime >= displayDuration) {
            // Reset the start time for the next image
            startTime = System.currentTimeMillis();

            // Get a new random image from the Dog class
            String randomImage = dog.getRandomImage(UpgradeSuperClass.Rarity.COMMON);
            dogImage = new Image("DogAssets/" + randomImage);
        }

        // Draw the dog image
        pen.drawImage(dogImage, imageX, imageY, 600, 600);


        //if (mouseInRect(400, 300, 550, 375)) {
            //TextInputDialog breedDialog = new TextInputDialog();
            //breedDialog.setHeaderText("Do you want to breed new dogs? (yes/no)");
           // Optional<String> breedResult = breedDialog.showAndWait();
           // if (breedResult.isPresent() && breedResult.get().equalsIgnoreCase("yes")) {
             //   Money.playerMoney += 300.0;
               // System.out.println("One new dog bred. Earned $300.");
                //dogImage = new Image("DogAssets/" + dog.getRandomImage(UpgradeSuperClass.Rarity.COMMON));
                //pen.drawImage(dogImage, imageX, imageY, 600, 600);
              //  System.out.println("Current income: $" + Money.playerMoney);

          //  } else {
          //      System.out.println("No dog grown.");
            }
        }
 //   }
//}
