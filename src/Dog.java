import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Dog {

    String variant;
    UpgradeSuperClass.Rarity rarity;
    Color color;
    public Dog(int hueInput){
        this.color = Color.hsb(hueInput, 1, 1);
    }


    public void setVariant(String variant){
        this.variant = variant;
    }

    public String getVariant(){
        return this.variant;
    }
    void drawDog(GraphicsContext pen){

    }
}
