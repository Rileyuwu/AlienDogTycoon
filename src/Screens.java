public class Screens extends ProcessingFX{



    boolean querying;
    private String name = "";
    public Screens(){

    }

    public void keyTyped(){
        while (querying){
            name+=key.key;

        }

    }
}
