/*public class Main {

    public static void main(String[] args) {

        int r = 0;
        int count = 0;
        String action = "";

        Motivation motivation = new Motivation();
        Agent agent = new Agent(motivation);
        Environment env = new Environment();

        while(count != 50) {

            action = agent.chooseExperience(r);
            r = env.getResult(action);

            System.out.println("DO : " + action.toString());
            System.out.println("RESULT Environnement " + r);
            System.out.println("RESULT Motivation " + motivation.getReward(action));
            System.out.println("---------------------");

            agent.updateReward(r);

            count++;
        }
    }
}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package agent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Main {
    
    public static int getRes ( int ex , Environment env){
    
      int res = 0 ;
      
      if (ex == 1){
      
          if (env.getId() == 1){
          
              res = 1;
          }
          else res = 2 ;
      }
      else if ( ex == 2){
      
          if ( env.getId() == 2){
          
              res = 2;
          }
          else res = 1 ;
      }
      return res ;
    }
    
 
    
    public static List Interaction (int exp ,Environment env , int s , int res) {
    
         
        List V = new ArrayList();
        
            
            if (exp == 1 && res ==1){
            
                if (s == 1){
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                else if ( s==2){
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                else {
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                   
            }
            else if (exp == 1 && res ==2){
            
                if (s == 1){
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                else if ( s==2){
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                else {
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                   
            }
            else if (exp == 2 && res ==1){
            
                if (s == 1){
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                else if ( s==2){
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                else {
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                   
            }
            else{
            
                if (s == 1){
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                else if ( s==2){
                
                    V.add(exp);
                    V.add(res);
                    V.add(1);
                }
                else {
                
                    V.add(exp);
                    V.add(res);
                    V.add(-1);
                }
                   
            }
                     
        return V ;
    }
    
    
    public static void main(String[] args) {

        List exps = new LinkedList();
        List ress = new LinkedList();
        List vals = new LinkedList();
        
        Environment e = new Environment(2);
        Motivation s = new Motivation(2);

        Agent a = new Agent(exps,ress,vals, s);
        
        int exp = 0 ;
        int res = 0 ; 
        List val  = new LinkedList();
        
        for (int i = 0 ; i < 10 ; i ++){
        
            exp = a.chooseExp(res);
            //PARTIE 1 res = getRes(exp, e);
            res = e.getResultatEnv3(exp);
            
            /*val = Interaction(exp, e, s.id, res);
            a.Resultats.add(res);*/
            a.historiqueExperiences.add(exp);/*
            a.ValeurMotivationelles.add(val.get(val.size()-1));*/
            
            System.out.println(" ==== >  ["+ exp + "," + res + "," + s.getRewardMotivationelle(exp, res) + "]");
        }
                
    }
    
}
