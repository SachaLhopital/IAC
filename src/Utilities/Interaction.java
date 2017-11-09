package src.Utilities;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class Interaction {

    private int action;
    private int result;
    private int valence;
    private int weight;
    private Interaction previousInteraction;

    public Interaction(int a, int r, int v, Interaction iPrec) {
        action = a;
        result = r;
        valence = v;
        weight = 1;
        previousInteraction = iPrec;
    }

    public Interaction(Interaction iToCopy) {
        action = iToCopy.getAction();
        result = iToCopy.result;
        valence = iToCopy.valence;
        previousInteraction = iToCopy.getPreviousInteraction();
    }

    //////////////////////////////
    // Getters & Setters

    public int getValence() {
        return valence;
    }

    public void setValence(int v) {
        valence = v;
    }

    public Interaction getPreviousInteraction() {
        return previousInteraction;
    }

    public int getAction() {
        return action;
    }

    public String getLabel() {
        return "e" + action + "r" + result;
    }

    public int getSize() {
        int size = previousInteraction == null ? 0 : previousInteraction.getSize();
        return 1 + size;
    }

    public void setResult(int r) {
        result = r;
    }

    public int getResult() {
        return result;
    }

    public int getWeight() {
        return weight;
    }

    public void addWeight(int x) {
        weight += x;
    }

    public String toString() {
        String s = (previousInteraction == null ? "" : previousInteraction.getLabel());
        return s + "-" + getLabel() + " | " + getWeight();
    }

    public boolean equals(Interaction i) {
        return i.getAction() == getAction()
                && i.result == result
                && (i.getPreviousInteraction() == null && getPreviousInteraction() == null
                    || i.getPreviousInteraction().equals(getPreviousInteraction()));
    }

    /***
     * Remove the older interaction of the current sequence
     * For instance if the sequence is [e1r1 - e2r2 - e1r2],
     * this method will remove "e1r1"
     */
    public void removeOlderInteraction() {
        Interaction prevInteractionOfMyPrevInteraction =
                previousInteraction == null ? null : previousInteraction.getPreviousInteraction();
        if(prevInteractionOfMyPrevInteraction == null) {
            previousInteraction = null;
        } else {
            prevInteractionOfMyPrevInteraction.removeOlderInteraction();
        }
    }
}
