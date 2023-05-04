import JProcessingFX.ProcessingFX;
public abstract class Screens extends ProcessingFX {
    boolean querying;
    protected String name = "";
    public Screens(){

    }

    public void keyTyped(){
        while (querying){
            name+=key.key;

        }

    }
}
