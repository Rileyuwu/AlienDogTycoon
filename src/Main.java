import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;

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
        DataSuperClass.DataSaver.main(null);
    }

    @Override
    protected void draw(GraphicsContext pen) {
        // TODO save every x seconds
        screens.draw(pen);
    }

    /**
     * PUT METHODS IN OTHER CLASSES IN THIS METHOD IF THEY REQUIRE MOUSE CLICK INPUT
     */
    public void mousePressed(){
        screens.mouseClicked();
    }

}
