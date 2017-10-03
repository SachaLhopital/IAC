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

/**
 *
 * @author PC
 */
public class Environment {
    
    public int id ;
    public int lastActionByAgent;

    public void setId(int id) {
        this.id = id;
    }

    public Environment(int id) {
        this.id = id;
        lastActionByAgent = -1;
    }

    public int getId() {
        return id;
    }

    public int getResultatEnv3(int action) {

        int resultat;

        if( lastActionByAgent == -1 || action == lastActionByAgent) {
            resultat = 1; //r1
        } else {
            resultat = 2; //r2
        }
        lastActionByAgent = action;
        return resultat;
    }

    
}
