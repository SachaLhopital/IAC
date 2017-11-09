package src.Agents;

import src.Utilities.Motivation;

import java.util.*;

public class Agent {

    private int bestExperience;

    protected int lastExperience;

    public List<String> historiqueExperiences;
    public Motivation motivation;

    public Agent(Motivation m) {
        historiqueExperiences = new ArrayList();

        motivation = m;

        String action = motivation.getRandomAction();
        bestExperience = getNumberOfAction(action);
        setLastExperience(action);
    }

    //////////////////////////////
    // Getters & Setters

    public int getLastExperience() {
        return lastExperience;
    }

    public void setLastExperience(String action) {
        lastExperience = getNumberOfAction(action);
        historiqueExperiences.add(action);
    }

    //////////////////////////////
    // IA methodes

    /***
     * Choose which action to do based on the previous result
     * @param result result of the previous action on the environment
     * @return the next action to do as an integer
     */
    public int chooseExp (int result) {

        if(result != 0) {

            if (motivation.getReward("" + getLastExperience() + result) >= 0) {
                updateReward(result);
            } else {
                setLastExperience(getActionNotTestedYet());
            }
        }
        return getLastExperience();
    }

    //////////////////////////////
    // Protected methodes

    /***
     * Update the bestExperience if the reward of the previous experience is better
     * @param result
     */
    protected void updateReward(int result) {
        int motivationReward = motivation.getReward("" + getLastExperience() + result);

        if(motivationReward > motivation.getReward("" + bestExperience + result)) {
            bestExperience = getLastExperience();
        }
    }

    /***
     * Get an action not tested yet by the agent
     * @return
     */
    protected String getActionNotTestedYet() {
        String key = "";
        for(Map.Entry<String, Integer> e : motivation.getSystemMotivation().entrySet()) {

            key = e.getKey();

            if(historiqueExperiences.contains(key)) {
                //continue
            } else {
                return key;
            }
        }
        return key;
    }

    /***
     * Split the interaction to return the i action
     * ex: '11' return 1
     * ex: '21' return 2
     * @param action
     * @return
     */
    protected int getNumberOfAction(String action) {
        return  Character.getNumericValue(action.charAt(0));
    }

    /***
     * Split the interaction to return the i result
     * ex: '11' return 1
     * ex: '12' return 2
     * @param result
     * @return
     */
    protected int getNumberOfResult(String result) {
        return Character.getNumericValue(result.charAt(1));
    }
}
