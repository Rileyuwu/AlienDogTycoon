import JProcessingFX.ProcessingFX;
import javafx.scene.image.Image;
public abstract class Screens extends ProcessingFX {
    boolean querying;
    protected String name = "";
    Image background = new Image("DogAssets/petDogBackground.png");
    public Screens(){

    }

    public void keyTyped(){
        while (querying){
            name+=key.key;


        }

    }

}
