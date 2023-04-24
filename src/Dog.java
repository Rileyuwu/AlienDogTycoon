import javafx.scene.paint.Color;

public class Dog {

    int variant;
    Color color;
    public Dog(int hueInput){
        this.color = Color.hsb(hueInput, 1, 1);
    }
}
