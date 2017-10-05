import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Agent {

    private int lastExperience;
    private int bestExperience;
   
    public List historiqueExperiences;
    public List<String> historiqueExperiencesTP2;

    public Motivation motivation;
    
    public List Resultats ;
    public List ValeurMotivationelles;


    public Agent(Motivation m) {
        this.historiqueExperiences = new ArrayList();
        this.Resultats = new ArrayList();
        this.ValeurMotivationelles = new ArrayList();

        motivation = m;
        bestExperience = motivation.getRandomAction();
        lastExperience = bestExperience;
    }

    public List getHistoriqueExperiences() {
        return historiqueExperiences;
    }

    public void setHistoriqueExperiences(List historiqueExperiences) {
        this.historiqueExperiences = historiqueExperiences;
    }

    /***
     * Choose wich action to do based on the previous result
     * @param result result of the previous action on the environment
     * @return the next action to do as an integer
     */
    public int chooseExp (int result) {

        if(result != 0) {

            if (motivation.getReward("" + lastExperience + result) >= 0) {
                updateReward(result);

            } else {
                //Todo : on doit réaliser une expérience non réalisé jusqu'à présent et pas une action random
                lastExperience = motivation.getRandomAction();
            }
        }
        return lastExperience;
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
        int motivationReward = motivation.getReward("" + lastExperience + result);

        if(motivationReward > motivation.getReward("" + bestExperience + result)) {
            bestExperience = lastExperience;
        }
    }
}
