import JProcessingFX.ProcessingFX;
import javafx.scene.canvas.GraphicsContext;

public class Main extends ProcessingFX {
    public static void main(String[] args){
        launch(args);
    }


    @Override
    protected void setup(GraphicsContext pen) {
    Player player = new Player();
    //TODO load data
        // TODO output data
    //TODO load background
        DataSuperClass.DataSaver.main(null);
    }

    @Override
    protected void draw(GraphicsContext pen) {
    //todo save every x seconds
    }

    /**
     * PUT METHODS IN OTHER CLASSES IN THIS METHOD IF THEY REQUIRE MOUSE CLICK INPUT
     */
    public void mousePressed(){
        Screens.checkForOpeningUpgradesScreen();
        Screens.checkForClosingUpgradesScreen();
        Screens.checkForUpgradeMachine();
    }

    void drawBackground(){

    }

}
