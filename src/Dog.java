import javafx.scene.paint.Color;

public class Dog {

    int variant;
    UpgradeSuperClass.Rarity rarity;
    Color color;
    public Dog(int hueInput){
        this.color = Color.hsb(hueInput, 1, 1);
    }
}
