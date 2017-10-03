/**
 * Created by Sachouw on 28/09/2017.
 */
public class Agent {
    // salut 

    private Motivation motivation;
    private String lastExperience;
    private String bestExperience;

    public Agent(Motivation m) {
        lastExperience = null;
        motivation = m;
        bestExperience = "2";
    }

    public String chooseExperience(int result) {

        /*if((int)(Math.random()*motivation.getNbRules()) > 1) {
            System.out.println("Choix aléatoire");
            lastExperience = motivation.getRandomAction();
        } else {
            System.out.println("Meilleur choix");
            lastExperience = bestExperience;
        }*/

        if(result > 0) {
            lastExperience = bestExperience;
        } else {
            lastExperience = motivation.getRandomAction();
        }

        return lastExperience;
    }

    public void updateReward(int result) {
        int motivationReward = motivation.getReward(lastExperience);

        if(motivationReward > motivation.getReward(bestExperience)) {
            bestExperience = lastExperience;
        }
    }
}
