package src.Utilities;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Motivation {

    protected HashMap<String, Integer> motivations;

    public Motivation(HashMap<String, Integer> m) {
        motivations = m;
    }

    public HashMap<String, Integer> getSystemMotivation() {
        return motivations;
    }

    /***
     * Return a random action involved in the motivationnal system
     * @return
     */
    public String getRandomAction() {
        Object[] keys = motivations.keySet().toArray();
        return (String) keys[new Random().nextInt(keys.length)];
    }

    /***
     * Return the reward for the experiment given
     * (ex : "11" for action 1 given 1 as result)
     * @return the reward of the experience
     */
    public int getReward(String experience) {
        int reward = motivations.get(experience);
        return reward;
    }
}
