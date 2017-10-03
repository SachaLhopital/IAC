import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Sachouw on 02/10/2017.
 */
/*
public class Motivation {

    private HashMap<String, Integer> motivations;

    public Motivation() {
        motivations = new HashMap<>();
        motivations.put("1", 1);
        motivations.put("2", -1);
        motivations.put("11", 1);
        motivations.put("12", -1);
    }

    public int getNbRules() {
        return motivations.size();
    }

    public String getRandomAction() {
        Object[] keys = motivations.keySet().toArray();
        return (String) keys[new Random().nextInt(keys.length)];
    }

    public int getReward(String action) {
        return motivations.get(action);
    }
}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
public class Motivation {
    
    public int id ;

    public Motivation(int id) {
        this.id = id;
    }

    public int getRewardMotivationelle(int exp, int res) {

        //List V = new ArrayList();

        if(res == 0) {
            return 0;
        }

        if (exp == 1 && res ==1){

            if (id == 1){

                /*V.add(exp);
                V.add(res);
                V.add(1);*/
                return 1;
            }
            else if (id ==2){

               return -1;
            }
            else {

                return 1;
            }

        }
        else if (exp == 1 && res ==2){

            if (id == 1){

                return 1;
            }
            else if (id==2){

               return -1;
            }
            else {

                return -1;
            }

        }
        else if (exp == 2 && res ==1){

            if (id == 1){

                return -1;
            }
            else if (id==2){

                return 1;
            }
            else {

                return 1;
            }

        }
        else{

            if (id == 1){

                return -1;
            }
            else if (id==2){

                return 1;
            }
            else {

                return -1;
            }

        }
        //return 0;
    }

    // TP 2
    public int getRewardMotivationPartie2(int res) {
        if(res == 2) {
            return 1;
        }
        return -1;
    }
    
}
