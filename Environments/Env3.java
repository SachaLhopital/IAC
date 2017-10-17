package Environments;

/**
 * Environnement pour la Partie 2 et les séquences
 * Retourne 1 si l'agent a changé d'action
 * Created by Sachouw on 17/10/2017.
 */
public class Env3 extends Environment {

    private int lastActionByAgent;

    public Env3() {
        super();
        lastActionByAgent = -1;
    }

    private int getLastActionByAgent() {
        return lastActionByAgent;
    }

    private void setLastActionByAgent(int action) {
        lastActionByAgent = action;
    }

    @Override
    public int getResultat(int action) {
        int resultat;

        if(getLastActionByAgent() == -1 || action == getLastActionByAgent()) {
            resultat = 1; //r1
        } else {
            resultat = 2; //r2
        }
        setLastActionByAgent(action);
        return resultat;
    }

    /*public int getResultatEnv3(int action) {

        int resultat;

        if( lastActionByAgent == -1 || action == lastActionByAgent) {
            resultat = 1; //r1
        } else {
            resultat = 2; //r2
        }
        lastActionByAgent = action;
        return resultat;
    }*/
}
