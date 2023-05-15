import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class Screens extends ProcessingFX {
    protected String name = "";
    Image background = new Image("DogAssets/DogTycoonBackground.png");

    public Screens() {

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
        if (mouseInRect(400, 50, 590, 165)) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Do you want to sell food? (yes/no)");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().equalsIgnoreCase("yes")) {
                Money.playerMoney += 100.0;
                System.out.println("One bag of pet food sold. Earned $100.");
                System.out.println("Current income: $" + Money.playerMoney);
            }
        } else if (mouseInRect(400, 200, 590, 250)) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Do you want to sell grooming service? (yes/no)");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().equalsIgnoreCase("yes")) {
                Money.playerMoney += 150.0;
                System.out.println("One grooming service sold. Earned $150.");
                System.out.println("Current income: $" + Money.playerMoney);
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
        double imageX = (canvasWidth - 600) / 2;  // Adjust 600 to the actual width of your image
        double imageY = (canvasHeight - 600) / 2;  // Adjust 600 to the actual height of your image

        // Draw the background image
        pen.drawImage(background, imageX, imageY, 600,600);
    }
}


