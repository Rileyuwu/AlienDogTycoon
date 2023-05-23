import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;
/**
 * Main Class
 * This class calls from Screen and other class to show graphics and display game mechanism
 *data saved from this class constantly
 *
 * @author Riley So, Emily Wang,Edwin Fleming
 * @version 1.0
 * @since 2023-05-17
 */

public class Main extends ProcessingFX {
    private Screens screens;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    protected void setup(GraphicsContext pen) {
        screens = new Screens();
        Player player = new Player();
        // TODO load data
        // TODO output data
        // TODO load background
        DataSuperClass.DataSaver.main(null); // Run data saving class
    }

    @Override
    protected void draw(GraphicsContext pen) {
        // TODO save every x seconds
        screens.draw(pen); // Draws screen class
    }

    /**
     * PUT METHODS IN OTHER CLASSES IN THIS METHOD IF THEY REQUIRE MOUSE CLICK INPUT
     */
    public void mousePressed(){
        screens.mouseClicked();
    }
    // Handle mouse click events for specific functionalities
}
