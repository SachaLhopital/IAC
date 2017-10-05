import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Motivation {

    private HashMap<String, Integer> motivations;

    public Motivation(HashMap<String, Integer> m) {
        motivations = m;
    }

    /***
     * Retourne une action aléatoire impliqué dans le système motivationnel
     * @return
     */
    public int getRandomAction() {
        Object[] keys = motivations.keySet().toArray();
        return Character.getNumericValue(
                ((String) keys[new Random().nextInt(keys.length)]).charAt(0));
    }

    /***
     * Return the reward for the experience given
     * (ex : "11" for action 1 given 1 as result)
     * @return the reward of the experience
     */
    public int getReward(String experience) {
        int reward = motivations.get(experience);
        return reward;
    }

    // TP 2
    public int getRewardMotivationPartie2(int res) {
        if(res == 2) {
            return 1;
        }
        return -1;
    }
    
}
