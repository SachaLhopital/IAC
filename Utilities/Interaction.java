package Utilities;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class Interaction {

    private int action;
    private int result;
    private int value;
    private String label;
    private Interaction previousInteraction;

    public Interaction(int a, int r, int v, Interaction iPrec) {
        action = a;
        result = r;
        value = v;
        label = "e" + a + "r" + r;
        previousInteraction = iPrec;
    }

    //////////////////////////////
    // Getters & Setters

    public Interaction getPreviousInteraction() {
        return previousInteraction;
    }

    public int getAction() {
        return action;
    }

    public String getLabel() {
        return label;
    }

    /***
     * Get the "weight" of the interaction
     * @return
     */
    //todo : pas super => doit permettre de donner plus d'importance aux meilleurs intéractions ?
    public int getWeight() {
        if(previousInteraction == null) {
            return value;
        }
        return value * previousInteraction.getWeight();
    }

    public String toString() {
        String s = "[" + (previousInteraction == null ? "" : previousInteraction.getLabel());
        return s + "-" + label + "," + getWeight() + "]";
    }
}
