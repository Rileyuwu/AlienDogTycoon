import java.util.Random;
public class Customer {
    private String name;
    private boolean wantsGrooming;
    private boolean wantsDogFood;
    private boolean wantsDogType;

    public Customer(String name) {
        this.name = name; //Make random name NEED DICTIONARY!
        Random random = new Random();
        int option = random.nextInt(3);

        switch (option) {
            case 0:
                wantsGrooming = true;
                break;
            case 1:
                wantsDogFood = true;
                break;
            case 2:
                wantsDogType = true;
                break;
            default:
                break;
        }
    }


}
