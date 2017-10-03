import java.util.HashMap;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
