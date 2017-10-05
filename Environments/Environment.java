package Environments;

/**
 * Created by Sachouw on 28/09/2017.
 */
public abstract class Environment {

    public int lastActionByAgent;

    public Environment() {
        lastActionByAgent = -1;
    }

    public abstract int getResultat(int action);

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
