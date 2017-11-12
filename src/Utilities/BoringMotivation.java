package src.Utilities;

import java.util.HashMap;

public class BoringMotivation extends Motivation {

    private int nbCorrectResult;
    private HashMap<String, Integer> motivation1;
    private HashMap<String, Integer> motivation2;

    public BoringMotivation(HashMap<String, Integer> m1, HashMap<String, Integer> m2) {
        super(m1);
        nbCorrectResult = 0;
        motivation1 = m1;
        motivation2 = m2;
    }

    public int getNbCorrectResult() {
        return nbCorrectResult;
    }

    public void setNbCorrectResult(int n) {
        nbCorrectResult = n;
    }

    public void switchMotivation() {
        System.out.println("SWITCH MOTIVATION");
        motivations = motivations.equals(motivation1) ? motivation2 : motivation1;
        nbCorrectResult = 0;
    }

    /***
     * Return the reward for the experiment given
     * And change the motivationnal system if needed
     * @return the reward of the experience
     */
    @Override
    public int getReward(String experience) {
        int reward = motivations.get(experience);
        return reward;
    }
}
