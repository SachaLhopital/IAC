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
package agent;

import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Agent {

    /**
     * @param args the command line arguments
     */
   
    public List experiences ;
    
    public List Resultats ;
    public List Valeur ; 


    public Agent(List experiences, List Resultats, List Valeur) {
        this.experiences = experiences;
        this.Resultats = Resultats;
        this.Valeur = Valeur;
    }

    public List getExperiences() {
        return experiences;
    }

    public void setExperiences(List experiences) {
        this.experiences = experiences;
    }

    public List getResultats() {
        return Resultats;
    }

    public void setResultats(List Resultats) {
        this.Resultats = Resultats;
    }
    
    
       public int chooseExp () {
    
        boolean exist = false;
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < experiences.size(); j++) {
                if ((Integer)experiences.get(j) == i) { 
                    exist = true;
                    if ((Integer)Valeur.get(j) > 0) {
                        return i;
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
    
}
