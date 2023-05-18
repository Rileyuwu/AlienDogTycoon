public class Dog {

    private final String[] commonImages;
    private final String[] uncommonImages;
    private final String[] rareImages;
    private final String[] epicImages;
    private final String[] legendaryImages;

    public Dog() {
        // Initialize common dog images
        commonImages = new String[] {
                "dogCommon.png",
                "chubbyDogCommon.png",
                "catCommon.png",
                "dogUncommon.png",
                "dogRare.png"

                // Add more common images or rearrange later
        };

        // Initialize uncommon dog images
        uncommonImages = new String[] {
                "dogUncommon.png"
        };

        // Initialize rare dog images
        rareImages = new String[] {
                "dogRare.png",
                "path_to_rare_image_2"
        };

        // Initialize epic dog images
        epicImages = new String[] {
                "dogEpic.png",
                "dogEpic1.png",
                "FireDogEpic.png",
                "SkullDogEpic.png"
        };

        // Initialize legendary dog images
        legendaryImages = new String[] {
                "dogLegend.png",
                "DragonDogLegendary.png",
                "FatDogLegendary.png"
        };
    }

    public String getRandomImage(UpgradeSuperClass.Rarity rarity) {
        String[] imageArray;

        // Determine the image array based on the rarity
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

        // Generate a random index to get a random image
        int randomIndex = (int) (Math.random() * imageArray.length);
        return imageArray[randomIndex];
    }
}
