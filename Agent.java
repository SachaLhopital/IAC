/**
 * Created by Sachouw on 28/09/2017.
 */
/*
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
/*
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
*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author PC
 */
public class Agent {
   
    public List historiqueExperiences;
    public List<String> historiqueExperiencesTP2;

    public Motivation motivation;
    public int bestAction;
    
    public List Resultats ;
    public List ValeurMotivationelles;


    public Agent(List experiences, List Resultats, List Valeur, Motivation motivation) {
        this.historiqueExperiences = experiences;
        this.Resultats = Resultats;
        this.ValeurMotivationelles = Valeur;
        this.motivation = motivation;
    }

    public List getHistoriqueExperiences() {
        return historiqueExperiences;
    }

    public void setHistoriqueExperiences(List historiqueExperiences) {
        this.historiqueExperiences = historiqueExperiences;
    }

    public List getResultats() {
        return Resultats;
    }

    public void setResultats(List Resultats) {
        this.Resultats = Resultats;
    }
    
    
       public int chooseExp (int result) {



        boolean exist = false;
        for (int i = 1; i < 3; i++) { //experiences 1 et 2
            for (int j = 0; j < historiqueExperiences.size(); j++) {
                if ((Integer) historiqueExperiences.get(j) == i) { //si j'ai déjà fait l'expérience
                    exist = true;
                    if (/*(Integer) ValeurMotivationelles.get(j)*/motivation.getRewardMotivationelle(i, result) > 0) { // et que son résultat est cool
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
    
}
