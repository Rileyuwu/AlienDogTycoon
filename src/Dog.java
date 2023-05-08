import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Dog {

    String variant;
    UpgradeSuperClass.Rarity rarity;
    Color color;
    public Dog(int hueInput){
        this.color = Color.hsb(hueInput, 1, 1);
    }

    /**
     * sets the dog variant
     * @param variant string to dog filepath
     */
    public void setVariant(String variant){
        this.variant = variant;
    }

    /**
     * gets the dog variant
     * @return the file path of the dog
     */
    public String getVariant(){
        return this.variant;
    }

    /**
     * get rarity of dog
     * @return the rarity of the object
     */
    public UpgradeSuperClass.Rarity getRarity(){
        return rarity;
    }
    void drawDog(GraphicsContext pen){

    }
}
