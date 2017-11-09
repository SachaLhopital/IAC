package src.Utilities;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class Interaction {

    private int action;
    private int result;
    private int value;
    private Interaction previousInteraction;

    public Interaction(int a, int r, int v, Interaction iPrec) {
        action = a;
        result = r;
        value = v;
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
        return "e" + action + "r" + result;
    }

    public int getResult() {
        return result;
    }

    public void SetResult(int r) {
        result = r;
    }

    public void AddValue(int v) {
        value += v;
    }

    /***
     * Get the "weight" of the interaction
     * (Addition of all sequence values)
     * @return
     */
    public int getWeight() {
        if(previousInteraction == null) {
            return value;
        }
        return value + getPreviousInteraction().getWeight();
    }

    public String toString() {
        String s = "[" + (previousInteraction == null ? "" : previousInteraction.toString());
        return s + "-" + getLabel() + "," + getWeight() + "]";
    }
}
