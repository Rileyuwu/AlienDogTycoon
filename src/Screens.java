import JProcessingFX.ProcessingFX;
import javafx.scene.image.Image;
import java.util.Scanner;
public abstract class Screens extends ProcessingFX {
    boolean querying;
    protected String name = "";
    Image background = new Image("DogAssets/petDogBackground.png");

    public Screens() {

    }
    /**
     * @param x1 the x value of the top left corner of the rectangle
     * @param y1 the y value of the top left corner of the rectangle
     * @param x2 the x value of the bottom right corner of the rectangle
     * @param y2 the y value of the bottom right corner of the rectangle
     * @return whether the mouse is within the box supplied in parameters
     */
    public boolean mouseInRect(double x1, double y1, double x2, double y2){
        if(x1 <= mouse.x && mouse.x <= x2 && y1 <= mouse.y && mouse.y <= y2){
            return true;
        } else {
            return false;
        }
    }
    public void keyTyped() {
        while (querying) {
            name += key.key;


        }

    }


}
