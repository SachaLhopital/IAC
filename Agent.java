import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Agent {

    private int lastExperience;
    private int bestExperience;
   
    public List<String> historiqueExperiences;
    public List<String> historiqueExperiencesTP2;

    public Motivation motivation;
    
    public List Resultats ;
    public List ValeurMotivationelles;


    public Agent(Motivation m) {
        this.historiqueExperiences = new ArrayList();
        this.Resultats = new ArrayList();
        this.ValeurMotivationelles = new ArrayList();

        motivation = m;

        String a = motivation.getRandomAction();
        bestExperience = getNumberOfAction(a);
        setLastExperience(a);
    }

    public int getLastExperience() {
        return lastExperience;
    }

    public void setLastExperience(String action) {
        lastExperience = getNumberOfAction(action);
        historiqueExperiences.add(action);
    }

    /***
     * Choose wich action to do based on the previous result
     * @param result result of the previous action on the environment
     * @return the next action to do as an integer
     */
    public int chooseExp (int result) {

        if(result != 0) {

            if (motivation.getReward("" + getLastExperience() + result) >= 0) {
                updateReward(result);

            } else {
                //Todo : on doit réaliser une expérience non réalisé jusqu'à présent et pas une action random
                setLastExperience(getActionNotTestedYet());
            }
        }
        return getLastExperience();
    }

    /*public int chooseExpPartie2 (int result) {

        boolean exist = false;
        for (int i = 1; i < 3; i++) { //experiences 1 et 2
            for (int j = 0; j < historiqueExperiencesTP2.size(); j++) {
                if ((Integer) historiqueExperiencesTP2.get(j) == i) { //si j'ai déjà fait l'expérience
                    exist = true;
                    if (*//*(Integer) ValeurMotivationelles.get(j)*//*motivation.getRewardMotivationelle(i, result) > 0) { // et que son résultat est cool
                        return i; //On refait l'experience réussie
                    }
                }
            }
            if (!exist) {
                return i;
            } else {
                exist = false;
            }
        }
        return 1;
    }*/

    private void updateReward(int result) {
        int motivationReward = motivation.getReward("" + getLastExperience() + result);

        if(motivationReward > motivation.getReward("" + bestExperience + result)) {
            bestExperience = getLastExperience();
        }
    }

    /***
     * Récupère une action que l'agent peux faire et qu'il n'a pas encore dans son historique
     * @return
     */
    private String getActionNotTestedYet() {
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
     * Split l'intéraction pour retourner le i de l'action
     * ex: '11' retourne 1
     * ex: '21' retourne 2
     * @param action
     * @return
     */
    private int getNumberOfAction(String action) {
        return  Character.getNumericValue(action.charAt(0));
    }


}
