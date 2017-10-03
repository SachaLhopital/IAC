/**
 * Created by Sachouw on 28/09/2017.
 */
/*
public class Environment {

    public Environment() {
    }

    public int getResult(String action) {

        switch(action) {
            case "1" :
                return 1; //r1

            case "2" :
                return 2; //r2

            default:
                return 3;
        }

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
public class Environment {
    
    public int id ;
    public int res ;

    public void setId(int id) {
        this.id = id;
    }

    public Environment(int id) {
        this.id = id;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getId() {
        return id;
    }

    public int getRes() {
        return res;
    }
    
}
