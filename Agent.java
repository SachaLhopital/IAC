import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sachouw on 28/09/2017.
 */
public class Agent {

    public static class Interaction{

        Experience exp;
        Result res;

        public Interaction(Experience e, Result r) {
            exp = e;
            res = r;
        }

    }

    private Experience[] experiences;
    private HashMap<Interaction, Integer> interactions;

    public Agent() {
        interactions = new HashMap<>();
    }

    public void addPossibility(Experience e) {
        experiences[experiences.length] = e;
    }

    public Experience chooseExperience(Result r) {

        for(Map.Entry<Interaction, Integer> entry : interactions.entrySet()) {

            //?
        }

        return null;
    }
}
