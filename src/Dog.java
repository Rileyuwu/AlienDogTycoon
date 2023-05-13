import javafx.scene.paint.Color;

public class Dog {

    private String[] commonImages;
    private String[] uncommonImages;
    private String[] rareImages;
    private String[] epicImages;
    private String[] legendaryImages;

    public Dog() {
        commonImages = new String[] {
                "dogCommon.png",
                "path_to_common_image_2"
                // Add more common image or rearrange later
        };

        uncommonImages = new String[] {
                "ChubbyDogUncommon.png",
                "dogUncommon.png"
        };

        rareImages = new String[] {
                "dogRare.png",
                "path_to_rare_image_2"
        };

        epicImages = new String[] {
                "dogEpic.png",
                "dogEpic1.png",
                "FireDogEpic.png",
                "SkullDogEpic.png"
        };

        legendaryImages = new String[] {
                "dogLegend.png",
                "DragonDogLegendary.png",
                "FatDogLegendary.png"
        };
    }

    public String getRandomImage(UpgradeSuperClass.Rarity rarity) {
        String[] imageArray;

        switch (rarity) {
            case COMMON:
                imageArray = commonImages;
                break;
            case UNCOMMON:
                imageArray = uncommonImages;
                break;
            case RARE:
                imageArray = rareImages;
                break;
            case EPIC:
                imageArray = epicImages;
                break;
            case LEGENDARY:
                imageArray = legendaryImages;
                break;
            default:
                return null; // Return null if rarity is not recognized
        }

        int randomIndex = (int) (Math.random() * imageArray.length);
        return imageArray[randomIndex];
    }
}
